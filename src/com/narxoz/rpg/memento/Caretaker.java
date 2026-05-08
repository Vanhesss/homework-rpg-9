package com.narxoz.rpg.memento;

import com.narxoz.rpg.combatant.HeroMemento;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Stores hero snapshots for the Chronomancer's Vault rewind mechanic.
 *
 * This class intentionally sits in a different package from {@link HeroMemento}
 * so it can only treat mementos as opaque values.
 */
public class Caretaker {

    private final Deque<HeroMemento> history = new ArrayDeque<>();

    public void save(HeroMemento memento) {
        if (memento != null) {
            history.push(memento);
        }
    }

    public HeroMemento undo() {
        return history.isEmpty() ? null : history.pop();
    }

    public HeroMemento peek() {
        return history.isEmpty() ? null : history.peek();
    }

    public int size() {
        return history.size();
    }
}
