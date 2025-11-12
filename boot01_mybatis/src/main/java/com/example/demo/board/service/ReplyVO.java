package com.example.demo.board.service;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class ReplyVO {

	private int rno;
	private Long bno;
	private String reply;
//	@JsonProperty("writer")
	private String replyer;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date replydate;
	@JsonIgnore
	private Date updatedate;


}
