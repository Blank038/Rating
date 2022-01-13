package com.blank038.rating.data;

import org.bukkit.configuration.file.FileConfiguration;

import java.util.UUID;

/**
 * @author Blank038
 * @since 2022-01-13
 */
public class RateData {
    private final UUID rateUUID;
    private final String playerName, text;
    private final int serverId, rate;

    public RateData(String uuid, String playerName, int rate, String text, int sid) {
        this.serverId = sid;
        this.rateUUID = UUID.fromString(uuid);
        this.playerName = playerName;
        this.rate = rate;
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public UUID getRateUUID() {
        return this.rateUUID;
    }

    public int getRate() {
        return this.rate;
    }

    public int getServerId() {
        return this.serverId;
    }
}
