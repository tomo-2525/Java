import java.util.Random;
public class Regular extends Employee{
    int hours;
    //int tmp;

    Regular(){
	super(2000);
    }
    
    public void generateNumberHours(){
	
	Random rand = new Random();
	
        this.hours = rand.nextInt(2)+8;
	
	setH(this.hours);

    }

}
