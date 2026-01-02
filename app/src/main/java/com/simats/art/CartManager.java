package com.simats.art;

import java.util.HashMap;
import java.util.Map;

public class CartManager {
    private static CartManager instance;
    private Map<String, Integer> items = new HashMap<>();

    private CartManager() {}

    public static synchronized CartManager getInstance() {
        if (instance == null) {
            instance = new CartManager();
        }
        return instance;
    }

    public void addItem(String itemName) {
        items.put(itemName, items.getOrDefault(itemName, 0) + 1);
    }

    public void setQuantity(String itemName, int quantity) {
        if (quantity <= 0) {
            items.remove(itemName);
        } else {
            items.put(itemName, quantity);
        }
    }

    public void removeItem(String itemName) {
        items.remove(itemName);
    }

    public int getQuantity(String itemName) {
        return items.getOrDefault(itemName, 0);
    }

    public int getTotalCount() {
        int total = 0;
        for (int count : items.values()) {
            total += count;
        }
        return total;
    }
}
