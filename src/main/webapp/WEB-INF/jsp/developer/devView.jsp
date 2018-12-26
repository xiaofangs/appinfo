<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE>
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'devInsert.jsp' starting page</title>

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
										APP基础信息 <small><i class="fa fa-user"></i>${devUser.devName}</small>
									</h2>
									<ul class="nav navbar-right panel_toolbox">
										<li><a class="collapse-link"><i
												class="fa fa-chevron-up"></i> </a>
										</li>
										<li class="dropdown"><a href="#" class="dropdown-toggle"
											data-toggle="dropdown" role="button" aria-expanded="false"><i
												class="fa fa-wrench"></i> </a>
											<ul class="dropdown-menu" role="menu">
												<li><a href="#">Settings 1</a>
												</li>
												<li><a href="#">Settings 2</a>
												</li>
											</ul>
										</li>
										<li><a class="close-link"><i class="fa fa-close"></i>
										</a>
										</li>
									</ul>
									<div class="clearfix"></div>
								</div>
								<div class="x_content">
									<br>
									<form id="demo-form2" data-parsley-validate=""
										action="${pageContext.request.contextPath}/dev/appinfo/appinfoUpdate"
										class="form-horizontal form-label-left" novalidate=""
										method="post" enctype="multipart/form-data">
										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12"
												for="first-name">软件名称<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<input type="hidden" value="${appinfo.id}" name="id" /> <input
													type="text" id="first-name" placeholder="请输入软件名称"
													class="form-control col-md-7 col-xs-12" name="softwareName"
													value="${appinfo.softwareName}" readonly="readonly"> 
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12"
												for="last-name">APK名称<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<input type="text" id="APKName" name="APKName"
													placeholder="请输入APK名称"
													class="form-control col-md-7 col-xs-12"
													value="${appinfo.APKName}" readonly="readonly">
											</div>
										</div>
										<div class="form-group">
											<label for="middle-name"
												class="control-label col-md-3 col-sm-3 col-xs-12">
												支持ROM<span class="required">*</span> </label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<input id="middle-name"
													class="form-control col-md-7 col-xs-12" type="text"
													placeholder="请输入支持的ROM" name="supportROM"
													value="${appinfo.supportROM}" readonly="readonly">
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12">
												界面语言<span class="required">*</span> </label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<input id="middle-name" placeholder="请输入软件支持的界面语言"
													class="form-control col-md-7 col-xs-12" type="text"
													name="interfaceLanguage"
													value="${appinfo.interfaceLanguage}" readonly="readonly">
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12">
												软件大小<span class="required">*</span> </label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<input id="birthday" placeholder="请输入软件大小，单位为MB"
													class="date-picker form-control col-md-7 col-xs-12"
													name="softwareSize" type="number"
													value="${appinfo.softwareSize}" readonly="readonly">
											</div>
										</div>

										<div class="form-group">
											<label for="middle-name"
												class="control-label col-md-3 col-sm-3 col-xs-12">
												下载次数<span class="required">*</span> </label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<input id="middle-name" placeholder="请输入下载次数"
													class="form-control col-md-7 col-xs-12" type="number"
													name="downloads" value="${appinfo.downloads}" readonly="readonly">
											</div>
										</div>
										<div class="form-group">
											<label for="middle-name"
												class="control-label col-md-3 col-sm-3 col-xs-12">
												所属平台<span class="required">*</span> </label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<input id="middle-name"
													class="form-control col-md-7 col-xs-12" type="text"
													name="" value="${appinfo.flatformName}" readonly="readonly">
											</div>
										</div>
										<div class="form-group">
											<label for="middle-name"
												class="control-label col-md-3 col-sm-3 col-xs-12">
												一级分类<span class="required">*</span> </label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<input id="middle-name"
													class="form-control col-md-7 col-xs-12" type="text"
													name="" value="${appinfo.category1Name}" readonly="readonly">
											</div>
										</div>
										<div class="form-group">
											<label for="middle-name"
												class="control-label col-md-3 col-sm-3 col-xs-12">
												二级分类<span class="required">*</span> </label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<input id="middle-name"
													class="form-control col-md-7 col-xs-12" type="text"
													name="" value="${appinfo.category2Name}" readonly="readonly">
											</div>
										</div>
										<div class="form-group">
											<label for="middle-name"
												class="control-label col-md-3 col-sm-3 col-xs-12">
												三级分类<span class="required">*</span> </label>
											<div class="col-md-6 col-sm-6 col-xs-12">
											<input id="middle-name"
													class="form-control col-md-7 col-xs-12" type="text"
													name="" value="${appinfo.category3Name}" readonly="readonly">
											</div>
										</div>
										<div class="form-group">
											<label for="middle-name"
												class="control-label col-md-3 col-sm-3 col-xs-12">
												APP状态<span class="required">*</span> </label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<input id="middle-name"
													class="form-control col-md-7 col-xs-12" type="text"
													name="status" value="${appinfo.statusName}" readonly="readonly">
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12">Date
												应用简介 <span class="required">*</span> </label>
											<div class="col-md-9 col-sm-9 col-xs-12">
												<textarea class="form-control" cols="4" style="width: 550px"
													placeholder="请输入本软件的相关信息，本信息作为软件的详细信息进行软件介绍" name="appInfo"
													value="${appinfo.appInfo}" readonly="readonly">${appinfo.appInfo}</textarea>
											</div>
										</div>
										<div class="form-group">
											<label for="middle-name"
												class="control-label col-md-3 col-sm-3 col-xs-12">
												LOGO图片<span class="required">*</span> </label>
											<div class="col-md-6 col-sm-6 col-xs-12" id="changePic">
												<img alt=""
													src="${appinfo.logoLocPath}"
													style="width: 100px;height: 100px"/>
											</div>
										</div>
                                    </form>
										</div>
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
										 <input type="button" class="btn btn-success" value="返回" onclick="location.href='${pageContext.request.contextPath}/dev/appinfo/appinfolist'"/>
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
	<!-- Bootstrap -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/statics/js/devUpdate.js"></script>
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
