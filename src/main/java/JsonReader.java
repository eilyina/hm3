import com.google.gson.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JsonReader {


public List<Person> getPersonListFromJson(String response, List<Person> list)
{
    JsonParser parser = new JsonParser();
    Gson gson = new GsonBuilder().create();
    JsonElement jsonTree = parser.parse(response);
    System.out.println("jsonTree " + jsonTree);

    JsonObject jsonObject = jsonTree.getAsJsonObject();
    JsonElement results = jsonObject.get("results");
    JsonArray jsonarray = results.getAsJsonArray();


        for (int i = 0; i < jsonarray.size(); i++) {
            JsonElement temp = jsonarray.get(i);
            JsonObject jsonobj = temp.getAsJsonObject();
            JsonElement gender = jsonobj.get("gender");
            JsonElement elementname = jsonobj.get("name");
            JsonElement elementlocation = jsonobj.get("location");
            JsonObject name = elementname.getAsJsonObject();
            JsonObject location = elementlocation.getAsJsonObject();

            Person johnDoe = gson.fromJson(name, Person.class);

            johnDoe.setGender(gender.toString());
            johnDoe.setStreet(location.get("street").toString());
            johnDoe.setCity(location.get("city").toString());
            johnDoe.setState(location.get("state").toString());
            johnDoe.setBirthDayDate();
            johnDoe.getAge(johnDoe.birthDayDate, LocalDate.now());

            list.add(johnDoe);
        }
        return list;
    }
}
