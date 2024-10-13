package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
class StoreTest {
    private Store store;
    private Flower rose;
    private Flower tulip;

    @BeforeEach
    void setUp() {
        store = new Store();
        rose = new Flower();
        rose.setFlowerType(FlowerType.ROSE);
        rose.setColor(FlowerColor.RED);
        tulip = new Flower();
        tulip.setFlowerType(FlowerType.TULIP);
        tulip.setColor(FlowerColor.RED);
        
        store.addFlower(rose);
        store.addFlower(tulip);
    }

    @Test
    void testSearch() {
        FlowerSpecification roseSpec = new FlowerSpecification(FlowerColor.RED, 
                                                            FlowerType.ROSE);
        ArrayList<Flower> result = new ArrayList<>();
        result = store.search(roseSpec);
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(FlowerType.ROSE,
                                result.get(0).getFlowerType());
        Assertions.assertEquals("#FF0000", result.get(0).getColor());
    }
}