def file = new File('src/groovylib/gdk/traveringFilesystem.groovy')

println file.name
println file.absolutePath
println file.canonicalPath

def homeDir = new File(".")
def dir = []
homeDir.eachDir { dir << it.name }
assert ['.git', '.settings', 'bin', 'data', 'src', 'target'] == dir

//println "++++++++++++++++++"
//println file.text


def example = new File("data/example.txt")

def lines = ['line one', 'line two', 'line three']
assert lines == example.readLines()

example.eachLine {
	it.startsWith('line')
}

def hex = []
example.eachByte { hex << it }
assert hex.size() == example.length()

example.splitEachLine(/\s/) {
	assert it[0] == 'line'
}

example.withReader { reader ->
	assert 'line one' == reader.readLine()
}

def outFile = new File('data/out.txt')

lines = ['line one', 'line two', 'line three']

outFile.write(lines[0..1].join('\n'))
outFile.append("\n" + lines[2])

assert lines == outFile.readLines()

outFile.withWriter { writer ->
	writer.writeLine(lines[0])
}

outFile.withWriterAppend { writer ->
	writer << lines[1] << '\n'
}

outFile << lines[2]

assert lines == outFile.readLines()


def reader = new StringReader("abc")
def writer = new StringWriter()

writer << "\nsome String" << "\n"
writer << [a:1, b:2] << "\n"
writer << [3,4] << "\n" 
writer << new Date(0) << "\n"
writer << reader << "\n"

assert writer.toString() == """
some String
[a:1, b:2]
[3, 4]
Thu Jan 01 08:00:00 CST 1970
abc
"""


byte[] data = new byte[256]

(0..<256).each { data[it] = it }

def store = data.encodeBase64().toString()

assert store.startsWith("AAECAwQFBg")
assert store.endsWith("r7/P3+/w==")

def stored = store.decodeBase64()

assert stored == data










