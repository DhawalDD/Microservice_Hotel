package com.icwd.user.service.exceptions;

public class ResourceNotFound extends  RuntimeException {

    public ResourceNotFound()
    {
        super("Resource Not Found on Server. ");
    }

    public ResourceNotFound (String message)
    {
        super("message");
    }
}
