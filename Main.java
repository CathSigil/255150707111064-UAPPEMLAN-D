
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static GoDriveRentalSystem sistem = new GoDriveRentalSystem();

    public static void main(String[] args) throws Exception {
        isiDataAwal();

        int pilihan;
        do {
            System.out.println("\n====== MENU GO DRIVE RENTAL SYSTEM ======");
            System.out.println("1. Tambah Kendaraan");
            System.out.println("2. Tampilkan Daftar Armada");
            System.out.println("3. Sewa Kendaraan");
            System.out.println("4. Kembalikan Kendaraan");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            
            pilihan = Integer.parseInt(scanner.nextLine().trim());

            switch (pilihan) {
                case 1 -> menuTambah();
                case 2 -> sistem.tampilkanDaftarKendaraan();
                case 3 -> menuSewa();
                case 4 -> menuKembalikan();
                case 5 -> System.out.println("Keluar dari sistem.");
                default -> System.out.println("Menu tidak valid.");
            }
        } while (pilihan != 5);
    }

    private static void menuTambah() {
        System.out.print("Masukkan jenis kendaraan (mobil/motor): ");
        String jenis = scanner.nextLine().trim().toLowerCase();
        
        System.out.print("Masukkan kode kendaraan: ");
        String kode = scanner.nextLine().trim();
        
        System.out.print("Masukkan nama kendaraan: ");
        String nama = scanner.nextLine().trim();
        
        System.out.print("Masukkan harga sewa per hari: ");
        double harga = Double.parseDouble(scanner.nextLine().trim());

        if (jenis.equals("mobil")) {
            System.out.print("Masukkan kapasitas kursi: ");
            int kursi = Integer.parseInt(scanner.nextLine().trim());
            sistem.tambahKendaraan(new Mobil(kode, nama, harga, kursi));
        } else if (jenis.equals("motor")) {
            System.out.print("Masukkan jenis transmisi (Matik/Manual): ");
            String transmisi = scanner.nextLine().trim();
            sistem.tambahKendaraan(new Motor(kode, nama, harga, transmisi));
        } else {
            System.out.println("Jenis kendaraan tidak dikenal.");
        }
    }

    public static void menuSewa() throws KendaraanTidakTersediaException {
        System.out.print("Masukkan kode kendaraan yang ingin disewa: ");
        String kode = scanner.nextLine().trim();
        
        System.out.print("Masukkan durasi sewa (dalam hari): ");
        int durasi = Integer.parseInt(scanner.nextLine().trim());
        
        sistem.sewaKendaraan(kode, durasi);
    }

    private static void menuKembalikan() {
        System.out.print("Masukkan kode kendaraan yang ingin dikembalikan: ");
        String kode = scanner.nextLine().trim();
        sistem.kembalikanKendaraan(kode);
    }

    private static void isiDataAwal() {
        sistem.tambahDataAwal(new Mobil("MBL01", "Toyota Avanza", 350000, 7));
        sistem.tambahDataAwal(new Mobil("MBL02", "Daihatsu Sigra", 300000, 7));
        sistem.tambahDataAwal(new Mobil("MBL03", "Honda Brio", 280000, 5));
        sistem.tambahDataAwal(new Motor("MTR01", "Honda Vario", 80000, "Matik"));
        sistem.tambahDataAwal(new Motor("MTR02", "Yamaha NMAX", 100000, "Matik"));
        sistem.tambahDataAwal(new Motor("MTR03", "Kawasaki KLX", 90000, "Manual"));
    }
}