package com.narxoz.rpg;

import com.narxoz.rpg.artifact.Inventory;
import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.vault.ChronomancerEngine;
import com.narxoz.rpg.vault.VaultRunResult;

import java.util.List;

/**
 * Entry point for Homework 9 — Chronomancer's Vault: Visitor + Memento.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== Homework 9 Demo: Visitor + Memento ===");

        // 1. Create 2 heroes with different starting states
        Hero warrior = new Hero("Aldric the Brave", 100, 20, 12, 8, 150, new Inventory());
        Hero mage = new Hero("Lyra the Enchantress", 60, 80, 6, 4, 200, new Inventory());

        // 2. Run the Chronomancer's Vault demo
        ChronomancerEngine engine = new ChronomancerEngine();
        VaultRunResult result = engine.runVault(List.of(warrior, mage));

        // 3. Final summary
        System.out.println("\n=== Final Party State ===");
        System.out.println("  " + warrior);
        System.out.println("  " + mage);
        System.out.println("\n=== Demo Complete ===");
    }
}
