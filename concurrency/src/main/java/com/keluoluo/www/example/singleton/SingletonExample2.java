package com.keluoluo.www.example.singleton;

import com.keluoluo.www.annoations.ThreadSafe;

/**
 * 饿汉模式 在类装载使用时进行创建
 * 
 * @author wx
 *
 *         2019年8月17日
 */
@ThreadSafe
public class SingletonExample2 {

	// 私有构造函数
	private SingletonExample2() {

	}

	// 单例对象
	private static SingletonExample2 instance = new SingletonExample2();

	// 静态工厂方法
	public static SingletonExample2 getInstance() {
		return instance;
	}

}
