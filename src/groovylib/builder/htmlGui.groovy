import groovy.xml.MarkupBuilder

def writer = new FileWriter("markup.html")
def builder = new MarkupBuilder(writer)
def html = builder.html{
	head{
		title "Constructed by MarkupBuilder"
	}
	body{
		h1 "What can I do with MarkupBuilder?"
		form(action:'whatever'){
			for(id in ['Produce HTML', 'Produce XML', 'Have some fun']){
				input(checked:'checked', type: 'checkbox', id: id)
				label(for:id, id)
				br('')
			}
		}
	}
}