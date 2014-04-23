<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>File Template edit</title>

</head>
<s:action name="type-active" executeResult="false"></s:action>
<s:action name="content-get" executeResult="false">
	<param name="id" value="#parameters.id" />
</s:action>
<body>
	<s:form action="content-update" theme="simple" method="post">
		<table border="1">
			<tr>
				<th>Type:</th>
				<td><s:select name="typeId" list="#request.types" listKey="typeId" listValue="name" value="#request.content.type.typeId"/></td>
			</tr>
			<tr>
				<th>Name:</th>
				<td><s:textfield name="name" value="%{#request.content.name}"/></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><s:submit value="Submit"/></td>
			</tr>
		</table>
	</s:form>
</body>
</html>
