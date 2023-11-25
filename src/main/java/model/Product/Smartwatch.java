package model.Product;

import model.Warehouse.Location;

public class Smartwatch extends Product {
    public Smartwatch(int id, String manufacturer, String model, String name, String color, double price, int quantityInStock, TypeProduct typeProduct, Location location) {
        super(id, manufacturer, model, name, color, price, quantityInStock, TypeProduct.SMARTWATCH, location);
    }

    @Override
    public void displayProduct() {

    }
}
