import groovy.swing.SwingBuilder

def swing = new SwingBuilder()

def frame = swing.frame(title:'Password'){
	passwordField(columns:10, actionPerformed:{ event ->
			println event.source.text
			System.exit(0)
		})
}
frame.pack()
frame.show()
