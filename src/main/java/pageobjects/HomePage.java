package pageobjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HomePage {
  public LoginPage openLoginPage() {
    $(By.cssSelector("[href='#login']")).click();
    return new LoginPage();
  }

  public SelenideElement userImage() {
    return $(By.cssSelector(".user-pic"));
  }

  public NewArticlePage createPost() {
    $(By.cssSelector("[href='#editor']")).click();
    return new NewArticlePage();
  }

  public HomePage openGlobalFeed() {
    $(By.cssSelector(".nav-pills li+li")).click();
    return this;
  }

  public HomePage setArticleAsFavorite(int index) {
    $$(By.cssSelector(".btn-sm")).get(index).click();
    return this;
  }
}
