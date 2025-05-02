import java.util.concurrent.Semaphore;

public class Pista {
    private Semaphore mutex = new Semaphore(1);

    public Pista() {
    
    }

    public void occupa(Aereo aereo) throws InterruptedException{
        mutex.acquire();
        System.out.println("Aereo " + aereo.getId() + " sta occupando la pista X");
    }

    public void libera(Aereo aereo){
        mutex.release();
        System.out.println("Aereo " + aereo.getId() + " ha liberato la pista X");
    }
}
