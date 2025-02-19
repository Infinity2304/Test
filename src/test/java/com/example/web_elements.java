package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class web_elements {

    private final WebDriver driver;
    private final WebDriverWait wait;


    // CONSTRUCTOR
    public web_elements(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    
    //Login page 
    // Login button
    WebElement Main_Login_button(){
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("login-btn")));
    }


    //Login page back arrow
    WebElement login_page_back_arrow(){
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("back-btn")));
    }

    //Login page email toggle icon
    WebElement email_toggle(){
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("email-tab-btn")));
    }
    
    //Login page phone toggle icon
    WebElement phone_toggle(){
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("phone-tab-btn")));
    }

    // Login page email field
    WebElement email_field(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email-field")));
    }

    // Login page password field
    WebElement password_field(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password-field")));
    }
    
    //Login page password show eye button
    WebElement show_pass(){
        return wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#show-password-icon")));
    }
    
    //Login page password hide eye button
    WebElement hide_pass(){
        return wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#hide-password-icon")));
    }

    //Login page forget password link
    WebElement forget_password(){
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("forgot-password-btn")));
    }

    // Login page continue button
    WebElement continue_btn(){
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("continue-btn")));
    }
    
    //Login with Facebook
    WebElement Login_facebook(){
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("fb-login-btn")));
    }
    
    //Login with Google
    WebElement Login_Google(){
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("google-login-btn")));
    }
    
    //Signup option
    WebElement SignUp(){
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("signup-btn")));
    }

    // Login page email field err_text
    WebElement email_field_err_text(){
        return driver.findElement(By.id("email-field-helper-text"));
    }

    // Login page pass field err_text
    WebElement password_field_err_text(){
        return driver.findElement(By.id("password-field-helper-text"));
    }

    //Login page general error
    WebElement Login_general_err(){
        return driver.findElement(By.id("login-error"));
    }
    
    
    //Signup page
    //Signup pagae phone field
    WebElement Signup_phone_field(){
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("phone-number-field")));
    }
    
    //Signup page term checkbox
    WebElement Signup_term_check(){
        return driver.findElement(By.id("terms-checkbox"));
        // return wait.until(ExpectedConditions.elementToBeClickable(By.id("terms-checkbox")));
    }

    //Signup page continue button
    WebElement Signup_continue_btn(){
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("continue-btn")));
    }
    
    //Signup page verify button
    WebElement Signup_verify_btn(){
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("verify-btn")));
    }
    
}
