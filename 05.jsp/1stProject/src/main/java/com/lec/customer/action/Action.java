package com.lec.customer.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.customer.vo.ActionForward;

public interface Action {

	public ActionForward execute(HttpServletRequest req, HttpServletResponse res);
}
