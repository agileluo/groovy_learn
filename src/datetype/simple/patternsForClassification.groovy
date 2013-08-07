assert (~/..../).isCase('abcd')

switch('abcd'){
	case ~/..../ : assert true; break
	default : assert false
}

beats = ['bear', 'wolf', 'triger', 'regex']

assert beats.grep(~/..../) == ['bear', 'wolf']

