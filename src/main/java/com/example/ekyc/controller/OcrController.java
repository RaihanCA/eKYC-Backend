package com.example.ekyc.controller;

import com.example.ekyc.DTO.OcrResponseDTO;
import com.example.ekyc.service.OcrService;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController // This annotation is used to define a controller
@RequestMapping(value = "/api")
public class OcrController {

    private final OcrService ocrService;

    @Autowired // This annotation is used to automatically inject objects
    public OcrController(OcrService ocrService) {
        this.ocrService = ocrService; // Assigns the injected ocrService to the local ocrService
    }

    @PostMapping("/nid") // This annotation maps HTTP POST requests onto the performOcr method
    public OcrResponseDTO performOcr(@RequestParam MultipartFile image) throws Exception {
        try {
            // Invokes the performOcr method of ocrService with the given image
           //return ocrService.performOcr(image);
            return ocrService.performOcr(image);
        } catch (IOException e) {
            // If an IOException occurs, it's thrown as a RuntimeException
            throw new RuntimeException(e);
        }
    }
}
