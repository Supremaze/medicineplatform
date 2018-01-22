package org.springside.examples.quickstart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springside.examples.quickstart.entity.Customer;
import org.springside.examples.quickstart.entity.Task;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CustomerDao extends PagingAndSortingRepository<Customer, Long>,JpaSpecificationExecutor<Customer>{
	//Customer findByAdduser(String adduser);
//	Page<Customer> findByUserId(Long id, Pageable pageRequest);
//	@Modifying
//	@Query("delete from Customer customer where customer.id=?1")
//	void deleteByUserId(Long id);
	
	@Modifying
	@Query("select p from Customer p where member_id=?1")
	List<Customer> findByAdduser(Long memid);
	
//	Customer findByAdduser(String adduser);
//	@Modifying
//	@Query("select p from Customer p where member_id=?1 and status=2")
//	List<Customer> getCustomerCheck(Long memid);
}
