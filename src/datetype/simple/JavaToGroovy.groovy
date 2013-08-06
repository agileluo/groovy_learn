import java.awt.GradientPaint;

System.out.println("hello world!");
System.out.println('hello world!');

println("hello world!")

println "hello world!"

def greeting = 'Hello Groovy!'

assert greeting.startsWith('Hello')

assert greeting.getAt(0) == 'H'
assert greeting[0] == 'H'

assert greeting.indexOf('Groovy') >= 0
assert greeting.contains('Groovy')

assert greeting[6..11] == 'Groovy'

assert 'Hi' + greeting - "Hello" == 'Hi Groovy!'

assert greeting.count('o') == 3

assert 'x'.center(3)  == ' x '
assert 'x' * 3 == 'xxx'



def other = 'Hello'
other <<= ' Groovy'
assert other instanceof StringBuffer

other << '!'
assert other.toString() == "Hello Groovy!"

other[1..4] = 'i'
assert other.toString() == "Hi Groovy!" 





















