def x = 0
10.times { x++ }
assert x == 10


class Mother{
	int field = 1
	int foo(){
		return 2
	}
	Closure birth(param){
		def local = 3
		def closure = { caller ->
			[this, field, foo(), local, param, caller]
		}
	}
}
Mother julia = new Mother()
def closure = julia.birth(4)
def context =  closure.call(this)

println context[0].class.name 

assert context[1..4] == [1, 2, 3, 4]
assert context[5] instanceof Script
assert context[0] instanceof Mother


def foo(n){
	return { n += it }
}

def accumulate = foo(1)

assert accumulate(2) == 3
assert accumulate(1) == 4 










