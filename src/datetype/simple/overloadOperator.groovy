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


def myword = 
'''
every person know that,
we are best for it!

thank your!
'''
println myword
def n = 1.0