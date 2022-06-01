package atm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Person {

    private String kullaniciadi;
    private String sifre;

    public Person(String kullaniciadi, String sifre) {
        this.kullaniciadi = kullaniciadi;
        this.sifre = sifre;
    }
    public Person(){}
    public String getKullaniciadi() {
        return kullaniciadi;
    }

    public void setKullaniciadi(String kullaniciadi) {
        this.kullaniciadi = kullaniciadi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }
    Scanner scan = new Scanner(System.in);

    public abstract boolean girisyap(String kadi,String sifre);

    public void kayitol() {
        
        File f =Dosyaislemler.dosyaac("musteriler.txt");
        
        System.out.println("kullanici adi giriniz: ");
        String kadi =scan.nextLine();
        System.out.println("şifreniz : ");
        String ksifre = scan.nextLine();
        Dosyaislemler.dosyaac("musteriler.txt");
        Dosyaislemler.dosyaac(kadi+"kasa.txt");
        String sorgu=kadi+" "+ksifre;
        Dosyaislemler.yenimusteriekle(f,sorgu);
    }

    
}
