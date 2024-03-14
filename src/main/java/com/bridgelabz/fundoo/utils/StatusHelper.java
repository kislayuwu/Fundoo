package com.bridgelabz.fundoo.utils;

import com.bridgelabz.fundoo.response.Response;

public class StatusHelper {
    public static Response statusInfo(String message, int code)
    {
        Response response = new Response();
        response.setMessage(message);
        response.setCode(code);
        return response;

    }


}