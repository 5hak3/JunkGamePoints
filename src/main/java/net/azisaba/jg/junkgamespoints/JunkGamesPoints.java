package net.azisaba.jg.junkgamespoints;

import net.azisaba.jg.junkgamespoints.commands.*;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class JunkGamesPoints extends JavaPlugin {
    @Override
    public void onEnable() {
        Objects.requireNonNull(getCommand("jgp#give")).setExecutor(new GivePoint());
        Objects.requireNonNull(getCommand("jgp#take")).setExecutor(new TakePoint());
        Objects.requireNonNull(getCommand("jgp2ticket")).setExecutor(new JGP2Ticket());
        Objects.requireNonNull(getCommand("ticket2jgp")).setExecutor(new Ticket2JGP());
        Objects.requireNonNull(getCommand("jgp2ticket")).setExecutor(new JGP2Ticket());
        Objects.requireNonNull(getCommand("otp2jgp")).setExecutor(new OTP2JGP());
        Objects.requireNonNull(getCommand("jgp")).setExecutor(new JGPGUI());
    }
}
