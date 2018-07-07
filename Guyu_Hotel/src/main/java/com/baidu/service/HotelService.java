package com.baidu.service;

import java.util.List;

import com.baidu.entity.Room;
import com.baidu.entity.State;
import com.baidu.entity.Type;

public interface HotelService {

	List<Room> hotelList();

	void addRoom(Room room);

	List<Type> getTypeList();

	List<State> getStateList();

	void updateRooms(Room room);

	List<Type> CountList();
	
}
