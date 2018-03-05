class MathDojo(object):
    def __init__(self, value):
        self.result = value
    def add(self, *args):
        for items in args:
            if type(items) == list or type(items) == tuple:
                for x in items:
                    self.result += x
            else:
                self.result += items
        return self
    def subtract(self, *args):
        for items in args:
            if type(items) == list or type(items) == tuple:
                for x in items:
                    self.result -= x
            else:
                self.result -= items
        return self
    def result(self):
        print 'The total is {}'.format(self.value)
        return self

md = MathDojo(0)
md.add(2).add(2,5).subtract(3,2).result
md.add([1], 3,4).add([3,5,7,8], [2,4.3,1.25]).subtract(2, [2,3], [1.1,2.3]).result