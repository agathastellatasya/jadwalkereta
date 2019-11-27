package jadwalkereta.model;

public class Kereta {
    protected String kodeKereta;
    //protected String namaKereta;
    protected int jmlGerbong;
    protected int jmlBisnis;
    protected String namaKereta; 
    protected int jmlPremium;
    int[][] bangkubisnis;
    int[][] bangkupremium;
    
	//protected ArrayList<Kota> kota = new ArrayList<Kota>();

    public Kereta(String kodeKereta, String namaKereta, int jmlGerbong, int jmlBisnis, int jmlPremium) {
		//kodeKereta, namaKereta, jmlGerbong, jmlBisnis, jmlBisnis
        this.kodeKereta = kodeKereta;
        this.namaKereta = namaKereta;
		this.jmlGerbong = jmlGerbong;
        this.jmlBisnis = jmlBisnis;
        this.jmlPremium = jmlPremium;
        bangkubisnis = new int[jmlBisnis][10];
        bangkupremium = new int[jmlPremium][20];
    }

    public void setBangkuBisnis(int i, int j, int value){
        bangkubisnis[i][j] = value;
    }

    public void setBangkuPremium(int i, int j, int value) {
        bangkupremium[i][j] = value;
    }

    public int getBangkuBisnis(int i, int j){
        return bangkubisnis[i][j];
    }

    public int getBangkuPremium(int i, int j){
        return bangkupremium[i][j];
    }

    public int countBangkuKosong(){
        int jumlah = 0;
        for(int i=0;i<bangkubisnis.length;i++)
        {
            for(int j=0;j<10;j++){
                if(bangkubisnis[i][j]==0) jumlah++;
            }
        }
        for(int i=0;i<bangkupremium.length;i++)
        {
            for(int j=0;j<20;j++){
                if(bangkupremium[i][j]==0) jumlah++;
            }
        }
        return jumlah;
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
    
    public boolean equals(Kereta kereta){
        return this.kodeKereta == kereta.getKodeKereta();
    }
}
