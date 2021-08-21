package com.artur;

public class Main 
{
    public static void main( String[] args )
    {
        var app = new App();
        
        var responseGET = app.get("http://localhost:3000/api/v1/get");
        var bodyJson = "{ \"response\": " + responseGET.body() + ", \"response2\": \"Hello World Part 2!\" }";
        
        var responsePOST = app.post("http://localhost:3000/api/v1/post/body", bodyJson);

        System.out.println(responseGET.body());
        System.out.println(responsePOST.body());
    }
}
