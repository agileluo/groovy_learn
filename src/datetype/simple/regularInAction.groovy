myFairStringy = "The rain in Spain stays mainly in the plain!"

BOUNDS = /\b/

rhyme = /$BOUNDS\w*ain$BOUNDS/

found = ''

myFairStringy.eachMatch(rhyme) { match ->
	found += match + ' '
}

assert found == 'rain Spain plain '

found = ''

(myFairStringy =~ rhyme).each { match ->
	found += match + " "
}
assert found == 'rain Spain plain '

cloze = myFairStringy.replaceAll(rhyme) { it - 'ain' + '___' }
assert cloze == 'The r___ in Sp___ stays mainly in the pl___!'



def matcher = 'a b c' =~ /\w/
assert matcher[0] == 'a'
assert matcher[1..2] == ['b', 'c']
assert matcher.size() == 3


matcher = 'a:1 b:2 c:3' =~ /(\S+):(\S+)/

assert matcher.hasGroup()

assert matcher[0] == ['a:1', 'a', '1']

('xy' =~ /(.)(.)/).each { all, x, y ->
	assert all == 'xy'
	assert x == 'x'
	assert y == 'y'
}

