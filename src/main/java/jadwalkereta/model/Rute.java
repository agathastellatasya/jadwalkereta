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
    ArrayList<TimeRute> timerute;
    ArrayList<KARute> karute;
	//protected ArrayList<Kota> kota = new ArrayList<Kota>();

    public Rute(String kodeRute, long hargaBisnis, long hargaPremium, String kotaBerangkat, String kotaTujuan) {
        this.kodeRute = kodeRute;
        this.hargaBisnis = hargaBisnis;
	this.hargaPremium = hargaPremium;
        this.kotaBerangkat = kotaBerangkat;
        this.kotaTujuan = kotaTujuan;
        jalur = new ArrayList<Jalur>();
        timerute = new ArrayList<TimeRute>();
        karute = new ArrayList<KARute>();
    }

    public Rute(String kodeRute, long hargaBisnis, long hargaPremium, String kotaBerangkat, String kotaTujuan, ArrayList<Jalur> jalur, ArrayList<TimeRute> timerute, ArrayList<KARute> karute) {
        this.kodeRute = kodeRute;
        this.hargaBisnis = hargaBisnis;
        this.hargaPremium = hargaPremium;
        this.kotaBerangkat = kotaBerangkat;
        this.kotaTujuan = kotaTujuan;
        this.jalur = jalur;
        this.timerute = timerute;
        this.karute = karute;
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
    
    public ArrayList<TimeRute> getTimeRute() {
        return this.timerute;
    }

    public void setTimeRute(ArrayList<TimeRute> timerute) {
        this.timerute = timerute;
    }
	
    public ArrayList<KARute> getKARute() {
        return this.karute;
    }

    public void setKARute(ArrayList<KARute> karute) {
        this.karute = karute;
    }
    
    public long getHargaPremium() {
        return hargaPremium;
    }

    
}
