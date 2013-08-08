(1..<10).each {
	print it + " "
}

assert (0..10).contains(0)
assert (0..10).contains(5)
assert (0..10).contains(10)

assert (0..10).contains(-1) == false
assert (0..10).contains(11) == false


def a = 0..10
assert a instanceof Range
assert a.contains(5)

a = new IntRange(0, 10)
assert a.contains(5)

def today = new Date()
def yesterday = today -1
assert (yesterday..today).size() == 2

assert ('a'..'c').contains('b')

def log = ''
for(element in 5..9){
	log += element
}
assert log == '56789'

log = ''
for(element in 9..5){
	log += element
}
assert log == '98765'

log = ''
(9..<5).each {
	log += it
}
assert log == '9876'