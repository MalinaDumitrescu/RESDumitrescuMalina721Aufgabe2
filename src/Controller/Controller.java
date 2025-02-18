package Controller;
import Model.Produkt;
import Service.Service;
import Model.Charakter;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import java.util.List;

public class Controller {
    private final Service<Charakter> charakterService;
    private final Service<Produkt> produktService;

    public Controller(Service<Charakter> charakterService, Service<Produkt> produktService) {
        this.charakterService = charakterService;
        this.produktService = produktService;
    }

    public void addProdukt(Produkt produkt) { produktService.add(produkt); }
    public Produkt getProdukt(int index) { return produktService.get(index); }
    public void updateProdukt(int index, Produkt produkt) { produktService.update(index, produkt); }
    public void deleteProdukt(int index) { produktService.delete(index); }


}

//TODO STOP AICI COMMIT d.

    //TODO STOP AICI COMMIT e.


