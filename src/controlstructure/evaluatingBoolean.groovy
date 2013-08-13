assert true
assert !false

assert 'a' =~ /\w/
assert !'a' =~ /\b/

assert [1]
assert ![]

assert [a:1]
assert ![:]

assert 'a'
assert ' '
assert !''

assert 1
assert 1.1
assert 1.2f
assert 1.3g
assert 2l
assert 3g
assert !0
assert !0.0

assert new Object()
assert !null

