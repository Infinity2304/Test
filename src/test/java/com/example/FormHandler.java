package com.example;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.lang.Thread;
import java.util.List;

import org.openqa.selenium.interactions.Actions;

public class FormHandler {

    private final web_elements elements;
    private final Actions action;
    private final utils utils;

    public FormHandler(WebDriver driver) {
        this.elements = new web_elements(driver); 
        this.action = new Actions(driver);
        this.utils = new utils();
    }

    // Enters login email and pass fields and click continue button
    public void login_form_filler(String email, String password) {
        elements.email_field().sendKeys(email); 
        elements.password_field().sendKeys(password);
    }

    //enters signup phone number field
    public void signup_form_filler(String phone){
        elements.Signup_phone_field().sendKeys(phone);
        elements.Signup_term_check().click();
        elements.Signup_continue_btn().click();
        otp();
        elements.Signup_verify_btn().click();
    }

    public void child_details_filler(String child, String city, String school){
        elements.Signup_child_name().sendKeys(child);
        System.out.println("child done");
        elements.Signup_city_name().sendKeys(city);
        System.out.println("city done");
        elements.Signup_title().click();
        elements.Signup_school_name().click();
        System.out.println("school click done");
        elements.Signup_school_name().sendKeys(school);
        System.out.println("school done");
        elements.Signup_grade().click();
        elements.Signup_grade().click();
        List<WebElement> grade = elements.signup_grade_list();
        grade.get(5).click();
        System.out.println("grade select done");
        elements.continue_btn().click();
    }

    //Can be used for clearing input field 
    public void clear_field(WebElement field){
        field.sendKeys(Keys.CONTROL, "a", Keys.DELETE); 
    }

    public void otp(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        for(int i=0; i<4 ;i++){
            action.sendKeys("1").perform();
        }
    }

    //Ideally used for clearing email and pass fields
    public void clear_field(WebElement email_field, WebElement pass_field){
        email_field.sendKeys(Keys.CONTROL, "a", Keys.DELETE); 
        pass_field.sendKeys(Keys.CONTROL, "a", Keys.DELETE); 
    }
}