package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.repository.Comment;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.Posts;
import com.example.demo.repository.PostsRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class PostRepositoryTest {

	@Autowired PostsRepository postRepository;
	@Autowired CommentRepository commentRepository;
	@Autowired CustomerRepository customerRepository;
	
	@Test
	public void 일대다_등록_조회() {
		Posts postentity = Posts.builder().title("글제목").content("글내용").author("저자").build();
		Posts postsaved = postRepository.save(postentity);
		Customer customerentity = Customer.builder().name("길동").phone("010-1234-5678").email("d@d.d").build();
		Customer customersaved = customerRepository.save(customerentity);
		commentRepository.save(Comment.builder().content("댓글내용").posts(postentity).build());
								
	}
}
