class VendorWithCtor{
	String name, product
	VendorWithCtor(name, product){
		this.name = name
		this.product = product
	}
}

def fisrt = new VendorWithCtor('Canoo', "uubox")
def sencod = ['Canoo', "uubox"] as VendorWithCtor
VendorWithCtor third =  ['Canoo', "uubox"]


class Vendor{
	String name, product
}
new Vendor()
new Vendor(name: 'Canno')
new Vendor(product: "ULC")
new Vendor(name: 'Canno', product: 'good')

def vendor = new Vendor(name: 'agileluo')
assert 'agileluo' == vendor.name

java.awt.Dimension area = [100, 200]
assert 100 == area.width
assert 200 == area.height






