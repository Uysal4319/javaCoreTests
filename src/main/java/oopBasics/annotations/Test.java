package oopBasics.annotations;

// Driver class that uses @oopBasics.annotations.TestAnnotation 
class Test
{
    @TestAnnotation(Developer="Rahul", ExpireDate ="01-10-2020")
  	public static void fun1()
    {
        System.out.println("oopBasics.annotations.Test method 1");
    }

    @TestAnnotation(Developer="Anil", ExpireDate ="01-10-2021")
    public static void fun2()
    {
        System.out.println("oopBasics.annotations.Test method 2");
    }

    public static void main(String args[])
    {
        System.out.println("Hello");
        fun1();
        fun2();
    }
} 
