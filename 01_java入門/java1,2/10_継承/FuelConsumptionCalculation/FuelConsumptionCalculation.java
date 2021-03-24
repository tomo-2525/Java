class FuelConsumptionCalculation {
    private double fuelConsumptionOldRegulation = 0;
    private double fuelConsumptionNewRegulation = 0;
    private SimpleCar[] cars;

    FuelConsumptionCalculation() {
	/* your code is here */
		cars = new SimpleCar[4];
	this.cars[0]	= new SimpleCar(13.0F, 7, 18);
	this.cars[1]	= new AdvancedCar(15.5F, 9.5F, 7, 18);
	this.cars[2]	= new DeluxeCar(14.0F, 10.5F, 7, 18, 5 );
	this.cars[3]	= new DeluxeCar(13.0F, 9.5F, 7, 17, 4 );
	this.calculateFuelConsumption();
	
       
    }
    FuelConsumptionCalculation(SimpleCar[] cars) {
	/* your code is here */
	this.cars = cars;
	calculateFuelConsumption();
    }
    
    private void calculateFuelConsumption() {
	/* your code to calculate values of
	   fuelConsumptionOldRegulation and
	   fuelConsumptionNewRegulation is here */
	int i;
	for(i=0; i<4; i++){
	    this.fuelConsumptionOldRegulation += cars[i].calculateFuelConsumptionOldRegulation();
	    this.fuelConsumptionNewRegulation += cars[i].calculateFuelConsumptionNewRegulation();
	}
    }
    
    float getFuelConsumptionOldRegulations() {
	/* your code is here */
	return (float)this.fuelConsumptionOldRegulation;
    }
    float getFuelConsumptionNewRegulations() {
	/* your code is here */
	return (float)this.fuelConsumptionNewRegulation;
    }


    public static void main(String[] args){
	SimpleCar[] cars;
	cars = new SimpleCar[4];
	cars[0]	= new SimpleCar(13.0F, 7, 18);
	cars[1]	= new AdvancedCar(15.5F, 9.5F, 7, 18);
	cars[2]	= new DeluxeCar(14.0F, 10.5F, 7, 18, 5 );
	cars[3]	= new DeluxeCar(13.0F, 9.5F, 7, 17, 4 );
	
	 FuelConsumptionCalculation hoge = new FuelConsumptionCalculation (cars);

	System.out.println("FuelconsumptionOldregulation is " + hoge.getFuelConsumptionOldRegulations());
	System.out.println("FuelconsumptionNewregulation is " + hoge.getFuelConsumptionNewRegulations());
	System.out.println("the profit  is " + (hoge.getFuelConsumptionOldRegulations()-hoge.getFuelConsumptionNewRegulations()) );

	
    }
}

class SimpleCar {
    
    float traveled_meter;
    float fueleconomy;
    int begin_time;
    int end_time;
    

    SimpleCar(float fueleconomy, int begin_time, int end_time){
	this.fueleconomy = fueleconomy;
	this.begin_time = begin_time;
	this.end_time = end_time;
    }

    float calculateFuelConsumptionOldRegulation(){
	return this.traveled_meter/fueleconomy;
    }
    
    float calculateFuelConsumptionNewRegulation(){
	return this.traveled_meter/fueleconomy;
    }

    
}

class AdvancedCar extends SimpleCar{
    
    float aircon_fueleconomy;

    AdvancedCar(float fueleconomy, float aircon_fueleconomy, int begin_time, int end_time  ){
	super(fueleconomy,begin_time,end_time);
	this.aircon_fueleconomy = aircon_fueleconomy;
    }

    float calculateFuelConsumptionOldRegulation(){
	return this.traveled_meter/fueleconomy + (end_time - begin_time)* aircon_fueleconomy;
    }
    
    float calculateFuelConsumptionNewRegulation(){
	return this.traveled_meter/fueleconomy + (end_time - begin_time)* aircon_fueleconomy;
    }
    
}

class DeluxeCar extends AdvancedCar{

    int exist_passengers_hours;

    DeluxeCar(float fueleconomy, float aircon_fueleconomy, int begin_time, int end_time, int exist_passengers_hours ){
	super(fueleconomy,aircon_fueleconomy,begin_time,end_time);
	this.exist_passengers_hours = exist_passengers_hours; 
    }


    float calculateFuelConsumptionOldRegulation(){
	return this.traveled_meter/fueleconomy + (end_time - begin_time) * aircon_fueleconomy;
    }
    
    float calculateFuelConsumptionNewRegulation(){
	return this.traveled_meter/fueleconomy + exist_passengers_hours * aircon_fueleconomy;
    }

    

}

