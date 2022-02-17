package net.azisaba.jg.junkgamespoints.commands;

import net.azisaba.jg.junkgamespoints.utils.ResultReasons;
import net.azisaba.jg.junkgamespoints.utils.Vault;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.milkbowl.vault.economy.Economy;
import org.black_ixx.playerpoints.PlayerPoints;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class OTP2JGP extends PointOperations{
    private static final PlayerPoints playerPoints;
    private static final int rateOTP2JGP;
    static {
        playerPoints = new PlayerPoints();
        rateOTP2JGP = 10;
    }

    public OTP2JGP() {
        this.success = Component.text("変換比" + rateOTP2JGP + "でJGP化に成功しました！", TextColor.color(0x00ffff));
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Component.text("このコマンドはプレイヤー専用です．", TextColor.color(0xff0000)));
            return false;
        }

        Player player = (Player) sender;
        if (args.length != 1) {
            sender.sendMessage(Component.text("変換するOTPの量を指定してください．", TextColor.color(0xff0000)));
            sender.sendMessage(Component.text("現在のOTP残高は /points me コマンドで確認できます．", TextColor.color(0xff0000)));
            return false;
        }

        int amount = Integer.parseInt(args[0]);
        if (amount < 1) {
            sender.sendMessage(Component.text("変換するOTPの量は1以上を指定してください．", TextColor.color(0xff0000)));
            return false;
        }

        if (!takeOTP(player, amount)) {
            sender.sendMessage(Component.text("処理に失敗したため取り消しました．", TextColor.color(0xff0000)));
            return false;
        }

        String[] reformatArgs = {
                sender.getName(),
                String.valueOf(amount * rateOTP2JGP)
        };
        if (super.onCommand(sender, command, label, reformatArgs)) {
            Bukkit.getServer().getLogger().info(
                    "[LOG/OTP2JGP] " + sender.getName() + " が OTP " + amount +
                            "Pt を JGP " + amount * rateOTP2JGP + "Pt に変換しました．"
            );
            return true;
        }

        sender.sendMessage(Component.text("処理に失敗したため取り消しました．このメッセージを運営に見せて補填申請してください．", TextColor.color(0xff0000)));
        return false;
    }

    private boolean takeOTP(Player player, int amount) {
        CompletableFuture<Integer> getPoints = playerPoints.getAPI().lookAsync(player.getUniqueId());
        int hasPoints;
        try {
            hasPoints = getPoints.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            player.sendMessage(Component.text("現在OTPを取得できませんでした．", TextColor.color(0xff0000)));
            return false;
        }
        if (amount > hasPoints) {
            player.sendMessage(Component.text("OTPの残高が不足しています．", TextColor.color(0xff0000)));
            player.sendMessage(Component.text("あなたの現在のOTPは" + hasPoints + "です．", TextColor.color(0xff0000)));
            return false;
        }

        CompletableFuture<Boolean> takePoints = playerPoints.getAPI().takeAsync(player.getUniqueId(), amount);
        try {
            if (takePoints.get()) return true;
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        player.sendMessage(Component.text("不明なエラーです．", TextColor.color(0xff0000)));
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
