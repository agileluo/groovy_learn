import java.net.InetAddress.Cache;

class SomeClass1{
	void publicVoidMetod(){
	}
	def publicUntypedMethod(){
		return 'hi'
	}
	String publicTypedMethod(){
		return 'ho'
	}
	protected static final void combineMethod(){
	}
}
def name = new SomeClass1()
name.publicVoidMetod()
assert 'hi' == name.publicUntypedMethod()
assert 'ho' == name.publicTypedMethod()
SomeClass1.combineMethod()


class SomeClassB{
	static method(arg){
		return "untyped"
	}
	static method(String str){
		return "string"
	}
	static method(arg, Number i){
		return 'two args'
	}
}
assert 'untyped' ==  SomeClassB.method(1)
assert 'untyped' ==  SomeClassB.method(null)
assert 'string' == SomeClassB.method('hello')
assert 'two args' == SomeClassB.method(null, 2)


class Summer{
	def sumWithDefaults(a, b, c=0){
		return a + b + c
	}
	def sumWithList(List args){
		return args.inject(0) { sum, i -> sum += i }
	}
	def sumWithOptions(a, b, Object[] options){
		return a + b + sumWithList(options.toList())
	}
	def sumNamed(Map args){
		['a', 'b', 'c'].each { args.get(it, 0) }
		return args.a + args.b + args.c
	}
}
def summer = new Summer()
assert 2 == summer.sumWithDefaults(1, 1)
assert 3 == summer.sumWithDefaults(1, 1, 1)


assert 2 == summer.sumWithList([1, 1])
assert 3 == summer.sumWithList([1, 1, 1])


assert 2 == summer.sumWithOptions(1, 1)
assert 3 == summer.sumWithOptions(1, 1, 1)


assert 1 == summer.sumNamed(a: 1)
assert 2 == summer.sumNamed(a: 1, b: 1)
assert 3 == summer.sumNamed(a: 1, b: 1, c: 1)



def map = [a: [b: [c: 1]]]
assert map.a.b.c == 1

if(map && map.a && map.a.x){
	assert map.a.x.c == null
}

try{
	map.a.x.c = null	
}catch(NullPointerException e){
}

map?.a?.x?.c = null






