package util;

import org.openqa.selenium.Cookie;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CookieManager {
    private static final String fileName = "/Users/dariasupriadkina/IdeaProjects/TPO-Lab-3/src/test/resources/cookies.json";
    JSONParser parser = new JSONParser();
    public List<Cookie> readCookies() {
        List<Cookie> cookies = new ArrayList<Cookie>();
        try {
            JSONArray arr = (JSONArray) parser.parse(new FileReader(fileName));
            for (Object o : arr) {
                JSONObject jo = (JSONObject) o;
                Cookie cookie = new Cookie((String) jo.get("name"), (String) jo.get("value"));
                cookies.add(cookie);
//                System.out.println(cookie.getName() + " " + cookie.getValue());
            }

        } catch (IOException | ParseException e){
            e.printStackTrace();
            return null;
        }
        return cookies;
    }
}
