class Person {
    private String name;
    public Person(String name){
	this.name = name;
    }
    public String introduction(){
	return "My name is " + name + ".";
    }
}


class Student extends Person{
    private String id;
    public Student(String name, String id){
	super(name);
	this.id = id;
    }
    public String introduction(){
	return "I am a student. " + super.introduction() + " My ID is "+ id + ".";
    }
}


class JapanesePerson extends Person{

    String greet = "hajime mashite";
    
    JapanesePerson(String name){
	super(name); 
	//System.out.println(greet);
    }

    public String introduction(){
	return greet + super.introduction();
    }
}


class EnglishPerson extends Person{

    String greet = "How do you do?";

    EnglishPerson(String name){
	super(name);
	//System.out.println(greet);
    }
    
    public String introduction(){
	return greet + super.introduction();
    }
    
}

class JapaneseStudent extends Student{

    String greet = "hajime mashite";
    
    JapaneseStudent(String name, String id){
	super(name, id);
	//System.out.println(greet);
    }
    public String introduction(){
	return greet + super.introduction();
    }
    
}

class EnglishStudent extends Student{

    String greet = "How do you do?";
    
    EnglishStudent(String name, String id){
	super(name,id); 
	//System.out.println(greet);
    }
    public String introduction(){
	return greet + super.introduction();
    }
    
    
}




public class PeopleIntroduction{
    public static void main(String[] args){

	/*
	  Student s = new Student("Saito","s115333");
	  Person h = s;
	  System.out.println(s.introduction());
	  System.out.println(h.introduction());
	*/

	String[][] data  = {
	    {"a","001"},
	    {"i","002"},
	    {"u","003"},
	    {"e","004"},
	    {"o","005"},
	    {"k","006"}
	};
	
	Person person = new Person(data[0][0]);
	
	Student student = new Student(data[1][0],data[1][1]);
	
	EnglishPerson E_person = new EnglishPerson(data[2][0]);
	
	EnglishStudent E_student = new EnglishStudent(data[3][0],data[3][1]);
	
	JapanesePerson J_person = new JapanesePerson(data[4][0]);
	
	JapaneseStudent J_student = new JapaneseStudent(data[5][0],data[5][1]);


	System.out.println(person.introduction());
	System.out.println(student.introduction());
	System.out.println(E_person.introduction());
	System.out.println(E_student.introduction());
	System.out.println(J_person.introduction());
	System.out.println(J_student.introduction());
    }
}
