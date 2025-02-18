package Model;

import java.util.List;
import java.util.ArrayList;

public class Charakter {
    private int id;
    private String name;
    private String herkunftsdorf;
    private List<Produkt> gekaufteProdukte;

    public Charakter(int id, String name, String herkunftsdorf) {
        this.id = id;
        this.name = name;
        this.herkunftsdorf = herkunftsdorf;
        this.gekaufteProdukte = new ArrayList<>();
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getHerkunftsdorf() { return herkunftsdorf; }
    public List<Produkt> getGekaufteProdukte() { return gekaufteProdukte; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setHerkunftsdorf(String herkunftsdorf) { this.herkunftsdorf = herkunftsdorf; }
    public void kaufeProdukt(Produkt produkt) { this.gekaufteProdukte.add(produkt); }

    @Override
    public String toString() {
        return "Charakter{" + "id=" + id + ", name='" + name + '\'' +
                ", herkunftsdorf='" + herkunftsdorf + '\'' + ", gekaufteProdukte=" + gekaufteProdukte + '}';
    }
}

