package model.Product;

import model.Warehouse.Location;

public class Headphones extends Product {
    public Headphones(int id, String manufacturer, String model, String name, String color, double price, int quantityInStock, TypeProduct typeProduct, Location location) {
        super(id, manufacturer, model, name, color, price, quantityInStock, TypeProduct.HEADPHONES, location);
    }

    @Override
    public void displayProduct() {
    }
}
