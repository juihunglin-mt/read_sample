<%@ page language="java" import="java.util.*" pageEncoding="BIG5"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>File Template delete</title>

</head>
<s:action name="content-get" executeResult="false">
	<param name="id" value="#parameters.id" />
</s:action>
<body>
	<s:form action="content-delete" method="post" theme="simple">
		<table border="1">
			<tr>
				<td>
					<s:hidden name="id" value="%{#request.content.contentId}" />
					<font color="red">Delete "<s:property value="#request.content.name" />" ?</font>
				</td>
			</tr>
			<tr>
				<td align="right"><s:submit value="Submit" /></td>
			</tr>
		</table>
	</s:form>
</body>
</html>
