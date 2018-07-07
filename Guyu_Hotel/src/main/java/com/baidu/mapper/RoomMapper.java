package com.baidu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baidu.entity.Room;
import com.baidu.entity.State;
import com.baidu.entity.Type;
@Mapper
public interface RoomMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Room record);

    int insertSelective(Room record);

    Room selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Room record);

    int updateByPrimaryKey(Room record);

	List<Room> hotelList();

	List<Type> getTypeList();

	List<State> getStateList();

	List<Type> CountList();
}