package com.baidu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.entity.Room;
import com.baidu.entity.State;
import com.baidu.entity.Type;
import com.baidu.mapper.RoomMapper;
import com.baidu.service.HotelService;
@Service
public class HotelServiceImpl implements HotelService {
	@Autowired
	private RoomMapper roomMapper;
	
	@Override
	public List<Room> hotelList() {
		// TODO Auto-generated method stub
		return roomMapper.hotelList();
	}

	@Override
	public void addRoom(Room room) {
		// TODO Auto-generated method stub
		roomMapper.insert(room);
	}

	@Override
	public List<Type> getTypeList() {
		// TODO Auto-generated method stub
		return roomMapper.getTypeList();
	}

	@Override
	public List<State> getStateList() {
		// TODO Auto-generated method stub
		return roomMapper.getStateList();
	}

	@Override
	public void updateRooms(Room room) {
		// TODO Auto-generated method stub
		roomMapper.updateByPrimaryKey(room);
	}

	@Override
	public List<Type> CountList() {
		// TODO Auto-generated method stub
		return roomMapper.CountList();
	}

}
