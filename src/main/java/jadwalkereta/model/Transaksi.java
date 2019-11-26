package jadwalkereta.model;

public class Transaksi {
    protected String kodebooking;
    protected String tanggal;
    protected String keterangan;

    public Transaksi(String kodebooking, String tanggal , String keterangan) {
        this.kodebooking = kodebooking;
        this.tanggal = tanggal;
        this.keterangan = keterangan;
    }

    public void setKodebooking(String kodebooking) {
        this.kodebooking = kodebooking;
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

    public String getTanggal() {
        return tanggal;
    }

    public String getKeterangan() {
        return keterangan;
    }
}
