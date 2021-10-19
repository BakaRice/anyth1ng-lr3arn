
package com.ricemarch.accessdata.service;
/**
 * @mbg.generated generator on Tue Oct 19 10:03:44 CST 2021
 */

import com.ricemarch.accessdata.entity.Data;
import com.ricemarch.accessdata.mapper.DataMapper;
import org.springframework.stereotype.Service;

@Service
public class DataServiceImpl implements DataService {
    private final DataMapper dataMapper;

    public DataServiceImpl(DataMapper dataMapper) {
        this.dataMapper = dataMapper;
    }

    /**
     * deleteByPrimaryKey
     *
     * @param id id
     * @return int int
     */
    @Override
    public int deleteByPrimaryKey(Long id) {
        return dataMapper.deleteByPrimaryKey(id);
    }

    /**
     * insert
     *
     * @param record record
     * @return int int
     */
    @Override
    public int insert(Data record) {
        return dataMapper.insert(record);
    }

    /**
     * insertSelective
     *
     * @param record record
     * @return int int
     */
    @Override
    public int insertSelective(Data record) {
        return dataMapper.insertSelective(record);
    }

    /**
     * selectByPrimaryKey
     *
     * @param id id
     * @return Data Data
     */
    @Override
    public Data selectByPrimaryKey(Long id) {
        return dataMapper.selectByPrimaryKey(id);
    }

    /**
     * updateByPrimaryKeySelective
     *
     * @param record record
     * @return int int
     */
    @Override
    public int updateByPrimaryKeySelective(Data record) {
        return dataMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * updateByPrimaryKey
     *
     * @param record record
     * @return int int
     */
    @Override
    public int updateByPrimaryKey(Data record) {
        return dataMapper.updateByPrimaryKey(record);
    }
}