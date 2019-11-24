package jadwalkereta.model;

import java.util.ArrayList;

public class Rute {
    protected String kodeRute;
    //protected String namaRute;
    protected long hargaBisnis;
    protected long hargaPremium;
    protected String kotaBerangkat; 
    protected String kotaTujuan;
    ArrayList<Jalur> jalur;
    ArrayList<Time> times;
    ArrayList<Kereta> kereta;
	//protected ArrayList<Kota> kota = new ArrayList<Kota>();

    public Rute(String kodeRute, long hargaBisnis, long hargaPremium, String kotaBerangkat, String kotaTujuan) {
        this.kodeRute = kodeRute;
        this.hargaBisnis = hargaBisnis;
	    this.hargaPremium = hargaPremium;
        this.kotaBerangkat = kotaBerangkat;
        this.kotaTujuan = kotaTujuan;
        jalur = new ArrayList<Jalur>();
        times = new ArrayList<Time>();
        kereta = new ArrayList<Kereta>();
    }

    public Rute(String kodeRute, long hargaBisnis, long hargaPremium, String kotaBerangkat, String kotaTujuan, ArrayList<Jalur> jalur, ArrayList<Time> times, ArrayList<Kereta> kereta) {
        this.kodeRute = kodeRute;
        this.hargaBisnis = hargaBisnis;
        this.hargaPremium = hargaPremium;
        this.kotaBerangkat = kotaBerangkat;
        this.kotaTujuan = kotaTujuan;
        this.jalur = jalur;
        this.times = times;
        this.kereta = kereta;
    }

    public Rute() {
    }

    public void setKodeRute(String kodeRute) {
        this.kodeRute = kodeRute;
    }

    public void setKotaBerangkat(String kotaBerangkat) {
        this.kotaBerangkat = kotaBerangkat;
    }
    
    public void setKotaTujuan(String kotaTujuan) {
        this.kotaTujuan = kotaTujuan;
    }
    
    public void setHargaBisnis(long hargaBisnis) {
        this.hargaBisnis = hargaBisnis;
    }
	
    public void setHargaPremium(long hargaPremium) {
        this.hargaPremium = hargaPremium;
    }

    public String getKodeRute() {
        return kodeRute;
    }
    
    public String getKotaBerangkat() {
        return kotaBerangkat;
    }
    
    public String getKotaTujuan() {
        return kotaTujuan;
    }

    public long getHargaBisnis() {
        return hargaBisnis;
    }

    public ArrayList<Jalur> getJalur() {
        return this.jalur;
    }

    public void setJalur(ArrayList<Jalur> jalur) {
        this.jalur = jalur;
    }
    
    public ArrayList<Time> getTime() {
        return this.times;
    }

    public void setTime(ArrayList<Time> times) {
        this.times = times;
    }
	
    public ArrayList<Kereta> getKereta() {
        return this.kereta;
    }

    public void setKereta(ArrayList<Kereta> kereta) {
        this.kereta = kereta;
    }
    
    public long getHargaPremium() {
        return hargaPremium;
    }

    public int getDuration(){
        int duration = 0;
        for(int i = 0; i<jalur.size();i++)
            duration += jalur.get(i).getMenit();
        
        return duration;
    }

    
}
