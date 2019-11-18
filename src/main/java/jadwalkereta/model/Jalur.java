package jadwalkereta.model;

public class Jalur {
    Station stasiunAwal;
    Station stasiunAkhir;
    int menit;
    public Jalur(Station stasiunAwal, Station stasiunAkhir, int menit) {
        this.stasiunAwal = stasiunAwal;
        this.stasiunAkhir = stasiunAkhir;
        this.menit = menit;
    }

    public Station getStasiunAwal() {
        return this.stasiunAwal;
    }

    public void setStasiunAwal(Station stasiunAwal) {
        this.stasiunAwal = stasiunAwal;
    }

    public Station getStasiunAkhir() {
        return this.stasiunAkhir;
    }

    public void setStasiunAkhir(Station stasiunAkhir) {
        this.stasiunAkhir = stasiunAkhir;
    }

    public int getMenit() {
        return this.menit;
    }

    public void setMenit(int menit) {
        this.menit = menit;
    }

}
