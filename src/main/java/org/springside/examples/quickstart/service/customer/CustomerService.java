package org.springside.examples.quickstart.service.customer;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springside.examples.quickstart.entity.Customer;
import org.springside.examples.quickstart.repository.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springside.modules.persistence.DynamicSpecifications;
import org.springside.modules.persistence.SearchFilter;
import org.springside.modules.persistence.SearchFilter.Operator;


//Spring Bean的标识.
@Component
//默认将类中的所有public函数纳入事务管理.
@Transactional
public class CustomerService {
	@Resource
	private CustomerDao customerDao;

	public Customer getCustomer(Long id) {
		return customerDao.findOne(id);
	}
	public void saveCustomer(Customer entity) {
		customerDao.save(entity);
	}
	public void deleteCustomer(Long id) {
		customerDao.delete(id);
	}
	public List<Customer> getAllCustomer() {
		return (List<Customer>) customerDao.findAll();
	}
	public List<Customer> getCustomerByMemid(Long memberId){
		return customerDao.findByAdduser(memberId);
	}
	public Page<Customer> getUserCustomer(Long userId, Map<String, Object> searchParams, int pageNumber, int pageSize,
			String sortType) {
		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
		Specification<Customer> spec = buildSpecification(userId, searchParams);

		return customerDao.findAll(spec, pageRequest);
	}
	/**
	 * 创建分页请求.
	 */
	private PageRequest buildPageRequest(int pageNumber, int pagzSize, String sortType) {
		Sort sort = null;
		if ("auto".equals(sortType)) {
			sort = new Sort(Direction.DESC, "id");
		} else if ("title".equals(sortType)) {
			sort = new Sort(Direction.ASC, "title");
		}

		return new PageRequest(pageNumber - 1, pagzSize, sort);
	}

	/**
	 * 创建动态查询条件组合.
	 */
	private Specification<Customer> buildSpecification(Long adduser, Map<String, Object> searchParams) {
		Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
		filters.put("member.id", new SearchFilter("member.id", Operator.EQ, adduser));
		Specification<Customer> spec = DynamicSpecifications.bySearchFilter(filters.values(), Customer.class);
		return spec;
	}
	@Autowired
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
}
