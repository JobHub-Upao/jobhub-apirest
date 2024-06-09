package com.jobhub.jobhubapi.exception;

public class DuplicateCandidatoException extends RuntimeException{

    public DuplicateCandidatoException(){

    }

    public DuplicateCandidatoException(String message){
        super(message);
    }

}