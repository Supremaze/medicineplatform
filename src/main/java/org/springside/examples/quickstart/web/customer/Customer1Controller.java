package org.springside.examples.quickstart.web.customer;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springside.examples.quickstart.service.account.ShiroDbRealm.ShiroUser;


@Controller
@RequestMapping(value = "/customer/test")//类中的所有响应请求的方法都是以该地址作为父路径
public class Customer1Controller {
	@RequestMapping("/customer/test")
	public String test1() {
		return "task/taskList";
	}
	/**
	 * 取出Shiro中的当前用户Id.
	 */
	private Long getCurrentUserId() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user.getUid();
	}
}

