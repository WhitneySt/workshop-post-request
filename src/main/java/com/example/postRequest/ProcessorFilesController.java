package com.example.postRequest;

import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("api/v1/processor")
public class ProcessorFilesController {
    private RestService restService;

    public ProcessorFilesController(RestService restService){
        this.restService = restService;
    }

    ProcessorService service = new ProcessorService();
    @PostMapping()
    public FileLines leerArchivo(@RequestBody ProcessorFile processorFile){
        return this.service.leerArchivo(processorFile, this.restService);
    }
}
