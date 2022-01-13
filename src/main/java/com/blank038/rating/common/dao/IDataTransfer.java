package com.blank038.rating.common.dao;

import com.blank038.rating.common.data.RateData;

/**
 * 数据转换接口
 *
 * @author Blank038
 * @since 2022-01-13
 */
public interface IDataTransfer {

    /**
     * 预加载时检测状态
     *
     * @return 检测结果
     */
    boolean checkStatus();

    /**
     * 开始加载模块
     */
    void load();

    /**
     * 开始卸载模块
     */
    void unload();

    /**
     * 载入所有评分数据
     */
    void loadAllRateData();

    /**
     * 更新或新增数据
     *
     * @param rateData 评分数据
     */
    void update(RateData rateData);
}