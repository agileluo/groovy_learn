class Equalizer{
	boolean equals(Equalizer e){
		return true
	}
}

Equalizer one = new Equalizer()
Equalizer other = new Equalizer()

assert one.equals(other)
assert !one.equals(new Object())