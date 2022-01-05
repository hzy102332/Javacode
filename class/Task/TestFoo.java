package Task;
public class TestFoo{
	public static void main(String[]args) {
	Foo foo=new Foo();
	Foo bar=new Bar();
	Foo baz=new Baz();
	Baz mumble=new Mumble();
	System.out.println(baz.toString());
	baz.method1();
	baz.method2();
	System.out.println(bar.toString());
	bar.method1();
	bar.method2();
	System.out.println(mumble.toString());
	mumble.method1();
	mumble.method2();
	System.out.println(foo.toString());
	foo.method1();
	foo.method2();
}}
class Foo {
	 public void method1 (){
		System.out.println("foo1");}
	 public void method2() {
		System.out.println("foo2");
	 } 
	 public String toString() {
		 return "foo";
	 }
}
class Baz extends Foo{
	public void method1() {
		System.out.println("baz1");}
	public String toString() {
		 return "baz";
	 }
	}
class Bar extends Foo{
	public void method2() {
		System.out.println("bar2");
	} 
}
class Mumble extends Baz{
	public void method2() {
		System.out.println("munble2");
	}
}