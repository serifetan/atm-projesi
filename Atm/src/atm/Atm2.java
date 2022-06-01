
package atm;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Atm2 implements Banka{

    @Override
    public void paraver(double para) {
        File f =Dosyaislemler.dosyaac("kasa2.txt");
        File f2 = Dosyaislemler.dosyaac("kasa.txt");
        double anakasa=0;
        double kasa = 0;
        try {
            kasa = Dosyaislemler.paraverisial(f);
            anakasa=Dosyaislemler.paraverisial(f2);
            
        } catch (IOException ex) {
            Logger.getLogger(Atm1.class.getName()).log(Level.SEVERE, null, ex);
        }
        Dosyaislemler.paraverisiguncelle(f,String.valueOf(kasa-para));
        Dosyaislemler.paraverisiguncelle(f2, String.valueOf(anakasa-para));
    }

    @Override
    public void paraal(double para) {
       File f =Dosyaislemler.dosyaac("kasa2.txt");
        File f2 = Dosyaislemler.dosyaac("kasa.txt");
        double kasa = 0;
        double anakasa=0;
        try {
            kasa = Dosyaislemler.paraverisial(f);
            anakasa=Dosyaislemler.paraverisial(f2);
            
        } catch (IOException ex) {
            Logger.getLogger(Atm1.class.getName()).log(Level.SEVERE, null, ex);
        }
        Dosyaislemler.paraverisiguncelle(f,String.valueOf(kasa+para));
        Dosyaislemler.paraverisiguncelle(f2, String.valueOf(anakasa+para));
    }
    
}
