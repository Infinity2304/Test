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
    utils util = new utils();

    @Test //To test the signup functionality of non partner school
    public void test01(){
        driver.get("https://test.logiqids.com/sign-up");
        driver.manage().window().maximize();

        //Fills the signup details (phone number)
        handler.signup_form_filler(util.random_num_generator(1000000000L, 9999999999L));
        
        handler.child_details_filler("Test","Test","IES Orion School, Dadar");

        String expected_msg = "10 FREE WORKSHEETS";
        String actual_msg = elements.free_worksheet().getText();
        
        assertEquals(expected_msg, actual_msg);

        driver.quit();

    }
}

