package com.blank038.rating;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Blank038
 * @since 2022-01-12
 */
public class Rating extends JavaPlugin {
    private static Rating instance;

    @Override
    public void onEnable() {
        instance = this;
        this.loadConfig();
    }

    public void loadConfig() {
        this.saveDefaultConfig();
        this.reloadConfig();
    }

    public static String getString(String key, boolean prefix) {
        return ChatColor.translateAlternateColorCodes('&',
                (prefix ? instance.getConfig().getString("message.prefix") : "")
                        + instance.getConfig().getString(key, ""));
    }

    public static Rating getInstance() {
        return instance;
    }
}
