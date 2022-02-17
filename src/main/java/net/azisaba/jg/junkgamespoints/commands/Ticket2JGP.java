package net.azisaba.jg.junkgamespoints.commands;

import net.azisaba.jg.junkgamespoints.utils.JGPTickets;
import net.azisaba.jg.junkgamespoints.utils.ResultReasons;
import net.azisaba.jg.junkgamespoints.utils.Vault;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class Ticket2JGP extends PointOperations{
    public Ticket2JGP() {
        this.success = Component.text("ポイント化に成功しました！", TextColor.color(0x00ffff));
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Component.text("このコマンドはプレイヤー専用です。", TextColor.color(0xff0000)));
            return false;
        }

        Player player = (Player) sender;
        Inventory pInv = player.getInventory();
        HashMap<Integer, Integer> counts = new HashMap<>();
        counts.put(10, 0);
        counts.put(100, 0);
        counts.put(1000, 0);
        counts.put(10000, 0);
        for (ItemStack item: pInv.getContents()) {
            if (item == null) continue;
            if (item.getType() == Material.PAPER) {
                if (item.isSimilar(JGPTickets.jgpTicket10)) counts.compute(10, (key, val) -> val+=item.getAmount());
                else if (item.isSimilar(JGPTickets.jgpTicket100)) counts.compute(100, (key, val) -> val+=item.getAmount());
                else if (item.isSimilar(JGPTickets.jgpTicket1000)) counts.compute(1000, (key, val) -> val+=item.getAmount());
                else if (item.isSimilar(JGPTickets.jgpTicket10000)) counts.compute(10000, (key, val) -> val+=item.getAmount());
            }
        }

        int sum = 0;
        for (Map.Entry<Integer, Integer> ent: counts.entrySet()) sum += ent.getKey() * ent.getValue();
        if (sum == 0) {
            sender.sendMessage(Component.text("JGPチケットを1枚も持っていません。", TextColor.color(0xff0000)));
            return false;
        }

        String[] reformatArgs = {
                sender.getName(),
                String.valueOf(sum)
        };
        if (super.onCommand(sender, command, label, reformatArgs)) {
            Bukkit.getServer().getLogger().info(
                    "[LOG/Ticket2JGP] " + sender.getName() + " が " + sum + "Pt 獲得しました。"
            );
            ItemStack delItem;
            if (counts.get(10) != 0) {
                delItem = JGPTickets.jgpTicket10;
                delItem.setAmount(counts.get(10));
                pInv.remove(delItem);
            }
            if (counts.get(100) != 0) {
                delItem = JGPTickets.jgpTicket100;
                delItem.setAmount(counts.get(100));
                pInv.remove(delItem);
            }
            if (counts.get(1000) != 0) {
                delItem = JGPTickets.jgpTicket1000;
                delItem.setAmount(counts.get(1000));
                pInv.remove(delItem);
            }
            if (counts.get(10000) != 0) {
                delItem = JGPTickets.jgpTicket10000;
                delItem.setAmount(counts.get(10000));
                pInv.remove(delItem);
            }
            return true;
        }

        sender.sendMessage(Component.text("処理に失敗したため取り消しました。", TextColor.color(0xff0000)));
        return false;
    }

    @Override
    protected ResultReasons operation(@NotNull OfflinePlayer player, @NotNull Double amount) {
        if (amount < 0) return ResultReasons.NEGATIVE_AMOUNT;
        Economy vault = Vault.vault;
        vault.depositPlayer(player, amount);
        return ResultReasons.SUCCESS;
    }
}
