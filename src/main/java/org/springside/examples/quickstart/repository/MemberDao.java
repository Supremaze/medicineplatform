package org.springside.examples.quickstart.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springside.examples.quickstart.entity.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberDao extends PagingAndSortingRepository<Member, Long> {
	Member findByUsername(String username);
	
	@Modifying
	@Query("delete from Member m where m.id=?1")
	void deleteByUserId(Long id);
}
