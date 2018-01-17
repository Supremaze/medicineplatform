package org.springside.examples.quickstart.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springside.examples.quickstart.entity.Member;

public interface MemberDao extends PagingAndSortingRepository<Member, Long> {
	Member findByUsername(String username);
}
