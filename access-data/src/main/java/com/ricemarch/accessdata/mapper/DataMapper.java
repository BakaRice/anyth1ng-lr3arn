package com.ricemarch.accessdata.mapper;

import com.ricemarch.accessdata.entity.Data;
import org.springframework.stereotype.Repository;

@Repository
public interface DataMapper {
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