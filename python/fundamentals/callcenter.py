from datetime import datetime

class Call(object):
    ID = 0
    def __init__(self,name,phone,reason):
        self.name = name
        self.phone = phone
        self.time = datetime.now()
        self.reason = reason
        self.id = Call.ID

        Call.ID += 1

    def display(self):
        print "Call name: {}".format(self.name)
        print "Call reason: {}".format(self.reason)
        print "Call number: {}".format(self.number)
        print "Call time: {}".format(self.time)
        print "Call ID: {}".format(self.id)
        print "=========================="
        

class CallCenter(object):
    def __init__(self):
        self.calls = []
        self.queue_size = 0

    def add(self, a_call):
        self.calls.append(a_call)
        self.queue_size += 1
        return self
    
    def remove(self):
        if (self.queue_size):
            self.calls.pop(0)
            self.queue_size -= 1
        return self

    def info(self):
        for call in self.calls:
            call.display()


c1 = Call("Todd", "444-1212", "I need help")
c2 = Call('Sam', "309=826-8775", "prank call")

cc1 = CallCenter()
cc1.add(c1)
cc2.add(c2)

cc1.call_list[0].display()