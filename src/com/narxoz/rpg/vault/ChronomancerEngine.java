package com.narxoz.rpg.vault;

import com.narxoz.rpg.artifact.*;
import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.memento.Caretaker;

import java.util.List;

/**
 * Orchestrates the Chronomancer's Vault demo run.
 */
public class ChronomancerEngine {

    public VaultRunResult runVault(List<Hero> party) {
        System.out.println("\n========================================");
        System.out.println("  ENTERING THE CHRONOMANCER'S VAULT");
        System.out.println("========================================\n");

        // --- Build mixed inventory (5+ artifacts) ---
        Inventory inventory = new Inventory();
        inventory.addArtifact(new Weapon("Shadowfang Blade", 50, 12, 7));
        inventory.addArtifact(new Potion("Elixir of Vitality", 25, 1, 40));
        inventory.addArtifact(new Scroll("Ancient Codex", 80, 2, "Dark Binding"));
        inventory.addArtifact(new Ring("Band of Arcana", 60, 1, 4));
        inventory.addArtifact(new Armor("Chrono Platemail", 100, 55, 9));

        int artifactsAppraised = inventory.size();
        int mementosCreated = 0;
        int restoredCount = 0;

        // --- Print party ---
        System.out.println("--- Party enters the vault ---");
        for (Hero hero : party) {
            System.out.println("  " + hero);
        }

        // --- Visitor 1: Gold Appraiser ---
        System.out.println("\n--- Appraisal Phase: Gold Appraiser ---");
        GoldAppraiser goldAppraiser = new GoldAppraiser();
        inventory.accept(goldAppraiser);
        System.out.println("  >> Total resale value: " + goldAppraiser.getTotalGoldValue() + " gold\n");

        // --- Visitor 2: Enchantment Scanner ---
        System.out.println("--- Appraisal Phase: Enchantment Scanner ---");
        EnchantmentScanner enchantmentScanner = new EnchantmentScanner();
        inventory.accept(enchantmentScanner);
        System.out.println("  >> Enchanted artifacts found: " + enchantmentScanner.getEnchantedCount() + "\n");

        // --- Visitor 3: Curse Detector ---
        System.out.println("--- Appraisal Phase: Curse Detector ---");
        CurseDetector curseDetector = new CurseDetector();
        inventory.accept(curseDetector);
        System.out.println("  >> Cursed artifacts found: " + curseDetector.getCursedCount() + "\n");

        // --- Visitor 4: Weight Calculator (open/closed proof) ---
        System.out.println("--- Appraisal Phase: Weight Calculator (4th visitor — open/closed proof) ---");
        WeightCalculator weightCalc = new WeightCalculator();
        inventory.accept(weightCalc);
        System.out.println("  >> Total carry weight: " + weightCalc.getTotalWeight()
                + " lbs | Heaviest item: " + weightCalc.getHeaviestName() + "\n");

        // --- Memento demo for each hero ---
        Caretaker caretaker = new Caretaker();

        for (Hero hero : party) {
            System.out.println("========================================");
            System.out.println("  VAULT EVENT: " + hero.getName());
            System.out.println("========================================");

            // Save snapshot before trap
            System.out.println("\n[Time Crystal] Saving snapshot of " + hero.getName() + "...");
            caretaker.save(hero.createMemento());
            mementosCreated++;
            System.out.println("  State saved: " + hero);
            System.out.println("  Snapshots stored: " + caretaker.size());

            // Vault trap damages hero
            System.out.println("\n[Vault Trap] A chrono-trap activates!");
            hero.takeDamage(30);
            hero.spendMana(15);
            hero.spendGold(50);
            hero.setInventory(new Inventory());
            System.out.println("  " + hero.getName() + " takes 30 damage, loses 15 mana, 50 gold, and all items!");
            System.out.println("  State after trap: " + hero);

            // Restore from memento
            System.out.println("\n[Time Crystal] Rewinding " + hero.getName() + " to saved state...");
            hero.restoreFromMemento(caretaker.undo());
            restoredCount++;
            System.out.println("  State restored: " + hero);
            System.out.println("  Snapshots remaining: " + caretaker.size());
            System.out.println();
        }

        VaultRunResult result = new VaultRunResult(artifactsAppraised, mementosCreated, restoredCount);

        System.out.println("========================================");
        System.out.println("  VAULT RUN COMPLETE");
        System.out.println("========================================");
        System.out.println("  " + result);

        return result;
    }
}
