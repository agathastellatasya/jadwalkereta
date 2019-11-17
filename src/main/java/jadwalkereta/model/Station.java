package jadwalkereta.model;

public class Station {
    protected String kode;
    protected String nama;

    public Station(String kode, String nama) {
        this.kode = kode;
        this.nama = nama;
    }

    public Station() {
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }
}
