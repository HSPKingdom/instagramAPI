package com.hackathon.instagram.module;


import java.io.*;

public class main {


    public static void main(String[] args) throws Exception{
        //PropertyConfigurator.configure("src/main/java/com/nsettle/config/log4j.properties");
        String authorizationCode = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InstaAPI API = new InstaAPI();



        System.out.println("1. Enter Access Code\n 2. Enter Access Token\n");
        switch(Integer.parseInt(reader.readLine())) {
            case 1:
                System.out.println("Enter Access Code: ");
                String accessCode = reader.readLine();
                authorizationCode = API.getToken(accessCode);
                API.tokenResponse(authorizationCode);
                break;

            case 2:
                /*System.out.println("Enter Authorization Code: ");
                authorizationCode = reader.readLine();
                API.tokenResponse(authorizationCode);
                break;*/
                API.checkAccessToken();
                API.saveResponse();
                break;
            default:
                System.out.println("Wrong instruction!!!");
                break;

        }





    }

}
