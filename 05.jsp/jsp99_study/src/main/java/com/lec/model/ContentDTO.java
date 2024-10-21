package com.lec.model;

public class ContentDTO {
	
	private int bno;
	private String subject;
	private String writer;
	private String content;
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "ContentDTO [bno=" + bno + ", subject=" + subject + ", writer=" + writer + ", content=" + content + "]";
	}
	public boolean matchWriter(String writer) {
		return writer!=null && writer.equals(writer);
	}
	
	
	

}
