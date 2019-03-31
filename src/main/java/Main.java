
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.Console;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.time.LocalDate;
import java.util.*;

public class Main {




    public static void main(String[] args) {
        // write your code here
        String pathfile = "C:"+File.separator+"Тест"+File.separator+"Тест.xls";
        int listsize = 1+(int)( Math.random() * 30 );
        String usercount= Integer.toString(listsize);
        String url ="https://randomuser.me/api/?results=X&inc=gender,nat,name,location&noinf";
        String urlResponse = url.replaceAll("X", usercount);
        System.out.println(listsize);
      //  StringBuilder response = new StringBuilder();
      //  Gson gson = new GsonBuilder().create();
        List<Person> list = new ArrayList<Person>();

          URLConnectionReader K1 = new URLConnectionReader();

          K1.getPersonList(urlResponse,listsize,list);



File1 myf = new File1();
myf.setFile(list,pathfile);


    }
    }



