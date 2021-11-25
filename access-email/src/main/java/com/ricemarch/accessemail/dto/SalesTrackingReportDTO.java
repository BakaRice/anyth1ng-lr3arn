package com.ricemarch.accessemail.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author tanwentao
 * @since 2021/10/25
 */
@Data
@Slf4j
@Accessors(chain = true)
public class SalesTrackingReportDTO {

    /**
     * 门店名称
     */
    private String storeName;

    /**
     * 月份
     */
    private Date month;

    /**
     * 月份 string
     */
    private String monthStr;

    /**
     * 一级业务分类 name
     */
    private String preBusinessCategoryName;

    /**
     * 一级业务分类 code
     */
    private String preBusinessCategoryCode;

    /**
     * 二级业务分类 code
     */
    private String businessCategoryCode;
    /**
     * 二级业务分类 name
     */
    private String businessCategoryName;

    /**
     * 台次
     */
    private Integer goodsCount;

    /**
     * 车辆数
     */
    private Integer carCount;

    /**
     * 营业额
     */
    private BigDecimal turnover;


    /**
     * 毛利
     */
    private BigDecimal grossProfit;

}
