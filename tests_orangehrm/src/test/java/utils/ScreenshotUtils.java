package utils;

import java.awt.Toolkit;
import java.awt.Robot;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.imageio.ImageIO;


public class ScreenshotUtils {

    public static void capturarScreenshot(String test, String printName) {

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm"));
        String screenshotPath = "evidencias/screenshots/" + test + "/";
        String screenshotName = screenshotPath + printName + "_" + timestamp + ".png";

        File diretorio = new File(screenshotPath);
            if (!diretorio.exists()) {
                diretorio.mkdirs();
            }; 
        
        try {            
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());            
            BufferedImage capture = new Robot().createScreenCapture(screenRect);            
            File imageFile = new File(screenshotName);            
            ImageIO.write(capture, "png", imageFile);        
        } catch (Exception e) {            
            System.err.println("Erro ao capturar o screenshot: " + e.getMessage());       
        }
    }
    
}
