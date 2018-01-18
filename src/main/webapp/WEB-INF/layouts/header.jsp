<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<header class="dark_grey">
	<div class="top">
		<div class="logo">
			<!-- 系统用户 -->
			<h2>健康管理及个性化推荐综合系统</h2>
		</div>

		<div id="site-bar">
			<ul class="site-nav float-right nav navbar-nav pull-right ">
				<shiro:hasRole name="user">
					<li class="wordbreak"><a
						href="${ctx}/user/update/${currUser.id}" title="到个人设定"
						class="user-online"> <shiro:user>
								<!-- <shiro:principal />-->
								<h>${currUser.name}</h>
							</shiro:user>
					</a></li>

					<li class="wordbreak"><a href="${ctx}/friend">我的好友&nbsp;</a></li>
				</shiro:hasRole>
				<shiro:hasAnyRoles name="admin,SubAdmin,orderAdmin">
					<li class="wordbreak"><a href="${ctx}/profile" class="user-online"> <shiro:user>
								<shiro:principal />
							</shiro:user>
					</a></li>
				</shiro:hasAnyRoles>

				<li class="nowordbreak"><a class="bh_logout"
					href="${ctx}/logout">退出</a></li>
			</ul>
		</div>
	</div>
</header> 

<div id="main_navigation" class="dark_navigation">
	<!-- Main navigation start -->
	<div class="inner_navigation" id="left-daohang"
		style="margin-top: 75px; height: 555px;">
		<ul class="main">
			<shiro:hasRole name="admin">
				<li><a href="${ctx}/admin/user" onClick="getclassname(this)" class="link_onclick"> <i
						class="icon-reorder"></i>&nbsp;&nbsp;用户管理
				</a></li>

				<li><a href="${ctx}/suggestionManage" class="link_onclick"
					onClick="getclassname(this)"> <i class="icon-reorder"></i>&nbsp;&nbsp;健康建议管理
				</a></li>
				<li><a href="${ctx}/healthReport" onClick="getclassname(this)" class="link_onclick">
						<i class="icon-table"></i>&nbsp;&nbsp;健康报告管理
				</a></li>
				<li><a href="${ctx}/importSurvey" onClick="getclassname(this)" class="link_onclick">
						<i class="icon-table"></i>&nbsp;&nbsp;健康调查表格
				</a></li>
				<li><a href="${ctx}/doctor" onClick="getclassname(this)" class="link_onclick"> <i
						class="icon-tasks"></i>&nbsp;&nbsp;医生管理
				</a></li>
				<li><a href="${ctx}/hospital" onClick="getclassname(this)" class="link_onclick">
						<i class="icon-calendar"></i>&nbsp;&nbsp;医院管理
				</a></li>
				<li><a href="${ctx}/institution"  class="link_onclick"> <i
						class="icon-sitemap"></i>&nbsp;&nbsp;机构管理
				</a></li>
				<li><a href="#adminAccountMeun" class="menu-first collapse" class="link_onclick"
					data-toggle="collapse"> <i class="icon-user"></i>&nbsp;&nbsp;二级账户管理
						<i class="icon-chevron-down" style="float: right;"></i>
				</a>
					<ul id="adminAccountMeun" class="menu-second collapse sub-menu">
						<li><a href="${ctx}/subAdmin/create" class="link_onclick_a"><i
								class="icon-plus"></i>&nbsp;&nbsp;账号添加</a></li>
						<li><a href="${ctx}/admin/user" class="link_onclick_a"><i
								class="icon-pencil"></i>&nbsp;&nbsp;账号修改</a></li>
					</ul></li>
				<li><a href="${ctx}/task" onClick="getclassname(this)" class="link_onclick">
						<i class="icon-cog"></i>&nbsp;&nbsp;健康项目管理
				</a></li>
				<li><a href="${ctx}/healthQuestion"
					onClick="getclassname(this)" class="link_onclick"> <i class="icon-edit"></i>&nbsp;&nbsp;自测试题管理
				</a></li>
				<li><a href="${ctx}/diet" onClick="getclassname(this)" class="link_onclick"> <i
						class="icon-food"></i>&nbsp;&nbsp;营养配膳
				</a></li>
				<li><a href="#Order" class="menu-first collapse"
					data-toggle="collapse"> <i class="icon-user"></i>&nbsp;&nbsp;订单管理
						<i class="icon-chevron-down" style="float: right;"></i>
				</a>
					<ul id="Order" class="menu-second collapse sub-menu">
						<li><a href="${ctx}/dietOrder" class="link_onclick_a"><i
								class="icon-food"></i>&nbsp;&nbsp;膳食订单</a></li>
						<li><a href="${ctx}/serviceOrder" class="link_onclick_a"><i
								class="icon-home"></i>&nbsp;&nbsp;服务订单</a></li>
					</ul></li>

				<li><a href="${ctx}/profile" class="link_onclick"
					onClick="getclassname(this)"> <i class="icon-edit"></i>&nbsp;&nbsp;修改密码
				</a></li>
			</shiro:hasRole>
			<shiro:hasRole name="user">
				<li><a href="${ctx}/user" onClick="getclassname(this)"> <i
						class="icon-medkit"></i>&nbsp;&nbsp;健康信息
				</a></li>
				<li><a href="${ctx}/handin" onClick="getclassname(this)"> <i
						class="icon-edit"></i>&nbsp;&nbsp;手动录入
				</a></li>
				<li><a href="${ctx}/friend" onClick="getclassname(this)"> <i
						class="icon-group"></i>&nbsp;&nbsp;我的亲友
				</a></li>
				<li><a href="${ctx}/doctorQuery/userQueryList"
					onClick="getclassname(this)"> <i class="icon-group"></i>&nbsp;&nbsp;我的提问
				</a></li>

				<li><a href="${ctx}/contact" onClick="getclassname(this)">
						<i class="icon-group"></i>&nbsp;&nbsp;收货地址
				</a></li>
				<li><a href="#myOrder" class="menu-first collapse"
					data-toggle="collapse"> <i class="icon-user"></i>&nbsp;&nbsp;我的订单
						<i class="icon-chevron-down" style="float: right;"></i>
				</a>
					<ul id="myOrder" class="menu-second collapse sub-menu">
						<li><a href="${ctx}/dietOrder" class="sub-menu-list"><i
								class="icon-food"></i>&nbsp;&nbsp;膳食订单</a></li>
						<li><a href="${ctx}/serviceOrder" class="sub-menu-list"><i
								class="icon-home"></i>&nbsp;&nbsp;服务订单</a></li>
					</ul></li>
				<li><a href="#myShopping" class="menu-first collapse"
					data-toggle="collapse"> <i class="icon-user"></i>&nbsp;&nbsp;服务膳食
						<i class="icon-chevron-down" style="float: right;"></i>
				</a>
					<ul id="myShopping" class="menu-second collapse sub-menu">
						<li><a href="${ctx}/diet" class="sub-menu-list"><i
								class="icon-food"></i>&nbsp;&nbsp;营养配膳</a></li>
						<li><a href="${ctx}/service" class="sub-menu-list"><i
								class="icon-home"></i>&nbsp;&nbsp;至家服务</a></li>
					</ul></li>
				<li><a href="#myCart" class="menu-first collapse"
					data-toggle="collapse"> <i class="icon-user"></i>&nbsp;&nbsp;购物车
						<i class="icon-chevron-down" style="float: right;"></i>
				</a>
					<ul id="myCart" class="menu-second collapse sub-menu">
						<li><a href="${ctx}/dietCart" class="sub-menu-list"><i
								class="icon-food"></i>&nbsp;&nbsp;营养配膳<b class="cart-count">${dietcount}</b></a></li>
						<li><a href="${ctx}/serviceCart" class="sub-menu-list"><i
								class="icon-home"></i>&nbsp;&nbsp;至家服务<b class="cart-count">${servicecount}</b></a></li>
					</ul></li>

			</shiro:hasRole>
			<shiro:hasRole name="doctor">
				<li><a href="#myOrder" class="menu-first collapse"
					data-toggle="collapse"> <i class="icon-user"></i>&nbsp;&nbsp;诊断管理
						<i class="icon-chevron-down" style="float: right;"></i>
				</a>
					<ul id="myOrder" class="menu-second collapse sub-menu">
						<li><a href="${ctx}/doctor/recordList" class="sub-menu-list"><i
								class="icon-food"></i>&nbsp;&nbsp;未诊断</a></li>
						<li><a href="${ctx}/serviceOrder" class="sub-menu-list"><i
								class="icon-home"></i>&nbsp;&nbsp;已诊断</a></li>
					</ul></li>
			</shiro:hasRole>
			<li><a href="#myOrder1" class="menu-first collapse"
					data-toggle="collapse"> <i class="icon-user"></i>&nbsp;&nbsp;系统设置
						<i class="icon-chevron-down" style="float: right;"></i>
				</a>
					<ul id="myOrder1" class="menu-second collapse sub-menu">
						<li><a href="${ctx}/dietOrder" class="sub-menu-list"><i
								class="icon-food"></i>&nbsp;&nbsp;个人资料</a></li>
						<li><a href="${ctx}/serviceOrder" class="sub-menu-list"><i
								class="icon-home"></i>&nbsp;&nbsp;修改密码</a></li>
					</ul></li>
			
			
			


			
		</ul>
	</div>
</div>