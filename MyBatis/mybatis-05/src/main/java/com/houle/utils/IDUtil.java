package com.houle.utils;

import java.util.UUID;

public class IDUtil {
    public static String genId(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

}
