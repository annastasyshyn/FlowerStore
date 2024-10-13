package flower.store;

public class FlowerSpecification {
    private FlowerColor color;
    private FlowerType flowerType;

    public FlowerSpecification(FlowerColor color_, FlowerType type) {
        color = color_;
        flowerType = type;
    }
    public boolean matches(FlowerSpecification anotherSpec) {
        return color.equals(anotherSpec.color) &&
         flowerType.equals(anotherSpec.flowerType);
    }
}
