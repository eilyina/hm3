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

public class File1 {

  //  List<Person> list;

    public void  setFile(  List<Person> list,String pathfile) {
        HSSFWorkbook workbook = new HSSFWorkbook();

        HSSFSheet sheet = workbook.createSheet("Просто лист");
        int rowNum = 0;
        Row row = sheet.createRow(rowNum);

        row.createCell(0).setCellValue("Имя");
        row.createCell(1).setCellValue("Фамилия");
        row.createCell(2).setCellValue("Отчество");
        row.createCell(3).setCellValue("Возраст");
        row.createCell(4).setCellValue("Пол");
        row.createCell(5).setCellValue("Дата рождения");
        row.createCell(6).setCellValue("ИНН");
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

            row.createCell(3).setCellValue(emp.age);
            row.createCell(8).setCellValue(emp.country);
            row.createCell(9).setCellValue(emp.state);
            row.createCell(10).setCellValue(emp.city);
            row.createCell(11).setCellValue(emp.street);

        }
        try {

            FileOutputStream fileOut = new FileOutputStream(new File(pathfile));
            workbook.write(fileOut);
            fileOut.close();
            System.out.println("Файл создан.Путь "+pathfile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //  catch (Exception e)
        //{System.out.println("Ошибка при создании файла.Файл не создан.");}
}
}
