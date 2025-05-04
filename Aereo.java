import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Aereo implements Runnable {
    private int id;
    private String impresaCostruttrice;
    private int numMaxPasseggeri;
    private int numPasseggeri;
    private int pesoMaxBagagli;
    private int pesoBagagliContenuti;
    private boolean viaggioAndataRitorno;
    private StatoAereo stato = StatoAereo.IN_HANGAR;
    private Semaphore semaforo = new Semaphore(1);
   
    public Aereo(int id, String impresaCostruttrice, int numMaxPasseggeri, int pesoMaxBagagli) {
        this.id = id;
        this.impresaCostruttrice = impresaCostruttrice;
        this.numMaxPasseggeri = numMaxPasseggeri;
        this.pesoMaxBagagli = pesoMaxBagagli;
        this.numPasseggeri = 0;
        this.pesoBagagliContenuti = 0;
        this.viaggioAndataRitorno = false;
    }
    
    public Aereo(int id, String impresaCostruttrice, int numMaxPasseggeri, int pesoMaxBagagli, boolean viaggioAndataRitorno) {
        this.id = id;
        this.impresaCostruttrice = impresaCostruttrice;
        this.numMaxPasseggeri = numMaxPasseggeri;
        this.pesoMaxBagagli = pesoMaxBagagli;
        this.numPasseggeri = 0;
        this.pesoBagagliContenuti = 0;
        this.viaggioAndataRitorno = viaggioAndataRitorno;
    }

    public int getId() {
        return id;
    }

    public String getImpresaCostruttrice() {
        return impresaCostruttrice;
    }

    public int getNumMaxPasseggeri() {
        return numMaxPasseggeri;
    }

    public int getNumPasseggeri() {
        return numPasseggeri;
    }

    public int getPesoBagagliContenuti() {
        return pesoBagagliContenuti;
    }

    public int getPesoMaxBagagli() {
        return pesoMaxBagagli;
    }

    public boolean isViaggioAndataRitorno() {
        return viaggioAndataRitorno;
    }

    public StatoAereo getStato() {
        return stato;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImpresaCostruttrice(String impresaCostruttrice) {
        this.impresaCostruttrice = impresaCostruttrice;
    }

    public void setNumMaxPasseggeri(int numMaxPasseggeri) {
        this.numMaxPasseggeri = numMaxPasseggeri;
    }

    public void setNumPasseggeri(int numPasseggeri) {
        this.numPasseggeri = numPasseggeri;
    }

    public void setPesoMaxBagagli(int pesoMaxBagagli) {
        this.pesoMaxBagagli = pesoMaxBagagli;
    }

    public void setPesoBagagliContenuti(int pesoBagagliContenuti) {
        this.pesoBagagliContenuti = pesoBagagliContenuti;
    }

    public void setViaggioAndataRitorno(boolean viaggioAndataRitorno) {
        this.viaggioAndataRitorno = viaggioAndataRitorno;
    }

    public void setStato(StatoAereo stato) {
        this.stato = stato;
    }

    public void acquireServizio() throws InterruptedException{
        semaforo.acquire();
    }

    public void releaseServizio(){
        semaforo.release();
    }

    public void run(){
        try{
            Aeroporto.hangar.esci(this);
            setStato(StatoAereo.IN_SOSTA);
            Aeroporto.areaSosta.entra(this);

            ExecutorService servizi = Executors.newFixedThreadPool(2);
            servizi.submit(new VeicoloRifornimento(this));
            servizi.submit(new VeicoloBagagli(this, true));
            servizi.shutdown();
            servizi.awaitTermination(2, TimeUnit.SECONDS);
            setStato(StatoAereo.PRONTO_DECOLLARE);

            Pista pista = Aeroporto.getPistaDisponibile();
            pista.occupa(this);
            setStato(StatoAereo.IN_PISTA);
            System.out.println("Aereo " + getId() + " decolla dalla pista " + pista.getId());
            pista.libera(this);
            setStato(StatoAereo.IN_VOLO);

            Thread.sleep(1000);

            pista = Aeroporto.getPistaDisponibile();
            pista.occupa(this);
            setStato(StatoAereo.ATTERRATO);
            System.out.println("Aereo " + getId() + " atterra sulla pista " + pista.getId());
            pista.libera(this);

            Aeroporto.areaSosta.esci(this);
            ExecutorService servizi2 = Executors.newFixedThreadPool(2);
            servizi2.submit(new VeicoloBagagli(this, false));
            servizi2.shutdown();
            servizi2.awaitTermination(1, TimeUnit.SECONDS);

            if(!viaggioAndataRitorno){
                Aeroporto.hangar.entra(this);
                setStato(StatoAereo.IN_HANGAR);
            }else{
                Aeroporto.areaSosta.entra(this);
                setStato(StatoAereo.IN_SOSTA);
            }
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}
