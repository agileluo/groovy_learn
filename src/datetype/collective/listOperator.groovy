def myList = ('a'..'f').toList()

assert myList[0..2] == ['a', 'b', 'c']
assert myList[0, 2, 4] == ['a', 'c', 'e']

myList[0..2] = ['x', 'y', 'z']
assert myList == ['x', 'y', 'z', 'd', 'e', 'f']

myList[3..5] = []
assert myList == ['x', 'y', 'z']

myList[1..1] = ['y', '1', '2'] //adding elements
assert myList == ['x', 'y', '1', '2', 'z']


myList = []
myList += 'a'
assert myList == ['a']


myList += ['b', 'c']
assert myList == ['a', 'b', 'c']

myList = []
myList << 'b' << 'c'
assert myList == ['b', 'c']

assert myList - 'c' == ['b']

assert myList * 2 == ['b', 'c', 'b', 'c']


myList = ['a', 'b', 'c']

assert myList.isCase('a')
def condidate = 'a'

switch(condidate){
	case myList : assert true; break;
	default : assert false
}

assert ['x', 'a', 'z'].grep(myList) == ['a']

myList = []
if(myList) assert false

def log = ''
[1, 'x', 5].each{
	log += it
}
assert log == '1x5'



