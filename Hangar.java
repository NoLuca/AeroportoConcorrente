import java.util.concurrent.Semaphore;

public class Hangar {
    private Semaphore posti = new Semaphore(5);

    public Hangar() {
        
    }

    public void entra(Aereo aereo) throws InterruptedException{
        posti.acquire();
        System.out.println("Aereo " + aereo.getId() + " entra nell'hangar");
    }
    
    public void esci(Aereo aereo){
        posti.release();
        System.out.println("Aereo " + aereo.getId() + " esce dall'hangar");
    }
}
