package practice;


interface Printable{}

class A implements Printable{
public void a(){System.out.println("a method");}
}

class B implements Printable{
public void b(){System.out.println("b method");}
}

class Call{
void invoke(Printable p){//upcasting
if(p instanceof A){
A a=(A)p;//Downcasting 
a.a();
}
if(p instanceof B){
B b=(B)p;//Downcasting 
b.b();
}

}
}//end of Call class

public class InstanceOf {
	
	public static void main(String args[]){
	Printable p=new B();
	System.out.println(  p instanceof Printable);  //true
	System.out.println( p instanceof B);  //true
	System.out.println(" argument passed =="+args.toString());
	Call c=new Call();
	c.invoke(p);
	//"...."+ p instanceof B +
	}
	


}
