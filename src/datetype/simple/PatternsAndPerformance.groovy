def twister = 'shw sells sea shells at the sea shore of seycheelles'

regex = /\b(\w)\w*\1\b/

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


