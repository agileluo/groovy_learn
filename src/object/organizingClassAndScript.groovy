import object.thirdpart.MathLib as ThirdMathLib
import object.thirdpart2.MathLib as IncMathLib

class Mathlib extends ThirdMathLib{
	Integer twice(Integer i){
		return 2 * i
	}	
}

def mathLib = new Mathlib()

assert 10 == mathLib.twice(5)
assert 2  == mathLib.half(5)

def math1 = new ThirdMathLib()
def math2 = new IncMathLib()

assert 3 == math1.half(math2.increment(5))

