package api;

import com.codeborne.selenide.WebDriverRunner;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;

public class ApiUtils {

  public static final MediaType JSON = MediaType.get("application/json");

  final static OkHttpClient client = new OkHttpClient();
  final static String baseURL = "https://api.realworld.io/api/users/";

  static public void loginWithAPI(String email, String password) {

    // Create a JSON object for the user's credentials
    String userJsonString = String.format("{\"user\":{\"email\":\"%s\",\"password\":\"%s\"}}", email, password);

    // Create a RequestBody object from the JSON String
    RequestBody body = RequestBody.create(userJsonString, JSON);

    // Create an HTTP request object for the login API
    Request request = new Request.Builder()
        .url(baseURL + "login")
        .post(body)
        .build();

    try (Response response = client.newCall(request).execute()) { // Execute the request and get the response
      assert response.body() != null;
      JSONObject responseJson = new JSONObject(response.body().string());

      // Extract the token from the JSON response
      String token = responseJson.getJSONObject("user").getString("token");

      // Access local storage of the web browser and store the token
      LocalStorage local = ((WebStorage) WebDriverRunner.getWebDriver()).getLocalStorage();
      local.setItem("jwt", token);

      WebDriverRunner.getWebDriver().navigate().refresh();

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}
