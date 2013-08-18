import org.codehaus.groovy.runtime.InvokerHelper
import org.codehaus.groovy.runtime.StringBufferWriter

class TraceAble implements GroovyInterceptable{
	Writer writer = new PrintWriter(System.out)
	private int intent = 0

	Object invokeMethod(String name, Object args){
		writer.write('\n' + ' ' * intent + "before method '$name'")
		writer.flush()
		intent++
		def metaClass = InvokerHelper.getMetaClass(this)
		def result = metaClass.invokeMethod(this, name, args)
		intent--
		writer.write('\n' + ' '* intent + "after method '$name'")
		writer.flush()
		return result
	}
}

class Whatever extends TraceAble{
	int outer(){
		return inner()
	}
	int inner(){
		return 1
	}
}

def log = new StringBuffer()
def traceMe = new Whatever(writer: new StringBufferWriter(log))

assert 1 == traceMe.outer()

assert log.toString() == """
before method 'outer'
 before method 'inner'
 after method 'inner'
after method 'outer'"""

