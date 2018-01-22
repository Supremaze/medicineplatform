package org.springside.examples.quickstart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
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
	List<Customer> findByUserId(Long id, Pageable pageRequest);
//	@Modifying
//	@Query("delete from Customer p where p.id=?1")
//	void deleteByUserId(Long id);
}
