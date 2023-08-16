package com.example.postRequest;

import com.example.postRequest.csv.CSVContent;
import com.example.postRequest.csv.CSVReaderCustom;
import com.example.postRequest.excel.ExcelContent;
import com.example.postRequest.excel.ExcelReader;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class ProcessorService {
    public final String validatorUrl = "http://localhost:8080/api/v1/validator";

    private Boolean validarLinea(Object content, String tipoArchivo, RestService restService) {
        // object -> Map
        ObjectMapper oMapper = new ObjectMapper();
        Map<String, Object> params = oMapper.convertValue(content, Map.class);
        params.put("tipo", tipoArchivo);

        Object validatedLine = restService.createPost(validatorUrl, params);
        return Boolean.parseBoolean(validatedLine.toString());
    }
    public FileLines leerArchivo(ProcessorFile processorFile, RestService restService){
        String tipoArchivo = processorFile.getTipo().toLowerCase();
        switch (tipoArchivo) {
            case "csv":
                FileLines<CSVContent> csvContentFileLines = new CSVReaderCustom().readFile(processorFile);
                for (CSVContent content : csvContentFileLines.getLines()) {
                    Boolean isValidLine = validarLinea(content, tipoArchivo, restService);
                    content.setValidLine(isValidLine);
                }
                return csvContentFileLines;
            case "excel":
                FileLines<ExcelContent> excelContentFileLines = new ExcelReader().readFile(processorFile);
                for (ExcelContent content : excelContentFileLines.getLines()) {
                    Boolean isValidLine = validarLinea(content, tipoArchivo, restService);
                    content.setValidLine(isValidLine);
                }
                return excelContentFileLines;
            default:
                return null;
        }
    }
}
