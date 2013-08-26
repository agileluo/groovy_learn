import org.codehaus.groovy.control.CompilerConfiguration


def shell = new GroovyShell()
def result = shell.evaluate("12 + 3*2")
assert 18 == result

assert evaluate("3 * 4") == 12


def kineticEnergy = shell.evaluate('''
	def mass = 20.6
	def velctory = 6.4
	mass * velctory**2 / 2
''')

assert kineticEnergy == 421.888


assert "hello" == Eval.me("'hello'")
assert 1 == Eval.x (1, "x")
assert 3 == Eval.xy(1, 2, "x + y")
assert 6 == Eval.xyz(1, 2, 3, "x + y + z")

def binding = new Binding()
binding.mass = 20.6
binding.velctory = 6.4

shell = new GroovyShell(binding)
assert shell.evaluate("mass * velctory**2 / 2") == 421.888

binding.mass = 10.3
assert shell.evaluate("mass * velctory**2 / 2") == 210.944


binding = new Binding(x: 3, y : 4)
shell  = new GroovyShell(binding);
shell.evaluate('''
	x2 = x**2
	y3 = y**3
''')
assert binding.getVariable("x2") == 9
assert binding.y3 == 64


shell = new GroovyShell()
def clazz = shell.evaluate('''
	class MyClass{
		def method() { return "hello" }
	}
	return MyClass
''')

assert clazz.name == "MyClass"
def instance = clazz.newInstance()
assert instance.method() == "hello"

def monthly = "amount * (rate/12) / (1 - (1 + rate/12)**-numberOfMonths)"
shell = new GroovyShell()
def script = shell.parse(monthly)

script.binding.amount = 300000
script.binding.rate = 6.55/100
script.binding.numberOfMonths = 240

assert script.run() == 2245.5590778051433

script.binding = new Binding(
		amount: 400000,
		rate: 6.55/100,
		numberOfMonths: 60
	)

assert script.run() == 7835.830652583356


binding = new Binding(multiply: { x, y -> x * y })
shell = new GroovyShell(binding)
def value = shell.evaluate('''

	multiply(5, 6)
''')
assert value == 30




  
