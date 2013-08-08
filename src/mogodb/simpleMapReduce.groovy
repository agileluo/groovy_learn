import com.gmongo.GMongo

// There is some bug using the [Random] word into codesnipt plugin
import java.util.Random as Rand

def mongo = new GMongo("127.0.0.1", 27017)
def db = mongo.getDB("gmongo")

db.words.remove([:])

def words = ['foo', 'bar', 'baz']
def rand  = new Rand()

1000.times{
	db.words << [word: words[rand.nextInt(3)]]
}

assert db.words.count() == 1000

def result = db.words.mapReduce(
"""
function map(){
	emit(this.word, {count: 1})
}
""",
"""
function reduce(key, values){
	var count = 0
	for(var i = 0; i < values.length; i++)
		count += values[i].count
	return {count: count}
}
""",
"mrresult",
[:]	
)

assert db.mrresult.count() == 3
assert db.mrresult.find()*.value*.count.sum() == 1000
