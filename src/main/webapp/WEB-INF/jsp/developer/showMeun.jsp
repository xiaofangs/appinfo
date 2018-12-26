<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE>
<html>
<head>

<title>My JSP 'devShow.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!-- Bootstrap -->
<link
	href="${pageContext.request.contextPath}/statics/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Font Awesome -->
<link
	href="${pageContext.request.contextPath}/statics/css/font-awesome.min.css"
	rel="stylesheet">
<!-- NProgress -->
<link
	href="${pageContext.request.contextPath}/statics/css/nprogress.css"
	rel="stylesheet">

<!-- Custom Theme Style -->
<link
	href="${pageContext.request.contextPath}/statics/css/custom.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/statics/css/dev/showMenu.css"
	type="text/css"></link>
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<%@include file="commens/left.jsp"%>
			<%@include file="commens/top.jsp"%>
			 <div class="right_col" role="main">
				<div class="">
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel">
								<div class="x_title">
									<h2>
										APP信息管理维护 <small><i class="fa fa-user"></i>${devUser.devName}-你可以通过搜索或者其他筛选对AAP进行修改，删除管理操作^-^</small>
									</h2>
									<div class="clearfix"></div>
								</div>
								<div class="x_content">
									<br />
									<form id="demo-form2" data-parsley-validate
										class="form-horizontal form-label-left" method="post" action="${pageContext.request.contextPath}/dev/appinfo/appinfolist">
										<ul>
											<li>
												<div class="form-group">
													<label class="control-label col-md-3 col-sm-3 col-xs-12">软件名字
													</label>
													<div class="col-md-6 col-sm-6 col-xs-12">
														<input type="text" class="form-control col-md-7 col-xs-12" name="softwareName" value="${softwareName}">
														<input type="hidden" class="form-control col-md-7 col-xs-12" name="pageCurr">
													</div>
												</div></li>
											<li>
												<div class="form-group">
													<label class="control-label col-md-3 col-sm-3 col-xs-12">APP状态
													</label>
													<div class="col-md-6 col-sm-6 col-xs-12">
														<select class="form-control col-md-7 col-xs-12" name="status">
															<option value="">--请选择--</option>
															<c:forEach var="status1" items="${dataStatus}">
															<option value="${status1.valueId}" <c:if test="${status==status1.valueId}">selected="selected"</c:if>>${status1.valueName}</option>
															</c:forEach>
														</select>
													</div>
												</div></li>
											<li>
												<div class="form-group">
													<label class="control-label col-md-3 col-sm-3 col-xs-12">所属平台</label>
													<div class="col-md-6 col-sm-6 col-xs-12">
														<select class="form-control col-md-7 col-xs-12"
															name="flatformId">
															<c:if test="${flatformId==flatform.id}">selected="selected"</c:if>
															<option value="">--请选择--</option>
															<c:forEach var="flatform" items="${dataFlatform}">
															<option value="${flatform.valueId}" <c:if test="${flatformId==flatform.valueId}">selected="selected"</c:if>>${flatform.valueName}</option>
															</c:forEach>
														</select>
													</div>
												</div></li>
											<li>
												<div class="form-group">
													<label class="control-label col-md-3 col-sm-3 col-xs-12">一级分类
													</label>
													<div class="col-md-6 col-sm-6 col-xs-12">
														<select class="form-control col-md-7 col-xs-12" name="categoryLevel1" onchange="javascript:changeCategory(2);" id="categoryLevel1">
															<option value="">全部应用</option>
															<c:forEach var="category1" items="${category1}">
															<option value="${category1.id}" <c:if test="${categoryLevel1==category1.id}">selected="selected"</c:if>>${category1.categoryName}</option>
															</c:forEach>
														</select>
													</div>
												</div></li>
											<li>
												<div class="form-group">
													<label class="control-label col-md-3 col-sm-3 col-xs-12">二级分类
													</label>
													<div class="col-md-6 col-sm-6 col-xs-12">
														<select class=" form-control col-md-7 col-xs-12" name="categoryLevel2" onchange="javascript:changeCategory(3);" id="categoryLevel2">
														<option value="">--请选择--</option>
														<c:forEach var="category2" items="${category2}">
															<option value="${category2.id}" <c:if test="${categoryLevel2==category2.id}">selected="selected"</c:if>>${category2.categoryName}</option>
															</c:forEach>
														</select>
													</div>
												</div></li>
											<li>
												<div class="form-group">
													<label class="control-label col-md-3 col-sm-3 col-xs-12">三级分类
													</label>
													<div class="col-md-6 col-sm-6 col-xs-12">
														<select class=" form-control col-md-7 col-xs-12" name="categoryLevel3" id="categoryLevel3">
													     <option value="">--请选择--</option>
													     <c:forEach var="category3" items="${category3}">
															<option value="${category3.id}" <c:if test="${categoryLevel3==category3.id}">selected="selected"</c:if>>${category3.categoryName}</option>
															</c:forEach>
														</select>
													</div>
												</div></li>
											<li>
												<div class="form-group">
													<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
														<input type="submit" class="btn btn-primary" value="查询">
													</div>
												</div>
											</li>
										</ul>
									</form>
								</div>

							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="x_panel">
							<div class="x_title">
								<button type="button" class="btn btn-primary" 
								onclick="location.href='${pageContext.request.contextPath}/dev/appinfo/appinfotoInsert'">
								新增APP基础信息
								</button>
								<div class="clearfix"></div>
							</div>
							<div class="x_content">
								<table id="datatable" class="table table-striped table-bordered">
									<thead>
										<tr>
											<th>软件名称</th>
											<th>APK名称</th>
											<th>软件大小（单位：M）</th>
											<th>所属平台</th>
											<th>所属分类（一级分类，二级分类，三级分类）</th>
											<th>状态</th>
											<th>下载次数</th>
											<th>最新版本号</th>
											<th width="155px">操作</th>
										</tr>
									</thead>
									<tbody>
									  <c:forEach items="${page.pageList}" var="appinfo">
										<tr class="app${appinfo.id}">
											<td>${appinfo.softwareName}</td>
											<td>${appinfo.APKName}</td>
											<td>${appinfo.softwareSize}</td>
											<td>${appinfo.flatformName}</td>
											<td>${appinfo.category1Name}>>${appinfo.category2Name}>>${appinfo.category3Name}</td>
											<td><span id="appInfoStatus${appinfo.id}">${appinfo.statusName}</span></td>
											<td>${appinfo.downloads}</td>
											<td>${appinfo.versionNo}</td>
											<td>
												<div class="btn-group">
													<button type="button" class="btn btn-danger">点击操作</button>
													<button type="button" style="height: 33px"
														class="btn btn-danger dropdown-toggle"
														data-toggle="dropdown" aria-expanded="false">
														<span class="caret"></span> 
														<span class="sr-only">Toggle
															Dropdown</span>
													</button>
													<ul class="dropdown-menu"   role="menu">
														<li>
														<c:if test="${appinfo.status==2||appinfo.status==5}">
														<a href="#" class="saleSwichOpen" 
														appinfoid="${appinfo.id}"
														saleSwitch="open"
														appsoftwarename="${appinfo.softwareName}">上架</a>
														</c:if>
														<c:if test="${appinfo.status==4}">
														<a href="#" class="saleSwichClose"
														appinfoid="${appinfo.id}"
														saleSwitch="close"
														appsoftwarename="${appinfo.softwareName}">下架</a>
														</c:if>
														</li>
														<li><a href="${pageContext.request.contextPath}/dev/appversion/toInsert?appId=${appinfo.id}">新增版本</a></li>
														<li><a href="#"
														versionid="${appinfo.versionId}"
														appinfoid="${appinfo.id}"
														status="${appinfo.status}"
														 statusName="${appinfo.statusName}"
														class="versionupdate"
														>修改版本</a></li>
														<li><a href="#" appinfoid="${appinfo.id}"
													     status="${appinfo.status}"
													     statusName="${appinfo.statusName}"
													     class="updateAppInfo">修改</a></li>
														<li><a href="${pageContext.request.contextPath}/dev/appinfo/viewAppInfo?appinfoid=${appinfo.id}">查看</a></li>
				   									    <li><a href="#"
				   									    appinfoid="${appinfo.id}"
				   									    class="deleteAppInfo"
				   									    softwareName="${appinfo.softwareName}">删除</a></li>
													</ul>
												</div></td>
										</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<div class="row">
								<div class="col-sm-5">
									<div class="dataTables_info" id="datatable_info" role="status"
										aria-live="polite">共${page.count}记录${page.pageCurr}/${page.pageCount}</div>
								</div>
								<div class="col-sm-7">
									<div class="dataTables_paginate paging_simple_numbers"
										id="datatable_paginate">
										<ul class="pagination">
											<li class="paginate_button previous"
												id="datatable_previous"><a href="javascript:pages(1);"
												aria-controls="datatable" data-dt-idx="0" tabindex="0">首页</a>
											</li>
											<li class="paginate_button "><a href="javascript:pages(${page.pageCurr-1});"
												aria-controls="datatable" data-dt-idx="2" tabindex="0">上一页</a>
											 </li>
											<c:forEach var="i" begin="1" end="${page.pageCount}">
											<li class="paginate_button "><a href="javascript:pages(${i});"
												aria-controls="datatable" data-dt-idx="${2+i}" tabindex="0">${i}</a>
											</li>
											</c:forEach>
											<li class="paginate_button "><a href="javascript:pages(${page.pageCurr+1});"
												aria-controls="datatable" data-dt-idx="3" tabindex="0">下一页</a>
											</li>
											<li class="paginate_button next" id="datatable_next"><a
												href="javascript:pages(${page.pageCount});" aria-controls="datatable" data-dt-idx="7"
												tabindex="0">尾页</a></li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<%@include file="commens/foot.jsp"%>
		</div>
	</div>
    
	<script src="${pageContext.request.contextPath}/statics/js/jquery.min.js"></script>
	<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath}/statics/js/showMeun.js"></script>
		<script type="text/javascript">
		
		function pages(pagecurrs){
		    document.forms[0].pageCurr.value=pagecurrs;
		    document.forms[0].submit();
		   
		}
		</script>
	<!-- Bootstrap -->
	<script 
		src="${pageContext.request.contextPath}/statics/js/bootstrap.min.js"></script>
	<!-- FastClick -->
	<script
		src="${pageContext.request.contextPath}/statics/js/fastclick.js"></script>

	<!-- Custom Theme Scripts -->
	<script
		src="${pageContext.request.contextPath}/statics/js/custom.min.js"></script>

</body>
</html>





