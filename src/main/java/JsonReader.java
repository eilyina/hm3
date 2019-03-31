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
    //System.out.println("jsonTree " + jsonTree);

    JsonObject jsonObject = jsonTree.getAsJsonObject();
    JsonElement results = jsonObject.get("results");
    JsonArray jsonArray = results.getAsJsonArray();


        for (int i = 0; i < jsonArray.size(); i++) {
            JsonElement temp = jsonArray.get(i);
            JsonObject jsonObj = temp.getAsJsonObject();
            JsonElement gender = jsonObj.get("gender");
            JsonElement elementName = jsonObj.get("name");
            JsonElement elementLocation = jsonObj.get("location");
            JsonObject name = elementName.getAsJsonObject();
            JsonObject location = elementLocation.getAsJsonObject();

            Person person = gson.fromJson(name, Person.class);

            person.setGender(gender.toString());
            person.setStreet(location.get("street").toString());
            person.setCity(location.get("city").toString());
            person.setState(location.get("state").toString());
            person.setBirthDayDate();
            person.getIndex();
            person.getAge(person.birthDayDate, LocalDate.now());

            list.add(person);
        }
        return list;
    }
}
