package org.springside.examples.quickstart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springside.examples.quickstart.entity.Customer;

public interface CustomerDao extends PagingAndSortingRepository<Customer, Long>{
	Customer findByAdduser(String adduser);
}
//fffff