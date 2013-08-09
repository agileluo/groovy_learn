
def myMap = [a:1, b:2, c:3]

assert myMap instanceof HashMap
assert myMap.size() == 3
assert myMap['a'] == 1

def emptyMap = [:]
assert emptyMap.size() == 0

def explictMap = new TreeMap()
explictMap.putAll(myMap)
assert explictMap['a'] == 1


assert ['a': 1] == [a: 1]

def x = 'a'
assert [x: 1] == ['x': 1]
assert ['a': 1] == [(x): 1]



