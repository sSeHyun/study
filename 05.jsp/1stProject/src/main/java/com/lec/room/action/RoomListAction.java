package com.lec.room.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.customer.action.Action;
import com.lec.customer.vo.ActionForward;
import com.lec.customer.vo.PageInfo;
import com.lec.room.service.RoomListService;
import com.lec.room.vo.RoomVO;


public class RoomListAction implements Action{
	
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) {
		
		int page=1;
		int limit=10;
		
		int p=1;
		String f="";
		String q="";
		
		if(req.getParameter("p") != null) p = Integer.parseInt(req.getParameter("p"));
		if(req.getParameter("f") != null) f = req.getParameter("f"); else f = "room_id";
		if(req.getParameter("q") != null) q = req.getParameter("q");
		
		
		List<RoomVO> roomList = new ArrayList<>();
		PageInfo pageInfo = new PageInfo();
		
		RoomListService roomListService = RoomListService.getInstance();
		int listCount=roomListService.getListCount(f, q);
		roomList = roomListService.getRoomList(p, limit, f, q);
		
		//페이징 처리
		//1. 총 페이지수 = (총레코드수 / limit ) + 1 
		int totalPage = (int)((double)listCount/limit + 0.95);
				
		//2. 현재페이지 ( 1~10 , 11~20 , 21~30....)
		int startPage = (p-1) / 10 * 10 +1;
				
		//3. 마지막페이지 
		int endPage = startPage + 9;
		endPage= endPage > totalPage ? (totalPage > 0 ? totalPage : 1) : endPage;
				
		pageInfo.setListCount(listCount);
		pageInfo.setPage(p);
		pageInfo.setTotalPage(totalPage);
		pageInfo.setStartPage(startPage);
		pageInfo.setEndPage(endPage);
		
		req.setAttribute("roomList", roomList);
		req.setAttribute("pageInfo", pageInfo);
		
	
		ActionForward forward = new ActionForward();
		forward.setPath(String.format("/room/room_list.jsp?p=%s&f=%s&q=%s", p, f, q));
		return forward;
	}

}
