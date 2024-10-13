package flower.store;

import java.util.ArrayList;

public class Store {
    private ArrayList<Flower> flowers;

    public Store() {
        flowers = new ArrayList<>();
    }
    public ArrayList<Flower> search(FlowerSpecification specification){
        ArrayList<Flower> flowerRes = new ArrayList<>();
        for (Flower flower: flowers) {
            if (flower.getSpecification().matches(specification)){
                flowerRes.add(flower);
            }
        }
        return flowerRes;
    }
}
