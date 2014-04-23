<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>File Template new</title>

</head>
<s:action name="type-active" executeResult="false"></s:action>
<body>
	<s:form action="content-save" theme="simple" method="post">
		<table border="1">
			<tr>
				<th>Type:</th>
				<td><s:select name="typeId" list="#request.types" listKey="typeId" listValue="name" /></td>
			</tr>
			<tr>
				<th>Name:</th>
				<td><s:textfield name="name" /></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><s:submit value="Submit"/></td>
			</tr>
		</table>
	</s:form>
</body>
</html>
