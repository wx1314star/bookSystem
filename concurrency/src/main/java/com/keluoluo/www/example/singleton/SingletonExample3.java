package com.keluoluo.www.example.singleton;

import com.keluoluo.www.annoations.NotRecommend;
import com.keluoluo.www.annoations.ThreadSafe;

/**
 * 懒汉模式 单例实例在第一次使用时进行创建
 * 
 * @author wx
 *
 *         2019年8月17日
 */
@ThreadSafe
@NotRecommend
public class SingletonExample3 {

	// 私有构造函数
	private SingletonExample3() {

	}

	// 单例对象
	private static SingletonExample3 instance;

	// 静态工厂方法
	public static synchronized SingletonExample3 getInstance() {
		if (instance == null)
			instance = new SingletonExample3();
		return instance;
	}

}
