def file = new File('data/objects.dta')

def out = file.newOutputStream()
def oos = new ObjectOutputStream(out)

def objects = [1, 'Hello groovy!', new Date()]

objects.each {
	oos.writeObject(it)
}
oos.close()

def received = []
file.eachObject {
	received << it
}

assert received == objects
