package com.keluoluo.www.example.singleton;

import com.keluoluo.www.annoations.ThreadSafe;

/**
 * 懒汉模式 (双重同步锁模式)单例实例在第一次使用时进行创建
 * 
 * @author wx
 *
 *         2019年8月17日
 */
@ThreadSafe
public class SingletonExample5 {

	// 私有构造函数
	private SingletonExample5() {

	}

	// 1.memory=allocate()分配对象内存空间
	// 2.ctorInstance()初始化对象
	// 3.instance=memory 设置instance指向刚分配的内存

	// 单例对象 volatile+双重检测机制 ->禁止指令重排
	private volatile static SingletonExample5 instance;

	// 静态工厂方法
	public static SingletonExample5 getInstance() {
		if (instance == null) {// 双重检测机制
			synchronized (SingletonExample5.class) {// 同步锁
				if (instance == null)
					instance = new SingletonExample5();
			}
		}
		return instance;
	}

}
