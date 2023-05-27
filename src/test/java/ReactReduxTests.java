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
    $(By.cssSelector("[href='#login']")).click();
    $(By.cssSelector("[type='email']")).setValue("luiscarlosgarelli+test@gmail.com");
    $(By.cssSelector("[type='password']")).setValue("toto");
    $(By.cssSelector("[type='submit']")).click();
    $(By.cssSelector("[href='#editor']")).click();
    $$(By.cssSelector("input.form-control")).get(0).setValue("Test Title");
    $$(By.cssSelector("input.form-control")).get(1).setValue("This article is about Ledger");
    $$(By.cssSelector("input.form-control")).get(2).setValue("selenide ledger luis");
    $(By.cssSelector("textarea.form-control")).setValue("Test Description Article bla bla bla");
    $(By.cssSelector(".btn-primary")).click();
  }

  @Test
  public void addToFavorites() {
    $(By.cssSelector("[href='#login']")).click();
    $(By.cssSelector("[type='email']")).setValue("luiscarlosgarelli+test@gmail.com");
    $(By.cssSelector("[type='password']")).setValue("toto");
    $(By.cssSelector("[type='submit']")).click();
    $(By.cssSelector(".nav-pills li+li")).click();
    $(By.cssSelector(".btn-sm")).click();
  }

}
