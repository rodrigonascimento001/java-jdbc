package br.com.mentoria.dao;

import br.com.mentoria.model.Product;

import java.sql.Connection;
import java.util.List;

public interface  Dao<T> {
    Connection getConnection();


    void create(T obj);
    boolean update(long id,T obj);
    boolean delete(long id);
    T findById(long id);
    List<T> findAll();
}
