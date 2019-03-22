package PACKAGE1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.util.*;

public class Main {

    public static String[] getListGender(int k)  {
        Random random = new Random();
        String[] out = new String[k];
        String[] values ={"м","ж"};

        for (int i=0;i<k;i++) {
            int idx=random.nextInt(values.length);
            out[i] = values[idx];
        }

        return  out;

    }

    public static String[] getList(int k, String namefile)  {
        try {File file = new File(namefile);
            Scanner scanner = new Scanner(file);
            int i=0;
            String[] listnames =new String[k];
            while((scanner.hasNextLine())&&(i<k))
            {
                listnames[i]= scanner.nextLine();
                i++;

            }
            return listnames;
        }
        catch (Exception e)
        {System.out.println("Ошибка.Файл не найден.");
            return null;}

    }

    public static void main(String[] args) {
        // write your code here
        String pathfile = "C:"+File.separator+"Тест"+File.separator+"Тест.xls";
        int listsize = 1+(int)( Math.random() * 30 );
        String usercount= Integer.toString(listsize);
        String url ="https://randomuser.me/api/?results=X&inc=gender,nat,name,location&noinf";
        String urlresponse = url.replaceAll("X", usercount);
        System.out.println(listsize);
        StringBuffer response = new StringBuffer();
        Gson gson = new GsonBuilder().create();
        List<Person> list = new ArrayList<Person>();
    try {
        URL yahoo = new URL(urlresponse);
    URLConnection yc = yahoo.openConnection();


    BufferedReader in = new BufferedReader(
            new InputStreamReader(
                    yc.getInputStream()));
    String inputLine;


    while ((inputLine = in.readLine()) != null) {
        response.append(inputLine);
    }
    JsonParser parser = new JsonParser();

    JsonElement jsonTree = parser.parse(response.toString());
    System.out.println("jsonTree " + jsonTree);

        JsonObject jsonObject = jsonTree.getAsJsonObject();
        JsonElement results = jsonObject.get("results");
        JsonArray jsonarray = results.getAsJsonArray();


        for (int i = 0; i < jsonarray.size(); i++) {
            JsonElement temp = jsonarray.get(i);
            JsonObject jsonobj = temp.getAsJsonObject();
            JsonElement gender = jsonobj.get("gender");
            JsonElement elementname= jsonobj.get("name");
            JsonElement elementlocation = jsonobj.get("location");
            JsonObject name = elementname.getAsJsonObject();
            JsonObject location = elementlocation.getAsJsonObject();

            Person  johnDoe =  gson.fromJson( name, Person.class);

            johnDoe.setGender(gender.toString());
            johnDoe.setStreet(location.get("street").toString());
            johnDoe.setCity(location.get("city").toString());
            johnDoe.setState(location.get("state").toString());

            list.add(johnDoe);

        }

        System.out.println(list);
    in.close();}
catch (Exception e)
{System.out.println("Не удалось получить доступ к сайту");

String[] lisgender =getListGender(listsize);
    System.out.println(Arrays.toString(lisgender));
    String[] boyname = getList(listsize, "Мужские имена");
    String[] girlname = getList(listsize, "Женские имена");
    String[] boysecondname = getList(listsize, "Мужские фамилии");
    String[] girlssecondname = getList(listsize, "Женские фамилии");
    String[] boymiddlename = getList(listsize, "Мужские отчества");
    String[] girlsmiddlename = getList(listsize, "Женские Отчества");
    String[] country = getList(listsize, "Страны");
    String[] city = getList(listsize, "Города");
    String[] state = getList(listsize, "Область");
    String[] street = getList(listsize, "Улицы");

    int m=0;
    int s=0;
    for (int i = 0; i < lisgender.length; i++)
    {
        Person  johnDoe2 =new Person();
        if (lisgender[i].equals("м"))

        {
            assert boyname != null;
            johnDoe2.setFirst(boyname[i]);
            johnDoe2.setLast(boysecondname[i]);
            johnDoe2.setTitle(boymiddlename[i]);

            m++;
        } else {
            assert girlname != null;
            johnDoe2.setFirst(girlname[i]);
            johnDoe2.setLast(girlssecondname[i]);
            johnDoe2.setTitle(girlsmiddlename[i]);
            s++;
        }
        johnDoe2.setCountry(country[i]);
        johnDoe2.setState(state[i]);
        johnDoe2.setCity(city[i]);
        johnDoe2.setStreet(street[i]);

        list.add(johnDoe2);
    }


}

File1 myf = new File1();
myf.setFile(list,pathfile);


    }
    }



