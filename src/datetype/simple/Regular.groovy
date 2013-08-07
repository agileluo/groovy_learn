import java.util.regex.Matcher;

assert "1234" ==~ /\d+/

assert "abc" == /abc/

def reference = "hello"
assert reference == /$reference/

assert "\$" == /$/

twister = 'she sells sea shells at the sea shorts of seycheeles'

assert twister =~ /s.a/

findler = (twister =~ /s.a/)
assert findler instanceof Matcher

assert twister ==~ /(\w+)( \w+)+/

word = /\w+/
matcher = (twister ==~ /$word(word )+/)
assert matcher instanceof Boolean

assert (twister ==~ /a.e/) == false

wordsByX = twister.replaceAll(word, "x")
assert wordsByX == 'x x x x x x x x x x'


words = twister.split(/ /)
assert words.size() == 10
assert words[0] == 'she'


























