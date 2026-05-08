package com.narxoz.rpg.artifact;

public class EnchantmentScanner implements ArtifactVisitor {

    private int enchantedCount = 0;

    @Override
    public void visit(Weapon weapon) {
        if (weapon.getAttackBonus() >= 5) {
            enchantedCount++;
            System.out.println("  [EnchantmentScanner] Weapon '" + weapon.getName()
                    + "' radiates strong combat enchantment (+" + weapon.getAttackBonus() + " attack)");
        } else {
            System.out.println("  [EnchantmentScanner] Weapon '" + weapon.getName()
                    + "' has minimal enchantment (+" + weapon.getAttackBonus() + " attack)");
        }
    }

    @Override
    public void visit(Potion potion) {
        if (potion.getHealing() >= 30) {
            enchantedCount++;
            System.out.println("  [EnchantmentScanner] Potion '" + potion.getName()
                    + "' glows with powerful restorative magic (+" + potion.getHealing() + " HP)");
        } else {
            System.out.println("  [EnchantmentScanner] Potion '" + potion.getName()
                    + "' contains weak healing essence (+" + potion.getHealing() + " HP)");
        }
    }

    @Override
    public void visit(Scroll scroll) {
        enchantedCount++;
        System.out.println("  [EnchantmentScanner] Scroll '" + scroll.getName()
                + "' contains spell '" + scroll.getSpellName()
                + "' — inherently magical");
    }

    @Override
    public void visit(Ring ring) {
        if (ring.getMagicBonus() >= 3) {
            enchantedCount++;
            System.out.println("  [EnchantmentScanner] Ring '" + ring.getName()
                    + "' pulses with arcane energy (+" + ring.getMagicBonus() + " magic)");
        } else {
            System.out.println("  [EnchantmentScanner] Ring '" + ring.getName()
                    + "' has faint magical trace (+" + ring.getMagicBonus() + " magic)");
        }
    }

    @Override
    public void visit(Armor armor) {
        if (armor.getDefenseBonus() >= 6) {
            enchantedCount++;
            System.out.println("  [EnchantmentScanner] Armor '" + armor.getName()
                    + "' is heavily warded (+" + armor.getDefenseBonus() + " defense)");
        } else {
            System.out.println("  [EnchantmentScanner] Armor '" + armor.getName()
                    + "' has standard protection (+" + armor.getDefenseBonus() + " defense)");
        }
    }

    public int getEnchantedCount() {
        return enchantedCount;
    }
}
