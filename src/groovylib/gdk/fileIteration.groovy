def file = new File('src/groovylib/gdk/fileIteration.groovy')
file.eachLine { println it }

assert file.any { it =~ /File/ }

assert file.findAll(){ it =~ /File/ }.size() == 3

assert file.grep{it}.size() == 5