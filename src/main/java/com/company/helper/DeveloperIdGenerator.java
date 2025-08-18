package com.company.helper;

import com.company.entity.Developer;

public class DeveloperIdGenerator {

    public static String generateDeveloperId(Developer developer){
        String fName = developer.getFName();
        String lName = developer.getLName();
        int YOB = developer.getYearofbirth();

        char a = lName.charAt(0);

        int b = YOB % 100;

        String developerId = a + fName + b;

        System.err.println("DeveloperID is"+ developerId);
        return developerId;

    }
}
