import java.io.File;
import java.io.FileNotFoundException;
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

    public static StringBuilder getList(int listSize, String nameFile)  {
        StringBuilder listNames =new StringBuilder();
        try {
            File file = new File(nameFile);
            Scanner scanner = new Scanner(file);
            int i=0;

            while((scanner.hasNextLine())&&(i<listSize))
            {
                listNames.append(scanner.nextLine()+"\n");

                i++;

            }
        } catch (FileNotFoundException e) {
          //  e.printStackTrace();
            System.out.println("Ошибка!Файл "+nameFile+" не найден");
        }
        return listNames;

    }

    public static String getStrFromFile( int count, StringBuilder stringBuilder1)  {
        int lineCounter=0;
        Scanner scanner = new Scanner(stringBuilder1.toString());
        while (lineCounter!=count)

        {
            scanner.nextLine();
            lineCounter++;}
        return scanner.nextLine();

    }

    public void  setListsfromFile(int listSize) {
        boyName = getList(listSize, "src/main/resources/Мужские имена");
        girlName= getList(listSize, "src/main/resources/Женские имена");
        boySecondName = getList(listSize, "src/main/resources/Мужские фамилии");
        girlsSecondName = getList(listSize, "src/main/resources/Женские фамилии");
        boyMiddleName = getList(listSize, "src/main/resources/Мужские отчества");
        girlsMiddleName = getList(listSize, "src/main/resources/Женские Отчества");
        country = getList(listSize, "src/main/resources/Страны");
        city = getList(listSize, "src/main/resources/Города");
        state = getList(listSize, "src/main/resources/Область");
        street = getList(listSize, "src/main/resources/Улицы");

    }

    public List<Person> getPersonListFromFile(int listSize, List<Person> list){
        int maleLineCounter=0;
        int femaleLineCounter=0;

        for (int i = 0; i < listSize; i++)
        {
            Person  person =new Person();
            person.getGenderRandom();
            if (person.gender.equals("м"))
            {
                person.setFirst(getStrFromFile(maleLineCounter,boyName));
                person.setLast(getStrFromFile(maleLineCounter,boySecondName));
                person.setTitle(getStrFromFile(maleLineCounter,boyMiddleName));
                maleLineCounter++;
            }

            if (person.gender.equals("ж"))
            {
                person.setFirst(getStrFromFile(femaleLineCounter,girlName));
                person.setLast(getStrFromFile(femaleLineCounter,girlsSecondName));
                person.setTitle(getStrFromFile(femaleLineCounter,girlsMiddleName));
                femaleLineCounter++;
            }

            person.setBirthDayDate();
            person.getAge(  person.birthDayDate, LocalDate.now());
            person.getIndex();
            person.setCountry(getStrFromFile(i,country));
            person.setState(getStrFromFile(i,state));
            person.setCity(getStrFromFile(i,city));
            person.setStreet(getStrFromFile(i,street));

            list.add(person);
        }
        return list;

    }
}
