package net.azisaba.jg.junkgamespoints.commands;

import net.azisaba.jg.junkgamespoints.utils.JGPHolder;
import net.azisaba.jg.junkgamespoints.utils.JGPTickets;
import net.azisaba.jg.junkgamespoints.utils.Vault;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

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

        if (clicked.isSimilar(JGPHolder.pane_10_1)) player.performCommand("jgp2ticket 10 1");
        else if (clicked.isSimilar(JGPHolder.pane_10_4)) player.performCommand("jgp2ticket 10 4");
        else if (clicked.isSimilar(JGPHolder.pane_10_8)) player.performCommand("jgp2ticket 10 8");
        else if (clicked.isSimilar(JGPHolder.pane_10_16)) player.performCommand("jgp2ticket 10 16");
        else if (clicked.isSimilar(JGPHolder.pane_100_1)) player.performCommand("jgp2ticket 100 1");
        else if (clicked.isSimilar(JGPHolder.pane_100_4)) player.performCommand("jgp2ticket 100 4");
        else if (clicked.isSimilar(JGPHolder.pane_100_8)) player.performCommand("jgp2ticket 100 8");
        else if (clicked.isSimilar(JGPHolder.pane_100_16)) player.performCommand("jgp2ticket 100 16");
        else if (clicked.isSimilar(JGPHolder.pane_1000_1)) player.performCommand("jgp2ticket 1000 1");
        else if (clicked.isSimilar(JGPHolder.pane_1000_4)) player.performCommand("jgp2ticket 1000 4");
        else if (clicked.isSimilar(JGPHolder.pane_1000_8)) player.performCommand("jgp2ticket 1000 8");
        else if (clicked.isSimilar(JGPHolder.pane_1000_16)) player.performCommand("jgp2ticket 1000 16");
        else if (clicked.isSimilar(JGPHolder.pane_10000_1)) player.performCommand("jgp2ticket 10000 1");
        else if (clicked.isSimilar(JGPHolder.pane_10000_4)) player.performCommand("jgp2ticket 10000 4");
        else if (clicked.isSimilar(JGPHolder.pane_10000_8)) player.performCommand("jgp2ticket 10000 8");
        else if (clicked.isSimilar(JGPHolder.pane_10000_16)) player.performCommand("jgp2ticket 10000 16");
        else if (clicked.isSimilar(JGPHolder.pane_otp_100)) player.performCommand("otp2jgp 100");
        else if (clicked.isSimilar(JGPHolder.pane_otp_500)) player.performCommand("otp2jgp 500");
        else if (clicked.isSimilar(JGPHolder.pane_otp_1000)) player.performCommand("otp2jgp 1000");
        else if (clicked.isSimilar(JGPHolder.pane_otp_5000)) player.performCommand("otp2jgp 5000");
        else if (clicked.isSimilar(JGPHolder.pane_restore)) player.performCommand("ticket2jgp");
        else if (clicked.isSimilar(JGPHolder.pane_cancel)) event.getInventory().close();
        else return;

        player.sendMessage(Component.text("現在所持JGP: " + Vault.vault.getBalance(player), TextColor.color(0x00ffff)));
    }
}
