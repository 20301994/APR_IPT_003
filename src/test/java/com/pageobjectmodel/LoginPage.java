package com.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_Class;
import com.interfaceelements.LoginPageInterfaceElements;
import com.pageobjectmanager.PageObjectManager;

public class LoginPage extends Base_Class implements LoginPageInterfaceElements {

        @FindBy(xpath = login_xpath) 
         private WebElement login;
        
        @FindBy(id = username_id)
         private WebElement username;
         
        @FindBy(css = password_css)
         private WebElement password;
        
        @FindBy(xpath = signin_xpath)
        private WebElement signin;
        
        @FindBy(id = title_id)
        private WebElement title;

       public LoginPage() {
    	   PageFactory.initElements(driver, this);
    	   
       }

    public void validLogInPage()   {
    	clickOnElement(login);
    	passInput(username ,PageObjectManager.getPageObjectManager().getFileREader().getDataPeoperty("username"));
    	passInput(password,PageObjectManager.getPageObjectManager().getFileREader().getDataPeoperty("password"));
    	clickOnElement(signin);
  
    
    
    
    }












}
