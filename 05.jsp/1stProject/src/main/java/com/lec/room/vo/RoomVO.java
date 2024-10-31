package com.lec.room.vo;

public class RoomVO {
	
	private String room_id;
	private int room_peopleCnt;
	private String room_type;
	private String room_price;
	
	public String getRoom_id() {
		return room_id;
	}
	public void setRoom_id(String room_id) {
		this.room_id = room_id;
	}
	public int getRoom_peopleCnt() {
		return room_peopleCnt;
	}
	public void setRoom_peopleCnt(int room_peopleCnt) {
		this.room_peopleCnt = room_peopleCnt;
	}
	public String getRoom_type() {
		return room_type;
	}
	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}
	
	public String getRoom_price() {
		return room_price;
	}
	public void setRoom_price(String room_price) {
		this.room_price = room_price;
	}
	
	@Override
	public String toString() {
		return "RoomVO [room_id=" + room_id + ", room_peopleCnt=" + room_peopleCnt + ", room_type=" + room_type
				+ ", room_price=" + room_price + "]";
	}


}
