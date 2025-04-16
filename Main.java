import java.util.ArrayList;
import java.util.Comparator;  
import java.util.Scanner;  

public class Main {  
    public static void main(String[] args) {  
        ArrayList<Kereta> daftarKereta = new ArrayList<>();  
        initData(daftarKereta);  

        try (Scanner scanner = new Scanner(System.in)) {  
            int pilihan;  
            do {  
                tampilkanMenu();  
                pilihan = scanner.nextInt();  
                scanner.nextLine();  

                switch(pilihan) {  
                    case 1:  
                        tampilkanSemuaKereta(daftarKereta);  
                        break;  
                    case 2:  
                        tambahKereta(scanner, daftarKereta);  
                        break;  
                    case 3:  
                        editKereta(scanner, daftarKereta);  
                        break;  
                    case 4:  
                        cariKereta(scanner, daftarKereta);  
                        break;  
                    case 5:  
                        sortHarga(daftarKereta);  
                        break;  
                    case 6:  
                        sortNamaPemesan(daftarKereta);  
                        break;  
                    case 7:  
                        generateTiket(scanner, daftarKereta);  
                        break;  
                    case 0:  
                        System.out.println("Terima kasih!");  
                        break;  
                    default:  
                        System.out.println("Pilihan tidak valid!");  
                }  
            } while(pilihan != 0);  
        }  
    }  

    private static void initData(ArrayList<Kereta> daftar) {  
        daftar.add(new Kereta("Joko", "Brantas", "Ekonomi", 120000, 12));  
        daftar.add(new Kereta("Ambarukmo", "Jaya Baya", "Ekonomi New Gen", 250000, 13));  
        daftar.add(new Kereta("Orang Hutan", "Papandayan", "Eksklusif", 300000, 25));  
        daftar.add(new Kereta("Andriana", "ArgoNgawi", "Panoramic", 1300000, 29));  
        daftar.add(new Kereta("Mas Rahmat", "TahuSumedang", "Ekonomi", 280000, 49));  
    }  

    private static void tampilkanMenu() {  
        System.out.println("\n=== SISTEM PEMESANAN KERETA ===");  
        System.out.println("1. Tampilkan semua kereta");  
        System.out.println("2. Tambah Pemesan Baru");  
        System.out.println("3. Edit data kereta");  
        System.out.println("4. Cari kereta");  
        System.out.println("5. Sorting berdasarkan harga");  
        System.out.println("6. Sorting berdasarkan nama pemesan");  
        System.out.println("7. Cetak Tiket");  
        System.out.println("0. Keluar");  
        System.out.print("Pilihan: ");  
    }  

    private static void tambahKereta(Scanner scanner, ArrayList<Kereta> daftar) {  
        System.out.println("\n=== TAMBAH PEMESAN BARU ===");  
        System.out.print("Nama Pemesan: ");  
        String nama = scanner.nextLine();  
        System.out.print("Nama Kereta: ");  
        String kereta = scanner.nextLine();  
        System.out.print("Kelas: ");  
        String kelas = scanner.nextLine();  
        System.out.print("Harga: ");  
        double harga = scanner.nextDouble();  
        System.out.print("Nomor Kursi: ");  
        int kursi = scanner.nextInt();  
        scanner.nextLine();  

        daftar.add(new Kereta(nama, kereta, kelas, harga, kursi));  
        System.out.println("Data berhasil ditambahkan!");  
    }  

    private static void editKereta(Scanner scanner, ArrayList<Kereta> daftar) {  
        System.out.print("\nMasukkan nomor kursi yang akan diedit: ");  
        int noKursi = scanner.nextInt();  
        scanner.nextLine();  

        Kereta found = null;  
        for(Kereta k : daftar) {  
            if(k.getNomorKursi() == noKursi) {  
                found = k;  
                break;  
            }  
        }  

        if(found == null) {  
            System.out.println("Data tidak ditemukan!");  
            return;  
        }  

        System.out.print("Nama baru [" + found.getNamaPemesan() + "]: ");  
        String nama = scanner.nextLine();  
        if(!nama.isEmpty()) found.setNamaPemesan(nama);  

        System.out.print("Harga baru [" + found.getHarga() + "]: ");  
        String hargaStr = scanner.nextLine();  
        if(!hargaStr.isEmpty()) found.setHarga(Double.parseDouble(hargaStr));  

        System.out.println("Data berhasil diupdate!");  
    }  

    private static void cariKereta(Scanner scanner, ArrayList<Kereta> daftar) {  
        System.out.print("\nMasukkan nama kereta atau pemesan: ");  
        String keyword = scanner.nextLine();  

        ArrayList<Kereta> hasil = new ArrayList<>();  
        for(Kereta k : daftar) {  
            if(k.getNamaKereta().equalsIgnoreCase(keyword) ||   
               k.getNamaPemesan().equalsIgnoreCase(keyword)) {  
                hasil.add(k);  
            }  
        }  

        if(hasil.isEmpty()) {  
            System.out.println("Tidak ditemukan hasil untuk '" + keyword + "'");  
        } else {  
            tampilkanSemuaKereta(hasil);  
        }  
    }  

    private static void sortHarga(ArrayList<Kereta> daftar) {  
        daftar.sort(Comparator.comparingDouble(Kereta::getHarga));  
        System.out.println("\n=== Sorting berdasarkan harga ===");  
        tampilkanSemuaKereta(daftar);  
    }  

    private static void sortNamaPemesan(ArrayList<Kereta> daftar) {  
        Kereta.quickSort(daftar);  
        System.out.println("\n=== Sorting berdasarkan nama pemesan ===");  
        tampilkanSemuaKereta(daftar);  
    }  

    private static void generateTiket(Scanner scanner, ArrayList<Kereta> daftar) {  
        System.out.print("Masukkan nomor kursi: ");  
        int noKursi = scanner.nextInt();  
        scanner.nextLine();  

        Kereta found = null;  
        for(Kereta k : daftar) {  
            if(k.getNomorKursi() == noKursi) {  
                found = k;  
                break;  
            }  
        }  

        if(found == null) {  
            System.out.println("Data tidak ditemukan!");  
            return;  
        }  

        System.out.print("Masukkan ID Tiket: ");  
        String id = scanner.nextLine();  
        System.out.print("Masukkan Tanggal: ");  
        String tgl = scanner.nextLine();  

        Tiket tiket = found.buatTiket(id, tgl);  
        tiket.printTiket();  
    }  

    private static void tampilkanSemuaKereta(ArrayList<Kereta> daftar) {  
        System.out.println("\n=== DAFTAR KERETA ===");  
        System.out.printf("%-15s | %-15s | %-15s | %-12s | %s\n",   
                "Pemesan", "Kereta", "Kelas", "Harga", "Kursi");  
        for(Kereta k : daftar) {  
            System.out.println(k);  
        }  
    }  
}  