def newLine = "\n"
assert newLine.toString() == "\n"
println newLine.dump()
assert newLine.inspect() == /'\n'/

//groovy.inspect.swingui.ObjectBrowser.inspect(newLine)

println properties

println newLine.properties

class MyClass{
	def first = 1
	def getSecond(){ return first * 2 }
	public third = 3
}

def obj = new MyClass()

def keys = ['first', 'second', 'class']

assert obj.properties.keySet() == new HashSet(keys)

assert 1 == obj.properties['first']
assert 1 == obj.properties.first

assert 1 == obj.first
assert 1 == obj['first']

def one = 'first'
def two = 'second'
obj[one] = obj[two]

assert obj.dump() =~ /first=2/


class PersonDao{
	def findAll(){
		"select * from person"
	}
}

def personDao = new PersonDao()
assert personDao.invokeMethod('findAll', new Object[0]) == 'select * from person'

class ClosureDao{
	public findAll = {
		"select * from person"
	}
}
dao = new ClosureDao()
assert dao['findAll'](*[]) == 'select * from person'

printf('PI=%2.5f and E=%2.5f', Math.PI, Math.E)

text = """
This text appears
slowly on the screen
as if someone would
tpye \b\b \b\b \b\b \bype it.
"""
for (c in text) {
	sleep 100
	print c
}




