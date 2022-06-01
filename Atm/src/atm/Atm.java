package atm;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Atm {

    public static void main(String[] args) throws IOException {
        boolean anamenu = true;
        boolean program = true;
        Scanner scan = new Scanner(System.in);
        String kadi = null;//kullanıcı adını diğer fonksiyonların içersinde kullanabilmek için tutmam gerekiyor
        int sayac = 0;
        System.out.println("banka sistemine hoş geldiniz! ");
        System.out.println("öncelikle atm seçimi yapmalısınız!\n  atm1 için: 1 \n atm2 için: 2");
        int atmsecim = scan.nextInt();
        switch (atmsecim) {
            case 1:
                Atm1 a1 = new Atm1();
                while (anamenu) {
                    System.out.println("giriş yapmak için g kayıt olmak için k ye basınız: ");

                    String cevap = scan.nextLine();

                    switch (cevap) {
                        case "g":
                            Person m = new Musteri();// poylmorphizm 
                            System.out.println("kullanıcı adı: ");
                            m.setKullaniciadi(scan.nextLine());
                            System.out.println("şifre: ");
                            m.setSifre(scan.nextLine());
                            kadi = m.getKullaniciadi();
                            if (m.girisyap(m.getKullaniciadi(), m.getSifre())) {
                                System.out.println("giriş yapıldı");
                                anamenu = false;
                                sayac++;
                                break;
                            } else {
                                System.out.println("hata");
                                
                                break;
                            }
                        case "k":
                            Musteri ym = new Musteri();
                            ym.kayitol();
                            program = false;
                            anamenu = false;
                            break;
                        default:
                            //anamenu=false;
                            break;
                    }
                }

                while (program) {

                    Musteri m = new Musteri();
                    if (sayac > 0) {

                        System.out.println("işlemler: "
                                + "\n para yatırmak için 1 \n para çekmek için 2\n bakiye öğrenmek için 3 \n çıkış yapmak için 4 \n tuşlayınız.. ");
                        int islem = scan.nextInt();

                        if (islem == 1) {
                            System.out.println("yatırmak istediğiniz miktarı giriniz:");
                            double miktar = scan.nextDouble();
                            m.parayatir(miktar, kadi);
                            a1.paraal(miktar);

                        } else if (islem == 2) {
                            System.out.println("çekmek istediğiniz miktarı giriniz:");
                            //System.out.println(m.getKullaniciadi());
                            double cekilenpara = scan.nextDouble();
                            m.paracek(cekilenpara, kadi);
                            a1.paraver(cekilenpara);

                        } else if (islem == 3) {
                            File f = Dosyaislemler.dosyaac(kadi + "kasa.txt");
                            Double para = Dosyaislemler.paraverisial(f);
                            System.out.println("kasanızda : " + para + " kadar paranız var.");
                        } else if (islem == 4) {
                            System.out.println("çıkış yapılıyor ");
                            program = false;
                        } else {
                            System.out.println("geçersiz işlem!");
                            program = false;
                        }
                    }
                }
                break;
            case 2:
                Atm2 a2 = new Atm2();
                while (anamenu) {
                    System.out.println("giriş yapmak için g kayıt olmak için k ye basınız: ");

                    String cevap = scan.nextLine();

                    switch (cevap) {
                        case "g":
                            Person m = new Musteri();// poylmorphizm 
                            System.out.println("kullanıcı adı: ");
                            m.setKullaniciadi(scan.nextLine());
                            System.out.println("şifre: ");
                            m.setSifre(scan.nextLine());
                            kadi = m.getKullaniciadi();
                            if (m.girisyap(m.getKullaniciadi(), m.getSifre())) {
                                System.out.println("giriş yapıldı");
                                anamenu = false;
                                sayac++;
                                break;
                            } else {
                                System.out.println("hata");
                                break;
                            }
                        case "k":
                            Musteri ym = new Musteri();
                            ym.kayitol();
                            program = false;
                            anamenu = false;
                            break;
                        default:
                            System.out.println("geçersiz seçim!");
                            break;
                    }
                }

                while (program) {

                    Musteri m = new Musteri();
                    if (sayac > 0) {

                        System.out.println("işlemler: "
                                + "\n para yatırmak için 1 \n para çekmek için 2\n bakiye öğrenmek için 3 \n çıkış yapmak için 4 \n tuşlayınız.. ");
                        int islem = scan.nextInt();
                        Atm1 atm = new Atm1();
                        if (islem == 1) {
                            System.out.println("yatırmak istediğiniz miktarı giriniz:");
                            double miktar = scan.nextDouble();
                            m.parayatir(miktar, kadi);
                            a2.paraal(miktar);
                        } else if (islem == 2) {
                            System.out.println("çekmek istediğiniz miktarı giriniz:");
                            //System.out.println(m.getKullaniciadi());
                            double cekilenpara = scan.nextDouble();
                            m.paracek(cekilenpara, kadi);
                            a2.paraver(cekilenpara);

                        } else if (islem == 3) {
                            File f = Dosyaislemler.dosyaac(kadi + "kasa.txt");
                            Double para = Dosyaislemler.paraverisial(f);
                            System.out.println("kasanızda : " + para + " kadar paranız var.");
                        } else if (islem == 4) {
                            System.out.println("çıkış yapılıyor ");
                            program = false;
                        } else {
                            System.out.println("geçersiz işlem!");
                            program = false;
                        }
                    }
                }
                break;
            default:
                System.out.println("hata cıktı ilk case");

        }

    }

}
