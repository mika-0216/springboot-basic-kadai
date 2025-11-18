package com.example.springkadaitodo.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "todos")//テーブルの名前紐付け
@Data//ゲッターセッターを自動で！
public class ToDo {
	
	@Id//プライマリーキーがついてたら
	//aboutついてたら
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//JavaフィールドはDBのidカラムに結びついてる
	//テーブルに書いてるものは定義する
	@Column(name = "id")
	private Integer id;
	//JavaのtitleフィールドはDBのtitleカラムと紐づく
	@Column(name = "title")
    private String title;
	// DBのpriority カラムと紐づく
	@Column(name = "priority")
    private String priority;
	//DBのstatus カラムと対応
    @Column(name = "status")
    private String status;

}
