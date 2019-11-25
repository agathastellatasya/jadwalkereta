package jadwalkereta.model;

public class Jadwal {
    protected String kode;
    String kotaBerangkat;
    String kotaTujuan;
    Kereta kereta;
    Tanggal tanggal;
    int jamBerangkat;
    int menitBerangkat;
    int jamSampai;
    int menitSampai;
    long hargaB;
    long hargaP;


    public Jadwal(String kode, Tanggal tanggal, int jamBerangkat, int menitBerangkat, int jamSampai, int menitSampai, String kotaBerangkat, String kotaTujuan, Kereta kereta, long hargaB, long hargaP) {
        this.kode = kode;
        this.tanggal = tanggal;
        this.jamBerangkat = jamBerangkat;
        this.menitBerangkat = menitBerangkat;
        this.jamSampai = jamSampai;
        this.menitSampai = menitSampai;
        this.kotaBerangkat = kotaBerangkat;
        this.kotaTujuan = kotaTujuan;
        this.kereta = kereta;
        this.hargaB=hargaB;
        this.hargaP=hargaP;
    }

    public String getKode() {
        return this.kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getKotaBerangkat() {
        return this.kotaBerangkat;
    }

    public void setKotaBerangkat(String kotaBerangkat) {
        this.kotaBerangkat = kotaBerangkat;
    }

    public String getKotaTujuan() {
        return this.kotaTujuan;
    }

    public void setKotaTujuan(String kotaTujuan) {
        this.kotaTujuan = kotaTujuan;
    }

    public Kereta getKereta() {
        return this.kereta;
    }

    public void setKereta(Kereta kereta) {
        this.kereta = kereta;
    }

    public Tanggal getTanggal() {
        return this.tanggal;
    }

    public void setTanggal(Tanggal tanggal) {
        this.tanggal = tanggal;
    }

    public int getJamBerangkat() {
        return this.jamBerangkat;
    }

    public void setJamBerangkat(int jamBerangkat) {
        this.jamBerangkat = jamBerangkat;
    }

    public int getMenitBerangkat() {
        return this.menitBerangkat;
    }

    public void setMenitBerangkat(int menitBerangkat) {
        this.menitBerangkat = menitBerangkat;
    }

    public int getJamSampai() {
        return this.jamSampai;
    }

    public void setJamSampai(int jamSampai) {
        this.jamSampai = jamSampai;
    }

    public int getMenitSampai() {
        return this.menitSampai;
    }

    public void setMenitSampai(int menitSampai) {
        this.menitSampai = menitSampai;
    }

    public long getHargaB() {
        return this.hargaB;
    }

    public void setHargaB(long hargaB) {
        this.hargaB = hargaB;
    }

    public long getHargaP() {
        return this.hargaP;
    }

    public void setHargaP(long hargaP) {
        this.hargaP = hargaP;
    }



}
