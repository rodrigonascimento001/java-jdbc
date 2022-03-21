package br.com.mentoria.dao;

import br.com.mentoria.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static br.com.mentoria.error.ErrorUtil.printException;
import static br.com.mentoria.error.ErrorUtil.printSQLException;
import static br.com.mentoria.util.Constants.*;

public class DaoImpl implements Dao<Product>{

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(COM_MYSQL_JDBC_DRIVER);
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            printException(e);
        }
        return connection;
    }

    @Override
    public void create(Product obj) {
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(INSERT_PRODUCTS_SQL)) {
            statement.setString(1, obj.getName());
            System.out.println(statement);
            statement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public boolean update(long id, Product obj) {
        boolean rowUpdated = false;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCTS_SQL);) {
            statement.setString(1, obj.getName());
            statement.setLong(2, id);

            System.out.println(statement);
            rowUpdated = statement.executeUpdate() > 0;
        }catch (SQLException e) {
            printSQLException(e);
        }
        return rowUpdated;
    }

    @Override
    public boolean delete(long id) {
        boolean rowDeleted = false;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCTS_SQL)) {
            statement.setLong(1, id);

            System.out.println(statement);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        }
        return rowDeleted;
    }

    @Override
    public Product findById(long id) {
        Product product = null;
        try(Connection connection = getConnection();PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCTS_BY_ID)){
            preparedStatement.setLong(1, id);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                product = new Product(id, name);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return  product;
    }

    @Override
    public List<Product> findAll() {
        List <Product> users = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS)) {
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                long id = rs.getLong("product_id");
                String name = rs.getString("name");
                users.add(new Product(id, name));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }
}
