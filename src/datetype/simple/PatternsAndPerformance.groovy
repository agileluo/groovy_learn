def twister = 'shw sells sea shells at the sea shore of seycheelles'

def regex = /\b(\w)\w*\1\b/

start = System.currentTimeMillis()
100000.times {
	twister =~ regex
}

first = System.currentTimeMillis() - start

start = System.currentTimeMillis()
pattern = ~regex
100000.times {
	pattern.matcher(twister)
}
second = System.currentTimeMillis() - start

println "first: ${first/1000}, secnod: ${second/1000}"


//The other way
def benchMethod(repeat, Closure closure){
	start = System.currentTimeMillis()
	repeat.times{ closure.call() }
	stop = System.currentTimeMillis()
	return stop - start
}
def slow = benchMethod(100000) { twister =~ regex }
def fast = benchMethod(100000) { pattern.matcher(twister) }
println "slow: ${slow/1000}, fast: ${fast/1000}"