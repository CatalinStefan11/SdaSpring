package ro.sda.spring._1_;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonProcessor {

    public static void main(String[] args) {

        System.out.println(userToJson(new User("Leo Messi", 37)));

        System.out.println("----------------------------------------");

        List<User> users = new ArrayList<>();
        users.add(new User("Cristiano", 39));
        users.add(new User("Neymar", 33));
        users.add(new User("Leo Messi", 37));

        System.out.println(userArrayToJson(users));
    }

    private static JSONObject userToJson(User u) {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("_name", u.getName());
        jsonObject.put("_age", u.getAge());

        return jsonObject;
    }

    private static JSONArray userArrayToJson(List<User> list) {
        JSONArray jsonArray = new JSONArray();

        for(User u : list) {
            jsonArray.put(new JSONObject(u));
        }

        return jsonArray;
    }
}
