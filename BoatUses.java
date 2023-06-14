package smartaBåtar;

/**
 *
 * @author karzan.murad
 */
public class BoatUses {
    // variabel för teoretiska maximala distansen för båt
    static int maxDis1;
    static int maxDis2;
    
    public static void main(String[] args) {
        // skapara kapternerna
        Captain kap1 = new Captain();
        Captain kap2 = new Captain();
        // skapa båtarna
        Boat b1 = new Boat();
        Boat b2 = new Boat();
        try{
            // första kapten mätvärden
            kap1.setName("Olle");
            kap1.setAge(40);

            // andra kapten mätvärden
            kap2.setName("pia");
            kap2.setAge(20);
            
            // båt 1 mätvärden
            b1.setFuel(100);
            b1.setName("Blixten");
            b1.setCaptain(kap1);
            
            // båt 2 mätvärden
            b2.setFuel(130);
            b2.setFuelConsumption(0.9);
            b2.setName("Dunder");
            b2.setCaptain(kap2);
            
            maxDis1 = distans(b1);
            maxDis2 = distans(b2);
            
            for (int i = 0; i <= 150; i++) {
                if(maxDis1 == 0 || maxDis2 == 0){
                    // Skriv ut resultat om sträckan är noll
                    raceString(b1, b2);
                    if(maxDis1 == 0) System.out.println(b1.getName() + " Slut på bränsle");
                    if(maxDis2 == 0) System.out.println(b2.getName() + " Slut på bränsle");
                    break;
                } else {
                    maxDis1--;
                    maxDis2--;
                }
            }
            
        } catch(IllegalArgumentException i){
            System.out.println(i);
        }
    }
    
    private static void raceString(Boat b1, Boat b2){
        if (b1.compareTo(b2) < 0) {
            // skriv ut informationen för var tionde kilometer
            System.out.println("*Vinnare*  " + b2.toString() + "Distans: " + maxDis2 + "\n");
            System.out.println(b1.toString() + "Distans: " + maxDis1 + "\n");
        } else {
            // skriv ut informationen för var tionde kilometer
            System.out.println(" -- Vinnare -- " + b1.toString() + "Distans: " + maxDis1 + "\n");
            System.out.println(b2.toString() + "Distans: " + maxDis2 + "\n");
        }    
    }
    
    private static int distans(Boat b) {
        // Dela bränslet med bränsleförbrukning för att få sträcka
        double distans = (b.getFuel() / b.getfuelConsumption());
        // returnera avrundade värdet
        return (int) (distans + 0.5);
    }
}
