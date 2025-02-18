package ConsoleView;

import java.util.List;
import java.util.Scanner;

import Controller.Controller;
import Model.Charakter;
import Model.Produkt;
import Service.Service;
import Repository.Repository;
import java.util.ArrayList;
import java.util.List;

//todo getAll for both i added now
public class ConsoleView {
    private final Controller controller;
    private final Scanner scanner = new Scanner(System.in);

    public ConsoleView(Controller controller) {
        this.controller = controller;
    }

    public void run() {
        while (true) {
            System.out.println("""
                ---- Shinobi-Handelsnetzwerk ----
                1 - Produkt hinzufügen
                2 - Produkt anzeigen
                3 - Produkt bearbeiten
                4 - Produkt löschen
                5 - Charakter hinzufügen
                6 - Charakter anzeigen
                7 - Charakter bearbeiten
                8 - Charakter löschen
                
                le am adaugat dupa pentru a fi mai usor sa verif
                9 - Afisare toate produsele
                10 - Afisare toti characterele
                
                0 - Beenden
                """);

            System.out.print("Option auswählen: ");
            String option = scanner.nextLine();
            switch (option) {
                case "1" -> addProdukt();
                case "2" -> viewProdukt();
                case "3" -> updateProdukt();
                case "4" -> deleteProdukt();
                case "5" -> addCharakter();
                case "6" -> viewCharakter();
                case "7" -> updateCharakter();
                case "8" -> deleteCharakter();
                case "9" -> getAllProdukte();
                case "10" -> getAllCharakters();

                case "0" -> {
                    System.out.println("Beenden...");
                    return;
                }
                default -> System.out.println("Ungültige Auswahl. Bitte erneut versuchen.");
            }
        }
    }

    private void addProdukt() {
        System.out.print("Produkt Name: ");
        String name = scanner.nextLine();
        System.out.print("Preis: ");
        double preis = getValidDouble();
        System.out.print("Herkunftsregion: ");
        String region = scanner.nextLine();

        Produkt produkt = new Produkt(name, preis, region);
        controller.addProdukt(produkt);
        System.out.println("Produkt erfolgreich hinzugefügt!");
    }

    private void viewProdukt() {
        System.out.print("Produkt Index: ");
        int index = getValidInt();
        Produkt produkt = controller.getProdukt(index);
        if (produkt != null) {
            System.out.println(produkt);
        } else {
            System.out.println("Produkt nicht gefunden.");
        }
    }

    private void updateProdukt() {
        System.out.print("Produkt Index: ");
        int index = getValidInt();
        Produkt produkt = controller.getProdukt(index);

        if (produkt == null) {
            System.out.println("Produkt nicht gefunden.");
            return;
        }

        System.out.print("Neuer Name: ");
        String name = scanner.nextLine();
        System.out.print("Neuer Preis: ");
        double preis = getValidDouble();
        System.out.print("Neue Herkunftsregion: ");
        String region = scanner.nextLine();

        controller.updateProdukt(index, new Produkt(name, preis, region));
        System.out.println("Produkt erfolgreich aktualisiert!");
    }

    private void deleteProdukt() {
        System.out.print("Produkt Index: ");
        int index = getValidInt();
        if (controller.getProdukt(index) == null) {
            System.out.println("Produkt nicht gefunden.");
            return;
        }
        controller.deleteProdukt(index);
        System.out.println("Produkt erfolgreich gelöscht!");
    }

    private void addCharakter() {
        System.out.print("Charakter Name: ");
        String name = scanner.nextLine();
        System.out.print("Herkunftsdorf: ");
        String dorf = scanner.nextLine();

        Charakter charakter = new Charakter(0, name, dorf);
        controller.addCharakter(charakter);
        System.out.println("Charakter erfolgreich hinzugefügt!");
    }

    private void viewCharakter() {
        System.out.print("Charakter Index: ");
        int index = getValidInt();
        Charakter charakter = controller.getCharakter(index);
        if (charakter != null) {
            System.out.println(charakter);
        } else {
            System.out.println("Charakter nicht gefunden.");
        }
    }

    private void updateCharakter() {
        System.out.print("Charakter Index: ");
        int index = getValidInt();
        Charakter charakter = controller.getCharakter(index);

        if (charakter == null) {
            System.out.println("Charakter nicht gefunden.");
            return;
        }

        System.out.print("Neuer Name: ");
        String name = scanner.nextLine();
        System.out.print("Neues Herkunftsdorf: ");
        String dorf = scanner.nextLine();

        Charakter updatedCharakter = new Charakter(charakter.getId(), name, dorf);
        updatedCharakter.getGekaufteProdukte().addAll(charakter.getGekaufteProdukte());

        controller.updateCharakter(index, updatedCharakter);
        System.out.println("Charakter erfolgreich aktualisiert!");
    }

    private void deleteCharakter() {
        System.out.print("Charakter Index: ");
        int index = getValidInt();
        if (controller.getCharakter(index) == null) {
            System.out.println("Charakter nicht gefunden.");
            return;
        }
        controller.deleteCharakter(index);
        System.out.println("Charakter erfolgreich gelöscht!");
    }
    private int getValidInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Ungültige Eingabe. Bitte eine Zahl eingeben: ");
            }
        }
    }

    private double getValidDouble() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Ungültige Eingabe. Bitte eine gültige Zahl eingeben: ");
            }
        }
    }




    //todo adaugate extra
    private void getAllProdukte() {
        List<Produkt> produkte = controller.getAllProdukte();
        produkte.forEach(System.out::println);
    }

    private void getAllCharakters() {
        List<Charakter> charaktere = controller.getAllCharakters();
        charaktere.forEach(System.out::println);
    }
}