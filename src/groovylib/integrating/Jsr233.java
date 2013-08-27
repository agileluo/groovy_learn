package groovylib.integrating;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Jsr233 {
	public static void main(String[] args) throws ScriptException {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine eng = manager.getEngineByName("groovy");
		eng.eval("def say(){ println 'hello' }");
		Invocable invocable = (Invocable)eng;
		BusinessService businessService = invocable.getInterface(BusinessService.class);
		businessService.say();
	}
}
interface BusinessService{
	void say();
}
