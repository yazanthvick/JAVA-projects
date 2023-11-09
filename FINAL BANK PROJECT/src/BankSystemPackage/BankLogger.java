package BankSystemPackage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class BankLogger {

    private static Logger log;
   // private static BankLogger logger;

    public static Logger getLogger(){
        if(log == null){
            try{

               // logger = new BankLogger();
                log = Logger.getLogger("Banking Logging");
                FileHandler fh = new FileHandler("log"+(new Date().getTime())+".txt");
                fh.setFormatter(new SimpleFormatter());
                log.addHandler(fh);


            }catch (Exception e){
                e.printStackTrace();
            }

        }
            return log;

        }

        private BankLogger(){
        }





}
