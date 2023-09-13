package com.example.ekyc.DTO;

public class OcrResponseDTO {
    // A private variable to hold the English text extracted from OCR

    private String name;
    private String dob;
    private String nid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid)  {
        this.nid = nid;
    }

}
