package com.lec.cookie;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class Cookies {
	
	private Map<String, Cookie> cookieMap=new HashMap<>();
	
	public static Cookie createCookie(String name,String value) throws Exception {
		return new Cookie(name, URLEncoder.encode(value,"utf-8"));
	}
	
	public static Cookie createCookie(String name,String value,String path,int maxAge) throws Exception {
		
		Cookie cookie= new Cookie(name, URLEncoder.encode(value,"utf-8"));
		
		cookie.setPath(path);
		cookie.setMaxAge(maxAge);
		
		return cookie;
	}
	
	public static Cookie createCookie(String name,String value,String path,int maxAge,String domain) throws Exception {
		
		Cookie cookie= new Cookie(name, URLEncoder.encode(value,"utf-8"));
		
		cookie.setPath(path);
		cookie.setMaxAge(maxAge);
		cookie.setDomain(domain);
		
		return cookie;
	}
	
	
	public Cookies(HttpServletRequest req) {
		
		Cookie[] cookies=req.getCookies();
		
		if(cookies!=null) {
			for(int i=0;i<cookies.length;i++) {
				cookieMap.put(cookies[i].getName(), cookies[i]);
			}
		}
	}
	
	public Cookie getCookie(String name) {
		return cookieMap.get(name);
	}
	
	public String getValue(String name) throws Exception {
		Cookie cookie=cookieMap.get(name);
		if(cookie==null) return null;
		return URLDecoder.decode(cookie.getValue(),"utf-8");
	}
	
	public boolean exits(String name) {
		return cookieMap.get(name)!=null;
		
	}
	
	
}
