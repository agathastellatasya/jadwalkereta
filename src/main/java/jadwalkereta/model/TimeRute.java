package jadwalkereta.model;

public class TimeRute {
    protected String kodeRute;
	protected String kodeTime;
    
	//protected ArrayList<Kota> kota = new ArrayList<Kota>();

    public TimeRute(String kodeRute, String kodeTime) {
        this.kodeRute = kodeRute;
        this.kodeTime = kodeTime;
    }

    public TimeRute() {
    }

    public void setKodeRute(String kodeRute) {
        this.kodeRute = kodeRute;
    }

    public void setKodeTime(String kodeTime) {
        this.kodeTime = kodeTime;
    }
    
    public String getKodeRute() {
        return kodeRute;
    }

    public String getKodeTime() {
        return kodeTime;
    }
}
