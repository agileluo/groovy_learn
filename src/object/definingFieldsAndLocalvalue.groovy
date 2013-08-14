class SomeClass{
	public fieldWithModifier
	String typedField
	def untypedField
	protected field1, field2, field3
	private assignedField = new Date()
	
	static classField
	public static final String CONSTA = 'a', CONSTB = 'b'
	
	def somthMethod(){
		def localUntypedMethodVar = 1
		int localTypedMethodVar = 1
		def localVarWithoutAssignment, andAtherOne
	}
}

def localVar = 1
boundVar = 1

def someMethod(){
	localMethodVar = 1
	boundVar2 = 1
}

final String PI = 3.14
assert PI.class.name == 'java.lang.String'
assert PI.length() == 4

new GroovyTestCase().shouldFail(ClassCastException.class) {
	Float areaOfCircleRediousOne = PI
}



class Counter{
	public count = 0
}

def counter = new Counter()

counter.count = 1
assert counter.count == 1

def fieldName = 'count'
counter[fieldName] = 2
assert counter['count'] == 2


class PretendFieldCounter{
	public count = 0
	Object get(String name){
		return 'pretent value'
	}
	void set(String name, Object value){
		count++
	}
}
def pretendFiledCounter = new PretendFieldCounter()

assert pretendFiledCounter.isNoField == 'pretent value'
assert pretendFiledCounter.count == 0

pretendFiledCounter.isNoField = 'hello dynamic groovy'
assert pretendFiledCounter.count == 1

