package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.NoSuchElementException;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class assert_signup_page_Test {

    WebDriver driver = new ChromeDriver();

    web_elements elements = new web_elements(driver);
    FormHandler handler = new FormHandler(driver);

    @Test
    public void test01(){
        driver.get("https://test.logiqids.com/sign-up");
        driver.manage().window().maximize();

        handler.signup_form_filler("1936284026");
        

    }



    
}

