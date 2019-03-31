import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class URLConnectionReader {

    StringBuilder response = new StringBuilder();
    public List<Person> getPersonList (String urlresponse,int listsize,List<Person> list){
     try

    {
        URL yahoo = new URL(urlresponse);
        URLConnection yc = yahoo.openConnection();


        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        yc.getInputStream()));
        String inputLine;


        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);

        }
        in.close();
        JsonReader jsonq = new JsonReader();
        jsonq.getPersonListFromJson(response.toString(), list);
        //  System.out.println(list);
    }
catch(
    Exception e)

    {
        System.out.println("Не удалось получить доступ к сайту");

        DataFromFile Spi = new DataFromFile();
        Spi.setListsfromFile(listsize);
        Spi.getPersonListFromFile(listsize, list);


    }

     return list;
}}
