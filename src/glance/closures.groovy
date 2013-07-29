[1, 2, 3].each { println it }

def totalClinks = 0
def partyPersons = 100
1.upto(partyPersons) { totalClinks += it - 1}
assert totalClinks == partyPersons * (partyPersons  - 1) / 2


1.upto(10) { print "$it " }