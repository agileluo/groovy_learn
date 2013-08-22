class Storge{
	List stack = []
	synchronized void leftShift(value){
		stack << value
		println "push: $value"
		notifyAll()
	}
	synchronized Object pop(p) {
		while(stack.isEmpty()){
			wait()
		}
		println "pop: ${stack.pop()}"
	}
}

def storge = new Storge()

Thread.start {
	for(i in 0..9){
		storge << i
		sleep 100
	}
}

Thread.start {
	10.times {
		sleep 200
		storge.pop()
	}
}

