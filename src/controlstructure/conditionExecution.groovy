if(true) assert true
else assert false

if(1){
	assert true
}else{
	assert false
}

if('not-empty') assert true
else if (['x']) assert true
else 			assert false

if(0)		assert false
else if([]) assert false
else 		assert true

def result = ( 1 == 1) ? 'ok' : 'failed'
assert result == 'ok'

result = 'some thing ' ? 10 : ['x']
assert result == 10


switch(10){
	case 0			: assert false; break
	case 0..9		: assert false; break
	case [8, 9, 11] : assert false; break
	case Float 		: assert false; break
	case {it%3 == 0}: assert false; break
	case ~/\d{2}/	: assert true ; break
	default 		: assert false; break
}



