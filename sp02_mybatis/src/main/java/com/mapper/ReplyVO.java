package com.mapper;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {

	private int rno;
	private int bno;
	private String reply;
	private String writer;
	private Date regdate;
	private Date updatedate;


}
