<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE >
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'VersionInsert.jsp' starting page</title>

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
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="x_panel">
							<div class="x_title">
								<h2>
									新增APP版本信息 <small><i class="fa fa-user"></i>${devUser.devName}</small>
								</h2>
								<div class="clearfix"></div>
							</div>
							<div class="x_content">
								<p class="text-muted font-13 m-b-30">历史版本列表</p>
								<div class="row">
									<div class="col-sm-12">
										<table id="datatable"
											class="table table-striped table-bordered dataTable no-footer"
											role="grid" aria-describedby="datatable_info">
											<thead>
												<tr role="row">
													<th class="sorting_asc" tabindex="0" style="width: 150px;">软件名称</th>
													<th class="sorting" tabindex="0" style="width: 245px;">版本号</th>
													<th class="sorting" tabindex="0" style="width: 112px;">版本大小（单位M）</th>
													<th class="sorting" tabindex="0" style="width: 56px;">发布状态</th>
													<th class="sorting" tabindex="0" style="width: 112px;">APK文件下载</th>
													<th class="sorting" tabindex="0" style="width: 83px;">最新更新时间</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="applict" items="${appversion}" varStatus="i">
													<tr role="row"
														<c:if test="${i.index%2==0}">class="odd"</c:if>
														<c:if test="${i.index%2==1}">class="even"</c:if>>
														<td>${applict.softwareName}</td>
														<td>${applict.versionNo}</td>
														<td>${applict.versionSize}</td>
														<td>${applict.publishName}</td>
														<td>${applict.downloadLink}</td>
														<td>${applict.modifyDate}</td>
													</tr>
												</c:forEach>
										</table>
									</div>
								</div>
								<div class="col-md-12 col-sm-12 col-xs-12">
									<div class="x_panel">
										<div class="x_title">
											<h2>新增版本信息</h2>
											<div class="clearfix"></div>
										</div>
										<div class="x_content">
											<br>
											<form id="demo-form2" data-parsley-validate=""
												class="form-horizontal form-label-left"
												 novalidate="" method="post" enctype="multipart/form-data"
												 action="${pageContext.request.contextPath}/dev/appversion/insert">
												 ${error}
												<div class="form-group">
													<label class="control-label col-md-3 col-sm-3 col-xs-12"
														for="first-name">版本号<span class="required">*</span>
													</label>
													<div class="col-md-6 col-sm-6 col-xs-12">
														<input type="text" id="first-name" required="required"
															class="form-control col-md-7 col-xs-12"
															placeholder="请输入版本号"
															name="versionNo">
															<input type="hidden" name="appId" value="${appinfoid}"/>
													</div>
												</div>
												<div class="form-group">
													<label class="control-label col-md-3 col-sm-3 col-xs-12"
														for="last-name">版本大小 <span class="required">*</span>
													</label>
													<div class="col-md-6 col-sm-6 col-xs-12">
														<input type="text" id="last-name" name="versionSize"
															required="required"
															class="form-control col-md-7 col-xs-12"
															placeholder="请输入版本大小，单位为MB"
															>
													</div>
												</div>
												<div class="form-group">
													<label class="control-label col-md-3 col-sm-3 col-xs-12"
														for="last-name">发布状态 <span class="required">*</span>
													</label>
													<div class="col-md-6 col-sm-6 col-xs-12">
														预发布
														<input type="hidden" id="last-name" name="publishStatus"
															required="required"
															class="form-control col-md-7 col-xs-12"
															value="3">
													</div>
												</div>
												<div class="form-group">
													<label class="control-label col-md-3 col-sm-3 col-xs-12">
														版本简介 <span class="required">*</span> </label>
													<div class="col-md-9 col-sm-9 col-xs-12">
														<textarea class="form-control" cols="3"
															style="width: 510px"
															placeholder="请输入本版本的相关信息，本信息作为软件的详细信息进行版本介绍"
															name="versionInfo"></textarea>
													</div>
												</div>
												<div class="form-group">
													<label class="control-label col-md-3 col-sm-3 col-xs-12">APK文件<span
														class="required">*</span> </label>
													<div class="col-md-6 col-sm-6 col-xs-12">
														<input id="birthday"
															class="date-picker form-control col-md-7 col-xs-12"
															required="required" type="file" name="apkupload">
													</div>
												</div>
												<div class="ln_solid"></div>
												<div class="form-group">
													<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
														<input type="submit" class="btn btn-primary" value="保存" />
														<input type="button" class="btn btn-success" value="返回" onclick="location.href='${pageContext.request.contextPath}/dev/appinfo/appinfolist'"/>
													</div>
												</div>
											</form>
										</div>
									
									
									
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

	<script
		src="${pageContext.request.contextPath}/statics/js/jquery.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/statics/js/VersionInsert.js"></script>
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
