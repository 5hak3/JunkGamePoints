package net.azisaba.jg.junkgamespoints.utils;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;

import java.util.Objects;

public class Vault {
    public static final Economy vault;
    static {
        RegisteredServiceProvider<Economy> registration = Bukkit.getServicesManager().getRegistration(Economy.class);
        vault = Objects.requireNonNull(registration).getProvider();
    }
}
