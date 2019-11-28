package jadwalkereta.model;

public class Booking{
    String kdJadwal;
    String tanggal;
    String kdKereta;
    String user;
    String kdpesan;
    String kdBooking;
    int ispaid;
    long harga;
    String[] penumpang;
    String[] kursi;


    public Booking(String kdJadwal, int ispaid, String kdpesan, String[] penumpang, String[] kursi, long harga, String user, String tanggal, String kdKereta)
    //String kdJadwal, int jmlPenumpang, String[] penumpang, String[] kursi
    {
        this.kdJadwal = kdJadwal;
        this.harga = harga;
        this.ispaid = ispaid;
        this.kdpesan = kdpesan;
        this.user = user;
        this.penumpang = penumpang;
        this.kursi = kursi;
        this.tanggal = tanggal;
        this.kdKereta = kdKereta;
    }
    public Booking(String kdJadwal, int ispaid, String kdpesan, long harga, String user, String tanggal, String kdKereta)
    //String kdJadwal, int jmlPenumpang, String[] penumpang, String[] kursi
    {
        this.kdJadwal = kdJadwal;
        this.harga = harga;
        this.ispaid = ispaid;
        this.kdpesan = kdpesan;
        this.user = user;
        this.tanggal = tanggal;
        this.kdKereta = kdKereta;
        this.penumpang = new String[]{};
        this.kursi = new String[]{};
    
    }


    public void setKdJadwal(String kdJadwal)
    {
        this.kdJadwal=kdJadwal;
    }
    public void setKdBooking(String kdBooking)
    {
        this.kdBooking=kdBooking;
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
    
    public String getKdBooking()
    {
        return this.kdBooking;
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

    public String[] getKursi()
    {
        return this.kursi;
    }
    public void setKursi(String[] kursi)
    {
        this.kursi=kursi;
    }

    public void setTanggal(String t)
    {
        this.tanggal=t;
    }

    public String getTanggal()
    {
        return this.tanggal;
    }

    public void setKdKereta(String kk)
    {
        this.kdKereta=kk;
    }

    public String getKdKereta()
    {
        return this.kdKereta;
    }
    


}