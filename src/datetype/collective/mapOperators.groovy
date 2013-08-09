def myMap = [a:1, b:2, c:3]

assert myMap['a'] == 1
assert myMap.a == 1
assert myMap.get('a') == 1
assert myMap.get('a', 0) == 1


assert myMap['d'] == null
assert myMap.d == null
assert myMap.get('d') == null

assert myMap.get('d', 0) == 0
assert myMap.d == 0
assert myMap['d'] == 0
assert myMap['z'] == null

myMap['d'] = 2
assert myMap.d == 2
myMap.d = 1
assert myMap.d == 1



myMap = [a:1, b:2, c:3]
def other = [b:2, c:3, a:1]

assert myMap == other
assert myMap.isEmpty() == false
assert myMap.size() == 3
assert myMap.containsKey('a')
assert myMap.containsValue(1)

assert myMap.keySet() == ['a', 'b', 'c'].toSet()
assert myMap.values().toSet() == [1, 2, 3].toSet()

assert myMap.entrySet() instanceof Collection



myMap = [a:1, b:2, c:3]
def store = ''
myMap.each { entry ->
	store += entry.key
	store += entry.value
}
assert store.contains('a1')
assert store.contains('b2')
assert store.contains('c3')


store = ''
myMap.each { key, value ->
	store += key
	store += value
}
assert store.contains('a1')
assert store.contains('b2')
assert store.contains('c3')


store = ''
myMap.keySet().each { key ->
	store += key
}
assert store.contains('a')
assert store.contains('b')
assert store.contains('c')


store = ''
myMap.values().each { value ->
	store += value
}
assert store.contains('1')
assert store.contains('2')
assert store.contains('3')


myMap = [a:1, b:2, c:3]
myMap.clear()
assert myMap.isEmpty()

myMap = [a:1, b:2, c:3]
myMap.remove('a')
assert myMap.size() == 2

myMap = [a:1, b:2, c:3]
def abMap = myMap.subMap(['a', 'b'])
assert abMap.size() == 2
assert abMap.a == 1
assert abMap.b == 2

abMap = myMap.findAll { it.value < 3}
assert abMap.size() == 2
assert abMap.a == 1


def foud = myMap.find { it.value < 2}
assert foud.key == 'a'
assert foud.value == 1

def doubled = myMap.collect { it.value * 2 }
assert doubled instanceof List
assert doubled.size() == 3
assert doubled.contains(4)
assert doubled.every{ it % 2 == 0}

def addTo = []
myMap.collect(addTo) { it.value * 2 }
assert addTo instanceof List
assert addTo.every{ it % 2 == 0 }




