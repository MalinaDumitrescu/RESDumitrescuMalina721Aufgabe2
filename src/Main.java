import Model.Charakter;
import Model.Produkt;
import Repository.Repository;
import Service.Service;
import ConsoleView.ConsoleView;
import Controller.Controller;
import Repository.Repository;
public class Main {
    public static void main(String[] args) {
        // Create repositories with explicit types
        Repository<Charakter> charakterRepo = new Repository<Charakter>();
        Repository<Produkt> produktRepo = new Repository<Produkt>();

        // Create services
        Service<Charakter> charakterService = new Service<Charakter>(charakterRepo);
        Service<Produkt> produktService = new Service<Produkt>(produktRepo);

        // Create controller
        Controller controller = new Controller(charakterService, produktService);

        // Create and start console view
        ConsoleView view = new ConsoleView(controller);
        view.run();
    }
}


