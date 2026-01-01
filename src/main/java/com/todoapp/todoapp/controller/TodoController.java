package com.todoapp.todoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.todoapp.todoapp.model.TodoItem;
import com.todoapp.todoapp.repository.TodoItemRepository;

@Controller
public class TodoController {
    @Autowired
    private TodoItemRepository todoItemRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("todoItems", todoItemRepository.findAll());
        return "index";
    }

    @PostMapping("/add")
    public String addTodo(@ModelAttribute TodoItem todoItem) {
        todoItemRepository.save(todoItem);
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Long id) {
        todoItemRepository.deleteById(id);
        return "redirect:/";
    }

    @PostMapping("/update")
    public String updateTodo(@ModelAttribute TodoItem todoItem) {
        todoItemRepository.save(todoItem);
        return "redirect:/";
    }

}