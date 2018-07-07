package com.baidu.mapper;

import com.baidu.entity.State;

public interface StateMapper {
    int deleteByPrimaryKey(Integer sid);

    int insert(State record);

    int insertSelective(State record);

    State selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(State record);

    int updateByPrimaryKey(State record);
}