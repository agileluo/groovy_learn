def log = ''
(1..9).each { counter -> log += counter }
assert log == '123456789'

log = ''
(1..9).each { log += it }
assert log == "123456789"

class MethodClosureSimple{
	int limit
	MethodClosureSimple(int limit){
		this.limit = limit
	}
	boolean validate(String value){
		return value.length() <= limit
	}
}

MethodClosureSimple first = new MethodClosureSimple(6)
MethodClosureSimple second = new MethodClosureSimple(5)

Closure firstMethod = first.&validate

def words = ['long string', 'medium', 'short', 'tiny']

assert 'medium'  == words.find(firstMethod)
assert 'short' == words.find(second.&validate)


class MultiMethodSample{
	int  mysteryMethod(String value){
		return value.length()
	}
	int  mysteryMethod(List values){
		return values.size()
	}
	int  mysteryMethod(int x, int y){
		return x + y
	}
}

Closure mystery = new MultiMethodSample().&mysteryMethod

assert 5 == mystery('agile')
assert 3 == mystery(['java', 'groovy', 'js'])
assert 10 == mystery(4, 6)


def map = [a:1, b:2]
map.each { key, value -> map[key] = value * 2 }
assert map == [a:2, b: 4]

def doubled = { key, value -> map[key] = value * 2 }
map.each(doubled)
assert map == [a:4, b:8]

def doubledMethod(entry){
	entry.value *= 2
}
Closure douber = this.&doubledMethod
map.each(douber)
assert map == [a:8, b:16]

