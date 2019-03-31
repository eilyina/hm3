import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ExelWriter {



    public void  setFile(  List<Person> list,String pathFile) {
        HSSFWorkbook workBook = new HSSFWorkbook();

        HSSFSheet sheet = workBook.createSheet("Просто лист");
        int rowNum = 0;
        Row row = sheet.createRow(rowNum);

        row.createCell(0).setCellValue("\u0418\u043c\u044f");
        row.createCell(1).setCellValue("Фамилия");
        row.createCell(2).setCellValue("Отчество");
        row.createCell(3).setCellValue("Возраст");
        row.createCell(4).setCellValue("Пол");
        row.createCell(5).setCellValue("Дата рождения");
        row.createCell(6).setCellValue("\u0418\u041d\u041d");
        row.createCell(7).setCellValue("Почтовый индекс");
        row.createCell(8).setCellValue("Страна/область");
        row.createCell(9).setCellValue("Область");
        row.createCell(10).setCellValue("Город");
        row.createCell(11).setCellValue("Улица");
        row.createCell(12).setCellValue("Дом");
        row.createCell(13).setCellValue("Квартира");

        for (Person emp : list) {
            rowNum++;
            row = sheet.createRow(rowNum);


            row.createCell(0).setCellValue(emp.first);
            row.createCell(1).setCellValue(emp.last);
            row.createCell(2).setCellValue(emp.title);
            row.createCell(4).setCellValue(emp.gender);
            row.createCell(5).setCellValue(emp.birthDayDate.toString());
            row.createCell(7).setCellValue(emp.index);
            row.createCell(3).setCellValue(emp.age);
            row.createCell(8).setCellValue(emp.country);
            row.createCell(9).setCellValue(emp.state);
            row.createCell(10).setCellValue(emp.city);
            row.createCell(11).setCellValue(emp.street);

        }

        try {

            FileOutputStream fileOut = new FileOutputStream(new File(pathFile));
            workBook.write(fileOut);
            fileOut.close();
            System.out.println("Файл создан.Путь "+pathFile);
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка!Путь "+pathFile+" не найден или файл занят другим процессом!");
            //e.printStackTrace();
        } catch (IOException e) {

            System.out.println("Ошибка при вводе/выводе данных из файла!");
           //e.printStackTrace();
        }

}

    public static void main(String[] args) {

        String pathFile = "C:"+File.separator+"Тест"+File.separator+"Тест.xls";
        int listSize = 1+(int)( Math.random() * 30 );
        String userCount= Integer.toString(listSize);
        String url ="https://randomuser.me/api/?results=X&inc=gender,nat,name,location&noinf";
        String urlResponse = url.replaceAll("X", userCount);
       // System.out.println(listSize);

        List<Person> list = new ArrayList<Person>();

        URLConnectionReader urlConnection = new URLConnectionReader();

        urlConnection.getPersonList(urlResponse,listSize,list);



        ExelWriter exelFile = new ExelWriter();
        exelFile.setFile(list,pathFile);


    }

}
