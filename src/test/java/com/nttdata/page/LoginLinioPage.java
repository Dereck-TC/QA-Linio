package com.nttdata.page;

import org.openqa.selenium.By;

public class LoginLinioPage {

    //Localizadores de elementos
    public static By emailInput = By.id("login_form_email");
    public static By claveInput = By.id("login_form_password");
    public static By btnLogin = By.xpath("/html/body/div[1]/main/div/div/div[2]/div[1]/form/button");
    public static By btnAddCar = By.id("buy-now");
    public static By headerProfile = By.id("header-profile-user-name");
    public static By promoAncore = By.xpath("/html/body/div[3]/main/div[1]/div[1]/div[1]/a[4]");
    public static By laptopAncore = By.xpath("//*[@id=\"catalogue-product-container\"]/div[2]/a[1]");
    public static By spanText = By.xpath("/html/body/div[3]/main/div[1]/div[2]/div[3]/div[1]/h1/span");
    public static By spanValidation = By.xpath("//*[@id=\"alert-add-to-cart\"]/div/div/div[1]/div/h2[1]");
}
