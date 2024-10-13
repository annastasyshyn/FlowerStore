package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class FlowerBucketTest {
    private static final double DELTA = 0.0001;
    private static final double PRICE_ROSE = 10.0;
    private static final double PRICE_TULIP = 5.0;
    private static final int ROSE_AMOUNT = 5;
    private static final int TULIP_AMOUNT = 3;

    private FlowerBucket bucket;
    private FlowerPack rosePack;
    private FlowerPack tulipPack;

    @BeforeEach
    void setUp() {
        bucket = new FlowerBucket();
        Flower rose = new Flower();
        rose.setPrice(PRICE_ROSE);
        rosePack = new FlowerPack(rose, ROSE_AMOUNT);
        
        Flower tulip = new Flower();
        tulip.setPrice(PRICE_TULIP);
        tulipPack = new FlowerPack(tulip, TULIP_AMOUNT);
    }

    @Test
    void testGetPrice() {
        bucket.addFlower(rosePack);
        Assertions.assertEquals(PRICE_ROSE * ROSE_AMOUNT, bucket.getPrice(),
                                DELTA);
        
        bucket.addFlower(tulipPack);
        Assertions.assertEquals(PRICE_ROSE * ROSE_AMOUNT + PRICE_TULIP 
                                * TULIP_AMOUNT, bucket.getPrice(), DELTA);
    }
}
