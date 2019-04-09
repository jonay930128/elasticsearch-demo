package wrx.xing;

import javassist.*;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;

import java.lang.reflect.Method;

/**
 * 请填写类的描述
 *
 * @author wangruxing
 * @date 2019-01-06 20:40
 */
public class MethodClassTest {
	public static void main(String[] args) throws Exception{
		methodArgs();
	}

	public void add(int a,int b){
		System.out.println(a + b);
	}

	public static void methodArgs() throws Exception{
		Class<MethodClassTest> clazz = MethodClassTest.class;
		for (Method method : clazz.getDeclaredMethods()) {
			ClassPool pool = ClassPool.getDefault();
			pool.insertClassPath(new ClassClassPath(clazz));
			CtClass cc = pool.get(clazz.getName());
			CtMethod cm = cc.getDeclaredMethod(method.getName());
			MethodInfo methodInfo = cm.getMethodInfo();
			CodeAttribute codeAttribute = methodInfo.getCodeAttribute();
			LocalVariableAttribute attr =
					(LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag);

			if (attr != null) {
				String[] paramNames = new String[cm.getParameterTypes().length];
				int pos = Modifier.isStatic(cm.getModifiers()) ? 0 : 1;
				for (int i = 0; i < paramNames.length; i++) {
					paramNames[i] = attr.variableName(i + pos);
				}
				for (int i = 0; i < paramNames.length; i++) {
					System.out.println(paramNames[i]);
				}
			}
		}
	}
}
