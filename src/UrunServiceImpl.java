import java.util.ArrayList;
import java.util.List;

public class UrunServiceImpl implements UrunService {
    // Verilerimizi bellekte tutacağımız liste
    private List<Urun> urunListesi = new ArrayList<>();

    @Override
    public void ekle(Urun urun) {
        urunListesi.add(urun);
        System.out.println("Başarılı: '" + urun.getAd() + "' sisteme eklendi.");
    }

    @Override
    public List<Urun> tumunuListele() {
        return urunListesi;
    }

    @Override
    public void fiyatGuncelle(int id, double yeniFiyat) {
        for (Urun u : urunListesi) {
            if (u.getId() == id) {
                u.setFiyat(yeniFiyat);
                System.out.println("Başarılı: Ürün fiyatı güncellendi.");
                return; // Ürün bulundu ve güncellendi, metottan çık
            }
        }
        System.out.println("Hata: " + id + " ID'li ürün bulunamadı.");
    }

    @Override
    public void sil(int id) {
        // Java 8+ removeIf metodu ile şarta uyan elemanı listeden kolayca sileriz
        boolean silindiMi = urunListesi.removeIf(u -> u.getId() == id);
        if (silindiMi) {
            System.out.println("Başarılı: " + id + " ID'li ürün silindi.");
        } else {
            System.out.println("Hata: Silinecek ürün bulunamadı.");
        }
    }
}