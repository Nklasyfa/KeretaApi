import java.util.ArrayList;  

public class Kereta extends TiketKereta {  
    private String namaKereta;  
    private String kelas;  

    public Kereta(String namaPemesan, String namaKereta, String kelas, double harga, int nomorKursi) {  
        super(namaPemesan, harga, nomorKursi);  
        this.namaKereta = namaKereta;  
        this.kelas = kelas;  
    }  

    @Override  
    public String getDetails() {  
        return String.format("%s | Kereta: %s | Kelas: %s",  
                super.getDetails(), namaKereta, kelas);  
    }  

    public String getNamaKereta() { return namaKereta; }  
    public void setNamaKereta(String nama) { if(!nama.isEmpty()) this.namaKereta = nama; }  
    public String getKelas() { return kelas; }  
    public void setKelas(String kelas) { if(!kelas.isEmpty()) this.kelas = kelas; }  

    public Tiket buatTiket(String id, String tanggal) {  
        return new Tiket(id, tanggal, this, this.namaPemesan, this.harga, this.nomorKursi);  
    }  

    public static Kereta cariKereta(ArrayList<Kereta> daftar, String namaKereta) {  
        for(Kereta k : daftar) {  
            if(k.getNamaKereta().equalsIgnoreCase(namaKereta)) {  
                return k;  
            }  
        }  
        return null;  
    }  

    public static ArrayList<Kereta> quickSort(ArrayList<Kereta> list) {  
        quickSortHelper(list, 0, list.size()-1);  
        return list;  
    }  

    private static void quickSortHelper(ArrayList<Kereta> list, int low, int high) {  
        if(low < high) {  
            int pi = partition(list, low, high);  
            quickSortHelper(list, low, pi-1);  
            quickSortHelper(list, pi+1, high);  
        }  
    }  

    private static int partition(ArrayList<Kereta> list, int low, int high) {  
        String pivot = list.get(high).getNamaPemesan();  
        int i = low-1;  

        for(int j=low; j<high; j++) {  
            if(list.get(j).getNamaPemesan().compareTo(pivot) < 0) {  
                i++;  
                swap(list, i, j);  
            }  
        }  
        swap(list, i+1, high);  
        return i+1;  
    }  

    private static void swap(ArrayList<Kereta> list, int i, int j) {  
        Kereta temp = list.get(i);  
        list.set(i, list.get(j));  
        list.set(j, temp);  
    }  

    @Override  
    public String toString() {  
        return String.format("%-15s | %-15s | %-15s | Rp%-10.0f | Kursi: %02d",  
                namaPemesan, namaKereta, kelas, harga, nomorKursi);  
    }  
}  