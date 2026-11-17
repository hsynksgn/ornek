import java.util.List;

public interface UrunService {
    void ekle(Urun urun);                           // Create
    List<Urun> tumunuListele();                     // Read
    void fiyatGuncelle(int id, double yeniFiyat);   // Update
    void sil(int id);                               // Delete
}