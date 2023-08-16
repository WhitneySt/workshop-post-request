package com.example.postRequest.excel;

import com.example.postRequest.FileLines;
import com.example.postRequest.IFileReader;
import com.example.postRequest.ProcessorFile;
import com.github.wnameless.workbookaccessor.WorkbookReader;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ExcelReader implements IFileReader<ExcelContent> {

    private String getDayOfWeek(int dayOfWeek){
        switch (dayOfWeek) {
            case 1:
                return "Sun";
            case 2:
                return "Mon";
            case 3:
                return "Tue";
            case 4:
                return "Wed";
            case 5:
                return "Thu";
            case 6:
                return "Fri";
            case 7:
                return "Sat";
            default:
                return "";
        }
    }

    @Override
    public FileLines<ExcelContent> readFile(ProcessorFile processorFile) {
        FileLines<ExcelContent> fileLines = new FileLines<>();
        WorkbookReader reader = WorkbookReader.open(processorFile.getRutaArchivo());
        for(List<String> fields : reader.toLists()) {
            // Print all the rows in workbook
            try {
                String sDate = fields.get(0);
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yy");
                Date date = formatter.parse(sDate);

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);

                // extract day of the week, month and year from the date
                String dayOfWeek = getDayOfWeek(calendar.get(Calendar.DAY_OF_WEEK));
                int month = (calendar.get(Calendar.MONTH) + 1);
                int year = calendar.get(Calendar.YEAR);

                ExcelContent excelContent = new ExcelContent(fields.get(0), fields.get(1), fields.get(2), fields.get(3), fields.get(4), Double.parseDouble(fields.get(5)), fields.get(6), fields.get(7), fields.get(8), fields.get(9), fields.get(10), dayOfWeek, month,year, false);
                fileLines.crearLinea(excelContent);
            }catch (Exception e) {
                System.out.println(e);
            }
        }

        return fileLines;
    }
}
