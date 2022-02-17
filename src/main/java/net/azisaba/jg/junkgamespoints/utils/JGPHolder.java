package net.azisaba.jg.junkgamespoints.utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collections;

public class JGPHolder implements InventoryHolder {
    public static final ItemStack pane_10_1;
    public static final ItemStack pane_10_4;
    public static final ItemStack pane_10_8;
    public static final ItemStack pane_10_16;
    public static final ItemStack pane_100_1;
    public static final ItemStack pane_100_4;
    public static final ItemStack pane_100_8;
    public static final ItemStack pane_100_16;
    public static final ItemStack pane_1000_1;
    public static final ItemStack pane_1000_4;
    public static final ItemStack pane_1000_8;
    public static final ItemStack pane_1000_16;
    public static final ItemStack pane_10000_1;
    public static final ItemStack pane_10000_4;
    public static final ItemStack pane_10000_8;
    public static final ItemStack pane_10000_16;
    public static final ItemStack pane_ott;
    public static final ItemStack pane_otp_100;
    public static final ItemStack pane_otp_500;
    public static final ItemStack pane_otp_1000;
    public static final ItemStack pane_otp_5000;
    public static final ItemStack pane_restore;
    public static final ItemStack pane_cancel;

    static {
        ItemMeta meta;
        pane_10_1 = new ItemStack(Material.ORANGE_STAINED_GLASS_PANE);
        meta = pane_10_1.getItemMeta();
        meta.displayName(Component.text("10JGPチケット x1", TextColor.color(0xff7f00)));
        meta.lore(Collections.singletonList(Component.text("10JGPチケットを1枚獲得します。")));
        meta.setCustomModelData(999);
        pane_10_1.setItemMeta(meta);

        pane_10_4 = new ItemStack(Material.ORANGE_STAINED_GLASS_PANE);
        meta = pane_10_4.getItemMeta();
        meta.displayName(Component.text("10JGPチケット x4", TextColor.color(0xff7f00)));
        meta.lore(Collections.singletonList(Component.text("10JGPチケットを4枚獲得します。")));
        meta.setCustomModelData(999);
        pane_10_4.setItemMeta(meta);

        pane_10_8 = new ItemStack(Material.ORANGE_STAINED_GLASS_PANE);
        meta = pane_10_8.getItemMeta();
        meta.displayName(Component.text("10JGPチケット x8", TextColor.color(0xff7f00)));
        meta.lore(Collections.singletonList(Component.text("10JGPチケットを8枚獲得します。")));
        meta.setCustomModelData(999);
        pane_10_8.setItemMeta(meta);

        pane_10_16 = new ItemStack(Material.ORANGE_STAINED_GLASS_PANE);
        meta = pane_10_16.getItemMeta();
        meta.displayName(Component.text("10JGPチケット x16", TextColor.color(0xff7f00)));
        meta.lore(Collections.singletonList(Component.text("10JGPチケットを16枚獲得します。")));
        meta.setCustomModelData(999);
        pane_10_16.setItemMeta(meta);
        pane_100_1 = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE);
        meta = pane_100_1.getItemMeta();
        meta.displayName(Component.text("100JGPチケット x1", TextColor.color(0xffff00)));
        meta.lore(Collections.singletonList(Component.text("100JGPチケットを1枚獲得します。")));
        meta.setCustomModelData(999);
        pane_100_1.setItemMeta(meta);

