package jadwalkereta.model;

public class KARute {
    protected int kode;
    protected String kodeRute;
    protected String kodeKA;

    public KARute(int kode, String kodeRute, String kodeKA) {
        this.kode = kode;
        this.kodeRute = kodeRute;
        this.kodeKA = kodeKA;
    }

    public KARute() {
    }

    public void setKode(int kode) {
        this.kode = kode;
    }

    public void setKodeRute(String kodeRute) {
        this.kodeRute = kodeRute;
    }

    public void setKodeKA(String kodeKA) {
        this.kodeKA = kodeKA;
    }
    public int getKode() {
        return kode;
    }

    public String getKodeRute() {
        return kodeRute;
    }

    public String getKodeKA() {
        return kodeKA;
    }
}
