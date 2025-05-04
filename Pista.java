import java.util.concurrent.Semaphore;

public class Pista {
    private int id;
    private Semaphore mutex = new Semaphore(1);

    public Pista(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void occupa(Aereo aereo) throws InterruptedException{
        mutex.acquire();
        System.out.println("Aereo " + aereo.getId() + " sta occupando la pista " + getId());
    }

    public void libera(Aereo aereo){
        mutex.release();
        System.out.println("Aereo " + aereo.getId() + " ha liberato la pista " + getId());
    }

    public boolean tryOccupa(){
        return mutex.tryAcquire();
    }
}
