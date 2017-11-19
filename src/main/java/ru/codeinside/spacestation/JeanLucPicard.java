package ru.codeinside.spacestation;

public class JeanLucPicard implements Captain {

    private final Spaceship spaceship;
    public static int roomsNumber = 0;

    public JeanLucPicard(Spaceship spaceship) {
        this.spaceship = spaceship;
    }

    @Override
    public int stateroomsNumber() {
    	int nCurIndex;
    	spaceship.current().turnOn();//Зажигаем свет в первой каюте
    	do{
	    	//Ищем первую каюту с выключенным светом
    		roomsNumber = 0;
	    	do {
	    		spaceship.next();
	    		roomsNumber++;
	    	}
	    	while(spaceship.current().isLightOn() == false);
	    	
	    	//Выключаем свет в каюте
	    	spaceship.current().turnOff();
	    	
	    	nCurIndex = roomsNumber;
	    	//Возвращаемся в первую каюту
	        do {
	        	spaceship.previous();
	        	nCurIndex--;
	        }
	        while (nCurIndex != 0);
	    }
        while(spaceship.current().isLightOn() == true);
    	
        return roomsNumber;
    }
    
    public static void main(String args[]) {
     	BypassEnterpriseTest EntTest = new BypassEnterpriseTest();
    	try{
    		EntTest.howManyStaterooms();
    	}
    	catch(Exception exc){
    		System.out.println("Error");
    		System.out.println(exc.getMessage()); 		
    	}
    }
} 
