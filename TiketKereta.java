public abstract class TiketKereta {  
    protected String namaPemesan;  
    protected double harga;  
    protected int nomorKursi;  

    public TiketKereta(String namaPemesan, double harga, int nomorKursi) {  
        this.namaPemesan = namaPemesan;  
        this.harga = harga;  
        this.nomorKursi = nomorKursi;  
    }  

    public String getDetails() {  
        return String.format("Pemesan: %s | Harga: Rp%.0f | Kursi: %d",  
                namaPemesan, harga, nomorKursi);  
    }  

    public String getNamaPemesan() { return namaPemesan; }  
    public void setNamaPemesan(String nama) { if(!nama.isEmpty()) this.namaPemesan = nama; }  
    public double getHarga() { return harga; }  
    public void setHarga(double harga) { if(harga > 0) this.harga = harga; }  
    public int getNomorKursi() { return nomorKursi; }  
    public void setNomorKursi(int no) { if(no > 0) this.nomorKursi = no; }  
}  