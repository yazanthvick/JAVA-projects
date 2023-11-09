package BankSystemPackage.LoggingExample;

import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class TestLogging {

    public static void main(String[] args) throws Exception{
        Logger log = Logger.getLogger("Banking Logging");
        FileHandler fh = new FileHandler("log"+(new Date().getTime())+".txt");
        fh.setFormatter(new SimpleFormatter());
        log.addHandler(fh);
        log.setUseParentHandlers(false);
        log.info("Information message 2020");
        log.warning("Warning message");
        log.severe("Error message");
    }
}
