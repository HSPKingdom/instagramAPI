package com.hackathon.instagram.module;


import com.hackathon.instagram.module.Post.Elements.Image.Image;
import com.hackathon.instagram.module.Post.Elements.Image.ImagePack;
import com.hackathon.instagram.module.Post.Elements.Image.ImageType;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Scanner;

public class InstaAPI {
    private static final String CLIENT_ID = "62d5b23a3c0d4cf8b183e0d71931d39e";
    private static final String CLIENT_SECRET = "788970229fd34e5abe9d0f53f1c33665";
    private static final String GRANT_TYPE = "authorization_code";
    private static final String REDIRECT_URL = "https://127.0.0.1:8080/foldername";
    private String authorizationCode = "";
    private String accessToken;

    public InstaAPI()
    {

    }

    public void showUserStory(){

    }

    public String getToken(String accessCode){

        try {
            ProcessBuilder ps = new ProcessBuilder("curl", "-F" , "client_id="+CLIENT_ID,"-F", "client_secret="+CLIENT_SECRET,"-F",
                    "grant_type="+GRANT_TYPE,"-F" ,"redirect_uri="+REDIRECT_URL,"-F",
                    "code="+accessCode,"https://api.instagram.com/oauth/access_token");
            Process pr = ps.start();
            pr.waitFor();
            BufferedReader reader2 = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            String result = reader2.readLine();
            System.out.println(result);
            JSONObject myObject = new JSONObject(result);
            System.out.println(myObject.getString("access_token"));
            System.out.println(myObject.getString("user"));
            return myObject.getString("access_token");


        }
        catch(Exception e){
            System.out.println("========ERROR===========" + e.getMessage());
            return null;
        }
    }


    /**
     * Get the correct Access Token
     * @throws Exception
     */
    public void checkAccessToken()throws Exception{
        JSONObject responseJSON;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        do {

            System.out.println("Enter Authorization Code: ");
            accessToken = reader.readLine();
            HttpGet httpRequest = new HttpGet("https://api.instagram.com/v1/users/self/media/recent/?access_token=" + accessToken);

            HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
            String responseInfo = EntityUtils.toString(httpResponse.getEntity());
            System.out.println(responseInfo);
            responseJSON = new JSONObject(responseInfo);

            if(!responseJSON.has("data")){
                System.out.println("Error Code");
            }
        }while(!responseJSON.has("data"));

    }
    public void saveResponse()throws Exception{
        JSONArray postList;
        JSONObject object;
        HttpGet httpRequest = new HttpGet("https://api.instagram.com/v1/users/self/media/recent/?access_token=" + accessToken);

        HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
        String responseInfo = EntityUtils.toString(httpResponse.getEntity());
        JSONObject responseJSON = new JSONObject(responseInfo);
        postList = (JSONArray) responseJSON.get("data");

        for(int i = 0 ; i< postList.length(); i++){
            JSONObject individual = postList.getJSONObject(i);

            ImagePack imagePack = new ImagePack();
            System.out.println(individual.getJSONObject("images").getJSONObject("thumbnail").toString());
            int width = individual.getJSONObject("images").getJSONObject("thumbnail").getInt("width");
            int height = individual.getJSONObject("images").getJSONObject("thumbnail").getInt("height");
            String url = individual.getJSONObject("image").getJSONObject("thumbnail").getString("url");
            System.out.println(width+height+url);
            imagePack.setThumbnail(new Image(url, width, height, ImageType.THUMBNAIL));

            width = individual.getJSONObject("images").getJSONObject("low_resolution").getInt("width");
            height = individual.getJSONObject("images").getJSONObject("low_resolution").getInt("height");
            url = individual.getJSONObject("image").getJSONObject("low_resolution").getString("url");
            System.out.println(width+height+url);
            imagePack.setLowResolution(new Image(url, width, height, ImageType.LOW_RESOLUTION));

            width = individual.getJSONObject("images").getJSONObject("standard_resolution").getInt("width");
            height = individual.getJSONObject("images").getJSONObject("standard_resolution").getInt("height");
            url = individual.getJSONObject("image").getJSONObject("standard_resolution").getString("url");
            System.out.println(width+height+url);
            imagePack.setStandardResolution(new Image(url, width, height, ImageType.STANDARD_RESOLUTION));



        }

    }
    public void tokenResponse(String accessToken)throws Exception{
        JSONArray postList = new JSONArray();
        JSONObject temp = new JSONObject();

        HttpGet httpRequest = new HttpGet("https://api.instagram.com/v1/users/self/media/recent/?access_token=" + accessToken);

        HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
        String responseInfo = EntityUtils.toString(httpResponse.getEntity());
        JSONObject responseJSON = new JSONObject(responseInfo);
        //temp = (JSONObject)responseJSON.get("data");
        postList = (JSONArray) responseJSON.get("data");

        System.out.println(postList);
        for(int i = 0; i< postList.length(); i++){
            JSONObject individual = postList.getJSONObject(i);
            System.out.println("=====================================");
            System.out.println("ImageURL: " + individual.getString("images") + "\nCreated Time: " + individual.getString("created_time")+ "\nCaption: " +
            individual.getString("caption") + "\nUser has Liked: " + individual.getString("user_has_liked") + "\nLikes: " + individual.getString("likes")
            + "\nTags: " + individual.getString("tags") + "\nFilter: " + individual.getString("filter") + "\nComments: " + individual.getString("comments")
            + "\nTypes: " + individual.getString("type") + "\nLink: " + individual.getString("link") + "\nLocation: " + individual.getString("location") +
            "\nAttribution " + individual.getString("attribution") + "\nUser in photo: " + individual.getString("users_in_photo"));
        }
    }

}