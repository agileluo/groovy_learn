class Money{
	private int amount
	private String currency
	Money(amount, currency){
		this.amount = amount
		this.currency = currency
	}
	boolean equals (Object other){
		if ( null == other) return false
		if ( ! other instanceof Money ) return false
		if ( ! amount == other.amount) return false
		if ( ! currency == other.currency ) return false
		return true
	}
	Money plus (Money other){
		if ( null == other ) return null;
		if ( currency != other.currency) {
			throw new IllegalArgumentException("currency must be same");
		}
		return new Money(amount + other.amount, currency)
	}
}

def duck = new Money(100, "USD")
assert duck == new Money(100, "USD")
assert duck + duck == new Money(200, "USD")
