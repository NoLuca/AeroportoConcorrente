import java.util.concurrent.Semaphore;

public class AreaSosta {
    private Semaphore posti = new Semaphore(3);

    public AreaSosta() {
        
    }
    
    public void entra(Aereo aereo) throws InterruptedException{
        posti.acquire();
        System.out.println("Aereo " + aereo.getId() + " entra nell'area di sosta");
    }

    public void esci(Aereo aereo){
        posti.release();
        System.out.println("Aereo " + aereo.getId() + " esce dall'area di sosta");
    }
}
