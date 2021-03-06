package org.springside.examples.quickstart.web.customer;


import java.io.Console;
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
import org.springframework.web.bind.annotation.ModelAttribute;
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

import org.springside.examples.quickstart.entity.Customer;
import org.springside.examples.quickstart.repository.CustomerDao;
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


		customerService.saveCustomer(newCustomer);
		redirectAttributes.addFlashAttribute("message", "创建受检者档案成功");
		return "redirect:/customer/showList";
	}

	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public String updateForm(@PathVariable("id") Long id, Model model) {
		model.addAttribute("customer", customerService.getCustomer(id));
		model.addAttribute("action", "update");
		return "customer/customerForm";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
		customerService.saveCustomer(customer);
		redirectAttributes.addFlashAttribute("message", "更新受检者档案成功");
		return "redirect:/customer/";

	}

	@RequestMapping(value = "delete/{id}")
	public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		customerService.deleteCustomer(id);

		redirectAttributes.addFlashAttribute("message", "删除任务成功");
		return "redirect:/customer/showList";
	
	}

	/**
	 * 所有RequestMapping方法调用前的Model准备方法, 实现Struts2 Preparable二次部分绑定的效果,先根据form的id从数据库查出Task对象,再把Form提交的内容绑定到该对象上。
	 * 因为仅update()方法的form中有id属性，因此仅在update时实际执行.
	 */
	@ModelAttribute
	public void getTask(@RequestParam(value = "id", defaultValue = "-1") Long id, Model model) {
		if (id != -1) {
			model.addAttribute("task", customerService.getCustomer(id));
		}
	}


	/**
	 * 取出Shiro中的当前用户Id.
	 */
	private Long getCurrentMemberId() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		//return user.getUid();
		return user.getUid();
	}

}
