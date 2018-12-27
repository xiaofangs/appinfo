<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
										新增APP基础信息 <small><i class="fa fa-user"></i>${devUser.devName}</small>
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
									<h3>${error}</h3>
									<form id="demo-form2" data-parsley-validate=""
										action="${pageContext.request.contextPath}/dev/appinfo/appinfoInsert"
										class="form-horizontal form-label-left" novalidate=""
										method="post" enctype="multipart/form-data">

										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12"
												for="first-name">软件名称<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<input type="text" id="first-name" placeholder="请输入软件名称"
													class="form-control col-md-7 col-xs-12" 
													required="required"
													name="softwareName">
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12"
												for="last-name">APK名称<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<input type="text" id="APKName" name="APKName"
													placeholder="请输入APK名称" onblur="javascript:checkedAPKNames();"
													class="form-control col-md-7 col-xs-12"
													required="required"/>
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
													required="required">
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12">
												界面语言<span class="required">*</span> </label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<input id="middle-name" placeholder="请输入软件支持的界面语言"
													class="form-control col-md-7 col-xs-12" type="text"
													name="interfaceLanguage"
													required="required">
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12">
												软件大小<span class="required">*</span> </label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<input id="birthday" placeholder="请输入软件大小，单位为MB"
													class="date-picker form-control col-md-7 col-xs-12"
													name="softwareSize" type="number"
													required="required">
											</div>
										</div>

										<div class="form-group">
											<label for="middle-name"
												class="control-label col-md-3 col-sm-3 col-xs-12">
												下载次数<span class="required">*</span> </label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<input id="middle-name" placeholder="请输入下载次数"
													class="form-control col-md-7 col-xs-12" type="number"
													name="downloads"
													required="required">
											</div>
										</div>
										<div class="form-group">
											<label for="middle-name"
												class="control-label col-md-3 col-sm-3 col-xs-12">
												所属平台<span class="required">*</span> </label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<select
													class="form-control col-md-7 col-xs-12"
													name="flatformId" id="flatformIds">
												   <option value="">--请选择--</option>
												</select>
											</div>
										</div>
										<div class="form-group">
											<label for="middle-name"
												class="control-label col-md-3 col-sm-3 col-xs-12">
												一级分类<span class="required">*</span> </label>
											<div class="col-md-6 col-sm-6 col-xs-12">
													<select id="categoryLevel1"
													class="form-control col-md-7 col-xs-12"
													name="categoryLevel1" onchange="javascript:onChange(2);">
													<option value="">--请选择--</option>
													</select>
											</div>
										</div>
										<div class="form-group">
											<label for="middle-name"
												class="control-label col-md-3 col-sm-3 col-xs-12">
												二级分类<span class="required">*</span> </label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<select id="categoryLevel2"
													class="form-control col-md-7 col-xs-12"
													name="categoryLevel2" onchange="javascript:onChange(3);">
													</select>
											</div>
										</div>
										<div class="form-group">
											<label for="middle-name"
												class="control-label col-md-3 col-sm-3 col-xs-12">
												三级分类<span class="required">*</span> </label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<select id="categoryLevel3"
													class="form-control col-md-7 col-xs-12"
													name="categoryLevel3">
													</select>
											</div>
										</div>
										<div class="form-group">
											<label for="middle-name"
												class="control-label col-md-3 col-sm-3 col-xs-12">
												APP状态<span class="required">*</span> </label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												待审核 <input id="middle-name"
													class="form-control col-md-7 col-xs-12" type="hidden"
													name="status" value="1">
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12">Date
												应用简介 <span class="required">*</span> </label>
											<div class="col-md-9 col-sm-9 col-xs-12">
												<textarea class="form-control" cols="3" style="width: 550px" 
												placeholder="请输入本软件的相关信息，本信息作为软件的详细信息进行软件介绍"
												name="appInfo"></textarea>
											</div>
										</div>
										<div class="form-group">
											<label for="middle-name"
												class="control-label col-md-3 col-sm-3 col-xs-12">
												LOGO图片<span class="required">*</span> </label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<input id="middle-name"
													class="form-control col-md-7 col-xs-12" type="file"
													name="uploadfiles">
											</div>
										</div>
										<div class="form-group">
											<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
												<input type="submit" value="保存" class="btn btn-primary" /> <input
													type="button" value="返回" class="btn btn-success"
													onclick="location.href='${pageContext.request.contextPath}/dev/appinfo/appinfolist'" />
											</div>
										</div>
									</form>
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
	<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/devInsert.js"></script>
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
