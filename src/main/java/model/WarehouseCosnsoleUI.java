package model;

import model.Product.*;
import model.Warehouse.Location;
import model.Warehouse.Warehouse;

import java.util.Scanner;

public class WarehouseCosnsoleUI {
    private static Warehouse warehouse = new Warehouse();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("=== PROGRAM ZARZĄDZANIA MAGAZYNEM ===");
            System.out.println("1. Przyjmowanie towaru");
            System.out.println("2. Wydanie towaru");
            System.out.println("3. Stan magazynu");
            System.out.println("4. Modyfikacja produktu");
            System.out.println("5. Zmiana lokalizacji");
            System.out.println("6. Usuwanie produktu");
            System.out.println("7. Wyszukiwanie produktu");
            System.out.println("0. Wyjście");
            System.out.print("\nWybierz opcję: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    handleReceiveProduct();
                    break;
                case 2:
                    handleIssueProduct();
                    break;
                case 3:
                    handleDisplayInventory();
                    break;
                case 4:
                    handleUpdateProduct();
                    break;
                case 5:
                    handleChangeProductLocation();
                    break;
                case 6:
                    handleRemoveProduct();
                    break;
                case 7:
                    handleFindProduct();
                    break;
                case 0:
                    System.out.println("=== WYŁĄCZANIE PROGRAMU ===");
                    break;
                default:
                    System.out.println("Nieprawidłowy wybór. Wybierz ponownie.");
            }
        } while (choice != 0);
        sc.close();
    }

    private static void handleReceiveProduct() {
        System.out.println("=== PRZYJMOWANIE TOWARU ===");

        System.out.println("Podaj ID produktu: ");
        int productId = sc.nextInt();
        sc.nextLine();

        Product existingProduct = warehouse.findProduct(productId);

        if (existingProduct != null) {
            System.out.println("Podaj ilość przyjmowanego towaru: ");
            int quantity = sc.nextInt();
            sc.nextLine();

            System.out.println("Podaj alejkę: ");
            char aisle = sc.nextLine().charAt(0);
            System.out.println("Podaj regał: ");
            int shelf = sc.nextInt();
            System.out.println("Podaj półkę: ");
            int rack = sc.nextInt();
            sc.nextLine();

            Location location = new Location(aisle,shelf,rack);
            warehouse.receiveProduct(existingProduct, quantity, location);

            System.out.println("Towar przyjęty do magazynu.");
        } else {
            System.out.println("Podaj nazwę producenta: ");
            String manufacturer = sc.nextLine();
            System.out.println("Podaj model: ");
            String model = sc.nextLine();
            System.out.println("Podaj nazwę: ");
            String name =  sc.nextLine();
            System.out.println("Podaj kolor: ");
            String color = sc.nextLine();
            System.out.println("Podaj cenę: ");
            double price = sc.nextDouble();
            sc.nextLine();

            System.out.println("Podaj typ produktu [PHONE, TABLET, SMARTWATCH, HEADPHONES]: ");
            TypeProduct type = TypeProduct.valueOf(sc.nextLine());

            System.out.println("Podaj ilość przyjmowanego towaru: ");
            int quantity = sc.nextInt();
            sc.nextLine();

            System.out.println("Podaj alejkę: ");
            char aisle = sc.nextLine().charAt(0);
            System.out.println("Podaj regał: ");
            int shelf = sc.nextInt();
            System.out.println("Podaj półkę: ");
            int rack = sc.nextInt();
            sc.nextLine();

            Location location = new Location(aisle,shelf,rack);

            Product newProduct = createProduct(productId, manufacturer, model, name, color, price, type, quantity, location);
            warehouse.receiveProduct(newProduct, quantity, location);

            System.out.println("Nowy produkt przyjęty do magazynu.");
        }
    }

    private static void handleIssueProduct() {
        System.out.println("=== WYDAWANIE TOWARU ===");
        System.out.println("Podaj ID produktu: ");
        int productId = sc.nextInt();
        sc.nextLine();

        Product existingProduct = warehouse.findProduct(productId);

        if (existingProduct != null) {
            System.out.println("Podaj ilość wydawanego towaru: ");
            int quantity = sc.nextInt();
            sc.nextLine();

            if (existingProduct.getQuantityInStock() >= quantity) {
                warehouse.issueProduct(existingProduct, quantity);
                System.out.println("TOWAR WYDANY");
            } else {
                System.out.println("Nie wystarczająca ilość produktu do wydania.");
            }
        } else {
            System.out.println("Produkt o podanym ID nie istnieje w magazynie.");
        }
    }

    private static void handleDisplayInventory() {
        System.out.println("=== STAN MAGAZYNU ===\n");
        warehouse.displayInventory();
        System.out.println("\n=== KONIEC STANU MAGAZYNU ===");
    }

    private static void handleUpdateProduct() {
        System.out.println("=== MODYFIKACJA PRODUKTU ===");

        System.out.println("Podaj ID produktu do modyfikacji: ");
        int productId = sc.nextInt();
        sc.nextLine();

        Product existingProduct = warehouse.findProduct(productId);

        if (existingProduct != null) {
            System.out.println("Aktualne informacje o produkcie");
            existingProduct.displayProduct();

            System.out.println("=== WYBIERZ OPCJĘ MODYFIKACJI ===");
            System.out.println("1. Zmiana ilości");
            System.out.println("2. Zmiana lokalizacji");
            System.out.println("3. Powrót do menu głównego");
            System.out.println("Wybierz opcję: ");

            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Podaj nową ilość: ");
                    int newQuantity = sc.nextInt();
                    sc.nextLine();
                    warehouse.updateProduct(existingProduct, newQuantity);
                    System.out.println("Ilość produktu zaktualizowama");
                    break;
                case 2:
                    System.out.println("Podaj nową lokalizację (Alejka): ");
                    char newAisle = sc.nextLine().charAt(0);
                    System.out.println("Podaj nową lokalizację (Regał): ");
                    int newShelf = sc.nextInt();
                    System.out.println("Podaj nową lokalizację (Półka): ");
                    int newRack = sc.nextInt();
                    sc.nextLine();

                    Location location = new Location(newAisle, newShelf, newRack);
                    warehouse.changeProductLocation(existingProduct, location);
                    System.out.println("Lokalizacja produktu zaktualizowana");
                    break;
                case 3:
                    System.out.println("Powrót do menu głównego.");
                    break;
                default:
                    System.out.println("Nieprawidłowy wybór. Powrót do menu głównego.");
            }
        } else {
            System.out.println("Produkt o podanym ID nie istnieje w magazynie.");
        }
    }

    private static void handleChangeProductLocation() {
        System.out.println("=== ZMIANA LOKALIZACJI PRODUKTU ===");
        System.out.println("Podaj ID produktu do zmiany lokalizacji: ");
        int productId = sc.nextInt();
        sc.nextLine();

        Product existingProduct = warehouse.findProduct(productId);

        if (existingProduct != null) {
            System.out.println("Aktualna lokalizacja produktu :");
            existingProduct.getLocation().displayLocation();

            System.out.println("Podaj nową lokalizację (Alejka): ");
            char newAisle = sc.nextLine().charAt(0);
            System.out.println("Podaj nową lokalizację (Regał): ");
            int newShelf = sc.nextInt();
            System.out.println("Podaj nową lokalizację (Półka): ");
            int newRack = sc.nextInt();
            sc.nextLine();

            Location newLocation = new Location(newAisle, newShelf, newRack);
            warehouse.changeProductLocation(existingProduct, newLocation);

            System.out.println("Lokalizacja produktu zaktualizowana");
        } else {
            System.out.println("Produkt o podanym ID nie istnieje w magazynie.");
        }
    }

    private static void handleRemoveProduct() {
        System.out.println("=== USUWANIE PRODUKTU ===");

        System.out.println("Podaj ID produktu do usunięcia");
        int productId = sc.nextInt();
        sc.nextLine();

        Product existingProduct = warehouse.findProduct(productId);

        if (existingProduct != null) {
            System.out.println("Czy na pewno chcesz usunąć poniższy produkt?");
            existingProduct.displayProduct();
            System.out.println("Potwiedź usunięcie (T/N): ");
            String decision = sc.nextLine();

            if (decision.equalsIgnoreCase("T")) {
                warehouse.removeProduct(existingProduct);
                System.out.println("Produkt usunięty z magazynu.");
            } else {
                System.out.println("Produkt nie został usunięty.");
            }
        } else {
            System.out.println("Produkt o podanym ID nie istnieje w magazynie.");
        }
    }

    private static void handleFindProduct() {
        System.out.println("=== Wyszukiwanie produktu ===");
        System.out.println("Podaj ID produktu do wyszukania: ");
        int productId = sc.nextInt();
        Product foundProduct = warehouse.findProduct(productId);

        if (foundProduct != null) {
            System.out.println("Znaleziony produkt: ");
            foundProduct.displayProduct();
        } else {
            System.out.println("Produkt o podanym ID nie istnieje w magazynie");
        }
    }

    private static Product createProduct(int id, String manufacturer, String name, String model, String color, double price, TypeProduct type, int quantity, Location location) {
        switch (type) {
            case PHONE:
                System.out.print("Podaj ilość pamieci ROM: ");
                int rom = sc.nextInt();
                System.out.print("Podaj ilość RAM: ");
                int ram = sc.nextInt();
                return new Phone(id, manufacturer, name, model, color, price, quantity,TypeProduct.PHONE, rom, ram, location);
            case TABLET:
                System.out.print("Podaj ilość pamieci ROM: ");
                int tabletRom = sc.nextInt();
                System.out.print("Podaj ilość RAM: ");
                int tabletRam = sc.nextInt();
                return new Tablet(id, manufacturer, name, model, color, price, quantity,TypeProduct.TABLET, tabletRom, tabletRam, location);
            case SMARTWATCH:
                return new Smartwatch(id,manufacturer, model, name, color, price, quantity, TypeProduct.SMARTWATCH, location);
            case HEADPHONES:
                return new Headphones(id, manufacturer, model, name, color, price, quantity, TypeProduct.HEADPHONES, location);
            default:
                throw new IllegalArgumentException("Nieobsługiwany typ produktu");
        }
    }
}
