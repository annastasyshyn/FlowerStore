package flower.store;
public class FlowerPack {
    private Flower flower;
    private int amount;

    public FlowerPack(Flower newFlower, int newAmount) {
        flower = newFlower;
        amount = newAmount;
    }

    public FlowerPack(FlowerPack pack) {
        flower = new Flower(pack.flower);
        amount = pack.amount;
    }

    public double getPrice() {
        return amount * flower.getPrice();
    }
}
