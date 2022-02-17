package net.azisaba.jg.junkgamespoints.commands;

import net.azisaba.jg.junkgamespoints.utils.ResultReasons;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public abstract class PointOperations implements CommandExecutor {
    protected Component argLenErr;
    protected Component negAmount;
    protected Component insufFunds;
    protected Component success;

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length < 2) {
            sender.sendMessage(argLenErr);
            return false;
        }

        OfflinePlayer player = Bukkit.getOfflinePlayer(args[0]);
        Double amount = Double.parseDouble(args[1]);

        ResultReasons res = operation(player, amount);
        if (res == ResultReasons.NEGATIVE_AMOUNT) {
            sender.sendMessage(negAmount);
            return false;
        }
        else if (res == ResultReasons.INSUFFICIENT_FUNDS) {
            sender.sendMessage(insufFunds);
            return false;
        }

        if (sender instanceof Player) {
            sender.sendMessage(success);
            ((Player) sender).playSound(((Player) sender).getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 2.0f);
        }
        return true;
    }

    protected abstract ResultReasons operation(@NotNull OfflinePlayer player, @NotNull Double amount);
}
