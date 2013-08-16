import java.awt.event.ActionEvent
import java.awt.event.ActionListener

import javax.swing.JButton

class DoublerBean {
	public value
	void setValue(value){
		this.value = value
	}
	Object getValue(){
		return value * 2
	}
}

def bean = new DoublerBean()
bean.setValue(3)
assert 6 == bean.getValue()
assert 3 == bean.@value


final JButton button = new JButton('Jb')
button.addActionListener(new ActionListener(){
	void actionPerformed(ActionEvent e){
		System.out.println(button.getText());
	}
})

button.actionPerformed = { event ->
	println button.text
}

class SomeClass3{
	def someProperty
	public someField
	private somePrivateField
}

def obj = new SomeClass3()

def store = []

obj.properties.each{ key, value ->
	store += key
	sorte += value
}



