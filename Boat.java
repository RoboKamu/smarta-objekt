package smartaBåtar;

import static jdk.dynalink.linker.support.Guards.isNull;
import smartaBåtar.Captain;

/**
 *
 * @author karzan.murad
 */
public class Boat {
    private double fuel;
    // notera att bränsleförbrukning är givet för 0.54
    private double fuelConsumption = 0.54;
    private String boatName;
    private Captain kapten;

    public Boat(double fuel, String boatName, Captain kapten) {
        setCaptain(kapten);
        setName(boatName);
        setFuel(fuel);
    }

    // boat måste inte har kapten 
    public Boat(double fuel, String boatName) {
        setName(boatName);
        setFuel(fuel);
    }

    public Boat() {
    }

    // getters
    public String getName() {
        return boatName;
    }

    public Captain getCaptain() {
        return kapten;
    }
    
    public double getfuelConsumption() {
        return fuelConsumption;
    }
    
    public double getFuel(){
        return fuel;
    }

    // setters
    public void setName(String boatName) {
        if (boatName.isBlank()){
            throw new IllegalArgumentException("Namnet får inte vara tom");
        } else {
            this.boatName = boatName;            
        }
    }

    public void setCaptain(Captain kapten) {
        this.kapten = kapten;
    }
   
    public void setCaptain(String name, int age){
        kapten.setName(name);
        kapten.setAge(age);
    }
    
    public void setFuelConsumption(double fuelConsum){
        // alla båtar har bränsleförbrukning
        if(fuelConsum <= 0){
            throw new IllegalArgumentException("Bränsleförbrukning måste vara större än noll");
        } else{
            this.fuelConsumption = fuelConsum;
        }
    }

    public void setFuel(double fuel) {
        // validera att bränslet inte är negativ
        if (fuel < 0){
            throw new IllegalArgumentException("Bränsle får inte vara negativ");
        } else{
            this.fuel = fuel;
        }
    }
    
    public int compareTo(Boat b){
        // returnera differeansen, positiv innebär denna ligger bakom
        return (int) (b.fuel - this.fuel);
    }
    
    @Override
    public String toString(){
        if(this.boatName == null || fuel == 0){
            // inte adderat värden till klassen kan då inte printa
            throw new IllegalArgumentException("Addera värden till båten först");
        } else{
            return String.format("Båtnamn: %s \nMotor: [%f , %f}\n", boatName, fuel, fuelConsumption);
        }
    }
}
