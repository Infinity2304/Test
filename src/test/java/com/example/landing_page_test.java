package com.example;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class landing_page_test {

    @Test
    public void login_test(){
        WebDriver driver = new ChromeDriver();

        web_elements elements = new web_elements(driver);
        FormHandler handler = new FormHandler(driver);

        driver.get("https://test.logiqids.com/");
        driver.manage().window().maximize();


        //Test_id 02
        System.out.println("Test 01 Started !");
        elements.Main_Login_button().click();
    
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
            System.out.println("All elements are present");
            
        } catch (NoSuchElementException e) {
            System.out.println("Element is Missing");
        }

        System.out.println("Test 01 Ended !");


        //Test_id 05(Login with email) invalid email valid pass
        System.out.println("Test 02 Started !");

        String expected_error_02 = "Email is not associated with any Account";
        
        try {
            handler.clear_field(elements.email_field(),elements.password_field());
            handler.login_form_filler("Sunnyyy@gmail.com", "123456");
            elements.show_pass().click();
            System.out.println("Entered email  "+elements.email_field().getAttribute("value"));
            System.out.println("Entered Password  "+elements.password_field().getAttribute("value"));
            elements.hide_pass().click();
            elements.continue_btn().click();
            String actual_error_02 = elements.Login_general_err().getText();

            assertEquals(expected_error_02, actual_error_02); //Test

        } catch (NoSuchElementException e) {
            System.out.println("Element is not clickable");
        }

        System.out.println("Test 02 Ended !");
        
        //Test_id 06(Login with email) valid email invalid pass
        System.out.println("Test 03 Started !");

        String expected_error_03 = "email: Enter a valid email address.";

        try {
            handler.clear_field(elements.email_field(),elements.password_field());
            handler.login_form_filler("@@@@@gmail.com", "123456");
            elements.show_pass().click();
            System.out.println("Entered email  "+elements.email_field().getAttribute("value"));
            System.out.println("Entered Password  "+elements.password_field().getAttribute("value"));
            elements.hide_pass().click();
            elements.continue_btn().click();
            String actual_error_03 = elements.Login_general_err().getText();

            assertEquals(expected_error_03, actual_error_03); //Test
            
        } catch (NoSuchElementException e) {
            System.out.println("Element is not clickable");
        }

        System.out.println("Test 03 Ended !");
        
        //Test_id 07(Login with email) valid email wrong pass
        System.out.println("Test 04 Started !");

        String expected_error_04 = "The password is incorrect";

        try {
            handler.clear_field(elements.email_field(),elements.password_field());
            handler.login_form_filler("vedantnarkar29@gmail.com", "1234567890");
            elements.show_pass().click();
            System.out.println("Entered email  "+elements.email_field().getAttribute("value"));
            System.out.println("Entered Password  "+elements.password_field().getAttribute("value"));
            elements.hide_pass().click();
            elements.continue_btn().click();
            String actual_error_04 = elements.Login_general_err().getText();

            assertEquals(expected_error_04, actual_error_04); //Test
            
        } catch (NoSuchElementException e) {
            System.out.println("Element is not clickable");
        }

        System.out.println("Test 04 Ended !");
        
        //Test_id 08(Login with email) valid email wrong pass
        System.out.println("Test 05 Started !");

        String expected_error_05 = "password: Ensure this field has at least 6 characters.";

        try {
            handler.clear_field(elements.email_field(),elements.password_field());
            handler.login_form_filler("vedantnarkar29@gmail.com", "12345");
            elements.show_pass().click();
            System.out.println("Entered email  "+elements.email_field().getAttribute("value"));
            System.out.println("Entered Password  "+elements.password_field().getAttribute("value"));
            elements.hide_pass().click();
            elements.continue_btn().click();
            String actual_error_05 = elements.Login_general_err().getText();

            assertEquals(expected_error_05, actual_error_05); //Test
            
        } catch (NoSuchElementException e) {
            System.out.println("Element is not clickable");
        }

        System.out.println("Test 05 Ended !");

        //Test_id 09(Login with email) valid email wrong pass
        System.out.println("Test 06 Started !");

        String expected_err_06 = "This field is compulsory!";

        try {
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
            
        } catch (NoSuchElementException e) {
            System.out.println("Element is not clickable");
        }

        System.out.println("Test 06 Ended !");

        driver.quit();
    }
}
