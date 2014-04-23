<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>File Template</title>

</head>
<s:action name="content-all" executeResult="false"></s:action>
<body>
	<table border="1">
		<caption>File Template</caption>
		<ul>
			<li><a href="file-template-new">Add</a></li>
		</ul>
		<tr>
			<th>Type</th>
			<th>Name</th>
			<th>Management</th>
		</tr>
		<s:iterator value="#request.contents">
			<tr>
				<td><s:property value="type.name"/></td>
				<td><s:property value="name"/></td>
				<td>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="file-template-edit?id=${contentId}">[EDIT]</a>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="file-template-del?id=${contentId}">[DELETE]</a>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="file-template-vars?id=${contentId}">[VARS]</a>
				</td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>
