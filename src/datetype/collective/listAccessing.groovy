def list = [1, 2, 3]

assert list.count(2) == 1
assert list.max() == 3
assert list.min() == 1

def even = list.find{ it % 2 == 0}
assert even == 2

assert list.every { it < 5 }
assert list.any { it < 2 }


def store = ''
list.each { store +=  it }
assert store == '123'

store = ''
list.reverseEach { store += it }
assert store == '321'

assert list.join('-') == '1-2-3'

def result = list.inject(0) { clinks, guest->
	clinks += guest
}
assert result == 0 + 1 + 2 + 3
assert list.sum() == 6

def factorial = list.inject(1) { fact , item->
	fact *= item
}
assert factorial == 1 *  1 * 2 * 3











