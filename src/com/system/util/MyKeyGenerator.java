package com.system.util;

import java.lang.reflect.Method;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKey;

/**
 * 自定义缓存Key生成器(方法名加参数的方式)
 * @author yangtao
 *
 */
public class MyKeyGenerator implements KeyGenerator {

	@Override
	public Object generate(Object object, Method method, Object... params) {
		Object[] objects = new Object[params.length+1];
		objects[0] = method.getName();
		
		for (int i=0;i<params.length;i++) {
			objects[i+1] = params[i];
		}
		return new SimpleKey(objects);
	}
}
