package model.Product;

public class Headphones extends Product {
    public Headphones(int id, String manufacturer, String model, String name, String color, double price, int quantityInStock, TypeProduct typeProduct) {
        super(id, manufacturer, model, name, color, price, quantityInStock, typeProduct);
    }

    @Override
    public void displayProduct() {

    }
}
