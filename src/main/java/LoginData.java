import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class LoginData {
    public String login;
    public String password;
    JSONParser parser = new JSONParser();

    LoginData() {
        try {
            Object obj = parser.parse(new FileReader(
                    "C:\\Users\\Melkish\\IdeaProjects\\Kabinet\\Data-file\\login-pass"));
            JSONObject jsonObject = (JSONObject) obj;
            login = (String) jsonObject.get("Login");
            password = (String) jsonObject.get("Password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
