package com.example.ekyc.util;

import java.util.UUID;

public class ConstantUtil {
    public static String getUUID(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}

