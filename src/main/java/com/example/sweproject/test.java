package com.example.sweproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.LinkedList;

public class test {
    public static void main(String[] args) throws Exception{
      Admin admin= new Admin("mfer");
      Games game= new Games("foot");
      LinkedList<Team> teams= new LinkedList<>();
      LinkedList<User> membs= new LinkedList<>();
      membs.add(new User("idiot"));
      teams.add(new Team(membs,"gitgud"));
      admin.createtournment(teams, game, "elim", "ass");
      Tournament[] tournaments= new Tournament[10];
      System.out.println(tournaments[0]==null);
        String String= "https://us-central1-swe206-221.cloudfunctions.net/app/UserSignIn?username=9215&password=6199";
        URL url = (new URI(String)).toURL();
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET"); // specify the request type
        con.setConnectTimeout(5000);
        int status= con.getResponseCode();
        try(BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));){
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
        content.append(inputLine);
        }
        System.out.println(content.toString());
        String[] temp= content.toString().split(",");
        for(int x=0;x<temp.length;x++){
          System.out.println(x+temp[x]);
        }
        System.out.println(temp[1].substring(1,temp[1].length()-1)+" "+temp[0].substring(9,temp[0].length()));
      }
      catch(IOException e){
        System.out.println("File couldnt be read bruv");
      }
      System.out.println(status);
    }
}