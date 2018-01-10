package com.tutorial.springboot.service;

import com.tutorial.springboot.model.Todo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component("todoService")
public class TodoService {
	private static List<Todo> todoList = new ArrayList<>();
	private static Long toDoCount = 3l;

	static {
		todoList.add(new Todo(1l, "Ramesh", "Learn Spring MVC", new Date(), false));
		todoList.add(new Todo(2l, "Ramesh", "Learn Struts", new Date(), false));
		todoList.add(new Todo(3l, "Ramesh", "Learn Hibernate", new Date(), false));
	}

	public List<Todo> getTodoList(String username) {
		return todoList.stream().filter(todo -> username.equalsIgnoreCase(todo.getUser())).collect(Collectors.toList());
	}

	public void addTodo(String username, String description, Date targetDate, boolean isDone) {
		todoList.add(new Todo(toDoCount++, username, description, targetDate, isDone));
	}

	public void deleteToDO(Long id) {
		todoList.removeIf(user -> id.equals(user.getId()));
	}

}
