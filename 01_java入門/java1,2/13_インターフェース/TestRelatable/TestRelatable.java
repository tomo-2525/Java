public class TestRelatable {
    public static void main(String[] args) {
	int i;
	int tmp=0;
	int num=0;
	//	RectanglePlus r1 = new RectanglePlus(10, 20);
	//	RectanglePlus r2 = new RectanglePlus(40, 50);
	    
	/*switch (r1.isLargerThan(r2)) {
	  case 1:
	  System.out.println("r1 is greater than r2");
	  break;
	  case 0:
	  System.out.println("r1 is equal to r2");
	  break;
	  default:
	  System.out.println("r1 is less than r2");
	  break;

	  }*/

	MyRectangle[] rectangle = new MyRectangle[3];

	rectangle[0] = new MyRectangle( 4, 5 );
	rectangle[1] = new MyRectangle( 3, 7 );
       	rectangle[2] = new MyRectangle( 4 ,8);
	    
	/*
	for(i=0 ; i<  ; i++){
	    if(tmp < rectangle[i].getLength()){
		tmp =  rectangle[i].getLength();
		num = i;
	    }
	}
	*/

	for(i=0; i<rectangle.length; i++){
	    if(rectangle[i].isLargerThan(rectangle[i]) == 1) tmp = rectangle[i].getLength();
	}
	
       

        
	    
	System.out.println(num + "is most large Rectangle. \n The Length is "+ tmp);

    }
}
