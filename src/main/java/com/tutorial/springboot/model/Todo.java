package com.tutorial.springboot.model;

import java.util.Date;
import java.util.Objects;

public class Todo {
	private Long id;
	private String user;
	private String description;
	private Date targetDate;
	private boolean isDone;

	public Todo(Long id, String user, String description, Date targetDate, boolean isDone) {
		this.id = id;
		this.user = user;
		this.description = description;
		this.targetDate = targetDate;
		this.isDone = isDone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean done) {
		isDone = done;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Todo)) return false;
		Todo todo = (Todo) o;
		return isDone() == todo.isDone() &&
				Objects.equals(getId(), todo.getId()) &&
				Objects.equals(getUser(), todo.getUser()) &&
				Objects.equals(getDescription(), todo.getDescription()) &&
				Objects.equals(getTargetDate(), todo.getTargetDate());
	}

	@Override
	public int hashCode() {

		return Objects.hash(getId(), getUser(), getDescription(), getTargetDate(), isDone());
	}

	@Override
	public String toString() {
		return "Todo{" +
				"id=" + id +
				", user='" + user + '\'' +
				", description='" + description + '\'' +
				", targetDate=" + targetDate +
				", isDone=" + isDone +
				'}';
	}
}
