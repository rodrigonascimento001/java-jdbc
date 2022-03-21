package br.com.mentoria;

import br.com.mentoria.model.Product;
import br.com.mentoria.service.ProductService;

public class Main {
    public static void main(String[] args) {
        ProductService service = new ProductService();

        Product product = new Product("Notebook Dell");
        service.create(product);

        Product searchProduct = service.findById(3);

        System.out.println(searchProduct);

        service.delete(1);

        Product p2 = service.findById(2);

        p2.setName("name updated");

        service.update(2,p2);

        Product pUpdated = service.findById(2);
        System.out.println(pUpdated);


        System.out.println("Listar todos");
        service.findAll().forEach(System.out::println);


    }
}
