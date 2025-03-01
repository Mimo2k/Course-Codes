class Age {

    int age;
    Age(int age){
        age = age;
		//this.age = age;
    }

    public static void main(String[] args) {
        Age obj = new Age(24);
        System.out.println("obj.age = " + obj.age);
    }
}