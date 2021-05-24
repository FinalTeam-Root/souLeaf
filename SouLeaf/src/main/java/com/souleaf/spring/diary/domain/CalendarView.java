package com.souleaf.spring.diary.domain;

public class CalendarView {
	private String title;
	private String start;
	private String end;
	private String color;
	private String constraint;
	
	public CalendarView() {}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getConstraint() {
		return constraint;
	}

	public void setConstraint(String constraint) {
		this.constraint = constraint;
	}

	@Override
	public String toString() {
		return "CalendarView [title=" + title + ", start=" + start + ", end=" + end + ", color=" + color
				+ ", constraint=" + constraint + "]";
	}
	
	
}
