public class Aereo {
    private int id;
    private String impresaCostruttrice;
    private int numMaxPasseggeri;
    private int numPasseggeri;
    private int pesoMaxBagagli;
    private int pesoBagagliContenuti;
    private boolean viaggioAndataRitorno;
   
    public Aereo(int id, String impresaCostruttrice, int numMaxPasseggeri, int pesoMaxBagagli) {
        this.id = id;
        this.impresaCostruttrice = impresaCostruttrice;
        this.numMaxPasseggeri = numMaxPasseggeri;
        this.pesoMaxBagagli = pesoMaxBagagli;
        this.numPasseggeri = 0;
        this.pesoBagagliContenuti = 0;
        this.viaggioAndataRitorno = false;
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
}
