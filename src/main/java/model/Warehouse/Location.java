package model.Warehouse;

public class Location {
    private char aisle;
    private int shelf;
    private int rack;

    public Location(char aisle, int shelf, int rack) {
        this.aisle = aisle;
        this.shelf = shelf;
        this.rack = rack;
    }

    public char getAisle() {
        return aisle;
    }

    public void setAisle(char aisle) {
        this.aisle = aisle;
    }

    public int getShelf() {
        return shelf;
    }

    public void setShelf(int shelf) {
        this.shelf = shelf;
    }

    public int getRack() {
        return rack;
    }

    public void setRack(int rack) {
        this.rack = rack;
    }


    public void displayLocation() {
        System.out.println("Alejka: " + aisle + " Regał: " + shelf + " Półka: " + rack);
    }
}
