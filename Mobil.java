
import java.util.Locale;

public class Mobil extends Kendaraan {
    private int jumlahKursi;

    public Mobil(String kode, String nama, double harga, int jumlahKursi) {
        super(kode, nama, harga);
        this.jumlahKursi = jumlahKursi;
    }

    public int getJumlahKursi() { return jumlahKursi; }
    public void setJumlahKursi(int jumlah) { this.jumlahKursi = jumlah; }

    @Override
    public void tampilInfo() {
        String status = isTersedia() ? "Tersedia" : "Disewa";
        String tarifStr = "Rp" + String.format(Locale.US, "%,.0f", getHargaSewaPerHari()) + "/hari";
        System.out.printf("[MOBIL] Kode: %s | Nama: %-17s | Kursi: %d | Tarif: %-14s | Status: %s%n",
                getKodeKendaraan(), getNamaKendaraan(), jumlahKursi, tarifStr, status);
    }

    @Override
    public double hitungBiayaDasar(int lamaSewa) {
        return super.hitungBiayaDasar(lamaSewa);
    }
}