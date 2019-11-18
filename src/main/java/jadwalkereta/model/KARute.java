package jadwalkereta.model;

public class KARute {
    //protected String kode;
    protected String kodeRute;
    protected String kodeKA;

    public KARute(String kodeRute, String kodeKA) {
        //this.kode = kode;
        this.kodeRute = kodeRute;
        this.kodeKA = kodeKA;
    }

    public KARute() {
    }

    /*public void setKode(String kode) {
        this.kode = kode;
    }*/

    public void setKodeRute(String kodeRute) {
        this.kodeRute = kodeRute;
    }

    public void setKodeKA(String kodeKA) {
        this.kodeKA = kodeKA;
    }
    /*public String getKode() {
        return kode;
    }*/

    public String getKodeRute() {
        return kodeRute;
    }

    public String getKodeKA() {
        return kodeKA;
    }
}
