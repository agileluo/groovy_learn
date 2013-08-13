def store = ''
for(String c in 'a'..'c') store += c
assert store == 'abc'

store = ''
for(i in [1, 2, 3]){
	store += i
}
assert store == '123'


store = ''
def mything = 'equvalent to java'
for(i in 0..<mything.size()){
	store += mything[i]
}
assert store == mything

store = ''
for(c in mything){
	store += c	
}
assert store == mything

def matcher = '123d4' =~ /\d/
for(m in matcher) println m

for(m in new Object()) println "print one for object $m"

for(i in 0..9) print i
println ""
(0..9).each { print it }