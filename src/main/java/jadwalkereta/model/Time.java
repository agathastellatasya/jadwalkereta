package jadwalkereta.model;

public class Time {
    protected String kode;
    protected int jam;
    protected int menit;

    public Time(String kode, int jam, int menit) {
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
