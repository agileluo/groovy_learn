def myList = [1, 2, 3]

assert myList.size() == 3
assert myList[0] == 1
assert myList instanceof ArrayList

def emptyList = []
assert emptyList.size() == 0

def longList = (0..1000).toList()
assert longList[555] == 555

def explicitList = new ArrayList()
explicitList.addAll(myList)
assert explicitList.size() == 3
explicitList[0] = 10
assert explicitList[0] == 10



explicitList = new LinkedList(myList)
assert explicitList.size() == 3
explicitList[0] = 11
assert explicitList[0] == 11

def strList = "hello".toList()
assert strList.size() == 5
assert strList[0] == 'h'
