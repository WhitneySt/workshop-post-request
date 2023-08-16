package com.example.postRequest;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorService {

    private boolean validarCSV(Map<String, Object> line) {
        try {
            String email = line.get("email").toString();
            String jobTitle = line.get("jobTitle").toString();
            String dateOfBirth = line.get("dateOfBirth").toString();

            // validating email
            Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
            Matcher mather = pattern.matcher(email);

            if (!mather.find()) {
                return false;
            }

            // validating job title
            List<String> validProfessions = Arrays.asList("Haematologist", "Phytotherapist", "Building surveyor", "Insurance account manager", "Educational psychologist");
            boolean isValidProfession = validProfessions.stream().anyMatch(profession -> jobTitle.contains(profession));
            if(!isValidProfession) {
                return false;
            }

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = formatter.parse(dateOfBirth);
            Date fixedDate = formatter.parse("1980-01-01");

            if(date.before(fixedDate)) {
                return false;
            }

            return true;
        }catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    private boolean validarExcel(Map<String, Object> line) {
        String injuryLocation = line.get("injuryLocation").toString();
        String reportType = line.get("reportType").toString();

        if(injuryLocation.equalsIgnoreCase("N/A")) {
            return false;
        }
        List<String> validReportTypes = Arrays.asList("Near Miss", "Lost Time", "First Aid");
        boolean isValidReportType = validReportTypes.stream().anyMatch(validReportType -> validReportType.equalsIgnoreCase(reportType));
        if(!isValidReportType) {
            return false;
        }

        return true;
    }
    public boolean validar(Object line) {
        ObjectMapper oMapper = new ObjectMapper();
        Map<String, Object> content = oMapper.convertValue(line, Map.class);

        String tipoArchivo = content.get("tipo").toString();
        switch (tipoArchivo) {
            case "csv":
                return validarCSV(content);
            case "excel":
                return validarExcel(content);
            default:
                return false;
        }
    }
}
