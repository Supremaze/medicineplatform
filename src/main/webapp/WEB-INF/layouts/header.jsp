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
			<shiro:hasRole name="user">
				<li><a href="#myShopping" class="menu-first collapse"
					data-toggle="collapse"> <i class="icon-user"></i>&nbsp;&nbsp;健康管理
						<i class="icon-chevron-down" style="float: right;"></i>
				</a>
					<ul id="myShopping" class="menu-second collapse sub-menu">
						<li><a href="${ctx}/diet" class="sub-menu-list"><i
								class="icon-food"></i>&nbsp;&nbsp;膳食管理</a></li>
						<li><a href="${ctx}/service" class="sub-menu-list"><i
								class="icon-home"></i>&nbsp;&nbsp;健康自测</a></li>
					</ul></li>
				<li><a href="${ctx}/customer/showList" onClick="getclassname(this)" class="link_onclick">
						<i class="icon-table"></i>&nbsp;&nbsp;受检者档案管理<i class="icon-chevron-down" style="float: right;"></i>
				</a>
				<ul id="myShopping" class="menu-second collapse sub-menu">
						<li><a href="${ctx}/diet" class="sub-menu-list"><i
								class="icon-food"></i>&nbsp;&nbsp;待审核列表</a></li>
						<li><a href="${ctx}/service" class="sub-menu-list"><i
								class="icon-home"></i>&nbsp;&nbsp;未通过列表</a></li>
					</ul>
				</li>
				<li><a href="${ctx}/customer/showList" onClick="getclassname(this)" class="link_onclick">
						<i class="icon-table"></i>&nbsp;&nbsp;诊断单管理<i class="icon-chevron-down" style="float: right;"></i>
				</a>
				<ul id="myShopping" class="menu-second collapse sub-menu">
				<li><a href="${ctx}/diet" class="sub-menu-list"><i
								class="icon-food"></i>&nbsp;&nbsp;选择医生</a></li>
						<li><a href="${ctx}/service" class="sub-menu-list"><i
								class="icon-home"></i>&nbsp;&nbsp;已诊断列表</a></li>
						<li><a href="${ctx}/diet" class="sub-menu-list"><i
								class="icon-food"></i>&nbsp;&nbsp;待审核列表</a></li>
						<li><a href="${ctx}/service" class="sub-menu-list"><i
								class="icon-home"></i>&nbsp;&nbsp;未通过列表</a></li>
					</ul>
				</li>
				<li><a href="${ctx}/doctorQuery/userQueryList"
					onClick="getclassname(this)"> <i class="icon-group"></i>&nbsp;&nbsp;我的提问
				</a></li>
			</shiro:hasRole>
			<shiro:hasRole name="doctor">
				<li><a href="#myOrder" class="menu-first collapse"
					data-toggle="collapse"> <i class="icon-user"></i>&nbsp;&nbsp;诊断管理
						<i class="icon-chevron-down" style="float: right;"></i>
				</a>
					<ul id="myOrder" class="menu-second collapse sub-menu">
						<li><a href="${ctx}/doctor/chooseRecord" class="sub-menu-list"><i
								class="icon-food"></i>&nbsp;&nbsp;未诊断</a></li>
						<li><a href="${ctx}/doctor/chooseDiagnoseRecord" class="sub-menu-list"><i
								class="icon-home"></i>&nbsp;&nbsp;已诊断</a></li>
					</ul></li>
			</shiro:hasRole>
			
			<shiro:hasRole name="manager">
				<li><a href="#myOrder1" class="menu-first collapse"
					data-toggle="collapse"> <i class="icon-user"></i>&nbsp;&nbsp;受检者管理
						<i class="icon-chevron-down" style="float: right;"></i>
				</a>
					<ul id="myOrder1" class="menu-second collapse sub-menu">
						<li><a href="${ctx}/manager/userCheck" class="sub-menu-list"><i
								class="icon-home"></i>&nbsp;&nbsp;受检者审核</a></li>
						<li><a href="${ctx}/manager/checkDiagnoseRecord" class="sub-menu-list"><i
								class="icon-home"></i>&nbsp;&nbsp;听诊单审核</a></li>
					</ul></li>
					
					<li><a href="#myCart" class="menu-first collapse"
					data-toggle="collapse"> <i class="icon-user"></i>&nbsp;&nbsp;医生管理
						<i class="icon-chevron-down" style="float: right;"></i>
				</a>
					<ul id="myCart" class="menu-second collapse sub-menu">
						<li><a href="${ctx}/manager/checkDoctorReg" class="sub-menu-list"><i
								class="icon-home"></i>&nbsp;&nbsp;医生注册审核<b class="cart-count">${dietcount}</b></a></li>
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