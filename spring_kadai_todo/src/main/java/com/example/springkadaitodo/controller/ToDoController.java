package com.example.springkadaitodo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.springkadaitodo.entity.ToDo;
import com.example.springkadaitodo.service.ToDoService;


//SpringにこのクラスはWebのコントローラ（画面表示向け）です」と伝えるアノテーション。
@Controller
public class ToDoController {
	
	//サービス層（ToDoService）への参照 を保持するフィールド。
	private final ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping("/todo")
    public String showTodoList(Model model) {
    	
    	//ServiceにToDoの一覧をちょうだいと頼む行。
        List<ToDo> todos = toDoService.getAllTodos();
        //取得したtodosリストをModelにtodosというキーで入れます。
        model.addAttribute("todos", todos);
        //このStringをもとにtodoView.html を探します。
        return "todoView";
    }

}
