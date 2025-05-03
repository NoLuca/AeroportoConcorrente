public class VeicoloRifornimento extends VeicoloServizio {
    public VeicoloRifornimento(Aereo aereo) {
        super(aereo);
    }

    public void run(){
        try{
            aereo.acquireServizio();
            aereo.setStato(StatoAereo.RIFORNIMENTO);
            System.out.println("Aereo " + getAereo().getId() + " in rifornimento");
            Thread.sleep(1000);
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }finally{
            aereo.releaseServizio();
        }
    }
}
