//run this program using javac Counter.java - > java Counter
class StaticCounter {
	//uncomment the below lines to know the importance of static keyword

	int number=10;
	//static int number=10;

	void increment(){
		number=number+1;
	}
  public static void main(String[] args) {
    StaticCounter obj1=new StaticCounter();
	StaticCounter  obj2=new StaticCounter();
	StaticCounter  obj3=new StaticCounter();
	//Guess the answer
	obj1.increment();
	obj2.increment();
	obj3.increment();

	//to check your answers uncomment the next lines
	
	//System.out.println(obj1.number);
	//System.out.println(obj2.number);
	//System.out.println(obj3.number);
 }
}