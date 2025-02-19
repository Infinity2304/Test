package com.example;

import java.util.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class main_test {
    public static void main(String[] args) throws InterruptedException{
        
        WebDriver driver = new ChromeDriver();

        web_elements elements = new web_elements(driver);
        FormHandler form_handler = new FormHandler(driver);

        driver.get("https://test.logiqids.com/login");
        driver.manage().window().maximize();



        form_handler.login_form_filler("vedantnarkar29@gmail.com",""); // Fills the email and pass fields
        try{
            String pass_error_text =  elements.password_field_err_text().getText();
            System.out.println("PASSWORD FIELD ERROR TEXT "+pass_error_text);
        }catch(NoSuchElementException e){
            System.out.println("Element not found");
        }
        form_handler.clear_field(elements.email_field(), elements.password_field()); // Clears the email and pass fields
        

        form_handler.login_form_filler("","Vedant@8454");
        try{
            String email_error_text = elements.email_field_err_text().getText();
            System.out.println("EMAIL FIELD ERROR TEXT "+email_error_text);

        }catch(NoSuchElementException e){
            System.out.println("Element not found");
        }
        form_handler.clear_field(elements.email_field(), elements.password_field());

        form_handler.login_form_filler("vedantnarkar29@gmail.com","Vedant@8454"); // Enters the Valid credentials


        
        driver.quit();

    }
}
