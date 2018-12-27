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
									<form id="demo-form2" data-parsley-validate=""
										action="${pageContext.request.contextPath}/dev/appinfo/appinfoUpdate"
										class="form-horizontal form-label-left" novalidate=""
										method="post" enctype="multipart/form-data">
										<h2>${error}</h2>
										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12"
												for="first-name">软件名称<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<input type="hidden" value="${appinfo.id}" name="id" /> <input
													type="text" id="first-name" placeholder="请输入软件名称"
													class="form-control col-md-7 col-xs-12" name="softwareName"
													value="${appinfo.softwareName}" required="required"> <input
													type="hidden" value="0" name="appinfojude" />
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12"
												for="last-name">APK名称<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<input type="text" id="APKName" name="APKName"
													placeholder="请输入APK名称"
													onblur="javascript:checkedAPKNames();"
													class="form-control col-md-7 col-xs-12"
													value="${appinfo.APKName}"
													required="required">
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
													value="${appinfo.supportROM}" required="required">
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12">
												界面语言<span class="required">*</span> </label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<input id="middle-name" placeholder="请输入软件支持的界面语言"
													class="form-control col-md-7 col-xs-12" type="text"
													name="interfaceLanguage"
													value="${appinfo.interfaceLanguage}" required="required">
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12">
												软件大小<span class="required">*</span> </label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<input id="birthday" placeholder="请输入软件大小，单位为MB"
													class="date-picker form-control col-md-7 col-xs-12"
													name="softwareSize" type="number"
													value="${appinfo.softwareSize}" required="required">
											</div>
										</div>

										<div class="form-group">
											<label for="middle-name"
												class="control-label col-md-3 col-sm-3 col-xs-12">
												下载次数<span class="required">*</span> </label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<input id="middle-name" placeholder="请输入下载次数"
													class="form-control col-md-7 col-xs-12" type="number"
													name="downloads" value="${appinfo.downloads}" required="required">
											</div>
										</div>
										<div class="form-group">
											<label for="middle-name"
												class="control-label col-md-3 col-sm-3 col-xs-12">
												所属平台<span class="required">*</span> </label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<select class="form-control col-md-7 col-xs-12"
													name="flatformId" id="flatformIds">
													<option value="">--请选择--</option>
													<c:forEach var="flat" items="${dataFlatform}">
														<option value="${flat.valueId}"
															<c:if test="${appinfo.flatformId==flat.valueId}">selected="selected"</c:if>>${flat.valueName}</option>
													</c:forEach>

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
													<c:forEach var="appcategorys" items="${appcategory}">
														<option value="${appcategorys.id}"
															<c:if test="${appinfo.categoryLevel1==appcategorys.id}">selected='selected'</c:if>>${appcategorys.categoryName}</option>
													</c:forEach>
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
													<c:forEach var="appcategorys" items="${appcategory2}">
														<option value="${appcategorys.id}"
															<c:if test="${appinfo.categoryLevel2==appcategorys.id}">selected="selected"</c:if>>${appcategorys.categoryName}</option>
													</c:forEach>
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
													<c:forEach var="appcategorys" items="${appcategory3}">
														<option value="${appcategorys.id}"
															<c:if test="${appinfo.categoryLevel3==appcategorys.id}">selected="selected"</c:if>>${appcategorys.categoryName}</option>
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="form-group">
											<label for="middle-name"
												class="control-label col-md-3 col-sm-3 col-xs-12">
												APP状态<span class="required">*</span> </label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<c:if test="${appinfo.status==1}">待审核</c:if>
												<c:if test="${appinfo.status==3}">审核未通过</c:if>
												<input id="middle-name"
													class="form-control col-md-7 col-xs-12" type="hidden"
													name="status" value="${appinfo.status}">
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12">Date
												应用简介 <span class="required">*</span> </label>
											<div class="col-md-9 col-sm-9 col-xs-12">
												<textarea class="form-control" cols="4" style="width: 550px"
													placeholder="请输入本软件的相关信息，本信息作为软件的详细信息进行软件介绍" name="appInfo"
													value="${appinfo.appInfo}">${appinfo.appInfo}</textarea>
											</div>
										</div>
										<div class="form-group">
											<label for="middle-name"
												class="control-label col-md-3 col-sm-3 col-xs-12">
												LOGO图片<span class="required">*</span> </label>
											<div class="col-md-6 col-sm-6 col-xs-12" id="changePic">
												<div id="hhh" <c:if test="${appinfo.logoLocPath==null}">
													 style="display: none"
												</c:if>>
												<img alt=""
													src="${appinfo.logoLocPath}"
													style="width: 100px;height: 100px"
													><a
													href="javascript:changePic(${appinfo.id});"
													style="vertical-align: middle;">删除</a> <input
													id="middle-name" class="form-control col-md-7 col-xs-12"
													type="hidden" name="logoPicPath"
													value="${appinfo.logoPicPath}"> <input
													id="middle-name" class="form-control col-md-7 col-xs-12"
													type="hidden" name="logoLocPath"
													value="${appinfo.logoLocPath}">
													</div>
													<input id='middle-name' class='form-control col-md-7 col-xs-12'
													type='file' name='uploadfiles' 
													<c:if test="${appinfo.logoLocPath!=null}">
													 style="display: none"
													</c:if>>
											</div>
										</div>
										<div class="form-group">
											<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
												<c:if test="${appinfo.status==1}">
													<input type="submit" value="保存" class="btn btn-primary" />
													<input type="button" value="返回" class="btn btn-success"
														onclick="location.href='${pageContext.request.contextPath}/dev/appinfo/appinfolist'" />
												</c:if>
												<c:if test="${appinfo.status==3}">
													<input type="submit" value="保存并再次提交审核"
														class="btn btn-primary"
														onclick="javascript:valuesChange();" />
													<input type="submit" value="保存" class="btn btn-primary" />
													<input type="button" value="返回" class="btn btn-success"
														onclick="location.href='${pageContext.request.contextPath}/dev/appinfo/appinfolist'" />
												</c:if>
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
