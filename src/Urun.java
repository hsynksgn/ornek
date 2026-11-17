public class Urun {
    private int id;
    private String ad;
    private double fiyat;
    private int stok;

    // Constructor (Yapıcı Metot)
    public Urun(int id, String ad, double fiyat, int stok) {
        this.id = id;
        this.ad = ad;
        this.fiyat = fiyat;
        this.stok = stok;
    }

    // Getter ve Setter Metotları
    public int getId() {
        return id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public double getFiyat() {
        return fiyat;
    }

    public void setFiyat(double fiyat) {
        if (fiyat > 0) {
            this.fiyat = fiyat;
        } else {
            System.out.println("Uyarı: Fiyat 0'dan büyük olmalıdır!");
        }
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    // Nesneyi ekrana yazdırırken okunaklı görünmesi için toString() metodunu eziyoruz (@Override)
    @Override
    public String toString() {
        return "ID: " + id + " | Ürün: " + ad + " | Fiyat: " + fiyat + " TL | Stok: " + stok;
    }
}