package com.lec.room.action;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFrame;

import com.lec.customer.action.Action;
import com.lec.customer.vo.ActionForward;
import com.lec.room.service.RoomPickDateService;
import com.lec.room.vo.RoomVO;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class RoomPickDateAction extends JFrame implements Action {
	
	public RoomPickDateAction () {
		UtilDateModel model = new UtilDateModel();	//날짜 저장 및 관리 UtilDateModel() 객체 생성
		JDatePanelImpl datePanel = new JDatePanelImpl(model);	//날짜 선택 JDatePanelImpl(model) 을 인자로 전달
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
		add(datePicker);
		setBounds(300,300,400,400);
			
		model.addPropertyChangeListener(new PropertyChangeListener() {
				
		@Override
		public void propertyChange(PropertyChangeEvent evt) {
			if("value".equals(evt.getPropertyName())) {
					System.out.println(model.getValue());
				}
			}
		});
		setVisible(true);
	}
	
	
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) {
		
		String room_id = req.getParameter("room_id");
		
		RoomPickDateService pickDateService = RoomPickDateService.getInstance();
		RoomVO room = pickDateService.getPickDateRoom(room_id);
		
		ActionForward forward = new ActionForward();
		req.setAttribute("room", room);
		
		forward.setPath(String.format("/room/room_pickdate.jsp?room_id=%s",room_id));
		
		return forward;
	}
	
	
}
