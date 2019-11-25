package jadwalkereta.model;

public class Booking{
    String kdJadwal;
    String user;
    String kdpesan;
    int ispaid;
    long harga;
    String[] penumpang;
    String[] kursi;


    public Booking(String kdJadwal, int ispaid, String kdpesan, String[] penumpang, String[] kursi, long harga, String user)
    //String kdJadwal, int jmlPenumpang, String[] penumpang, String[] kursi
    {
        this.kdJadwal = kdJadwal;
        this.harga = harga;
        this.ispaid = ispaid;
        this.kdpesan = kdpesan;
        this.user = user;
        this.penumpang = penumpang;
        this.kursi = kursi;
    }
    public Booking(String kdJadwal, int ispaid, String kdpesan, long harga, String user)
    //String kdJadwal, int jmlPenumpang, String[] penumpang, String[] kursi
    {
        this.kdJadwal = kdJadwal;
        this.harga = harga;
        this.ispaid = ispaid;
        this.kdpesan = kdpesan;
        this.user = user;
        this.penumpang = new String[]{};
        this.kursi = new String[]{};
    
    }


    public void setKdJadwal(String kdJadwal)
    {
        this.kdJadwal=kdJadwal;
    }
    public void setHarga(long harga)
    {
        this.harga=harga;
    }
    public void setIsPaid(int p)
    {
        this.ispaid=p;
    }
    public void setKdPesan(String kp)
    {
        this.kdpesan=kp;
    }

    public String getKdJadwal()
    {
        return this.kdJadwal;
    }
    public long getHarga()
    {
        return this.harga;
    }
    public int getIsPaid()
    {
        return this.ispaid;
    }
    public String getKdPesan()
    {
        return this.kdpesan;
    }

    public String getUser()
    {
        return this.user;
    }
    public void setUser(String user)
    {
        this.user=user;
    }

    public String[] getPenumpang()
    {
        return this.penumpang;
    }
    public void setUser(String[] penumpang)
    {
        this.penumpang=penumpang;
    }


    


}