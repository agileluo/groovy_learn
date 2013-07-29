def langs = ['java', 'groovy', 'js', 'c++', 'shell']

assert langs[0] == 'java'
langs[8] = 'c#'
assert langs.size() == 9

def http = [
	200: "ok",
	400: "not found",
	500: "system busy"
	]

assert "ok" == http[200]
assert 3 == http.size()
http[800] = "not know"
assert "not know" == http[800]
assert 4 == http.size()

def range = 1..10
assert range.contains(2)
assert range.from == 1
assert range.to == 10
assert 1 == range[0]
assert 10 == range.size()
assert range.reverse() == 10..1

println evaluate("1 + 'I know it'.toUpperCase()")

