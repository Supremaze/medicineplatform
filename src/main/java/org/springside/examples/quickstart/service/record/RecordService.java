package org.springside.examples.quickstart.service.record;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springside.examples.quickstart.entity.Record;
import org.springside.examples.quickstart.repository.RecordDao;

@Component
@Transactional
public class RecordService {
	@Resource
	private RecordDao recDao;
	
	public Record getRecordById(Long id){
		return recDao.findOne(id);
	}
	
	public void updateRecord(Record rec){
		recDao.save(rec);
	}

}
