ac = 4 # global variable
# self is a default arg for each method
class loop:
    abc = 6 # class variable
    def __init__(self):
        self.val = 5
    def fck_on(self):
        time.sleep(self.val)
        print "Fck once.."
        self.fck_on()
    def test_val(self):
        print self.val
        print self.abc
        print ac
        self.fuck_on()
        
import time
if __name__ == "__main__":
    a = loop()
    a.test_val()
