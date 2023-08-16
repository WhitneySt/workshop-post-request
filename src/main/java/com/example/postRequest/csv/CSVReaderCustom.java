package com.example.postRequest.csv;

import com.example.postRequest.FileLines;
import com.example.postRequest.IFileReader;
import com.example.postRequest.ProcessorFile;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileReader;
import java.util.Arrays;

public class CSVReaderCustom implements IFileReader<CSVContent> {
    private final char SEPARATOR=',';
    private final char QUOTE='"';
    @Override
    public FileLines<CSVContent> readFile(ProcessorFile processorFile) {
        FileLines<CSVContent> fileLines = new FileLines<>();
        String ruta = processorFile.getRutaArchivo();

        CSVReader reader = null;
        try {
            reader = new CSVReaderBuilder(new FileReader(ruta))
                    .withCSVParser(new CSVParserBuilder()
                            .withQuoteChar(QUOTE)
                            .withSeparator(SEPARATOR)
                            .build())
                    .build();

            String[] fields = null;
            while ((fields = reader.readNext()) != null) {
                //System.out.println(Arrays.toString(nextLine));
                CSVContent csvContent = new CSVContent(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5], fields[6], fields[7], fields[8], false);
                fileLines.crearLinea(csvContent);
            }
            fileLines.borrarCabeceras();
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            if (null != reader) {
                reader.close();
            }
        } catch (Exception e){
            System.out.println(e);
        }

        return fileLines;
    }
}
