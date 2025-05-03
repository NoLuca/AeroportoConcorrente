public class VeicoloBagagli extends VeicoloServizio {
    private boolean carico;

    public VeicoloBagagli(Aereo aereo, boolean carico) {
        super(aereo);
        this.carico = carico;
    }

    public void run(){
        try{
            aereo.acquireServizio();
            if(carico){
                aereo.setStato(StatoAereo.CARICO_BAGAGLI);
                System.out.println("Aereo " + getAereo().getId() + " carica bagagli");
                Thread.sleep(1000);
            }else{
                aereo.setStato(StatoAereo.ATTERRATO);
                System.out.println("Aereo " + getAereo().getId() + " scarica bagagli");
                Thread.sleep(1000);
            }
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }finally{
            aereo.releaseServizio();
        }
    }
}
