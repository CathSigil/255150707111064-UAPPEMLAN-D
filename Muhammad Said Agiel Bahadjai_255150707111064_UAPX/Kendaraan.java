
import java.util.Locale;

public abstract class Kendaraan {
    private String kodeKendaraan;
    private String namaKendaraan;
    private double hargaSewaPerHari;
    private boolean isTersedia;

    public Kendaraan(String kode, String nama, double hargaSewa) {
        this.kodeKendaraan = kode;
        this.namaKendaraan = nama;
        this.hargaSewaPerHari = hargaSewa;
        this.isTersedia = true;
    }

    // Getter dan Setter sesuai Class Diagram
    public String getKodeKendaraan() { return kodeKendaraan; }
    public void setKodeKendaraan(String kode) { this.kodeKendaraan = kode; }

    public String getNamaKendaraan() { return namaKendaraan; }
    public void setNamaKendaraan(String nama) { this.namaKendaraan = nama; }

    public double getHargaSewaPerHari() { return hargaSewaPerHari; }
    public void setHargaSewaPerHari(double harga) { this.hargaSewaPerHari = harga; }

    public boolean isTersedia() { return isTersedia; }
    public void setTersedia(boolean status) { this.isTersedia = status; }

    // Method sesuai Class Diagram
    public void tampilInfo() {
        // Akan di-override oleh sub-class
    }

    public double hitungBiayaDasar(int lamaSewa) {
        return this.hargaSewaPerHari * lamaSewa;
    }
}