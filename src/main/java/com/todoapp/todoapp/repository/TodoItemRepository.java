package com.todoapp.todoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todoapp.todoapp.model.TodoItem;

public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {

}