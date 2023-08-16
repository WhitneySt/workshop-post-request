package com.example.postRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("api/v1/validator")
public class ValidatorFilesController {
    ValidatorService service = new ValidatorService();
    @PostMapping()
    public boolean validar(@RequestBody Object line){
        return this.service.validar(line);
    }
}
