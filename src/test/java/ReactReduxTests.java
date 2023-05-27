import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReactReduxTests {


  @BeforeMethod
  public void setup() {
    Configuration.browserSize = "1920x1080";
    open("https://react-redux.realworld.io");
  }

  @Test
  public void signIn() {
    $(By.cssSelector("[href='#login']")).click();
    $(By.cssSelector("[type='email']")).setValue("luiscarlosgarelli+test@gmail.com");
    $(By.cssSelector("[type='password']")).setValue("toto");
    $(By.cssSelector("[type='submit']")).click();
    $(By.cssSelector(".user-pic")).shouldBe(visible);
  }

  @Test
  public void addNewPost() {

  }

  @Test
  public void addToFavorites() {

  }

}
