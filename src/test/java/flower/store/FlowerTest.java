package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

import org.junit.jupiter.api.Assertions;

public class FlowerTest {
    private static final Random RANDOM_GENERATOR = new Random();
    private static final int MAX_PRICE = 100;
    private Flower flower;

    @BeforeEach
    public void init() {
        flower = new Flower();
    }

    @Test
    public void testPrice() {
        int price = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        flower.setPrice(price);
        Assertions.assertEquals(price, flower.getPrice());
    }

    @Test
    public void testColor() {
        FlowerColor color = FlowerColor.RED;
        flower.setColor(color);
        Assertions.assertEquals("#FF0000", flower.getColor());
    }
}
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
        FlowerSpecification roseSpec = new FlowerSpecification(FlowerColor.RED, FlowerType.ROSE);
        ArrayList<Flower> result = new ArrayList<>();
        result = store.search(roseSpec);
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(FlowerType.ROSE, result.get(0).getFlowerType());
        Assertions.assertEquals("RED", result.get(0).getColor());
    }
}

class FlowerBucketTest {
    private FlowerBucket bucket;
    private FlowerPack rosePack;
    private FlowerPack tulipPack;

    @BeforeEach
    void setUp() {
        bucket = new FlowerBucket();
        
        Flower rose = new Flower();
        rose.setPrice(10.0);
        rosePack = new FlowerPack(rose, 5);
        
        Flower tulip = new Flower();
        tulip.setPrice(5.0);
        tulipPack = new FlowerPack(tulip, 3);
    }

    @Test
    void testAddFlower() {
        bucket.addFlower(rosePack);
        bucket.addFlower(tulipPack);
        Assertions.assertEquals(65.0, bucket.getPrice(), 0.001);
    }

    @Test
    void testGetPrice() {
        bucket.addFlower(rosePack);
        Assertions.assertEquals(50.0, bucket.getPrice(), 0.001);
        bucket.addFlower(tulipPack);
        Assertions.assertEquals(65.0, bucket.getPrice(), 0.001);
    }
}