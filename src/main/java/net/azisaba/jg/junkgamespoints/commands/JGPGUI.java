package net.azisaba.jg.junkgamespoints.commands;

import net.azisaba.jg.junkgamespoints.utils.JGPTickets;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collections;

public class JGPGUI implements CommandExecutor, Listener {
    private static final Inventory gui;
    static {
        gui = Bukkit.createInventory(new JGPHolder(), 45, Component.text("JG Point GUI", TextColor.color(0xffff00)));
        gui.setItem(0, JGPTickets.jgpTicket10);
        gui.setItem(1, JGPTickets.jgpTicket100);
        gui.setItem(2, JGPTickets.jgpTicket1000);
        gui.setItem(3, JGPTickets.jgpTicket10000);
        gui.setItem(6, JGPHolder.pane_ott);
        gui.setItem(8, JGPHolder.pane_restore);
        gui.setItem(9, JGPHolder.pane_10_1);
        gui.setItem(10, JGPHolder.pane_100_1);
        gui.setItem(11, JGPHolder.pane_1000_1);
        gui.setItem(12, JGPHolder.pane_10000_1);
        gui.setItem(15, JGPHolder.pane_otp_100);
        gui.setItem(18, JGPHolder.pane_10_4);
        gui.setItem(19, JGPHolder.pane_100_4);
        gui.setItem(20, JGPHolder.pane_1000_4);
        gui.setItem(21, JGPHolder.pane_10000_4);
        gui.setItem(24, JGPHolder.pane_otp_500);
        gui.setItem(27, JGPHolder.pane_10_8);
        gui.setItem(28, JGPHolder.pane_100_8);
        gui.setItem(29, JGPHolder.pane_1000_8);
        gui.setItem(30, JGPHolder.pane_10000_8);
        gui.setItem(33, JGPHolder.pane_otp_1000);
        gui.setItem(36, JGPHolder.pane_10_16);
        gui.setItem(37, JGPHolder.pane_100_16);
        gui.setItem(38, JGPHolder.pane_1000_16);
        gui.setItem(39, JGPHolder.pane_10000_16);
        gui.setItem(42, JGPHolder.pane_otp_5000);
        gui.setItem(44, JGPHolder.pane_cancel);
    }

    private static class JGPHolder implements InventoryHolder {
        private static final ItemStack pane_10_1;
        private static final ItemStack pane_10_4;
        private static final ItemStack pane_10_8;
        private static final ItemStack pane_10_16;
        private static final ItemStack pane_100_1;
        private static final ItemStack pane_100_4;
        private static final ItemStack pane_100_8;
        private static final ItemStack pane_100_16;
        private static final ItemStack pane_1000_1;
        private static final ItemStack pane_1000_4;
        private static final ItemStack pane_1000_8;
        private static final ItemStack pane_1000_16;
        private static final ItemStack pane_10000_1;
        private static final ItemStack pane_10000_4;
        private static final ItemStack pane_10000_8;
        private static final ItemStack pane_10000_16;
        private static final ItemStack pane_ott;
        private static final ItemStack pane_otp_100;
        private static final ItemStack pane_otp_500;
        private static final ItemStack pane_otp_1000;
        private static final ItemStack pane_otp_5000;
        private static final ItemStack pane_restore;
        private static final ItemStack pane_cancel;

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

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Component.text("このコマンドはプレイヤー専用です。", TextColor.color(0xff0000)));
            return false;
        }

        Player player = (Player) sender;
        player.openInventory(gui);
        return true;
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent event) {
        if (!(event.getInventory().getHolder() instanceof JGPHolder)) return;

        event.setCancelled(true);
        Player player = (Player) event.getWhoClicked();
        ItemStack clicked = event.getCurrentItem();
        if (clicked == null) return;

        if (clicked == JGPHolder.pane_10_1) player.performCommand("jgp2ticket 10 1");
        else if (clicked == JGPHolder.pane_10_4) player.performCommand("jgp2ticket 10 4");
        else if (clicked == JGPHolder.pane_10_8) player.performCommand("jgp2ticket 10 8");
        else if (clicked == JGPHolder.pane_10_16) player.performCommand("jgp2ticket 10 16");
        else if (clicked == JGPHolder.pane_100_1) player.performCommand("jgp2ticket 100 1");
        else if (clicked == JGPHolder.pane_100_4) player.performCommand("jgp2ticket 100 4");
        else if (clicked == JGPHolder.pane_100_8) player.performCommand("jgp2ticket 100 8");
        else if (clicked == JGPHolder.pane_100_16) player.performCommand("jgp2ticket 100 16");
        else if (clicked == JGPHolder.pane_1000_1) player.performCommand("jgp2ticket 1000 1");
        else if (clicked == JGPHolder.pane_1000_4) player.performCommand("jgp2ticket 1000 4");
        else if (clicked == JGPHolder.pane_1000_8) player.performCommand("jgp2ticket 1000 8");
        else if (clicked == JGPHolder.pane_1000_16) player.performCommand("jgp2ticket 1000 16");
        else if (clicked == JGPHolder.pane_10000_1) player.performCommand("jgp2ticket 10000 1");
        else if (clicked == JGPHolder.pane_10000_4) player.performCommand("jgp2ticket 10000 4");
        else if (clicked == JGPHolder.pane_10000_8) player.performCommand("jgp2ticket 10000 8");
        else if (clicked == JGPHolder.pane_10000_16) player.performCommand("jgp2ticket 10000 16");
        else if (clicked == JGPHolder.pane_otp_100) player.performCommand("otp2jgp 100");
        else if (clicked == JGPHolder.pane_otp_500) player.performCommand("otp2jgp 500");
        else if (clicked == JGPHolder.pane_otp_1000) player.performCommand("otp2jgp 1000");
        else if (clicked == JGPHolder.pane_otp_5000) player.performCommand("otp2jgp 5000");
        else if (clicked == JGPHolder.pane_restore) player.performCommand("ticket2jgp");
        else if (clicked == JGPHolder.pane_cancel) event.getInventory().close();
    }
}
