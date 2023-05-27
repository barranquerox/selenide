package pageobjects;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import org.openqa.selenium.By;

public class NewArticlePage {
  public NewArticlePage enterTitle(String title) {
    $$(By.cssSelector("input.form-control")).get(0).setValue(title);
    return this;
  }

  public NewArticlePage enterWhatItsAbout(String whatItsAbout) {
    $$(By.cssSelector("input.form-control")).get(1).setValue(whatItsAbout);
    return this;
  }

  public NewArticlePage enterTags(String tags) {
    $$(By.cssSelector("input.form-control")).get(2).setValue(tags);
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
