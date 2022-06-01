/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dosyaislemler {

    public static File dosyaac(String dosyaadi) {
        File file = new File(dosyaadi);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                System.out.println("dosya oluşturulamadı hata!!");
            }
        }
        return file;
    }

    public static void yenimusteriekle(File file, String sorgu) {
        FileWriter fw;
        try {
            fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("\n");
            bw.write(sorgu);
            bw.close();
        } catch (IOException ex) {
            System.out.println("hata yeni musteriekle");
        }
        System.out.println("yeni kullanici eklendi");
    }

    public static boolean boylebirkullanicivarmi(File f, String sorgu) {
        try {
            FileReader fr = new FileReader(f);
            String line;
            BufferedReader br = new BufferedReader(fr);
            int a = 0;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                if (!line.equals(sorgu)) {
                    continue;
                } else {
                   System.out.println("bilgiler doğru giriş yapıldı");
                   return true;
                }
                
            }
            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println("dosya yok");
        } catch (IOException ex) {
            System.out.println("hata");
        }
        System.out.println("kullanıcı adı veya şifre hatalı");
        return false;

    }

    public static double paraverisial(File f) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader(f);
        String line;
        BufferedReader br = new BufferedReader(fr);
        while((line=br.readLine())!=null){
            if(Double.valueOf(line)<=0){
                System.out.println("kasada yeterli para yok! lütfen en yakın atm ye müracaat edin");
                break;
            }
            else{
                double para =Double.valueOf(line);
                return para;
            }
        }
        return 0;
    }
    public static void paraverisiguncelle(File f, String para){
         FileWriter fw;
        try {
            fw = new FileWriter(f, false);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(para);
            bw.close();
        } catch (IOException ex) {
            System.out.println("hatavar paraverisigüncelle");
        }
    }

}
