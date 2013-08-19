class DebugBuilder extends BuilderSupport{
	def result = ''<<''
	def indent = ' ' * 4
	int indentCount = -1
	def createNode(name){
		indentCount++
		return check(name)
	}
	def createNode(name, value){
		return check(createNode(name) << format(value))
	}
	def createNode(name, Map attributes){
		return check(createNode(name) << format(attributes))
	}
	def createNode(name, Map attributes, value){
		return check(createNode(name, attributes)<< format(value));
	}
	void setParent(parent, child) {
		result << '\n' << indent * indentCount << child.toString()
	}
	void nodeCompleted(parent,  node) {
		indentCount--
	};
	
	private check(desr){
		if(!current) result << desr
		return desr
	}
	private format(value){
		return '(' << value.toString() << ")"
	}
	private format(Map attrs){
		StringBuffer formatted = '' << '['
		attrs.each { key, value ->
			formatted << key << ':' << value << ", "
		}
		formatted.length = formatted.size() - 2
		formatted << ']'
		return formatted
	}
}

def debugBuilder = new DebugBuilder()
debugBuilder.foo(){
	bar()
	baz('x') { map(a:1) }
}
println debugBuilder.result