package org.springside.examples.quickstart.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springside.examples.quickstart.entity.Customer;
import org.springside.examples.quickstart.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CustomerDao extends PagingAndSortingRepository<Customer, Long>,JpaSpecificationExecutor<Task>{
	//Customer findByAdduser(String adduser);
	Page<Customer> findByUserId(Long id, Pageable pageRequest);
	@Modifying
	@Query("delete from Customer customer where customer.id=?1")
	void deleteByUserId(Long id);
}
