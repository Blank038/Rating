package com.blank038.rating.gui;

import com.blank038.rating.Rating;
import com.mc9y.blank038api.util.common.CommonUtil;
import com.mc9y.blank038api.util.inventory.GuiModel;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Blank038
 * @since 2022-01-13
 */
public class RatingGui {

    public static void open(Player player, int page) {
        File file = new File(Rating.getInstance().getDataFolder() + "/gui/", "rating.yml");
        FileConfiguration data = YamlConfiguration.loadConfiguration(file);

        GuiModel model = new GuiModel(data.getString("title"), data.getInt("size"));
        // 设置界面物品
        if (data.contains("items")) {
            for (String key : data.getConfigurationSection("items").getKeys(false)) {
                ConfigurationSection section = data.getConfigurationSection("items." + key);
                ItemStack itemStack = new ItemStack(Material.valueOf(section.getString("type")),
                        section.getInt("amount"), (short) section.getInt("data"));
                ItemMeta itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', section.getString("name")));
                List<String> lore = new ArrayList<>();
                for (String text : section.getStringList("lore")) {
                    lore.add(ChatColor.translateAlternateColorCodes('&', text));
                }
                itemMeta.setLore(lore);
                itemStack.setItemMeta(itemMeta);
                for (int slot : CommonUtil.formatSlots(section.getString("slot"))) {
                    model.setItem(slot, itemStack);
                }
            }
        }
        // 设置评论物品


        // 设置界面属性
        model.registerListener(Rating.getInstance());
        model.setCloseRemove(true);
        model.execute((e) -> e.setCancelled(true));
        model.openInventory(player);
    }
}
