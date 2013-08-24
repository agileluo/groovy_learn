import groovy.text.SimpleTemplateEngine

def mailReader = '''
Dear <%= salutation? salutation + ' ' : '' %>$lastname,
another month has passed and it's time for these
${task.size()} tasks:
<% task.each { %> -$it
<% }%>'''

def engine = new SimpleTemplateEngine(true)
def bing = [
	salutation: 'Mr.',
	lastname: 'agileluo',
	task: ['learn groovy','learn java core']
	]
assert engine.createTemplate(mailReader).make(bing).toString() == '''
Dear Mr. agileluo,
another month has passed and it's time for these
2 tasks:
 -learn groovy
 -learn java core
'''