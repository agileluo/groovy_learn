def box = new Expando()

assert null == box.name
box.name = 'agile'
assert 'agile' == box.name

box.printTimes =  { times -> box.name * times }

assert 'agileagileagile' == box.printTimes(3)