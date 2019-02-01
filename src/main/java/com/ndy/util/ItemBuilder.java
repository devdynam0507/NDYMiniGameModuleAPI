package com.ndy.util;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2017-06-08.
 */
public class ItemBuilder extends ItemStack {

    private Material material;
    private ItemMeta meta;

    private int typeID;

    private List<String> lore;

    public ItemBuilder(Material material){
        this.material = material;
        this.setType(material);
        meta = this.getItemMeta();
        this.setAmount(1);
        lore = new ArrayList<>();
    }

    public ItemBuilder(int typeID){
        this.typeID = typeID;
        this.setTypeId(typeID);
        meta = this.getItemMeta();
        this.setAmount(1);
        lore = new ArrayList<>();
    }

    public ItemBuilder(ItemStack itemStack) {
        this.typeID = itemStack.getTypeId();
        this.setTypeId(typeID);
        meta = itemStack.getItemMeta();
        this.setAmount(1);
        lore = meta.hasLore() ? meta.getLore() : new ArrayList<>();
        this.setData(itemStack.getData());
    }

    public ItemBuilder setData(short data){
        this.setDurability(data);
        return this;
    }

    public ItemBuilder setAmounts(int amount){
        this.setAmount(amount);
        return this;
    }

    public ItemBuilder setDisplayName(String name){
        this.meta.setDisplayName(name);
        return this;
    }

    public ItemBuilder addLore(String lore){
        this.lore.add(lore);
        return this;
    }

    public ItemBuilder setLore(List<String> lores) {
        this.lore.addAll(lores);
        return this;
    }

    public ItemBuilder addEnchant(Enchantment enchant, int level){
        this.addUnsafeEnchantment(enchant, level);
        return this;
    }

    public ItemStack build(){
        meta.setLore(lore);
        this.setItemMeta(meta);
        return this;
    }

}
