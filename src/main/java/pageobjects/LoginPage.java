package pageobjects;

import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

public class LoginPage {
  public HomePage login(String email, String password) {
    $(By.cssSelector("[type='email']")).setValue(email);
    $(By.cssSelector("[type='password']")).setValue(password);
    $(By.cssSelector("[type='submit']")).click();
    return new HomePage();
  }


}
