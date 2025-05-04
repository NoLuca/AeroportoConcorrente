import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Aeroporto {
    static Hangar hangar = new Hangar();
    static AreaSosta areaSosta = new AreaSosta();
    static List<Pista> piste = List.of(new Pista(1), new Pista(2), new Pista(3));

    public static Pista getPistaDisponibile() throws InterruptedException {
        while(true){
            for(Pista pista : piste){
                if(pista.tryOccupa()){
                    System.out.println("Pista " + pista.getId() + " assegnata");
                    return pista;
                }
            }
            Thread.sleep(1000);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++){
            Aereo a = new Aereo(i, "Boing", 300, 1500);
            hangar.entra(a);
            executor.submit(a);
        }
        Aereo a = new Aereo(5, "Kamikazze", 300, 1500, true);
        hangar.entra(a);
        executor.submit(a);

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println("Tutti gli aerei sono stati gestiti");
    }
}
