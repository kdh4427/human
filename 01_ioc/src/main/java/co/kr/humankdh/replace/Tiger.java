package co.kr.humankdh.replace;

import java.lang.invoke.MethodHandleInfo;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.beans.factory.support.MethodReplacer;

public class Tiger implements MethodReplacer {

	@Override
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		System.out.println(obj.getClass().getCanonicalName());
		System.out.println(method.getName());
		System.out.println(Arrays.toString(args));
		return "난 호랑이다 어흥";
	}

}
