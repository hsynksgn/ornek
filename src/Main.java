import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Polymorphism: Interface referansı ile Impl nesnesi tutuyoruz
        UrunService urunService = new UrunServiceImpl();
        int otomatikId = 1; // Her yeni üründe ID otomatik 1 artacak

        while (true) {
            System.out.println("\n=== ÜRÜN YÖNETİM SİSTEMİ ===");
            System.out.println("1. Ürün Ekle (Create)");
            System.out.println("2. Ürünleri Listele (Read)");
            System.out.println("3. Fiyat Güncelle (Update)");
            System.out.println("4. Ürün Sil (Delete)");
            System.out.println("0. Çıkış");
            System.out.print("Seçiminiz: ");

            try {
                // Kullanıcı harf girerse program çökmesin diye satır okuyup sayıya çeviriyoruz
                int secim = Integer.parseInt(scanner.nextLine());

                if (secim == 0) {
                    System.out.println("Sistemden çıkılıyor...");
                    break; // while döngüsünü kırar ve programı bitirir
                }

                switch (secim) {
                    case 1:
                        System.out.print("Ürün Adı: ");
                        String ad = scanner.nextLine();

                        System.out.print("Fiyatı (TL): ");
                        double fiyat = Double.parseDouble(scanner.nextLine());

                        System.out.print("Stok Adedi: ");
                        int stok = Integer.parseInt(scanner.nextLine());

                        Urun yeniUrun = new Urun(otomatikId++, ad, fiyat, stok);
                        urunService.ekle(yeniUrun);
                        break;

                    case 2:
                        List<Urun> urunler = urunService.tumunuListele();
                        if (urunler.isEmpty()) {
                            System.out.println("Listede henüz hiç ürün yok.");
                        } else {
                            System.out.println("\n--- Kayıtlı Ürünler ---");
                            for (Urun u : urunler) {
                                System.out.println(u); // Otomatik toString() metodunu çağırır
                            }
                        }
                        break;

                    case 3:
                        System.out.print("Fiyatı güncellenecek Ürün ID: ");
                        int guncellenecekId = Integer.parseInt(scanner.nextLine());

                        System.out.print("Yeni Fiyat (TL): ");
                        double yeniFiyat = Double.parseDouble(scanner.nextLine());

                        urunService.fiyatGuncelle(guncellenecekId, yeniFiyat);
                        break;

                    case 4:
                        System.out.print("Silinecek Ürün ID: ");
                        int silinecekId = Integer.parseInt(scanner.nextLine());

                        urunService.sil(silinecekId);
                        break;

                    default:
                        System.out.println("Geçersiz seçim! Lütfen 0-4 arası bir sayı girin.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Hata: Lütfen sayısal bir değer giriniz!");
            }
        }
        scanner.close();
    }
}