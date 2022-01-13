package com.blank038.rating.dao;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Blank038
 * @since 2022-01-13
 */
public class DataTransferModelManager {
    private final List<IDataTransfer> models = new ArrayList<>();
    private IDataTransfer basicModel;

    public DataTransferModelManager() {
        this.loadBasicModel();
    }

    public void loadBasicModel() {

    }

    public void registerBasicModel(IDataTransfer dataTransfer) {
        if (dataTransfer.checkStatus()) {
            this.basicModel.unload();
            this.basicModel = dataTransfer;
            this.basicModel.load();
        }
    }

    public void unregisterBasicModel() {
        this.basicModel.unload();
        this.loadBasicModel();
    }

    public void registerCoexistModel(IDataTransfer dataTransfer) {
        if (this.models.contains(dataTransfer) || !dataTransfer.checkStatus()) {
            return;
        }
        dataTransfer.load();
        this.models.add(dataTransfer);
    }

    public void unregisterCoexistModel(IDataTransfer dataTransfer) {
        if (this.models.contains(dataTransfer)) {
            this.models.remove(dataTransfer);
            dataTransfer.unload();
        }
    }
}