package com.example.ekyc.service;

import com.example.ekyc.DTO.OcrResponseDTO;
import net.sourceforge.tess4j.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service // This annotation is used to declare this class as a Service class
public class OcrService {

    public OcrResponseDTO performOcr(MultipartFile image) throws TesseractException, IOException {
        // Convert MultipartFile to BufferedImage
        BufferedImage ipimage = ImageIO.read(image.getInputStream());

        // Get RGB value of the center pixel of the image
        double d = ipimage.getRGB(ipimage.getTileWidth() / 2, ipimage.getTileHeight() / 2);

        BufferedImage fopimage;
        // Depending on the RGB value, process the image
        if (d >= -1.4211511E7 && d < -7254228) {
            fopimage = processImg(ipimage, 3f, -10f);
        } else if (d >= -7254228 && d < -2171170) {
            fopimage = processImg(ipimage, 1.455f, -47f);
        } else if (d >= -2171170 && d < -1907998) {
            fopimage = processImg(ipimage, 1.35f, -10f);
        } else if (d >= -1907998 && d < -257) {
            fopimage = processImg(ipimage, 1.19f, 0.5f);
        } else if (d >= -257 && d < -1) {
            fopimage = processImg(ipimage, 1f, 0.5f);
        } else {
            fopimage = processImg(ipimage, 1f, 0.35f);
        }

        // Extract English text from the processed image
        String englishText = enTextExtract(fopimage);
        // Split the englishText into three parts: Name, Date of Birth, and ID NO
        String[] splitText = englishText.split("\n");

        // Each part is now a separate string
        String name = splitText[0]; // "Name: DABASHIS KUNDU SHENTO"
        String dob = splitText[1]; // "Date of Birth: 03Jul1999"
        String idNo = splitText[2]; // "ID NO: 5103985445"

        // Split each string again at ": " to get the actual values
//        String actualName = name.split(": ")[1]; // "DABASHIS KUNDU SHENTO"
//        String actualDob = dob.split(": ")[1]; // "03Jul1999"
//        String actualIdNo = idNo.split(": ")[1]; // "5103985445"

        // Create a new OcrResponseDTO, set the extracted text to it and return
        OcrResponseDTO response = new OcrResponseDTO();

        response.setName(name);
        response.setDob(dob);
        response.setIdNo(idNo);


        return response;
    }

    public String enTextExtract(BufferedImage fopimage) throws TesseractException {
        // Create a new Tesseract instance
        Tesseract it1 = new Tesseract();
        // Set the datapath and language
        it1.setDatapath("D:/Tessaract/Tess4J-3.4.8-src/Tess4J/tessdata");
        it1.setLanguage("eng");

        // Perform OCR on the image and get the result as a string
        String str1 = it1.doOCR(fopimage);

        // Define regex patterns for name, date of birth, and ID
        String namePattern = "Name:\\s*(\\w+\\s+\\w+\\s+\\w+)";
        String dobPattern = "Date of Birth:\\s*(\\d{2}.*\\d{4}$)";
        String idPattern = "ID NO:\\s*(\\d+)";

        // Compile the regex patterns
        Pattern nameRegex = Pattern.compile(namePattern);
        Pattern dobRegex = Pattern.compile(dobPattern);
        Pattern idRegex = Pattern.compile(idPattern);

        String name = "";
        String dob = "";
        String id = "";

        // Split the OCR result into lines
        String[] lines1 = str1.split("\\n");

        // For each line, match the regex patterns and extract the data
        for (String line : lines1) {
            Matcher nameMatcher = nameRegex.matcher(line);
            Matcher dobMatcher = dobRegex.matcher(line);
            Matcher idMatcher = idRegex.matcher(line);

            if (nameMatcher.find()) {
                name = nameMatcher.group(1);
            }

            if (dobMatcher.find()) {
                dob = dobMatcher.group(1);
            }

            if (idMatcher.find()) {
                id = idMatcher.group(1);
            }
        }

        // Return the extracted data as a formatted string
        return "Name: " + name + "\nDate of Birth: " + dob + "\nID NO: " + id;

    }

    private BufferedImage processImg(BufferedImage ipimage, float scaleFactor, float offset) {
        // Create a new BufferedImage with specific size and type
        BufferedImage opimage = new BufferedImage(1050, 1024, ipimage.getType());

        // Create a Graphics2D object from the BufferedImage and draw the image
        Graphics2D graphic = opimage.createGraphics();
        graphic.drawImage(ipimage, 0, 0, 1050, 1024,null);
        graphic.dispose();

        RescaleOp rescale = new RescaleOp(scaleFactor, offset, null);

        return rescale.filter(opimage, null);
    }
}
