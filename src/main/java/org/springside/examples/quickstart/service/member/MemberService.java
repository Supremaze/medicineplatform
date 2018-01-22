package org.springside.examples.quickstart.service.member;


import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springside.examples.quickstart.entity.Member;
import org.springside.examples.quickstart.entity.Task;
import org.springside.examples.quickstart.repository.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springside.examples.quickstart.repository.TaskDao;
import org.springside.modules.persistence.DynamicSpecifications;
import org.springside.modules.persistence.SearchFilter;
import org.springside.modules.persistence.SearchFilter.Operator;
import org.springframework.data.repository.CrudRepository;

//Spring Bean的标识.
@Component
//默认将类中的所有public函数纳入事务管理.
@Transactional
public class MemberService {
	
	private MemberDao memberDao;
	
	public Member getMember(Long id) {
		return memberDao.findOne(id);
	}
	public void saveMember(Member entity) {
		memberDao.save(entity);
	}
	public void deleteMember(Long id) {
		memberDao.delete(id);
	}
	public List<Member> getAllMember() {
		return (List<Member>) memberDao.findAll();
	}
	
	
	public Page<Member> getMember(Long id, Map<String, Object> searchParams, int pageNumber, int pageSize,
			String sortType) {
		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
		Specification<Member> spec = buildSpecification(id, searchParams);

		return memberDao.findAll(pageRequest);
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
	private Specification<Member> buildSpecification(Long id, Map<String, Object> searchParams) {
		Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
		filters.put("user.id", new SearchFilter("user.id", Operator.EQ, id));
		Specification<Member> spec = DynamicSpecifications.bySearchFilter(filters.values(), Member.class);
		return spec;
	}
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
}
