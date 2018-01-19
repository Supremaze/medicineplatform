package org.springside.examples.quickstart.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springside.examples.quickstart.entity.Record;

public interface RecordDao extends PagingAndSortingRepository<Record, Long> {

}
