package model.Product;

public abstract class Product {
    private int id;
    private String manufacturer;
    private String model;
    private String name;
    private String color;
    private double price;
    private int quantityInStock;
    private TypeProduct typeProduct;

    public Product(int id, String manufacturer, String model, String name, String color, double price, int quantityInStock, TypeProduct typeProduct) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.name = name;
        this.color = color;
        this.price = price;
        this.quantityInStock = quantityInStock;
        this.typeProduct = typeProduct;
    }

    public abstract void displayProduct();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public TypeProduct getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(TypeProduct typeProduct) {
        this.typeProduct = typeProduct;
    }
}
