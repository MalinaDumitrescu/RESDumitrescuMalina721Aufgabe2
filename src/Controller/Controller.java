package Controller;
import Model.Produkt;
import Service.Service;
import Model.Charakter;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import java.util.List;

/**
 * Controller class that manages operations for Produkt and Charakter entities.
 */
public class Controller {
    private final Service<Charakter> charakterService;
    private final Service<Produkt> produktService;

    /**
     * Constructor for the Controller class.
     *
     * @param charakterService Service for managing Charakter entities.
     * @param produktService Service for managing Produkt entities.
     */
    public Controller(Service<Charakter> charakterService, Service<Produkt> produktService) {
        this.charakterService = charakterService;
        this.produktService = produktService;
    }

    /**
     * Adds a Produkt entity.
     *
     * @param produkt The Produkt entity to add.
     */
    public void addProdukt(Produkt produkt) { produktService.add(produkt); }

    /**
     * Retrieves a Produkt entity by index.
     *
     * @param index The index of the Produkt entity to retrieve.
     * @return The Produkt entity at the specified index.
     */
    public Produkt getProdukt(int index) { return produktService.get(index); }

    /**
     * Updates a Produkt entity at the specified index.
     *
     * @param index The index of the Produkt entity to update.
     * @param produkt The Produkt entity with updated values.
     */
    public void updateProdukt(int index, Produkt produkt) { produktService.update(index, produkt); }

    /**
     * Deletes a Produkt entity at the specified index.
     *
     * @param index The index of the Produkt entity to delete.
     */
    public void deleteProdukt(int index) { produktService.delete(index); }

    /**
     * Adds a Charakter entity.
     *
     * @param charakter The Charakter entity to add.
     */
    public void addCharakter(Charakter charakter) { charakterService.add(charakter); }

    /**
     * Retrieves a Charakter entity by index.
     *
     * @param index The index of the Charakter entity to retrieve.
     * @return The Charakter entity at the specified index.
     */
    public Charakter getCharakter(int index) { return charakterService.get(index); }

    /**
     * Updates a Charakter entity at the specified index.
     *
     * @param index The index of the Charakter entity to update.
     * @param charakter The Charakter entity with updated values.
     */
    public void updateCharakter(int index, Charakter charakter) { charakterService.update(index, charakter); }

    /**
     * Deletes a Charakter entity at the specified index.
     *
     * @param index The index of the Charakter entity to delete.
     */
    public void deleteCharakter(int index) { charakterService.delete(index); }


    //todo adaugate extra

    public List<Produkt> getAllProdukte(){
        return produktService.getAll();
    }

    public  List<Charakter> getAllCharakters(){
        return charakterService.getAll();
    }
}

//TODO STOP AICI COMMIT d.

    //TODO STOP AICI COMMIT e.


