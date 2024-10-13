package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

class FlowerBucketTest {
    private FlowerBucket bucket;
    private FlowerPack rosePack;
    private FlowerPack tulipPack;
    private double delta = 0.001;
    private double priceRose = 10.0;
    private double priceTulip = 5.0;
    private int roseAmount = 5;
    private int tulipAmount = 3;

    @BeforeEach
    void setUp() {
        bucket = new FlowerBucket();
        Flower rose = new Flower();
        rose.setPrice(priceRose);
        rosePack = new FlowerPack(rose, roseAmount);
        
        Flower tulip = new Flower();
        tulip.setPrice(priceTulip);
        tulipPack = new FlowerPack(tulip, tulipAmount);
    }

    @Test
    void testGetPrice() {
        bucket.addFlower(rosePack);
        Assertions.assertEquals(priceRose * roseAmount, bucket.getPrice(), delta);
        bucket.addFlower(tulipPack);
        Assertions.assertEquals(priceRose * roseAmount + priceTulip * tulipAmount,
                                bucket.getPrice(), delta);
    }
}