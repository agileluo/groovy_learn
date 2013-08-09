class WeekDay implements Comparable{
	static final DAYS = [
		'Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat']
	private int index;
	WeekDay(String day){
		index = DAYS.indexOf(day)
	}
	WeekDay next(){
		new WeekDay(DAYS[(index+1) % DAYS.size()])
	}
	WeekDay previous(){
		new WeekDay(DAYS[index-1])
	}
	int compareTo(Object other){
		this.index <=> other.index
	}
	String toString(){
		DAYS[index]
	}
}

def log = ''
def today = new WeekDay('Fri')
def nextWorkDay = new WeekDay('Mon')
(today..nextWorkDay).each {
	log += it.toString() + ' '
}
assert log == 'Fri Thu Wed Tue Mon '

