package com.baidu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baidu.entity.Room;
import com.baidu.entity.State;
import com.baidu.entity.Type;
import com.baidu.service.HotelService;

@Controller
public class HotelController {
	@Autowired
	private HotelService hotelService;
	//房间列表
	@RequestMapping("/hotelList")
	@ResponseBody
	public Map<String,Object> hotelList(){
		List<Room> list = hotelService.hotelList();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("rows", list);
		return map;
	}
	//房型下拉列表
	@RequestMapping("/getTypeList")
	@ResponseBody
	public List<Type> getTypeList(){
		List<Type> list = hotelService.getTypeList();
		
		return list;
	}
	//房型统计
	@RequestMapping("/CountList")
	@ResponseBody
	public List<Type> CountList(){
		List<Type> list = hotelService.CountList();
		
		return list;
	}
	@RequestMapping("/getStateList")
	@ResponseBody
	public List<State> getStateList(){
		List<State> list = hotelService.getStateList();
		
		return list;
	}
	//跳转页面
	
	@RequestMapping("/toList")
	public String toList() {
		return "roomList";
	}
	@RequestMapping("/toAdd")
	public String toAdd() {
		return "roomAdd";
	}
	@RequestMapping("/toedit")
	public String toedit() {
		return "roomEdit";
	}
	
	@RequestMapping("/toTotal")
	public String toTotal() {
		return "roomTotal";
	}
	
	//添加房间
	@RequestMapping("addRoom")
	public void addRoom(Room room) {
		hotelService.addRoom(room);
	}
	//添加房间
	@RequestMapping("updateRooms")
	public void updateRooms(Room room) {
		hotelService.updateRooms(room);
	}
}
