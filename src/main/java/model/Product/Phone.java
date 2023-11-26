package model.Product;

import model.Warehouse.Location;

public class Phone extends Product {
    private int rom;
    private int ram;

    public Phone(int id, String manufacturer, String model, String name, String color, double price, int quantityInStock, TypeProduct typeProduct, int rom, int ram, Location location) {
        super(id, manufacturer, model, name, color, price, quantityInStock, TypeProduct.PHONE,location);
        this.rom = rom;
        this.ram = ram;
    }

    @Override
    public void displayProduct() {
        System.out.println("ID[" + getId() + "]Producent: " + getManufacturer() + "   MODEL: " + getModel() + "   NAZWA: " + getName() + "   KOLOR: " + getColor()
                + "   CENA:   " + getPrice() + "   TYP: " + TypeProduct.PHONE + "   ILOŚĆ: " + getQuantityInStock() + "   RAM\\ROM: " + getRam()+"\\"+getRom());
    }

    public int getRom() {
        return rom;
    }

    public void setRom(int rom) {
        this.rom = rom;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }
}
