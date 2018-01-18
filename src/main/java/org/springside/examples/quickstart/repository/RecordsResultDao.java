package org.springside.examples.quickstart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springside.examples.quickstart.entity.RecordsResult;

public interface RecordsResultDao extends PagingAndSortingRepository<RecordsResult, Long> {

	@Modifying
	@Query("select rresult from RecordsResult rresult where doctor_id=?1 and status=0")
	List<RecordsResult> getUndiagnoseByDocid(Long docid);
}
