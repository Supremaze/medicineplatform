package org.springside.examples.quickstart.web.customer;

import java.util.Map;

import javax.servlet.ServletRequest;
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
import org.springside.examples.quickstart.entity.Task;
import org.springside.examples.quickstart.entity.User;
import org.springside.examples.quickstart.service.account.ShiroDbRealm.ShiroUser;
import org.springside.examples.quickstart.service.task.TaskService;
import org.springside.modules.web.Servlets;
import org.springside.examples.quickstart.service.customer.CustomerService;
import org.springside.examples.quickstart.entity.Customer;
import org.springside.examples.quickstart.repository.CustomerDao;
import org.springside.examples.quickstart.service.customer.CustomerService;

import com.google.common.collect.Maps;

/**
 * Task管理的Controller, 使用Restful风格的Urls:
 * 
 * List page : GET /customer/
 * Create page : GET /customer/create
 * Create action : POST /customer/create
 * Update page : GET /customer/update/{id}
 * Update action : POST /customer/update
 * Delete action : GET /customer/delete/{id}
 * 
 */
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

	@RequestMapping(method = RequestMethod.GET)
	public String list(@RequestParam(value = "page", defaultValue = "1") int pageNumber,
			@RequestParam(value = "page.size", defaultValue = PAGE_SIZE) int pageSize,
			@RequestParam(value = "sortType", defaultValue = "auto") String sortType, Model model,
			ServletRequest request) {
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		Long userId = getCurrentAddUser();

		Page<Customer> customers = customerService.getCustomer(userId, searchParams, pageNumber, pageSize, sortType);

		model.addAttribute("customers", customers);
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
		Customer customer = new Customer(getCurrentAddUser());
		//newCustomer.setCustomer(customer);

		customerService.saveCustomer(newCustomer);
		redirectAttributes.addFlashAttribute("message", "创建受检者档案成功");
		return "redirect:/customer/";
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
		redirectAttributes.addFlashAttribute("message", "删除受检者档案成功");
		return "redirect:/customer/";
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
	private Long getCurrentAddUser() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user.id;
	}
}
