package com.ndy.util;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class InventoryUtility {

    public static int getSlot(ItemStack item, Player player) {
        for(int i = 0; i < player.getInventory().getSize(); i++) {
            if(player.getInventory().getItem(i) == null) continue;
            if(equals(item, player.getInventory().getItem(i))) return i;
        }
        return -1;
    }

    public static boolean equals(ItemStack item1, ItemStack item2) {
        ItemMeta meta1 = item1.getItemMeta();
        ItemMeta meta2 = item2.getItemMeta();
        boolean matchDisplayName = false;
        boolean matchLore = false;
        boolean matchType = item1.getType() == item2.getType();
        boolean matchDurability = item1.getDurability() == item2.getDurability();
        boolean matchEnchantment = false;

        List<String> lore1 = filter(meta1.hasLore() ? meta1.getLore() : new ArrayList<>());
        List<String> lore2 = filter(meta2.hasLore() ? meta2.getLore() : new ArrayList<>());

        if(meta1.hasDisplayName() && meta2.hasDisplayName() && meta1.getDisplayName().equals(meta2.getDisplayName())) matchDisplayName = true;
        else if(!meta1.hasDisplayName() && !meta2.hasDisplayName()) matchDisplayName = true;

        if((meta1.hasLore() || meta2.hasLore()) && lore1.equals(lore2)) matchLore = true;
        else if(!meta1.hasLore() && !meta2.hasLore()) matchLore = true;
        else if(meta1.hasLore() && meta2.hasLore() && lore1.equals(lore2)) matchLore = true;

        if(meta1.hasEnchants() && meta2.hasEnchants() && meta1.getEnchants().equals(meta2.getEnchants())) matchEnchantment = true;
        else if(!meta1.hasEnchants() && !meta2.hasEnchants()) matchEnchantment = true;
//
//        System.out.println("matchDisplay: " + matchDisplayName);
//        System.out.println("matchLore: " + matchLore);
//        System.out.println("matchType: " + matchType);
//        System.out.println("matchDura: " + matchDurability);
//        System.out.println("matchEnchat: " + matchEnchantment);
//
//        System.out.println(lore1.equals(lore2));

        return matchDisplayName && matchDurability && matchLore && matchType && matchEnchantment;
    }

    private static List<String> filter(List<String> lore) {
        int ind = -1;
        for(int i = 0; i < lore.size(); i++) {
            if(lore.get(i).contains("할인")) {
                ind = i;
                break;
            }
        }
        if(ind != -1) lore.remove(ind);

        return lore;
    }

}
