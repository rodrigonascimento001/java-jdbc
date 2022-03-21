package br.com.mentoria.service;

import br.com.mentoria.dao.DaoImpl;
import br.com.mentoria.error.CustomDaoException;
import br.com.mentoria.model.Product;

import java.util.List;
import java.util.Optional;

public class ProductService {

    DaoImpl dao = new DaoImpl();

    public void getConnection(){
        dao.getConnection();
    }

    public void create(Product product){
          dao.create(product);
    }

    public Product findById(long id){
        return Optional.ofNullable(dao.findById(id)).orElseThrow(()-> new CustomDaoException("Resource not found"));
    }

    public boolean delete(long id){
        return dao.delete(id);
    }

    public boolean update(long id, Product product){
        return dao.update(id,product);
    }

    public List<Product> findAll(){
        return dao.findAll();
    }
}
