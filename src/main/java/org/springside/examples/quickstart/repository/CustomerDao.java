package org.springside.examples.quickstart.repository;

import org.springside.examples.quickstart.entity.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

public  interface CustomerDao extends PagingAndSortingRepository<Customer, Long>{
	Customer findByAdduser(int adduser);
}
