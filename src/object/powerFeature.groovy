class Invoice {
	List items
	Date date
}
class LineItem {
	Product product
	int count
	int total() {
	return product.dollar * count
	}
}
class Product {
	String name
	def dollar
}
def ulcDate = new Date(107,0,1)
def ulc = new Product(dollar:1499, name:'ULC')
def ve = new Product(dollar:499, name:'Visual Editor')
def invoices = [
	new Invoice(date:ulcDate, items: [
		new LineItem(count:5, product:ulc),
		new LineItem(count:1, product:ve)
	]),
	new Invoice(date:[107,1,2], items: [
		new LineItem(count:4, product:ve)
	])
]
assert [5*1499, 499, 4*499] == invoices.items.flatten()*.total()
assert ['ULC'] ==
invoices.items.flatten().grep{it.total() > 7000}.product.name
def searchDates = invoices.grep{
	it.items.any{it.product == ulc}
	}.date*.toString()
assert [ulcDate.toString()] == searchDates



def getList(){
	return [1, 2, 3]
}
def sum(a, b, c){
	return a + b + c
}
assert 6 == sum(*list)

def rang = [1, 2, 3]
assert [0, 1, 2, 3] == [0, *rang]

def map = [b: 2, c: 3]
assert [a: 1, b: 2, c: 3] == [a:1, *:map]


class StringCalcCategory{
	static def plus(String self, String operator){
		try{
			return self.toInteger() + operator.toInteger()
		}catch (NumberFormatException e) {
			return (self << operator).toString()
		}
	}
}

use(StringCalcCategory){
	assert 1 == '1' + '0'
	assert 2 == '1' + '1'
	assert 'x1' == 'x' + '1'
}
