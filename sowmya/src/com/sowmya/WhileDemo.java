package com.sowmya;

class Base
{
	static int x=100;
	static
	{
		x=++x + --x;
	}
}
class Derived extends Base
{
	static
	{
		x=x-- + --x;
	}
	{
		x=x++ - ++x;
	}
}
class WhileDemo{
	public static void main(String s[])
	{
		Derived d = new Derived();
		System.out.println(d.x);
	}
}