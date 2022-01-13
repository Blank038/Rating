package com.blank038.rating.common.dao.basic;

import com.blank038.rating.bukkit.Rating;
import com.blank038.rating.common.dao.IDataTransfer;
import com.blank038.rating.common.data.RateData;
import com.mc9y.blank038api.util.mysql.MySqlStorageHandler;

/**
 * @author Blank038
 * @since 2022-01-13
 */
public class MysqlDataTransferModel implements IDataTransfer {

    private final MySqlStorageHandler sqlStorageHandler;

    public MysqlDataTransferModel() {
        String[] sqlArray = {
                "CREATE TABLE IF NOT EXISTS rating_data (user VARCHAR(30) NOT NULL, data TEXT, locked INT, PRIMARY KEY ( user ))"
        };
        this.sqlStorageHandler = new MySqlStorageHandler(Rating.getInstance(), Rating.getInstance().getConfig().getString("data-option.mysql.url"),
                Rating.getInstance().getConfig().getString("data-option.mysql.user"), Rating.getInstance().getConfig().getString("data-option.mysql.password"), sqlArray);
        this.sqlStorageHandler.setCheckConnection(true);
        this.sqlStorageHandler.setReconnectionQueryTable("fire_system");
    }

    @Override
    public boolean checkStatus() {
        return false;
    }

    @Override
    public void load() {

    }

    @Override
    public void unload() {

    }

    @Override
    public void loadAllRateData() {

    }

    @Override
    public void update(RateData rateData) {

    }
}
