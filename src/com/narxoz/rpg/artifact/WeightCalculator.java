package com.narxoz.rpg.artifact;

public class WeightCalculator implements ArtifactVisitor {

    private int totalWeight = 0;
    private int heaviestWeight = 0;
    private String heaviestName = "none";

    @Override
    public void visit(Weapon weapon) {
        totalWeight += weapon.getWeight();
        trackHeaviest(weapon.getName(), weapon.getWeight());
        System.out.println("  [WeightCalculator] Weapon '" + weapon.getName()
                + "' weighs " + weapon.getWeight() + " lbs (combat gear)");
    }

    @Override
    public void visit(Potion potion) {
        totalWeight += potion.getWeight();
        trackHeaviest(potion.getName(), potion.getWeight());
        System.out.println("  [WeightCalculator] Potion '" + potion.getName()
                + "' weighs " + potion.getWeight() + " lbs (lightweight vial)");
    }

    @Override
    public void visit(Scroll scroll) {
        totalWeight += scroll.getWeight();
        trackHeaviest(scroll.getName(), scroll.getWeight());
        System.out.println("  [WeightCalculator] Scroll '" + scroll.getName()
                + "' weighs " + scroll.getWeight() + " lbs (parchment)");
    }

    @Override
    public void visit(Ring ring) {
        totalWeight += ring.getWeight();
        trackHeaviest(ring.getName(), ring.getWeight());
        System.out.println("  [WeightCalculator] Ring '" + ring.getName()
                + "' weighs " + ring.getWeight() + " lbs (trinket)");
    }

    @Override
    public void visit(Armor armor) {
        totalWeight += armor.getWeight();
        trackHeaviest(armor.getName(), armor.getWeight());
        System.out.println("  [WeightCalculator] Armor '" + armor.getName()
                + "' weighs " + armor.getWeight() + " lbs (heavy plate)");
    }

    private void trackHeaviest(String name, int weight) {
        if (weight > heaviestWeight) {
            heaviestWeight = weight;
            heaviestName = name;
        }
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    public String getHeaviestName() {
        return heaviestName;
    }
}
