package com.blank038.rating.bukkit.command;

import com.blank038.rating.bukkit.Rating;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author Blank038
 * @since 2022-01-13
 */
public class RateCommand implements CommandExecutor {
    private final Rating instance = Rating.getInstance();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length == 0) {
            this.sendHelp(commandSender, s);
        } else {
            switch (strings[0]) {
                case "reload":
                    this.reloadConfig(commandSender);
                    break;
                case "rate":
                    this.callRate(commandSender);
                    break;
                default:
                    this.sendHelp(commandSender, s);
                    break;
            }
        }
        return false;
    }

    /**
     * 发送命令帮助
     */
    private void sendHelp(CommandSender sender, String label) {
        for (String line : instance.getConfig().getStringList("message.help."
                + (sender.hasPermission("rating.admin") ? "admin" : "default"))) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', line)
                    .replace("%c", label));
        }
    }

    /**
     * 插件配置重载命令
     */
    private void reloadConfig(CommandSender sender) {
        if (sender.hasPermission("rating.admin")) {
            instance.loadConfig();
            sender.sendMessage(Rating.getString("message.reload", true));
        }
    }

    /**
     * 评分命令
     */
    private void callRate(CommandSender sender) {
        if (sender instanceof Player) {

        }
    }
}
