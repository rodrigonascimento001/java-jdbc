package br.com.mentoria.util;

public class Constants {

    public static final String COM_MYSQL_JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/dbtest?useSSL=false";
    public static final String JDBC_USERNAME = "root";
    public static final String JDBC_PASSWORD = "123@test";

    public static final String INSERT_PRODUCTS_SQL = "insert into products" + "  (name) VALUES  (?);";
    public static final String SELECT_PRODUCTS_BY_ID = "select product_id,name from products where product_id =?";
    public static final String SELECT_ALL_PRODUCTS = "select * from products";
    public static final String DELETE_PRODUCTS_SQL = "delete from products where product_id = ?;";
    public static final String UPDATE_PRODUCTS_SQL = "update products set name = ? where product_id = ?;";

}
