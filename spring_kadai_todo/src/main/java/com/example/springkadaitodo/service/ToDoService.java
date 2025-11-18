package com.example.springkadaitodo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springkadaitodo.entity.ToDo;
import com.example.springkadaitodo.repository.ToDoRepository;

//サービス層であることをSpringに知らせる
@Service
public class ToDoService {
	//データベース操作を行うリポジトリ
	private final ToDoRepository toDoRepository;
	//ToDoRepositoryをコンストラクタの引数で受け取りフィールドに代入
	public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public List<ToDo> getAllTodos() {
        return toDoRepository.findAll();
    }

}
