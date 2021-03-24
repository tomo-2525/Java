import java.util.Random;
public class Manager extends Employee{
    //  int hours;
    //int tmp;

    Manager(){
	super(2900);
    }
    
    public void generateNumberHours(){
	
	Random rand = new Random();
	
	setH(rand.nextInt(6)+6);

    }




}
