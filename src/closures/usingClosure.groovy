

def adder = { x, y -> return x + y}

assert 5 == adder(2, 3)
assert 7 == adder.call(3, 4)


def benchMark(repeat, Closure worker){
	start = System.currentTimeMillis()
	repeat.times { worker(it) }
	
	stop = System.currentTimeMillis()
	return stop - start 
}

def slow = benchMark(10000) { (int) it/2 }
def fast = benchMark(10000) { it.intdiv(2) }

assert fast * 2 < slow


adder = { x, y=5 -> return x+y }

assert 5 == adder(2, 3)
assert 12 == adder(7)


def caller(Closure closure){
	return closure.getParameterTypes().size()
}

assert 1 == caller { x -> }
assert 2 == caller { x, y -> }


adder = { x, y -> return x + y }
def addOne = adder.curry(5)
assert addOne(6) == 11



def config = { format, filter, line ->
	filter(line) ? format(line) : null
}
def appender = { configer, appen, line ->
	if(configer(line)){
		appen(line)
	}
}
def dataFormat = { line-> println "${new Date()}: $line" }
def debugFilter = { line -> return line.contains("debug") }
def consoleAppender = { line -> println line}
def myConfig = config.curry(dataFormat, debugFilter)
def log = appender.curry(myConfig, consoleAppender)
log("hello")
log("hello debug")


assert [1, 2, 3].grep { it < 3 } == [1, 2]

switch(10){
	case { it%2 == 1 } : assert false;
}

