import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

import api.ApiUtils;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.HomePage;

public class ReactReduxTests {

  @BeforeMethod
  public void setup() {
    Configuration.browserSize = "1920x1080";
    open("https://react-redux.realworld.io");
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
