package desafio.automacao.orangehrm.login;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.ScreenshotUtils;



public class LoginTest {

    private LoginPage paginaDeLogin;


    @BeforeEach
    public void beforeEach() {
        this.paginaDeLogin = new LoginPage();
    }

    @AfterEach
    public void AfterEach() {
        this.paginaDeLogin.fechar();
        
    }

    @Test
    public void CT01_efetuarLoginCredenciaisCorretas() {
        paginaDeLogin.preencheFormulario("Admin", "admin123");
        paginaDeLogin.efetuaLogin();

        
        Assertions.assertTrue(paginaDeLogin.isPaginaDashboard());
        ScreenshotUtils.capturarScreenshot("CT01Login", "CredenciaisValidas");
    }

    @Test
    public void CT02_naoLogarUsuarioInvalido() {
        paginaDeLogin.preencheUsuarioInvalido("UsuarioErrado", "admin123");
        paginaDeLogin.efetuaLogin();

        Assertions.assertTrue(paginaDeLogin.isPaginaDeLogin());
        Assertions.assertTrue(paginaDeLogin.contemCredencialInvalida());
        ScreenshotUtils.capturarScreenshot("CT02Login", "UsuarioInvalido");
    }

    @Test
    public void CT03_naoLogarSenhaInvalida() {
        paginaDeLogin.preencheSenhaInvalida("Admin", "SenhaIncorreta");
        paginaDeLogin.efetuaLogin();
        
        Assertions.assertTrue(paginaDeLogin.isPaginaDeLogin());
        Assertions.assertTrue(paginaDeLogin.contemCredencialInvalida());
        ScreenshotUtils.capturarScreenshot("CT03Login", "SenhaInvalida");
    }

    @Test
    public void CT04_naoLogarCamposEmBranco() {
        paginaDeLogin.naoPreencheUsuario("", "admin123");
        paginaDeLogin.efetuaLogin();

        Assertions.assertTrue(paginaDeLogin.isPaginaDeLogin());
        Assertions.assertTrue(paginaDeLogin.contemCampoEmBranco());
        paginaDeLogin.esperarUrlDashboard();
        ScreenshotUtils.capturarScreenshot("CT04Login", "UsuarioEmBranco");
    }

}
