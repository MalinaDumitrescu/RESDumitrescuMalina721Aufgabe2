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
                0 - Beenden
                """);

            System.out.print("Option auswählen: ");
            String option = scanner.nextLine();
            switch (option) {
                case "1" -> addProdukt();
                case "2" -> viewProdukt();
                case "3" -> updateProdukt();
                case "4" -> deleteProdukt();

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
}