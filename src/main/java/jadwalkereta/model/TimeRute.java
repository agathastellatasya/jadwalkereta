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

    public int[] addTime(int addmenit) {
        int add = (jam*60+menit) + addmenit;
        int retjam = (add/60) % 24;
        int retmenit = add % 60;
        int[] retval = {retjam, retmenit};
        return retval;
    }

    public boolean isGreaterThan(TimeRute time){
        if(jam > time.getJam()) return false;
        else{
            if(menit > time.getMenit()) return false;
            else return false;
        }
    }

 }