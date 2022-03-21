package br.com.mentoria.error;

import java.sql.SQLException;

public class ErrorUtil {

    public static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    public static void printException(Exception e){
        System.err.println("Cause: "+e.getCause());
        System.err.println("Message: "+e.getMessage());
    }
}
