def customers = new XmlSlurper().parse(new File("src/script/customers.xml"))
for(customer in customers.corporate.customer){
	println "${customer.@name} work for ${customer.@company}"
}