assert [1, [2, 3]].flatten() == [1, 2, 3]

assert [1, 2, 3].intersect([4, 3, 1]) == [3, 1]
assert [1, 2, 3].grep([4, 3, 1]) == [1, 3]

assert [1, 2, 3].disjoint([4, 5, 6])


def list = [1, 2, 3]
def popped = list.pop()
assert popped == 3
assert list == [1, 2]

assert [1, 2].reverse() == [2, 1]
assert [3, 1, 2].sort() == [1, 2, 3]

list = [ [1, 0], [0, 1, 2] ]
list = list.sort() {a, b -> a[0] <=> b[0]}
assert list == [[0, 1, 2], [1, 0]]


list = list.sort {item -> item.size()}
assert list == [[1, 0], [0, 1, 2]]


list = ['a', 'b', 'c']
list.remove(2)
assert list == ['a', 'b']
list.remove('b')
assert list == ['a']


list = ['a', 'b', 'b', 'c']
list.removeAll(['b', 'c'])
assert list == ['a']

def doubled = [1, 2, 3].collect{ it*2}
assert doubled == [2, 4, 6]

def odd = [1, 2,3].findAll() {
	it % 2 == 1 
}
assert odd == [1, 3]



def x = [1, 1, 1]
assert [1] == new HashSet(x).toList()
assert [1] == x.unique()

x = [1, null, 1]
assert [1, 1] == x.findAll{ it != null }
assert [1, 1] == x.grep{it}




