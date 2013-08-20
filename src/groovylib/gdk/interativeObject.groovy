samples = 4

def domain(yield){
	step = Math.PI * 2 / samples
	(0..samples).each { yield  it * step }
}

domain { println it }

println this.&domain.collect { Math.sin(it) }