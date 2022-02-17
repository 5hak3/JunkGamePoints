package net.azisaba.jg.junkgamespoints.commands;

import net.azisaba.jg.junkgamespoints.utils.ResultReasons;
import net.azisaba.jg.junkgamespoints.utils.Vault;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class TakePoint extends PointOperations{
    public TakePoint() {
        this.argLenErr = Component.text("剥奪元とポイント数を指定してください。", TextColor.color(0xff0000));
        this.negAmount = Component.text("剥奪するポイント数は正数を指定してください。", TextColor.color(0xff0000));
        this.insufFunds = Component.text("対象の残高が不足しています。", TextColor.color(0xff0000));
        this.success = Component.text("剥奪に成功しました！", TextColor.color(0x00ffff));
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (super.onCommand(sender, command, label, args)) {
            if (args.length < 3) {
                Bukkit.getServer().getLogger().info(
                        "[LOG/TakePt] " + sender.getName() + " が " + args[0] + " に " + args[1] + "Pt 剥奪しました。"
                );
            }
            else {
                Bukkit.getServer().getLogger().info(
                        "[LOG/TakePt] " + args[2] + " が " + args[0] + " に " + args[1] + "Pt 剥奪しました。"
                );
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
        if (vault.getBalance(player) < amount) return ResultReasons.INSUFFICIENT_FUNDS;
        vault.withdrawPlayer(player, amount);
        return ResultReasons.SUCCESS;
    }
}
