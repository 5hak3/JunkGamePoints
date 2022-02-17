package net.azisaba.jg.junkgamespoints.commands;

import net.azisaba.jg.junkgamespoints.utils.JGPTickets;
import net.azisaba.jg.junkgamespoints.utils.ResultReasons;
import net.azisaba.jg.junkgamespoints.utils.Vault;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class JGP2Ticket extends PointOperations{
    public JGP2Ticket() {
        this.insufFunds = Component.text("残高不足です！", TextColor.color(0xff0000));
        this.success = Component.text("チケット化に成功しました！", TextColor.color(0x00ffff));
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Component.text("このコマンドはプレイヤー専用です。", TextColor.color(0xff0000)));
            return false;
        }
        if (args.length != 2) {
            sender.sendMessage(Component.text("チケットの種類と数を指定してください。", TextColor.color(0xff0000)));
            sender.sendMessage(Component.text("チケットの種類は {10, 100, 1000, 10000} から選んでください。",
                    TextColor.color(0xff0000)));
            return false;
        }


        ItemStack ticket;
        switch (args[0]) {
            case "10":
                ticket = JGPTickets.jgpTicket10;
                break;

            case "100":
                ticket = JGPTickets.jgpTicket100;
                break;

            case "1000":
                ticket = JGPTickets.jgpTicket1000;
                break;

            case "10000":
                ticket = JGPTickets.jgpTicket10000;
                break;

            default:
                sender.sendMessage(Component.text(args[0] + "は有効なチケットの種類ではありません。",
                        TextColor.color(0xff0000)));
                sender.sendMessage(Component.text("チケットの種類は {10, 100, 1000, 10000} から選んでください。",
                        TextColor.color(0xff0000)));
                return false;
        }

        int amount = Integer.parseInt(args[1]);
        if (!(amount > 0 && amount < 65)) {
            sender.sendMessage(Component.text(args[1] + "は有効な数ではありません。",
                    TextColor.color(0xff0000)));
            sender.sendMessage(Component.text("チケットの数は1から64の間の整数で指定してください。",
                    TextColor.color(0xff0000)));
            return false;
        }
        ticket.setAmount(amount);

        String[] reformatArgs = {
                sender.getName(),
                String.valueOf(Double.parseDouble(args[0]) * Double.parseDouble(args[1]))
        };
        if (super.onCommand(sender, command, label, reformatArgs)) {
            ((Player) sender).getInventory().addItem(ticket);
            Bukkit.getServer().getLogger().info(
                    "[LOG/JGP2Ticket] " + sender.getName() + " が " + ticket.getItemMeta().displayName() + " を " + amount + " 枚入手しました。"
            );
            return true;
        }

        sender.sendMessage(Component.text("処理に失敗したため取り消しました。", TextColor.color(0xff0000)));
        return false;
    }

    @Override
    protected ResultReasons operation(@NotNull OfflinePlayer player, @NotNull Double amount) {
        if (amount < 0) return ResultReasons.NEGATIVE_AMOUNT;
        Economy vault = Vault.vault;
        if (vault.getBalance(player) < amount) return ResultReasons.INSUFFICIENT_FUNDS;
        vault.withdrawPlayer(player, amount);
        return ResultReasons.SUCCESS;
    }
}
