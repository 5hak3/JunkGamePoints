package net.azisaba.jg.junkgamespoints.utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;

public class JGPTickets {
    public static final ItemStack jgpTicket10;
    public static final ItemStack jgpTicket100;
    public static final ItemStack jgpTicket1000;
    public static final ItemStack jgpTicket10000;

    static {
        ItemMeta meta;
        jgpTicket10 = new ItemStack(Material.PAPER);
        meta = jgpTicket10.getItemMeta();
        meta.displayName(Component.text("10JGPチケット", TextColor.color(0xff7f00)));
        meta.lore(Arrays.asList(
                Component.text("10JGP分のチケット"),
                Component.text("/ticket2jgp コマンドでJGPに戻せます．")
        ));
        meta.addEnchant(Enchantment.DURABILITY, 0, false);
        meta.setCustomModelData(101);
        jgpTicket10.setItemMeta(meta);
        jgpTicket10.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        jgpTicket100 = new ItemStack(Material.PAPER);
        meta = jgpTicket100.getItemMeta();
        meta.displayName(Component.text("100JGPチケット", TextColor.color(0xffff00)));
        meta.lore(Arrays.asList(
                Component.text("100JGP分のチケット"),
                Component.text("/ticket2jgp コマンドでJGPに戻せます．")
        ));
        meta.addEnchant(Enchantment.DURABILITY, 0, false);
        meta.setCustomModelData(102);
        jgpTicket100.setItemMeta(meta);
        jgpTicket100.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        jgpTicket1000 = new ItemStack(Material.PAPER);
        meta = jgpTicket1000.getItemMeta();
        meta.displayName(Component.text("1000JGPチケット", TextColor.color(0x7fff00)));
        meta.lore(Arrays.asList(
                Component.text("1000JGP分のチケット"),
                Component.text("/ticket2jgp コマンドでJGPに戻せます．")
        ));
        meta.addEnchant(Enchantment.DURABILITY, 0, false);
        meta.setCustomModelData(103);
        jgpTicket1000.setItemMeta(meta);
        jgpTicket1000.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        jgpTicket10000 = new ItemStack(Material.PAPER);
        meta = jgpTicket10000.getItemMeta();
        meta.displayName(Component.text("10000JGPチケット", TextColor.color(0x00ff00)));
        meta.lore(Arrays.asList(
                Component.text("10000JGP分のチケット"),
                Component.text("/ticket2jgp コマンドでJGPに戻せます．")
        ));
        meta.addEnchant(Enchantment.DURABILITY, 0, false);
        meta.setCustomModelData(104);
        jgpTicket10000.setItemMeta(meta);
        jgpTicket10000.addItemFlags(ItemFlag.HIDE_ENCHANTS);
    }

    public static ArrayList<ItemStack> getAllTickets() {
        ArrayList<ItemStack> tickets = new ArrayList<>();
        tickets.add(jgpTicket10);
        tickets.add(jgpTicket100);
        tickets.add(jgpTicket1000);
        tickets.add(jgpTicket10000);
        return tickets;
    }
}
