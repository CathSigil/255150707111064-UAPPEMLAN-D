
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class GoDriveRentalSystem {
    private ArrayList<Kendaraan> daftarKendaraan;

    public GoDriveRentalSystem() {
        daftarKendaraan = new ArrayList<>();
    }

    public void tambahKendaraan(Kendaraan k) {
        daftarKendaraan.add(k);
        System.out.println("[INFO] Kendaraan berhasil ditambahkan: " + k.getNamaKendaraan() + " (" + k.getKodeKendaraan() + ")");
    }

    public void tambahDataAwal(Kendaraan k) {
        daftarKendaraan.add(k);
    }

    public void tampilkanDaftarKendaraan() {
        System.out.println("=== DAFTAR ARMADA GODRIVE ===");
        int i = 1;
        for (Kendaraan k : daftarKendaraan) {
            System.out.print(i + ". ");
            k.tampilInfo(); 
            i++;
        }
    }

    public void sewaKendaraan(String kode, int lamaSewa) throws KendaraanTidakTersediaException {
        Scanner inputSewa = new Scanner(System.in);
        
        for (Kendaraan k : daftarKendaraan) {
            if (k.getKodeKendaraan().equalsIgnoreCase(kode)) {
                
                System.out.print("Apakah Anda Member VIP? (y/n): ");
                String isVIP = inputSewa.nextLine().trim();

                if (!k.isTersedia()) {
                    throw new KendaraanTidakTersediaException("Kendaraan dengan kode " + kode + " gagal disewa. Alasan: Kendaraan sedang disewa atau tidak ditemukan!");
                }

                k.setTersedia(false);
                double biayaDasar = k.hitungBiayaDasar(lamaSewa); 
                double tambahan = 0;

                System.out.println("\n=== TRANSAKSI SEWA GODRIVE ===");
                System.out.println("Kendaraan Berhasil Disewa!");
                System.out.println("Unit            : " + k.getNamaKendaraan() + " (" + k.getKodeKendaraan() + ")");
                System.out.println("Lama Sewa       : " + lamaSewa + " hari");
                System.out.println("Biaya Dasar Hari : Rp " + String.format(Locale.US, "%,.0f", biayaDasar));

                if (k instanceof Mobil m) {
                    if (m.getJumlahKursi() > 5) {
                        tambahan = 50000;
                        System.out.println("Tambahan Kursi (>5): Rp " + String.format(Locale.US, "%,.0f", tambahan));
                    }
                } else if (k instanceof Motor mo) {
                    if (mo.getJenisTransmisi().equalsIgnoreCase("Matik")) {
                        tambahan = 10000.0 * lamaSewa;
                        System.out.println("Biaya Asuransi (Matik): Rp " + String.format(Locale.US, "%,.0f", tambahan));
                    }
                }

                double subtotal = biayaDasar + tambahan;
                double diskon = 0;

                if (isVIP.equalsIgnoreCase("y")) {
                    diskon = subtotal * 0.10;
                    System.out.println("Diskon Member VIP (10%): -Rp " + String.format(Locale.US, "%,.0f", diskon));
                }

                double totalBiaya = subtotal - diskon;
                System.out.println("Total Biaya     : Rp " + String.format(Locale.US, "%,.0f", totalBiaya));
                return;
            }
        }
        
        throw new KendaraanTidakTersediaException("Kendaraan dengan kode " + kode + " gagal disewa. Alasan: Kendaraan sedang disewa atau tidak ditemukan!");
    }

    public void kembalikanKendaraan(String kode) {
        for (Kendaraan k : daftarKendaraan) {
            if (k.getKodeKendaraan().equalsIgnoreCase(kode)) {
                k.setTersedia(true);
                System.out.println("[INFO] Kendaraan " + k.getNamaKendaraan() + " (" + kode + ") berhasil dikembalikan. Status: Tersedia.");
                return;
            }
        }
        System.out.println("[INFO] Kendaraan dengan kode " + kode + " tidak ditemukan.");
    }
}