
package atm;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Musteri extends Person {

    Scanner scan = new Scanner(System.in);

    @Override
    public boolean girisyap(String kadi, String sifre) {
        String sorgu = kadi+" "+sifre;
        File f = Dosyaislemler.dosyaac("musteriler.txt");
        if (Dosyaislemler.boylebirkullanicivarmi(f,sorgu)) {
            return true;
        } else {
            return false;
        }

    }

    public void paracek(double x,String kadi) throws IOException {
        File f =Dosyaislemler.dosyaac(kadi+"kasa.txt");
        
        double para =Dosyaislemler.paraverisial(f);
        if(para<x){
            System.out.println("istenilen kadar para yok");
        }
        else{
            para=para-x;
            Dosyaislemler.paraverisiguncelle(f,String.valueOf(para));
            System.out.println("para cekme işleminiz başarıyla gerçekleşti!");
        }
    }

    public void parayatir(double para,String kadi) throws IOException {
        
    File f =Dosyaislemler.dosyaac(kadi+"kasa.txt");
    double kasa =Dosyaislemler.paraverisial(f);
    Dosyaislemler.paraverisiguncelle(f,String.valueOf(para+kasa));
        System.out.println("para yatırma işleminiz başarıyla gerçekleşti!");
    }

}
