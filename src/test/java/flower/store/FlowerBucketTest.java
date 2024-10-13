package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

class FlowerBucketTest {
    private double delta;
    private double priceRose;
    private double priceTulip;
    private int roseAmount;
    private int tulipAmount;
    private FlowerBucket bucket;
    private FlowerPack rosePack;
    private FlowerPack tulipPack;


    @BeforeEach
    void setUp() {
        delta = 0.0001;
        priceRose = 10.0;
        priceTulip = 5.0;
        roseAmount = 5;
        tulipAmount = 3;

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
        Assertions.assertEquals(priceRose * roseAmount, bucket.getPrice(), 
                                delta);
        bucket.addFlower(tulipPack);
        Assertions.assertEquals(priceRose * roseAmount 
                                + priceTulip * tulipAmount,
                                bucket.getPrice(), delta);
    }
}