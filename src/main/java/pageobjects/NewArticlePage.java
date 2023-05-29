package pageobjects;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import org.openqa.selenium.By;

public class NewArticlePage {

  By textBoxSelector = By.cssSelector("input.form-control");

  public NewArticlePage enterTitle(String title) {
    $$(textBoxSelector).get(0).setValue(title);
    return this;
  }

  public NewArticlePage enterWhatItsAbout(String whatItsAbout) {
    $$(textBoxSelector).get(1).setValue(whatItsAbout);
    return this;
  }

  public NewArticlePage enterTags(String tags) {
    $$(textBoxSelector).get(2).setValue(tags);
    return this;
  }

  public NewArticlePage enterArticleInMarkdown(String articleInMarkdown) {
    $(By.cssSelector("textarea.form-control")).setValue(articleInMarkdown);
    return this;
  }

  public HomePage saveArticle() {
    $(By.cssSelector(".btn-primary")).click();
    return new HomePage();
  }
}
