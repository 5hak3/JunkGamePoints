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

public class GivePoint extends PointOperations{
    public GivePoint() {
        this.argLenErr = Component.text("付与先とポイント数を指定してください．", TextColor.color(0xff0000));
        this.negAmount = Component.text("付与するポイント数は正数を指定してください．", TextColor.color(0xff0000));
        this.success = Component.text("付与に成功しました！", TextColor.color(0x00ffff));
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (super.onCommand(sender, command, label, args)) {
            if (args.length < 3) {
                Bukkit.getServer().getLogger().info(
                        "[LOG/GivePt] " + sender.getName() + " が " + args[0] + " に " + args[1] + "Pt 付与しました．"
                );
            }
            else {
                Bukkit.getServer().getLogger().info(
                        "[LOG/GivePt] " + args[2] + " が " + args[0] + " に " + args[1] + "Pt 付与しました．"
                );
            }
            return true;
        }

        sender.sendMessage(Component.text("処理に失敗したため取り消しました．", TextColor.color(0xff0000)));
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
