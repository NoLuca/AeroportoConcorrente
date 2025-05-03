abstract public class VeicoloServizio implements Runnable {
    protected Aereo aereo;

    protected VeicoloServizio(Aereo aereo) {
        this.aereo = aereo;
    }

    public Aereo getAereo() {
        return aereo;
    }

    public void setAereo(Aereo aereo) {
        this.aereo = aereo;
    }

    public void run(){

    }
}
