package jadwalkereta.model;

public class Jadwal {
    protected String kode;
    protected int jam;
    protected int menit;

    public Jadwal(String kode, int jam, int menit) {
        this.kode = kode;
        this.jam = jam;
        this.menit = menit;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public void setJam(int jam) {
        this.jam = jam;
    }

    public void setMenit(int menit) {
        this.menit = menit;
    }

    public String getKode() {
        return kode;
    }

    public int getJam() {
        return jam;
    }

    public int getMenit() {
        return menit;
    }
}
