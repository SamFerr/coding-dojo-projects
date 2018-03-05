# -*- coding: utf-8 -*-
from __future__ import unicode_literals
from django.shortcuts import render, redirect, HttpResponse
from django.db.models import Count
from models import *

# Create your views here.

def index(request):     #login/registration page
    if not 'id' in request.session:
        request.session['id'] = 0
    return render(request, "poke/index.html")


def register(request):  #insert rout for a new user
    result = User.objects.validate(request.POST)
    if result[0]:
        request.session['id'] =  result[1].id          
        return redirect("/home")
    else:
        for error in result[1]:
            messages.add_message(request, messages.INFO, error)

    return redirect("/")


def login(request):  #login route for users
    result = User.objects.validatelogin(request.POST)
    if result[0]:
        request.session['id'] =  result[1].id        
        return redirect("/home")
    else:
        for error in result[1]:
            messages.add_message(request, messages.INFO, error)
    return redirect("/")


def logout(request):   #logout route
    request.session['id'] =0
    return redirect("/")


def home(request):   #content area with all pokes
    if request.session['id'] != 0:
        currentUser = User.objects.get(id=request.session['id'])
        otherUsers = User.objects.exclude(id=request.session['id'])
        poked_by = currentUser.pokes_received.all()

        context = {
            'currUser': currentUser,
            'otherUsers': otherUsers,
            'poked_by': poked_by,
        }

        return render(request, "poke/dash.html", context)

    return redirect("/")


def poke(request, id):
    if request.session['id'] != 0:
        Poke.objects.Poke(id, request.session['id'])
        return redirect("/home")
    return redirect("/")