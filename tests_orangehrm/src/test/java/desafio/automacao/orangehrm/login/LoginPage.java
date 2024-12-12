package desafio.automacao.orangehrm.login;

import java.time.Duration;
import java.util.function.BooleanSupplier;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import desafio.automacao.orangehrm.DriverManager;

public class LoginPage {
 
    private static final String URL_BASE = "https://opensource-demo.orangehrmlive.com/web/index.php";
    private static final String URL_DASHBOARD = URL_BASE + "/dashboard/index";
    private static final String URL_LOGIN = URL_BASE + "/auth/login";
    private WebDriver browser;
    private WebDriverWait wait;
    public BooleanSupplier isPaginaLogin;

    public LoginPage() {
        this.browser = DriverManager.getDriver();
        this.wait = new WebDriverWait(browser, Duration.ofSeconds(5));
        browser.navigate().to(URL_LOGIN);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
    }

    public void fechar() {
        DriverManager.quitDriver();
    }

    public void preencheFormulario(String username, String password) {
        browser.findElement(By.name("username")).sendKeys(username);
        browser.findElement(By.name("password")).sendKeys(password);
    }

    public void efetuaLogin() {
        browser.findElement(By.cssSelector("button[type='submit']")).click();
    }

    public boolean isPaginaDashboard() {
        return browser.getCurrentUrl().equals(URL_DASHBOARD);
        
    }

    public void preencheUsuarioInvalido(String username, String password) {
        browser.findElement(By.name("username")).sendKeys(username);
        browser.findElement(By.name("password")).sendKeys(password);
    }

    public boolean isPaginaDeLogin() {
        return browser.getCurrentUrl().equals(URL_LOGIN);
    }

    public boolean contemCredencialInvalida() {
        return browser.getPageSource().contains("Invalid credentials");
    
    }

    public void preencheSenhaInvalida(String username, String password) {
        browser.findElement(By.name("username")).sendKeys(username);
        browser.findElement(By.name("password")).sendKeys(password);

    }

    public void naoPreencheUsuario(String username, String password) {
        browser.findElement(By.name("username")).sendKeys(username);
        browser.findElement(By.name("password")).sendKeys(password);
    }

    public boolean contemCampoEmBranco() {
        return browser.getPageSource().contains("Required");
    }

    public void esperarUrlDashboard() {
        System.out.println("chegou até aqui");
        System.out.println("Título da página: " + browser.getTitle());
    }

}
