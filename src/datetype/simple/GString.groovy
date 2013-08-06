import org.codehaus.groovy.runtime.GStringImpl;

me = 'agileluo'
you =  'groovy'
line = "$me love $you"
assert line == "agileluo love groovy"
assert line.strings[1] == " love "
assert line.values[0] == me
assert line.values[1] == you



date = new Date(0)
out = "year $date.year month $date.month day $date.date"
assert out == "year 70 month 0 day 1"

