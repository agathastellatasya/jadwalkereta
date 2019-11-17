package jadwalkereta.model;

public class Rute {
    protected String kodeRute;
    //protected String namaRute;
    protected long hargaBisnis;
    protected long hargaPremium;
    protected String kotaBerangkat; 
    protected String kotaTujuan;
    
	//protected ArrayList<Kota> kota = new ArrayList<Kota>();

    public Rute(String kodeRute, long hargaBisnis, long hargaPremium, String kotaBerangkat, String kotaTujuan) {
        this.kodeRute = kodeRute;
        this.hargaBisnis = hargaBisnis;
	this.hargaPremium = hargaPremium;
        this.kotaBerangkat = kotaBerangkat;
        this.kotaTujuan = kotaTujuan;
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
	
    public long getHargaPremium() {
        return hargaPremium;
    }
}
