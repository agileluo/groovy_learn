import com.gmongo.GMongo

def mongo = new GMongo("127.0.0.1", 27017)
def db = mongo.getDB("gmongo")

assert db.myCollection instanceof com.mongodb.DBCollection
assert db['my.collection'] instanceof com.mongodb.DBCollection

db.languages.remove([:])

db.languages.insert([name: 'Groovy'])
db.languages.insert(name: 'ruby')
db.languages << [name: 'Python']


db.languages << [[name: 'javascript', type: 'prototyped'], [name: 'Ikoe', type: 'prototyped']]

def statics = ['Java', 'c', 'VB']

statics.each {
	db.languages << [name: it, type:'static']
}

def lang = db.languages.findOne()
assert lang.name == 'Groovy'


lang.site = 'http://groovy.codehaus.org/'
db.languages.save lang

assert db.languages.findOne('name': 'Groovy').site == 'http://groovy.codehaus.org/'


assert db.languages.find(type: 'static').count()  == 3

assert db.languages.count(type: 'prototyped') == 2


db.languages.update([name: 'Python'], [$set: [paradigms: ['object-oriented', 'functional', 'imperative']]])

assert 3 == db.languages.findOne(name: 'Python').paradigms.size()

//Using upsert
db.languages.update([name: 'Haskel'], [$set: [paradigms: 'shell']], true)

assert db.languages.findOne(name: 'Haskel')


db.languages.remove(type: 'prototyped')
assert 0 == db.languages.count(type: 'prototyped')

db.languages.remove([:])
assert 0 == db.languages.count()


db.inRequest{
	db.languages.save([name: 'groovy'])
	assert 1 == db.languages.count()
}









