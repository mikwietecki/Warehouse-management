package model.Warehouse;

import model.Product.Product;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    private List<Product> products;

    public Warehouse() {
        this.products = new ArrayList<>();
    }

    //Funkcja przyjmowania towaru
    public void receiveProduct(Product product, int quantity, Location location) {
        Product existingProduct = findProduct(product.getId());
        if (existingProduct != null) {
            existingProduct.updateQuantity(quantity);
        } else {
            product.setQuantityInStock(quantity);
            product.setLocation(location);
            products.add(product);
        }
    }

    //Funkcja wydawania towaru
    public void issueProduct(Product product, int quantity) {
        Product existingProduct = findProduct(product.getId());
        if (existingProduct != null && existingProduct.getQuantityInStock() >= quantity) {
            existingProduct.updateQuantity(-quantity);
            if (existingProduct.getQuantityInStock() == 0) {
                handleZeroQuantity(existingProduct);
            }
        } else {
            System.out.println("Nie wystarczająca ilość produktu do wydania.");
        }
    }

    //Funkcja aktualizacji stanu
    public void updateProduct(Product product, int newQuantity) {
        Product existingProduct = findProduct(product.getId());
        if (existingProduct != null) {
            existingProduct.setQuantityInStock(newQuantity);
            if (newQuantity == 0) {
                handleZeroQuantity(existingProduct);
            }
        } else {
            System.out.println("Produkt nie istnieje w magazynie");
        }
    }

    //Funkcja zmiany lokalizacji towaru
    public void changeProductLocation(Product product, Location newLocation) {
        Product exisitngproduct = findProduct(product.getId());
        if (exisitngproduct != null) {
            exisitngproduct.setLocation(newLocation);
        } else {
            System.out.println("Produkt nie istnieje w magazynie.");
        }
    }

    //Funkcja usuwania produktu
    public void removeProduct(Product product) {
        Product existingProduct = findProduct(product.getId());
        if (existingProduct != null) {
            products.remove(existingProduct);
        } else {
            System.out.println("Produkt nie istnieje w magazynie.");
        }
    }

    //Funkcja wyszukiwania produktu
    public Product findProduct(int productId) {
        for (Product product : products) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }

    //Funkcja wyświetlania stanu magazynu
    public void displayInventory() {
        System.out.println("Stan magazynu:");
        for (Product product : products) {
            product.displayProduct();
            System.out.print("  Lokalizacja: ");
            product.getLocation().displayLocation();
            System.out.print("  Ilość w magazynie: " + product.getQuantityInStock());
            System.out.println();
        }
    }

    private void handleZeroQuantity(Product product) {
        System.out.println("Uwaga: Produkt " + product.getName() + " osiągnął ilość 0 w magazynie.");
    }


}
