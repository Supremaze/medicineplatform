package org.springside.examples.quickstart.web.customer;


import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springside.examples.quickstart.entity.Customer;
import org.springside.examples.quickstart.entity.Member;
import org.springside.examples.quickstart.service.account.ShiroDbRealm.ShiroUser;
import org.springside.modules.web.Servlets;
import org.springside.examples.quickstart.service.customer.CustomerService;

import com.google.common.collect.Maps;

@Controller
@RequestMapping(value = "/customer")//类中的所有响应请求的方法都是以该地址作为父路径
public class CustomerController {

	private static final String PAGE_SIZE = "3";

	private static Map<String, String> sortTypes = Maps.newLinkedHashMap();
	static {
		sortTypes.put("auto", "自动");
		sortTypes.put("title", "标题");
	}

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "showList",method = RequestMethod.GET)
	public String list(
			@RequestParam(value = "page", defaultValue = "1") int pageNumber,
			@RequestParam(value = "page.size", defaultValue = PAGE_SIZE) int pageSize,
			@RequestParam(value = "sortType", defaultValue = "auto") String sortType, 
			Model model,
			HttpServletRequest request) {
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		Long userId = getCurrentMemberId();
		System.out.println(userId);
//		List<Customer> customers = customerService.getCustomerCheck(userId);
		/*List<Customer> customers = customerService.getCustomerByMemid(userId);
		System.out.println(customers);*/
		
		Page<Customer> cus = customerService.getUserCustomer(userId, searchParams, pageNumber, pageSize, sortType);
		model.addAttribute("customers", cus);
		//model.addAttribute("customers", customers);
		model.addAttribute("sortType", sortType);
		model.addAttribute("sortTypes", sortTypes);
		// 将搜索条件编码成字符串，用于排序，分页的URL
		model.addAttribute("searchParams", Servlets.encodeParameterStringWithPrefix(searchParams, "search_"));

		return "customer/customerList";
	}
	
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String createForm(Model model) {
		model.addAttribute("customer", new Customer());
		model.addAttribute("action", "create");
		return "customer/customerForm";
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String create(@Valid Customer newCustomer, RedirectAttributes redirectAttributes) {
		Member member = new Member(getCurrentMemberId());
		newCustomer.setMember(member);

		customerService.saveCustomer(newCustomer);
		redirectAttributes.addFlashAttribute("message", "创建任务成功");
		return "redirect:/customer/showList";
	}

	@RequestMapping(value = "delete/{id}")
	public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		customerService.deleteCustomer(id);
		redirectAttributes.addFlashAttribute("message", "删除任务成功");
		return "redirect:/customer/showList";
	}
	
	/**
	 * 取出Shiro中的当前用户Id.
	 */
	private Long getCurrentMemberId() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user.getUid();
	}

}
