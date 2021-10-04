package ru.gb.antonov.j75.dtos.errorhandlers;

public class ResourceNotFoundException extends RuntimeException
{
    public ResourceNotFoundException (String messageText) { super (messageText); }
}
