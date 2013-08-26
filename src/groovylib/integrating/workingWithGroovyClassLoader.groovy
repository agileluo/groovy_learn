def gcl = new GroovyClassLoader()
Class helloClass = gcl.parseClass(new File("src/groovylib/integrating/Hello.groovy"))
assert "hello" == helloClass.newInstance().greeting()

