package jadwalkereta.model;

public class Tanggal{

    int Hari;
    int Bulan;
    int Tahun;

    public Tanggal(int Hari,int Bulan,int Tahun)
    {
        this.Hari = Hari;
        this.Bulan = Bulan;
        this.Tahun = Tahun;
    }
    public int getHari() {
        return this.Hari;
    }

    public void setHari(int Hari) {
        this.Hari = Hari;
    }

    public int getBulan() {
        return this.Bulan;
    }

    public void setBulan(int Bulan) {
        this.Bulan = Bulan;
    }

    public int getTahun() {
        return this.Tahun;
    }

    public void setTahun(int Tahun) {
        this.Tahun = Tahun;
    }

    public boolean isGreaterThan(Tanggal mtanggal)
    {
        if(this.Tahun<mtanggal.getTahun())
            return false;
        else{
            if(this.Bulan<mtanggal.getBulan())
                return false;
            else{
                if(this.Hari<mtanggal.getHari())
                    return false;
                else return true;
            }
        }
    }
}