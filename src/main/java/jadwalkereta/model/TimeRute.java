package jadwalkereta.model;

public class TimeRute {
    protected String kodeRute;
	protected int jam;
        protected int menit;
        protected int waktuRute;
        protected String kdWaktu;
	//protected ArrayList<Kota> kota = new ArrayList<Kota>();

    public TimeRute(String kodeRute, int wr, int jam, int menit, String kdWkt) {
        this.kodeRute = kodeRute;
        this.jam = jam;
        this.menit = menit;
        this.waktuRute = wr;
        this.kdWaktu = kdWkt;
    }

    public TimeRute() {
    }

    public void setKodeRute(String kodeRute) {
        this.kodeRute = kodeRute;
    }
    
    public void setKdWaktu(String kdWaktu) {
        this.kdWaktu = kdWaktu;
    }

    public void setWaktuRute(int wr) {
        this.waktuRute = wr;
    }
    
    public void setJam(int jam) {
        this.jam = jam;
    }
    
    public void setMenit(int menit) {
        this.menit = menit;
    }
    
    public String getKodeRute() {
        return kodeRute;
    }
    
    public String getKdWaktu() {
        return kdWaktu;
    }

    public int getJam() {
        return jam;
    }
    public int getMenit() {
        return menit;
    }
    public int getWaktuRute() {
        return waktuRute;
    }
}
