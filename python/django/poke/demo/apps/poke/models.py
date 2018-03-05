# -*- coding: utf-8 -*-
from __future__ import unicode_literals
from django.contrib.messages import error
from django.shortcuts import render, redirect, HttpResponse
from django.contrib import messages
from django.db import models
import re
import bcrypt

EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9\.\+_-]+@[a-zA-Z0-9\._-]+\.[a-zA-Z]*$')

# Create your models here.

class UserManager(models.Manager):
    def validate(self, POST):
        errors = []

        try:
            new_user = User.objects.get(email = POST['email'])
        except:
        
            if len(POST['name']) < 1:
                errors.append('Missing your name. Please, introduce yourself')
            if len(POST['alias']) < 1:
                errors.append('Got any nicknames? Enter an alias')
            if not re.match(EMAIL_REGEX, POST['email']):
                errors.append("We're going to need your email")
            if len(POST['password']) < 8:
                errors.append("Enter a password with 8 characters.")
            if POST['password'] != POST['cpassword']:
                errors.append("Passwords need to match duuude")
            if len(POST['birth_date']) < 1:
                errors.append("You need to enter a birth date")
            if len(errors) > 0:
                return (False, errors)

            else:
                
                new_user = User.objects.create(
                    name = POST['name'],
                    alias = POST['alias'],
                    email = POST['email'],
                    birth_date = POST['birth_date'],
                    password =  bcrypt.hashpw(POST['password'].encode(), bcrypt.gensalt())
                )

                
                return (True, new_user)

        errors.append("This user already exists!")
        return (False, errors)
        
    def validatelogin(self, POST):
        errors = []
        try: 
            user = User.objects.get(email = POST['email']) 

            if not bcrypt.checkpw(POST['password'].encode(), user.password.encode()):
                errors.append("The password you have entered is incorrect")
                return (False, errors)
            else:
                return (True, user)
        
        except:
            errors.append("The email you entered doesn't match anything in our database!")
        return (False, errors)


class PokeManager(models.Manager):
    def Poke(self, id, userId):
        try:
            userToPoke = User.objects.get(id=id)
            currentUser = User.objects.get(id=userId)
            Poke.objects.create(poker=currentUser, pokee =userToPoke)
        except:
            print "No user found with id {}".format(id)
            errors.append("Something went wrong... we can't find your pokee")



#User table
class User(models.Model):
    
    name = models.CharField(max_length=255)
    email = models.CharField(max_length=255)
    alias = models.CharField(max_length=255)
    password = models.CharField(max_length=255)
    birth_date = models.DateField(null=True)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    objects = UserManager()

    def __str__(self):
        return self.name


class Poke(models.Model):
    poker = models.ForeignKey(User, related_name="pokes_made")
    pokee = models.ForeignKey(User, related_name="pokes_received")
    created_at = models.DateTimeField(auto_now_add=True)
    objects = PokeManager()