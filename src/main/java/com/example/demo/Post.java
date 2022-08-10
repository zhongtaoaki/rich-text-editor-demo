package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Data;

@Data
@Entity
//数据库中保存的entity
public class Post {

	//自动生成的主键
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	
	//标题以String保存
	private String title;
	
	//内容也以String保存
	//使用Lob注释可以突破字符串长度限制并存储图片
	@Lob
	private String content;

}
