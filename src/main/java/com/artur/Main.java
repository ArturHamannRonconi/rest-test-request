package com.artur;

import java.util.UUID;

public class Main 
{
    public static void main( String[] args )
    {
        var app = new App();
        var uuid = UUID.randomUUID();

        var responseGET = app.get("http://localhost:8080/user/" + uuid);
        
        var userData = "{\"id\":\""+ uuid +"\", \"email\":\"user@mail.com\", \"password\":\"123456\"}";
        var responsePOST = app.post("http://localhost:8080/user", userData);

        System.out.println(responseGET.body());
        System.out.println(responsePOST.body());
    }
}
