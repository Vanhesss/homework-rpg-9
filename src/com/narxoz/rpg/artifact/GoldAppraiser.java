package com.narxoz.rpg.artifact;

public class GoldAppraiser implements ArtifactVisitor {

    private int totalGoldValue = 0;

    @Override
    public void visit(Weapon weapon) {
        int appraisal = weapon.getValue() + weapon.getAttackBonus() * 10;
        totalGoldValue += appraisal;
        System.out.println("  [GoldAppraiser] Weapon '" + weapon.getName()
                + "' appraised at " + appraisal + " gold (base " + weapon.getValue()
                + " + attack bonus premium " + weapon.getAttackBonus() * 10 + ")");
    }

    @Override
    public void visit(Potion potion) {
        int appraisal = potion.getValue() + potion.getHealing() * 2;
        totalGoldValue += appraisal;
        System.out.println("  [GoldAppraiser] Potion '" + potion.getName()
                + "' appraised at " + appraisal + " gold (base " + potion.getValue()
                + " + healing premium " + potion.getHealing() * 2 + ")");
    }

    @Override
    public void visit(Scroll scroll) {
        int appraisal = scroll.getValue() * 3;
        totalGoldValue += appraisal;
        System.out.println("  [GoldAppraiser] Scroll '" + scroll.getName()
                + "' (spell: " + scroll.getSpellName() + ") appraised at "
                + appraisal + " gold (rare spell multiplier x3)");
    }

    @Override
    public void visit(Ring ring) {
        int appraisal = ring.getValue() + ring.getMagicBonus() * 15;
        totalGoldValue += appraisal;
        System.out.println("  [GoldAppraiser] Ring '" + ring.getName()
                + "' appraised at " + appraisal + " gold (base " + ring.getValue()
                + " + magic bonus premium " + ring.getMagicBonus() * 15 + ")");
    }

    @Override
    public void visit(Armor armor) {
        int appraisal = armor.getValue() + armor.getDefenseBonus() * 8;
        totalGoldValue += appraisal;
        System.out.println("  [GoldAppraiser] Armor '" + armor.getName()
                + "' appraised at " + appraisal + " gold (base " + armor.getValue()
                + " + defense premium " + armor.getDefenseBonus() * 8 + ")");
    }

    public int getTotalGoldValue() {
        return totalGoldValue;
    }
}
