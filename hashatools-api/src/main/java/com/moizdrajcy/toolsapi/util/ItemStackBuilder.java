package com.moizdrajcy.toolsapi.util;

import java.util.Arrays;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class ItemStackBuilder {

  private ItemStack item;

  public ItemStackBuilder(Material material) {
    this.item = new ItemStack(material);
  }

  public ItemStackBuilder(ItemStack itemStack) {
    this.item = itemStack;
  }

  public ItemStackBuilder name(String name) {
    this.item.getItemMeta().setDisplayName(Colors.colored(name));

    return this;
  }

  public ItemStackBuilder amount(int amount) {
    this.item.setAmount(amount);

    return this;
  }

  public ItemStackBuilder lore(String... lore) {
    List<String> lores = Arrays.asList(lore);
    lores.forEach(Colors::colored);
    this.item.getItemMeta().setLore(lores);

    return this;
  }

  public ItemStackBuilder enchantment(Enchantment enchantment, int level) {
    this.item.addUnsafeEnchantment(enchantment, level);

    return this;
  }

  public ItemStackBuilder enchantment(Enchantment enchantment) {
    this.item.addUnsafeEnchantment(enchantment, 1);

    return this;
  }

  public ItemStack build() {
    return this.item.clone();
  }

}
