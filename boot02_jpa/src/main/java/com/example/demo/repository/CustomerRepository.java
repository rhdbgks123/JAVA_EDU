package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

// JpaRepository 상속<연결할class, 키값의 데이터타입>
public interface CustomerRepository extends JpaRepository<Customer, Long>{

	List<Customer> findByName(String name);
	List<Customer> findByNameLike(String name);
	List<Customer> findByEmailContainingOrNameContaining(String email, String name);
	
	
//	@Query(value="select * from customer where phone = ?1 or name like ?2",nativeQuery = true)
	@Query(value="select * from customer where phone = :phone or name = :name",nativeQuery = true)
	List<Object[]> findAllNative(@Param("phone")String phone,@Param("name") String name);
	
	@Query(value="select * from customer where phone = :phone or name = :name",nativeQuery = true)
	List<CustomerNative[]> findAllNativeVO(@Param("phone")String phone,@Param("name") String name);
	
	@Query("select c from Customer c order by id desc")
	List<Customer> findAllquery();
}
