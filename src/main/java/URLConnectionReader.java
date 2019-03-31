import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class URLConnectionReader {

    StringBuilder response = new StringBuilder();

    public List<Person> getPersonList (String urlResponse,int listSize,List<Person> list){
     try

    {
        URL url = new URL(urlResponse);
        URLConnection urlConnection = url.openConnection();


        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        urlConnection.getInputStream()));
        String inputLine;


        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);

        }
        in.close();
        JsonReader json = new JsonReader();
        json.getPersonListFromJson(response.toString(), list);
        //  System.out.println(list);
    }
     catch(
             Exception e)

     {
         System.out.println("Не удалось получить доступ "+urlResponse);

         DataFromFile dataFromFile = new DataFromFile();
         dataFromFile.setListsfromFile(listSize);
         dataFromFile.getPersonListFromFile(listSize, list);


     }

     return list;
}}
