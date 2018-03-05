class Product(object):
    def __init__(self, price, name, weight, brand, cost):
        self.price = price
        self.name = name
        self.weight = weight
        self.brand = brand
        self.cost = cost
        self.status = "for sale"
    def sell(self):
        self.status = "sold"
        print 'This item is ' + str(self.status)
        return self
    def add_tax(self):
        self.price = price * .15
        return self
    def returns(self, reason):
        if reason == "defective":
            self.price = 0
            self.status = "defective"
        if reason == "boxed":
            self.status = "for sale"
        if reason == "opened":
            self.status = "used"
            self.price = price * .20
        return self
    def DisplayInfo(self):
        print 'Price is $' + str(self.price)
        print 'Item name is ' + str(self.name)
        print 'The weight is ' + str(self.weight) + 'lbs'
        print 'The brand is ' + str(self.brand)
        print 'The cost is $' + str(self.cost)
        print 'This item is ' + str(self.status)

product1 = Product(69, 'Borat', 420, 'V Nice', 300)