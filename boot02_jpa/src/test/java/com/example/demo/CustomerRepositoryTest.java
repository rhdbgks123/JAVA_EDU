package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;

import com.example.demo.repository.Address;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.Customer;
import com.example.demo.repository.CustomerNative;
import com.example.demo.repository.CustomerRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class CustomerRepositoryTest {

	@Autowired CustomerRepository customerRepository;
	@Autowired AddressRepository addressRepository;
	
	@Test
	public void 고객등록() {
//		customerRepository.save(customer);
	}
	
//	@AfterEach
	void cleanup() {
		customerRepository.deleteAll();
	}

	@Disabled
	@Transactional
	@Commit
	@Test
	public void 고객_조회() {
		//given
		String name = "홍길동";
		String phone = "017";
		Customer customer = Customer.builder().name(name).phone(phone).build();
		customerRepository.save(customer);
		//when
		List<Customer> customerList = (List<Customer>) customerRepository.findAll();
		//then
		assertEquals(customerList.get(0).getName(), name);
		log.info("조회된 고객 이름: {}", customerList.get(0).getName());
	 }
	
	@Disabled
	@Test
	public void 고객_수정() {
		// given - 초기 데이터 저장
		String name = "홍길동";
		String phone = "011";
		Customer saved = customerRepository.save(Customer.builder().name(name).phone(phone).build());
		// when - 고객 정보 수정
		Customer customer = customerRepository.findById(saved.getId()).orElse(new Customer());
		customer.updateNameAndEmail("둘리", "");
		Customer updated = customerRepository.save(customer);
		customer.updateNameAndEmail("둘리", "b@a.a");
		 updated = customerRepository.save(customer);
		//then
		assertEquals(updated.getName(), customer.getName());
		log.info("수정된 고객 이름: {}", updated.getName());
	}
	@Disabled
	@Test
	public void 이름조회() {
		String name = "둘리";
		List<Customer> list1  = customerRepository.findByName(name);
		List<Customer> list2  = customerRepository.findByNameLike("%" + "둘" + "%");
		list2.stream().forEach(cust -> System.out.println(cust.getName()));
		
		assertEquals(list1.get(0).getName(), name);
		
	}
	@Disabled
	@Test
	public void 이메일조회() {
		String email = "b";
		List<Customer> list = customerRepository.findByEmailContainingOrNameContaining(email,"길");
		list.stream().forEach(cust -> System.out.println(cust.getEmail()));
	}
	@Disabled
	@Test
	public void 네이티브_쿼리() {
		List<Object[]> list = customerRepository.findAllNative("017","둘리");
		for(Object[] data : list) {
			System.out.println(data[0].toString());
		}
		
		List<CustomerNative[]> list2 = customerRepository.findAllNativeVO("017", "둘리");
		for(CustomerNative[] data : list2) {
			System.out.println(data[0].toString());
			System.out.println(Arrays.toString(data));
		}
				
	}
	@Disabled
	@Test
	public void jpql_test() {
		List<Customer> list = customerRepository.findAllquery();
		list.stream().forEach(cust -> System.out.println(cust.getName()));
	}
	
	@Test
	public void 일대다() {
		// given(준비)
		Customer customerentity = Customer.builder()
                .name("길동")
                .phone("010-1234-5678")
                .email("d@d.d")
                .build();
		Customer saved = customerRepository.save(customerentity);
		; 
		addressRepository.save(Address.builder().zipcode("04411").address("대구").customer(customerentity).build());
		addressRepository.save(Address.builder().zipcode("04412").address("경산").customer(customerentity).build());
		//when(실행)
		Customer customer = customerRepository.findById(saved.getId()).get();
		customer.getAddress().forEach(addr -> System.out.println(addr.getZipcode() + ":" + addr.getAddress()));
//		log.info(customer.getName()+":"+customer.getAddress().getZipcode());
		//then(검증)
		assertEquals("04411", customer.getAddress().get(0).getZipcode());
	}
}
