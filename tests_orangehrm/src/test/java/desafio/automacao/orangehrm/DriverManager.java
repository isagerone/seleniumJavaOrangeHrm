package desafio.automacao.orangehrm;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class DriverManager {

    private static WebDriver browser;

    public static WebDriver getDriver() {
        if (browser == null) {
            System.setProperty("web.edge.driver", "driver/msedgedriver.exe");

            EdgeOptions options = new EdgeOptions();
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

            browser = new EdgeDriver(options);
            browser.manage().window().maximize();        
        }
        return browser;
    }

    public static void quitDriver() {
        if (browser != null) {
            browser.quit();
            browser = null;
        }
    }
}


