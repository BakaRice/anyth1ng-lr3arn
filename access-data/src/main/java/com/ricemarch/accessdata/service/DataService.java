
package com.ricemarch.accessdata.service;
/**
 * @mbg.generated generator on Tue Oct 19 10:03:44 CST 2021
 */

import com.ricemarch.accessdata.entity.Data;

public interface DataService {
    /**
     * deleteByPrimaryKey
     *
     * @param id id
     * @return int int
     */
    int deleteByPrimaryKey(Long id);

    /**
     * insert
     *
     * @param record record
     * @return int int
     */
    int insert(Data record);

    /**
     * insertSelective
     *
     * @param record record
     * @return int int
     */
    int insertSelective(Data record);

    /**
     * selectByPrimaryKey
     *
     * @param id id
     * @return Data Data
     */
    Data selectByPrimaryKey(Long id);

    /**
     * updateByPrimaryKeySelective
     *
     * @param record record
     * @return int int
     */
    int updateByPrimaryKeySelective(Data record);

    /**
     * updateByPrimaryKey
     *
     * @param record record
     * @return int int
     */
    int updateByPrimaryKey(Data record);
}