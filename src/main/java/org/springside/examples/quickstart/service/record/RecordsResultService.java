package org.springside.examples.quickstart.service.record;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springside.examples.quickstart.entity.RecordsResult;
import org.springside.examples.quickstart.repository.RecordsResultDao;

//Spring Service Bean的标识.
@Component
@Transactional
public class RecordsResultService {
	
	private RecordsResultDao rresultDao;
	
	public List<RecordsResult> getUndiagnoseByDocid(Long docid){
		return rresultDao.getUndiagnoseByDocid(docid);
	}
	

}
