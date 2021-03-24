import java.util.Random;
public class PartTime extends Employee{
    int hours;

    PartTime(){
  super(1000);
    }

    public void generateNumberHours(){
        Random rand = new Random();
	this.hours = rand.nextInt(5);
	setH(this.hours);
      
    }

}
