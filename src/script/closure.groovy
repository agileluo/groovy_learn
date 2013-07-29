/**
 * comment
 */
def number = 0
new File('src/script/closure.groovy').eachLine { line ->
	number++
	println "$number: $line"
}

def classes = [String, List, File]
for(clazz in classes){
	println clazz.'package'.name
}

println( [String, List, File].'package'.name )

def i = 0
10.times { print "${i++} " }
println()

str = URLEncoder.encode "a, b"
println str