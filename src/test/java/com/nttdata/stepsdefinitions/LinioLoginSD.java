package com.nttdata.stepsdefinitions;

import com.nttdata.page.LoginLinioPage;
import com.nttdata.steps.LoginLinioSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinioLoginSD {

    LoginLinioSteps loginsteps;
    private WebDriver driver;
    private Scenario scenario;

    @Before(order = 0)
    public void setUp(){
        //setUp
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        //crear el driver
        driver = new ChromeDriver();
        //max
        driver.manage().window().maximize();
    }

    @Before(order = 1)
    public void setScenario(Scenario scenario){
        this.scenario = scenario;
    }

    @After
    public void quitDriver(){
        driver.quit();
    }
    @Given("que estoy en la URL {string}")
    public void queEstoyEnLaURL(String url) {
        driver.get(url);
        screenShot();
    }

    @When("ingreso el E-mail {string}")
    public void ingresoElEMail(String email) {
        initialize();
        loginsteps.ingresaValor("E-mail",
                email,
                LoginLinioPage.emailInput,
                null);
        screenShot();
    }

    @And("tipeo la clave {string}")
    public void tipeoLaClave(String clave) {
        initialize();
        loginsteps.ingresaValor("Clave",
                clave,
                LoginLinioPage.claveInput,
                null);
        screenShot();
    }

    @And("doy clic en iniciar sesión")
    public void doyClicEnIniciarSesión() throws InterruptedException {
        initialize();
        loginsteps.seleccionarYesperar(LoginLinioPage.btnLogin);
        screenShot();
    }

    @Then("valido que el usuario {string} esté logueado")
    public void validoQueElUsuarioEstéLogueado(String name) {
        initialize();
        loginsteps.validarValor(name, LoginLinioPage.headerProfile);
        screenShot();
    }

    @And("selecciono la opcion de Promos y cupones")
    public void seleccionoLaOpcionDePromosYCupones() throws InterruptedException {
        initialize();
        loginsteps.seleccionarYesperar(LoginLinioPage.promoAncore);
        screenShot();
    }

    @When("elijo el producto")
    public void elijoElProducto() throws InterruptedException {
        initialize();
        loginsteps.seleccionarYesperar(LoginLinioPage.laptopAncore);
        screenShot();
    }

    @And("valido que el producto sea {string}")
    public void validoQueElProductoSea(String producto) {
        initialize();
        loginsteps.validarValor(producto, LoginLinioPage.spanText);
        screenShot();
    }

    @Then("agrego al carrito")
    public void agregoAlCarrito() throws InterruptedException {
        initialize();
        loginsteps.seleccionarYesperar(LoginLinioPage.btnAddCar);
        screenShot();
    }

    @And("valido que salga el mensaje {string}")
    public void validoQueSalgaElMensaje(String text) {
        initialize();
        loginsteps.validarValor(text, LoginLinioPage.spanValidation);
        screenShot();
    }

    public void screenShot(){
        byte[] evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(evidencia, "image/png", "evidencias");
    }
    public void initialize(){
        loginsteps = new LoginLinioSteps(driver);
    }

}
