package jadwalkereta.model;

public class TimeRute {
    String kdWaktu; 
    int jam, menit;
    
    public TimeRute(String kdWaktu, int jam, int menit) {
        this.kdWaktu = kdWaktu;
        this.jam =jam;
        this.menit = menit;
    }

    public String getKdWaktu() {
        return this.kdWaktu;
    }
	
    public int getJam() {
        return jam;
    }
	
    public int getMenit() {
        return menit;
    }

    public void setKdWaktu(String kdWaktu) {
        this.kdWaktu = kdWaktu;
    }
	
	public void setJam(int jam) {
        this.jam = jam;
    }
    
    public void setMenit(int menit) {
        this.menit = menit;
    }

 }