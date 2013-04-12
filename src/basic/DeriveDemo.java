/*
 * Java 中变量和方法的初始化顺序
 */
package basic;

class A0
{
	A0()
	{
		System.out.println("父类的构造函数被调用（初始化父类）");
	}
}

class A1 extends A0
{
	static final int b = print1();
	
	static
	{
		System.out.println("A1 静态块被执行");
	}
	
	int a = print();
	
	{
		System.out.println("A1 非静态块被执行");
	}
	
	A1()
	{
		System.out.println("A1 的构造函数被调用");
	}
	
	private int print()
	{
		System.out.println("A1中非静态变量被初始化");
		return 1;
	}
	
	final static int print1()
	{
		System.out.println("A1中静态变量被初始化");
		return 1;
	}
}

class A2 extends A1
{
	A2()
	{
		System.out.println("A2构造函数被调用");
	}
}

public class DeriveDemo
{
	public static void main(String[] args)
	{
		System.out.println("这是A1类的初始化顺序：");
		A1 a = new A1();
		System.out.println("\n这是A2类的初始化顺序：");
		A2 a1 = new A2();
		System.out.println("\n这是A2类的初始化顺序（注意静态变量）：");
		A2 a2 = new A2();
		System.out.println("");
		System.out.println("我们还注意到静态变量被A2全盘继承下来了");
	}
}
