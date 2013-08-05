class B {
	def String name
	public B(String name){
		this.name = name
	}
	public B minus(B b){
		return new B(this.name + b.name)
	}
	public String toString(){
		name
	}
}

def a = new B("hello")
def b = new B(" world")
println a - b 
