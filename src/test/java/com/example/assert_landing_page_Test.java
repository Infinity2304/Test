package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.NoSuchElementException;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class assert_landing_page_Test {

    WebDriver driver = new ChromeDriver();

    web_elements elements = new web_elements(driver);
    FormHandler handler = new FormHandler(driver);

    
    @Test
    public void test01(){
        driver.get("https://test.logiqids.com/login");
        driver.manage().window().minimize();

        try {
            elements.login_page_back_arrow();
            elements.email_toggle();
            elements.phone_toggle();
            elements.email_field();
            elements.password_field();
            elements.forget_password();
            elements.continue_btn();
            elements.Login_facebook();
            elements.Login_Google();
            elements.SignUp();
            assertTrue(true);
            
        } catch (NoSuchElementException e) {
            fail("Element "+e+" is not present");
        }finally{
            driver.quit();
        }
    }

    @Test
    public void test02(){
        driver.get("https://test.logiqids.com/login");
        driver.manage().window().minimize();

        String expected_error_02 = "Email is not associated with any Account";

        handler.clear_field(elements.email_field(),elements.password_field());
        handler.login_form_filler("Sunnyyy@gmail.com", "123456");
        elements.show_pass().click();
        System.out.println("Entered email  "+elements.email_field().getAttribute("value"));
        System.out.println("Entered Password  "+elements.password_field().getAttribute("value"));
        elements.hide_pass().click(); 
        elements.continue_btn().click();

        String actual_error_02 = elements.Login_general_err().getText();

        assertEquals(expected_error_02, actual_error_02); //Test

        driver.quit();
    }

    @Test
    public void test03(){
        driver.get("https://test.logiqids.com/login");
        driver.manage().window().minimize();

        String expected_error_03 = "email: Enter a valid email address.";

        handler.clear_field(elements.email_field(),elements.password_field());
        handler.login_form_filler("@@@@@gmail.com", "123456");
        elements.show_pass().click();
        System.out.println("Entered email  "+elements.email_field().getAttribute("value"));
        System.out.println("Entered Password  "+elements.password_field().getAttribute("value"));
        elements.hide_pass().click();
        elements.continue_btn().click();

        String actual_error_03 = elements.Login_general_err().getText();

        assertEquals(expected_error_03, actual_error_03); //Test

        driver.quit();
    }

    @Test
    public void test04(){
        driver.get("https://test.logiqids.com/login");
        driver.manage().window().minimize();

        String expected_error_04 = "The password is incorrect";

        handler.clear_field(elements.email_field(),elements.password_field());
        handler.login_form_filler("vedantnarkar29@gmail.com", "1234567890");
        elements.show_pass().click();
        System.out.println("Entered email  "+elements.email_field().getAttribute("value"));
        System.out.println("Entered Password  "+elements.password_field().getAttribute("value"));
        elements.hide_pass().click();
        elements.continue_btn().click();
        String actual_error_04 = elements.Login_general_err().getText();

        assertEquals(expected_error_04, actual_error_04); //Test
        driver.quit();
    }

    @Test
    public void test05(){
        driver.get("https://test.logiqids.com/login");
        driver.manage().window().minimize();

        String expected_error_05 = "password: Ensure this field has at least 6 characters.";

        handler.clear_field(elements.email_field(),elements.password_field());
        handler.login_form_filler("vedantnarkar29@gmail.com", "12345");
        elements.show_pass().click();
        System.out.println("Entered email  "+elements.email_field().getAttribute("value"));
        System.out.println("Entered Password  "+elements.password_field().getAttribute("value"));
        elements.hide_pass().click();
        elements.continue_btn().click();
        String actual_error_05 = elements.Login_general_err().getText();

        assertEquals(expected_error_05, actual_error_05); //Test

        driver.quit();
    }

    @Test
    public void test06(){
        driver.get("https://test.logiqids.com/login");
        driver.manage().window().minimize();

        String expected_err_06 = "This field is compulsory!";

        handler.clear_field(elements.email_field(),elements.password_field());
        handler.login_form_filler("", "");
        elements.show_pass().click();
        System.out.println("Entered email  "+elements.email_field().getAttribute("value"));
        System.out.println("Entered Password  "+elements.password_field().getAttribute("value"));
        elements.hide_pass().click();
        elements.continue_btn().click();
        String actual_email_error_06 = elements.email_field_err_text().getText();
        String actual_pass_error_06 = elements.password_field_err_text().getText();

        assertEquals(expected_err_06, actual_email_error_06); //Test
        assertEquals(expected_err_06, actual_pass_error_06); //Test

        driver.quit();
    }
}
