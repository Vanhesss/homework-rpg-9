package com.narxoz.rpg.artifact;

public class CurseDetector implements ArtifactVisitor {

    private int cursedCount = 0;

    @Override
    public void visit(Weapon weapon) {
        if (weapon.getValue() < 20 && weapon.getAttackBonus() >= 8) {
            cursedCount++;
            System.out.println("  [CurseDetector] WARNING: Weapon '" + weapon.getName()
                    + "' is suspiciously powerful for its value — likely cursed!");
        } else {
            System.out.println("  [CurseDetector] Weapon '" + weapon.getName() + "' — no curse detected");
        }
    }

    @Override
    public void visit(Potion potion) {
        if (potion.getHealing() > 50) {
            cursedCount++;
            System.out.println("  [CurseDetector] WARNING: Potion '" + potion.getName()
                    + "' has unnaturally high potency — possible poison trap!");
        } else {
            System.out.println("  [CurseDetector] Potion '" + potion.getName() + "' — no curse detected");
        }
    }

    @Override
    public void visit(Scroll scroll) {
        String spell = scroll.getSpellName().toLowerCase();
        if (spell.contains("dark") || spell.contains("death") || spell.contains("shadow")) {
            cursedCount++;
            System.out.println("  [CurseDetector] WARNING: Scroll '" + scroll.getName()
                    + "' contains dark spell '" + scroll.getSpellName() + "' — cursed!");
        } else {
            System.out.println("  [CurseDetector] Scroll '" + scroll.getName() + "' — no curse detected");
        }
    }

    @Override
    public void visit(Ring ring) {
        if (ring.getMagicBonus() >= 5 && ring.getValue() < 30) {
            cursedCount++;
            System.out.println("  [CurseDetector] WARNING: Ring '" + ring.getName()
                    + "' has excessive magic for its value — cursed artifact!");
        } else {
            System.out.println("  [CurseDetector] Ring '" + ring.getName() + "' — no curse detected");
        }
    }

    @Override
    public void visit(Armor armor) {
        if (armor.getWeight() > 50) {
            cursedCount++;
            System.out.println("  [CurseDetector] WARNING: Armor '" + armor.getName()
                    + "' is unnaturally heavy (" + armor.getWeight() + " lbs) — bound by curse!");
        } else {
            System.out.println("  [CurseDetector] Armor '" + armor.getName() + "' — no curse detected");
        }
    }

    public int getCursedCount() {
        return cursedCount;
    }
}
