package jadwalkereta.model;

public class Transaksi {
    protected String kodebayar;
    protected String kodebooking;
    protected String tanggal;
    protected String keterangan;

    public Transaksi(String kodebayar, String tanggal , String keterangan, String kodebooking) {
        this.kodebayar = kodebayar;
        this.kodebooking = kodebooking;
        this.tanggal = tanggal;
        this.keterangan = keterangan;
    }

    public void setKodebooking(String kodebooking) {
        this.kodebooking = kodebooking;
    }
    public void setKodebayar(String kodebayar) {
        this.kodebayar = kodebayar;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getKodebooking() {
        return kodebooking;
    }
    public String getKodebayar() {
        return kodebayar;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getKeterangan() {
        return keterangan;
    }
}
