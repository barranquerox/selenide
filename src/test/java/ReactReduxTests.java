import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

import api.ApiUtils;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.HomePage;

public class ReactReduxTests {

  @BeforeMethod
  public void setup() {
    // comment next line to run in your own chrome
    //Configuration.remote = "http://localhost:4444/wd/hub";
    Configuration.browser = "chrome";
    Configuration.browserSize = "1920x1080";
    // comment next line to run in your own chrome and see the browser
    Configuration.headless = true;
    open("https://react-redux.realworld.io");

    // Clear local storage, sometimes the token is not cleared and the test fails
    LocalStorage local = ((WebStorage) WebDriverRunner.getWebDriver()).getLocalStorage();
    local.clear();
    WebDriverRunner.getWebDriver().navigate().refresh();
  }

  @Test
  public void signIn() {
    final String email = "luiscarlosgarelli+test@gmail.com";
    final String password = "toto";
    HomePage homePage = new HomePage();

    homePage.openLoginPage()
        .login(email, password)
        .userImage()
        .shouldBe(visible);
  }

  @Test
  public void addNewPost() {
    final String email = "luiscarlosgarelli+test@gmail.com";
    final String password = "toto";
    final String articleTitle = "Title test";
    final String articleWhatItsAbout = "It is about Ledger";
    final String articleMarkdown = "Markdown description";
    final String articleTags = "Tag1 Tag2";

    ApiUtils.loginWithAPI(email, password);
    HomePage homePage = new HomePage();

    homePage.createPost()
        .enterTitle(articleTitle)
        .enterArticleInMarkdown(articleMarkdown)
        .enterWhatItsAbout(articleWhatItsAbout)
        .enterTags(articleTags)
        .saveArticle()
        .userImage()
        .shouldBe(visible);
    // The article is not saved, so I don't know what assertion to do, need to discuss with PO or solve bug
  }

  @Test
  public void addToFavorites() {
    final String email = "luiscarlosgarelli+test@gmail.com";
    final String password = "toto";

    ApiUtils.loginWithAPI(email, password);
    HomePage homePage = new HomePage();

    homePage.openGlobalFeed()
        .setArticleAsFavorite(0)
        .setArticleAsFavorite(1);
    // The favorite is not really saved, I don't know what assertion to do, need to discuss with PO or solve bug
  }
}
