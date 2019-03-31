import java.io.File;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class DataFromFile {
    StringBuilder boyName;
    StringBuilder girlName;
    StringBuilder boySecondName ;
    StringBuilder girlsSecondName;
    StringBuilder boyMiddleName ;
    StringBuilder girlsMiddleName ;
    StringBuilder country;
    StringBuilder city ;
    StringBuilder state ;
    StringBuilder street;

    public static StringBuilder getList(int k, String namefile)  {
        try {
            File file = new File(namefile);
            Scanner scanner = new Scanner(file);
            int i=0;
            //String[] listnames =new String[k];
            StringBuilder listnames =new StringBuilder();
            while((scanner.hasNextLine())&&(i<k))
            {
                listnames.append(scanner.nextLine()+"\n");

                i++;

            }
            return listnames;
        }
        catch (Exception e)
        {System.out.println("Ошибка.Файл не найден.");
            return null;}

    }
    public static String getStrFromFile( int count, StringBuilder stringBuilder1)  {
        int d=0;
        Scanner scanner = new Scanner(stringBuilder1.toString());
        while (d!=count)

        {
            scanner.nextLine();
            d++;}
        return scanner.nextLine();

    }

    public void  setListsfromFile(int listsize) {

         boyName = getList(listsize, "src/main/resources/Мужские имена");
        girlName= getList(listsize, "src/main/resources/Женские имена");
        boySecondName = getList(listsize, "src/main/resources/Мужские фамилии");
        girlsSecondName = getList(listsize, "src/main/resources/Женские фамилии");
         boyMiddleName = getList(listsize, "src/main/resources/Мужские отчества");
         girlsMiddleName = getList(listsize, "src/main/resources/Женские Отчества");
         country = getList(listsize, "src/main/resources/Страны");
       city = getList(listsize, "src/main/resources/Города");
       state = getList(listsize, "src/main/resources/Область");
       street = getList(listsize, "src/main/resources/Улицы");

    }

    public List<Person> getPersonListFromFile(int listsize, List<Person> list){
        int m=0;
        int s=0;

        for (int i = 0; i < listsize; i++)
        {
            Person  johnDoe2 =new Person();
            johnDoe2.getGenderRandom();
            if (johnDoe2.gender.equals("м"))

            {
                johnDoe2.setFirst(getStrFromFile(m,boyName));
                johnDoe2.setLast(getStrFromFile(m,boySecondName));
                johnDoe2.setTitle(getStrFromFile(m,boyMiddleName));
                m++;
            } else {

                johnDoe2.setFirst(getStrFromFile(s,girlName));
                johnDoe2.setLast(getStrFromFile(s,girlsSecondName));
                johnDoe2.setTitle(getStrFromFile(s,girlsMiddleName));
                s++;
            }

            //johnDoe2.setGender(lisgender[i]);
            johnDoe2.setBirthDayDate();


            johnDoe2.getAge(  johnDoe2.birthDayDate, LocalDate.now());
            johnDoe2.setCountry(getStrFromFile(i,country));
            johnDoe2.setState(getStrFromFile(i,state));
            johnDoe2.setCity(getStrFromFile(i,city));
            johnDoe2.setStreet(getStrFromFile(i,street));

            list.add(johnDoe2);
        }
        return list;

    }
}
