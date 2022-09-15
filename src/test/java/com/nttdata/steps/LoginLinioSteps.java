package com.nttdata.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class LoginLinioSteps {

    private WebDriver driver;

    //constructor
    public LoginLinioSteps(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Seleccionar y hacer clic en un elemento
     * @param findElement Elemento a seleccionar
     */
    public void seleccionarYesperar(By findElement) throws InterruptedException {
        WebElement userButtonElement = driver.findElement(findElement);
        userButtonElement.click();
        Thread.sleep(10000);
    }

    /**
     * Ingresar un valor
     * @param nameValor Nombre del Valor
     * @param valor el valor a ingresar
     * @param findElement Elemento a buscar
     * @param waitElement Elemento de espera
     */
    public void ingresaValor(String nameValor, String valor, By findElement, By waitElement){
        initValue(nameValor,valor,findElement,waitElement);
    }
    public void validarValor(String valor, By findElement){
        WebElement userInputElement = driver.findElement(findElement);
        userInputElement.getText().equalsIgnoreCase(valor);
    }


    /********************* METODOS DE AYUDA *********************/

    /**
     * Elemento de espera
     * @param element el elemento de espera
     */
    private void waiting(By element){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    private void setValue(String value, By findElement){
        WebElement userInputElement = driver.findElement(findElement);
        userInputElement.sendKeys(value);
    }

    private void initValue(String nameValue, String value, By findElement, By waitElement){
        System.out.println(nameValue + ": " + value);
        setValue(value, findElement);
        if(waitElement != null){
            waiting(waitElement);
        }
    }
}
