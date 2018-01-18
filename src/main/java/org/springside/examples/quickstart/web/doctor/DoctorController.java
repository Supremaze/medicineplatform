package org.springside.examples.quickstart.web.doctor;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springside.examples.quickstart.entity.Customer;
import org.springside.examples.quickstart.entity.RecordsResult;
import org.springside.examples.quickstart.service.account.AccountService;
import org.springside.examples.quickstart.service.account.ShiroDbRealm.ShiroUser;
import org.springside.examples.quickstart.service.customer.CustomerService;
import org.springside.examples.quickstart.service.record.RecordsResultService;
//import com.springside.myspringside.service.account.ShiroDbRealm.ShiroUser;
import com.google.common.collect.Maps;
//import com.springside.myspringside.entity.Customer;
//import com.springside.myspringside.entity.Record;
//import com.springside.myspringside.service.account.ShiroDbRealm.ShiroUser;

@Controller
@RequestMapping(value = "/doctor")
public class DoctorController {
	private static Map<String, String> sortTypes = Maps.newLinkedHashMap();
	static {
		sortTypes.put("auto", "自动");
		sortTypes.put("title", "标题");
	}
	@Autowired
	 private AccountService accountService;
	@Autowired
	 private RecordsResultService recordsResultService;
	@Autowired
	private CustomerService cusService;
	
	@RequestMapping(value = "chooseRecord")
	public String showList(Model model,HttpServletRequest  request,RedirectAttributes redirectAttributes) {
		Long memId = getCurrentMemberId();
		List<RecordsResult> rresultList=recordsResultService.getUndiagnoseByDocid(memId);
		
//		if(rresultList.isEmpty()){
//			redirectAttributes.addFlashAttribute("message", "尚未有未诊断诊断单！");
//		}
			model.addAttribute("rresultList",rresultList);
			return "doctor/recordList";		
		}		
	
	/**
	 * 取出Shiro中的当前用户Id.
	 */
	private Long getCurrentMemberId() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user.getUid();
	}

}
