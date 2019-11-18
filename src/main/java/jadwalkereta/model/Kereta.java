package jadwalkereta.model;

public class Kereta {
    protected String kodeKereta;
    //protected String namaKereta;
    protected int jmlGerbong;
    protected int jmlBisnis;
    protected String namaKereta; 
    protected int jmlPremium;
    
	//protected ArrayList<Kota> kota = new ArrayList<Kota>();

    public Kereta(String kodeKereta, String namaKereta, int jmlGerbong, int jmlBisnis, int jmlPremium) {
		//kodeKereta, namaKereta, jmlGerbong, jmlBisnis, jmlBisnis
        this.kodeKereta = kodeKereta;
        this.namaKereta = namaKereta;
		this.jmlGerbong = jmlGerbong;
        this.jmlBisnis = jmlBisnis;
        this.jmlPremium = jmlPremium;
    }

    public Kereta() {
    }

    public void setKodeKereta(String kodeKereta) {
        this.kodeKereta = kodeKereta;
    }

    public void setNamaKereta(String namaKereta) {
        this.namaKereta = namaKereta;
    }
    
    public void setJmlGerbong(int jmlGerbong) {
        this.jmlGerbong = jmlGerbong;
    }
    
    public void setJmlBisnis(int jmlBisnis) {
        this.jmlBisnis = jmlBisnis;
    }
	
    public void setJmlPremium(int jmlPremium) {
        this.jmlPremium = jmlPremium;
    }

    public String getKodeKereta() {
        return kodeKereta;
    }
    
    public String getNamaKereta() {
        return namaKereta;
    }
    
    public int getJmlGerbong() {
        return jmlGerbong;
    }

    public int getJmlBisnis() {
        return jmlBisnis;
    }
	
    public int getJmlPremium() {
        return jmlPremium;
    }
}
