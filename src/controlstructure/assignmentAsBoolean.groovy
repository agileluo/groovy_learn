def x = 1

if(x == 2){
	assert false
}

/*if(x = 2){ //compile error
	println x
}*/

if((x = 3)){
	println x
}
assert x == 3

def store = []
while(--x){
	store << x
}
assert store == [2, 1]

while( x = 1){
	println x
	break
}

