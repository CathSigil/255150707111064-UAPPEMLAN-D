
import java.util.Locale;

public class Motor extends Kendaraan {
    private String jenisTransmisi;

    public Motor(String kode, String nama, double harga, String jenisTransmisi) {
        super(kode, nama, harga);
        this.jenisTransmisi = jenisTransmisi;
    }

    public String getJenisTransmisi() { return jenisTransmisi; }
    public void setJenisTransmisi(String jenis) { this.jenisTransmisi = jenis; }

    @Override
    public void tampilInfo() {
        String status = isTersedia() ? "Tersedia" : "Disewa";
        String tarifStr = "Rp" + String.format(Locale.US, "%,.0f", getHargaSewaPerHari()) + "/hari";
        System.out.printf("[MOTOR] Kode: %s | Nama: %-17s | Transmisi: %s | Tarif: %-14s | Status: %s%n",
                getKodeKendaraan(), getNamaKendaraan(), jenisTransmisi, tarifStr, status);
    }

    @Override
    public double hitungBiayaDasar(int lamaSewa) {
        return super.hitungBiayaDasar(lamaSewa);
    }
}