        pane_100_4 = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE);
        meta = pane_100_4.getItemMeta();
        meta.displayName(Component.text("100JGPチケット x4", TextColor.color(0xffff00)));
        meta.lore(Collections.singletonList(Component.text("100JGPチケットを4枚獲得します。")));
        meta.setCustomModelData(999);
        pane_100_4.setItemMeta(meta);

        pane_100_8 = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE);
        meta = pane_100_8.getItemMeta();
        meta.displayName(Component.text("100JGPチケット x8", TextColor.color(0xffff00)));
        meta.lore(Collections.singletonList(Component.text("100JGPチケットを8枚獲得します。")));
        meta.setCustomModelData(999);
        pane_100_8.setItemMeta(meta);

        pane_100_16 = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE);
        meta = pane_100_16.getItemMeta();
        meta.displayName(Component.text("100JGPチケット x16", TextColor.color(0xffff00)));
        meta.lore(Collections.singletonList(Component.text("100JGPチケットを16枚獲得します。")));
        meta.setCustomModelData(999);
        pane_100_16.setItemMeta(meta);
        pane_1000_1 = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
        meta = pane_1000_1.getItemMeta();
        meta.displayName(Component.text("1000JGPチケット x1", TextColor.color(0x7fff00)));
        meta.lore(Collections.singletonList(Component.text("1000JGPチケットを1枚獲得します。")));
        meta.setCustomModelData(999);
        pane_1000_1.setItemMeta(meta);

        pane_1000_4 = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
        meta = pane_1000_4.getItemMeta();
        meta.displayName(Component.text("1000JGPチケット x4", TextColor.color(0x7fff00)));
        meta.lore(Collections.singletonList(Component.text("1000JGPチケットを4枚獲得します。")));
        meta.setCustomModelData(999);
        pane_1000_4.setItemMeta(meta);

        pane_1000_8 = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
        meta = pane_1000_8.getItemMeta();
        meta.displayName(Component.text("1000JGPチケット x8", TextColor.color(0x7fff00)));
        meta.lore(Collections.singletonList(Component.text("1000JGPチケットを8枚獲得します。")));
        meta.setCustomModelData(999);
        pane_1000_8.setItemMeta(meta);

        pane_1000_16 = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
        meta = pane_1000_16.getItemMeta();
        meta.displayName(Component.text("1000JGPチケット x16", TextColor.color(0x7fff00)));
        meta.lore(Collections.singletonList(Component.text("1000JGPチケットを16枚獲得します。")));
        meta.setCustomModelData(999);
        pane_1000_16.setItemMeta(meta);
        pane_10000_1 = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
        meta = pane_10000_1.getItemMeta();
        meta.displayName(Component.text("10000JGPチケット x1", TextColor.color(0x00ff00)));
        meta.lore(Collections.singletonList(Component.text("10000JGPチケットを1枚獲得します。")));
        meta.setCustomModelData(999);
        pane_10000_1.setItemMeta(meta);

        pane_10000_4 = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
        meta = pane_10000_4.getItemMeta();
        meta.displayName(Component.text("10000JGPチケット x4", TextColor.color(0x00ff00)));
        meta.lore(Collections.singletonList(Component.text("10000JGPチケットを4枚獲得します。")));
        meta.setCustomModelData(999);
        pane_10000_4.setItemMeta(meta);

        pane_10000_8 = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
        meta = pane_10000_8.getItemMeta();
        meta.displayName(Component.text("10000JGPチケット x8", TextColor.color(0x00ff00)));
        meta.lore(Collections.singletonList(Component.text("10000JGPチケットを8枚獲得します。")));
        meta.setCustomModelData(999);
        pane_10000_8.setItemMeta(meta);

        pane_10000_16 = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
        meta = pane_10000_16.getItemMeta();
        meta.displayName(Component.text("10000JGPチケット x16", TextColor.color(0x00ff00)));
        meta.lore(Collections.singletonList(Component.text("10000JGPチケットを16枚獲得します。")));
        meta.setCustomModelData(999);
        pane_10000_16.setItemMeta(meta);

        pane_ott = new ItemStack(Material.PAPER);
        meta = pane_ott.getItemMeta();
        meta.displayName(Component.text("オンタイムチケット", TextColor.color(0x55ff55)));
        meta.lore(Arrays.asList(
                Component.text("ログインしていると一定時間ごとにもらえる。", TextColor.color(0xffffff)),
                Component.text("換金、特殊アイテムとの交換等に使える。", TextColor.color(0xffffff))
        ));
        meta.addEnchant(Enchantment.DURABILITY, 0, false);
        meta.setCustomModelData(0);
        pane_ott.setItemMeta(meta);
        pane_ott.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        pane_otp_100 = new ItemStack(Material.BLUE_STAINED_GLASS_PANE);
        meta = pane_otp_100.getItemMeta();
        meta.displayName(Component.text("OTP 100 → JGP 1000", TextColor.color(0x0000ff)));
        meta.lore(Arrays.asList(
                Component.text("OTPをJGPに変換します。"),
                Component.text("注意！JGPに変換したOTPはOTPに戻すことができません！")
        ));
        meta.setCustomModelData(999);
        pane_otp_100.setItemMeta(meta);

        pane_otp_500 = new ItemStack(Material.BLUE_STAINED_GLASS_PANE);
        meta = pane_otp_500.getItemMeta();
        meta.displayName(Component.text("OTP 500 → JGP 5000", TextColor.color(0x0000ff)));
        meta.lore(Arrays.asList(
                Component.text("OTPをJGPに変換します。"),
                Component.text("注意！JGPに変換したOTPはOTPに戻すことができません！")
        ));
        meta.setCustomModelData(999);
        pane_otp_500.setItemMeta(meta);

        pane_otp_1000 = new ItemStack(Material.BLUE_STAINED_GLASS_PANE);
        meta = pane_otp_1000.getItemMeta();
        meta.displayName(Component.text("OTP 1000 → JGP 10000", TextColor.color(0x0000ff)));
        meta.lore(Arrays.asList(
                Component.text("OTPをJGPに変換します。"),
                Component.text("注意！JGPに変換したOTPはOTPに戻すことができません！")
        ));
        meta.setCustomModelData(999);
        pane_otp_1000.setItemMeta(meta);

        pane_otp_5000 = new ItemStack(Material.BLUE_STAINED_GLASS_PANE);
        meta = pane_otp_5000.getItemMeta();
        meta.displayName(Component.text("OTP 5000 → JGP 50000", TextColor.color(0x0000ff)));
        meta.lore(Arrays.asList(
                Component.text("OTPをJGPに変換します。"),
                Component.text("注意！JGPに変換したOTPはOTPに戻すことができません！")
        ));
        meta.setCustomModelData(999);
        pane_otp_5000.setItemMeta(meta);

        pane_restore = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE);
        meta = pane_restore.getItemMeta();
        meta.displayName(Component.text("全てのチケットをJGPに戻す", TextColor.color(0x7f00ff)));
        meta.lore(Collections.singletonList(Component.text("JGPチケットを全てJGPに戻します。")));
        meta.setCustomModelData(999);
        pane_restore.setItemMeta(meta);

        pane_cancel = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        meta = pane_cancel.getItemMeta();
        meta.displayName(Component.text("メニューを閉じる", TextColor.color(0xff0000)));
        meta.lore(Collections.singletonList(Component.text("このメニューを閉じます。")));
        meta.setCustomModelData(999);
        pane_cancel.setItemMeta(meta);
    }

    @Override
    public @NotNull Inventory getInventory() {
        return Bukkit.createInventory(this, 27);
    }
}
