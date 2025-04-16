public class Tiket extends TiketKereta {  
    private String tiketId;  
    private String tanggal;  
    private Kereta kereta;  

    public Tiket(String tiketId, String tanggal, Kereta kereta, String namaPemesan, double harga, int nomorKursi) {  
        super(namaPemesan, harga, nomorKursi);  
        this.tiketId = tiketId;  
        this.tanggal = tanggal;  
        this.kereta = kereta;  
    }  

    public String getTiketId() { return tiketId; }  
    public String getTanggal() { return tanggal; }  
    public Kereta getKereta() { return kereta; }  

    @Override  
    public String getDetails() {  
        return String.format("\n=== TIKET KERETA ===\nID Tiket: %s\nTanggal: %s\n%s",  
                tiketId, tanggal, super.getDetails());  
    }  

    public void printTiket() {  
        System.out.println(this.getDetails());  
        System.out.println("====================");  
    }  

    public void setTiketId(String tiketId) {
        this.tiketId = tiketId;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public void setKereta(Kereta kereta) {
        this.kereta = kereta;
    }
}  