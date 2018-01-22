package org.springside.examples.quickstart.service.check;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springside.examples.quickstart.entity.RecordsResult;
import org.springside.examples.quickstart.repository.RecordsResultDao;

//Spring Service Bean的标识.
@Component
@Transactional
public class CheckDoctorService {
	@Resource
	private RecordsResultDao rresultDao;
	
	public List<RecordsResult> getUndiagnoseByDocid(Long docid){
		return rresultDao.getUndiagnoseByDocid(docid);
	}
	public List<RecordsResult> getDiagnoseByDocid(Long docid){
		return rresultDao.getDiagnoseByDocid(docid);
	}
	
	public RecordsResult getRecordsResultById(Long rrid){
		return rresultDao.findOne(rrid);
	}
	public void updateRResult(RecordsResult rr){
		rresultDao.save(rr);
	}
	

}
