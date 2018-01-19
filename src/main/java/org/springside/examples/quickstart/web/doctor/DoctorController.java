package org.springside.examples.quickstart.web.doctor;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springside.examples.quickstart.entity.Customer;
import org.springside.examples.quickstart.entity.Record;
import org.springside.examples.quickstart.entity.RecordsResult;
import org.springside.examples.quickstart.service.account.AccountService;
import org.springside.examples.quickstart.service.account.ShiroDbRealm.ShiroUser;
import org.springside.examples.quickstart.service.customer.CustomerService;
import org.springside.examples.quickstart.service.record.RecordService;
import org.springside.examples.quickstart.service.record.RecordsResultService;
import org.springside.modules.utils.Clock;

//import com.springside.myspringside.service.account.ShiroDbRealm.ShiroUser;
import com.google.common.collect.Maps;
//import com.springside.myspringside.entity.Customer;
//import com.springside.myspringside.entity.Record;
//import com.springside.myspringside.service.account.ShiroDbRealm.ShiroUser;
//import com.springside.myspringside.entity.Record;

@Controller
@RequestMapping(value = "/doctor")
public class DoctorController {
	private Clock clock = Clock.DEFAULT;
//	@Autowired
//	 private AccountService accountService;
	@Autowired
	 private RecordsResultService recordsResultService;
//	@Autowired
//	private CustomerService cusService;
	@Autowired
	private RecordService recService;
	@RequestMapping(value = "chooseRecord",method = RequestMethod.GET)
	public String showList(Model model,HttpServletRequest  request,RedirectAttributes redirectAttributes) {
		Long memId = getCurrentMemberId();
//		List<RecordsResult> rresultList = new ArrayList<RecordsResult>();
		List<RecordsResult> rresultList=recordsResultService.getUndiagnoseByDocid(memId);
			model.addAttribute("rresultList",rresultList);
			return "doctor/recordList";		
		}
	
	@RequestMapping(value = "chooseDiagnoseRecord",method = RequestMethod.GET)
	public String showRecord(Model model,HttpServletRequest  request,RedirectAttributes redirectAttributes) {
		Long memId = getCurrentMemberId();
//		List<RecordsResult> rresultList = new ArrayList<RecordsResult>();
		List<RecordsResult> rresultList=recordsResultService.getUndiagnoseByDocid(memId);
			model.addAttribute("rresultList",rresultList);
			model.addAttribute("diagnose",1);
			return "doctor/recordList";		
		}
	
	@RequestMapping(value = "giveDiagnose/{rrid}", method = RequestMethod.GET)
	public String createForm(RedirectAttributes redirectAttributes,Model model,@PathVariable("rrid") Long recordResultId) {
		RecordsResult rresult = recordsResultService.getRecordsResultById(recordResultId);
		model.addAttribute("customer", rresult.getCustomer());
		model.addAttribute("recordsResult",rresult);
//		model.addAttribute("cars", carsService.findCarsByRecordId(rresult.getParentid()));
//		model.addAttribute("cabs", cabsService.findCabsByRecordId(rresult.getParentid()));
//		model.addAttribute("chat", chatService.findChatByRecordId(rresult.getParentid()));
		model.addAttribute("action", "saveDiagnose");
		return "record/giveDiagnose";
	}
	
	@RequestMapping(value = "saveDiagnose", method = RequestMethod.POST)
	public String create(RedirectAttributes redirectAttributes,HttpServletRequest request) {
		Long rrid = Long.valueOf(request.getParameter("id").trim());
		RecordsResult rresult = recordsResultService.getRecordsResultById(rrid);
		rresult.setStatus(Long.valueOf(1));
		rresult.setRes_text(request.getParameter("res_text").trim());
		rresult.setRes_time(clock.getCurrentDate());
		Record record = recService.getRecordById(rresult.getParentid());
		record.setStatus(Long.valueOf(6));
		record.setAssigntime(clock.getCurrentDate());
		recService.updateRecord(record);
		recordsResultService.updateRResult(rresult);
		redirectAttributes.addFlashAttribute("message","诊断成功！");
		return "redirect:/doctor";
		}
	
	@RequestMapping(value = "showDiagnose/{rrid}", method = RequestMethod.GET)
	public String showForm(Model model,@PathVariable("rrid") Long recordResultId){
		RecordsResult rresult=recordsResultService.getRecordsResultById(recordResultId);
		model.addAttribute("rresult",rresult);
		Customer customer = rresult.getCus();
		model.addAttribute("customer", customer);
//		model.addAttribute("cars", carsService.findCarsByRecordId(rresult.getParentid()));
//		model.addAttribute("cabs", cabsService.findCabsByRecordId(rresult.getParentid()));
//		model.addAttribute("chat", chatService.findChatByRecordId(rresult.getParentid()));
		return "record/showDiagnose";
	}
	
	/**
	 * 取出Shiro中的当前用户Id.
	 */
	private Long getCurrentMemberId() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user.getUid();
	}

}
