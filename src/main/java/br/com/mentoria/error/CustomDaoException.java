package br.com.mentoria.error;

public class CustomDaoException extends RuntimeException{
    public CustomDaoException(String message) {
        super(message);
    }
}
