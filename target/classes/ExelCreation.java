public class ExelCreation {


    // создание самого excel файла в памяти
    HSSFWorkbook workbook = new HSSFWorkbook();
    // создание листа с названием "Просто лист"
    HSSFSheet sheet = workbook.createSheet("Просто лист");

    // заполняем список какими-то данными
    List<DataModel> dataList = fillData();

    // счетчик для строк
    int rowNum = 0;

    // создаем подписи к столбцам (это будет первая строчка в листе Excel файла)
    Row row = sheet.createRow(rowNum);

   // Row row = sheet.createRow(0);
    Cell name14 = row.createCell(0);




        Cell c1 = createCell(1).setCellValue("Фамилия");
    setCellValue("Имя");
        row.createCell(1).setCellValue("Фамилия");
        row.createCell(2).setCellValue("Город");
        row.createCell(3).setCellValue("Зарплата");

    // заполняем лист данными
        for (DataModel dataModel : dataList) {
        createSheetHeader(sheet, ++rowNum, dataModel);
    }

    // записываем созданный в памяти Excel документ в файл
        try (FileOutputStream out = new FileOutputStream(new File("F:\\Apache POI Excel File.xls"))) {
        workbook.write(out);
    } catch (IOException e) {
        e.printStackTrace();
    }
        System.out.println("Excel файл успешно создан!");
}

    // заполнение строки (rowNum) определенного листа (sheet)
    // данными  из dataModel созданного в памяти Excel файла
    private static void createSheetHeader(HSSFSheet sheet, int rowNum, DataModel dataModel) {
        Row row = sheet.createRow(rowNum);

        row.createCell(0).setCellValue(dataModel.getName());
        row.createCell(1).setCellValue(dataModel.getSurname());
        row.createCell(2).setCellValue(dataModel.getCity());
        row.createCell(3).setCellValue(dataModel.getSalary());
    }

    // заполняем список рандомными данными
    // в реальных приложениях данные будут из БД или интернета
    private static List<DataModel> fillData() {
        List<DataModel> dataModels = new ArrayList<>();
        dataModels.add(new DataModel("Howard", "Wolowitz", "Massachusetts", 90000.0));
        dataModels.add(new DataModel("Leonard", "Hofstadter", "Massachusetts", 95000.0));
        dataModels.add(new DataModel("Sheldon", "Cooper", "Massachusetts", 120000.0));

        return dataModels;
    }

}
