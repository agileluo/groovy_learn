import groovy.xml.MarkupBuilder

def builder = new MarkupBuilder()

builder.numbers {
	description "Squares and factors of 10..15"
	for(i in 10..15){
		number(value: i, square: i*i){
			for(fact in 2..i-1){
				if( i % fact == 0){
					factor(value: fact)
				}
			}
		}
	}
}

def nodeBuilder = new NodeBuilder()

def ulcDate = new Date(2013, 8, 19)

def invoices = nodeBuilder.invoices{
	invoice(date: ulcDate){
		item(count:5){
			product(name:'ULC', dollar:1499)
		}
		item(count:1){
			product(name:'Visual Editor', dollar:499)
		}
	}
	invoice(date: new Date(2013,8,20)){
		item(count:4){
			product(name:'Visual Studio', 499)
		}
	}
}
def soldAt = invoices.grep{
	it.item.product.any{
		it.'@name' == 'ULC'
	}
}.'@date'
assert soldAt == [ulcDate]
