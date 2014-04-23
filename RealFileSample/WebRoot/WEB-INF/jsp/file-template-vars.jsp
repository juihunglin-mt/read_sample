<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript" src="js/jquery-2.0.3.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#update").click(function(){
		var id = $(this).attr("_vId");
		$.post(
			"vars-update",
		 	{ 
		 		contentId: <s:property value="#parameters.id" />,
		 		varsId: id,
		 		sort: $("#sort" + id).val(),
		 		rowIndex: $("#rowIndex" + id).val(),
		 		rowFilter: $("#rowFilter" + id).val(),
		 		rowReplace: $("#rowReplace" + id).val(),
		 		cellIndex: $("#cellIndex" + id).val(),
		 		cellFilter: $("#cellFilter" + id).val(),
		 		cellReplace: $("#cellReplace" + id).val(),
		 		active: $("#active" + id).val()
		 	}, function(data) {
            	location.reload();
            	return false;
    	});
	});

	$("#delete").click(function() {
		var id = $(this).attr("_vId");
		$.post("vars-delete", { varsId: id}, function(data) {
        	location.reload();
        	return false;
        });
	});
});
</script>
<title>File Template vars</title>
</head>
<s:action name="content-get" executeResult="false">
	<s:param name="id" value="#parameters.id" />
</s:action>
<s:action name="vars-by-cId" executeResult="false">
	<s:param name="contentId" value="#parameters.id" />
</s:action>
<body>
	<s:form action="vars-save" method="post" theme="simple">
		<table border="1">
			<caption>Content >> [ <s:property value="#request.content.name"/> ]</caption>
			<tr>
				<th>Sort</th>
				<th>Row Index</th>
				<th>Row Filter</th>
				<th>Row Replace</th>
				<th>Cell Index</th>
				<th>Cell Filter</th>
				<th>Cell Replace</th>
				<th>Read Active</th>
				<th>Management</th>
			</tr>
			<s:iterator value="#request.varses">
				<tr>
					<td><s:select id="sort%{varsId}" list="#{0:'First',1:'Last'}" value="%{sort}" /></td>
					<td><s:textfield id="rowIndex%{varsId}" value="%{rowIndex}"/></td>
					<td><s:textfield id="rowFilter%{varsId}" value="%{rowFilter}"/></td>
					<td><s:textfield id="rowReplace%{varsId}" value="%{rowReplace}"/></td>
					<td><s:textfield id="cellIndex%{varsId}" value="%{cellIndex}"/></td>
					<td><s:textfield id="cellFilter%{varsId}" value="%{cellFilter}"/></td>
					<td><s:textfield id="cellReplace%{varsId}" value="%{cellReplace}"/></td>
					<td><s:select id="active%{varsId}" list="#{0:'False',1:'True'}" value="%{active}"/></td>
					<td>
						<input type="button" id="update" value="UPDATE" _vId="<s:property value="varsId"/>"/>
						<input type="button" id="delete" value="DELETE" _vId="<s:property value="varsId"/>"/>
					</td>
				</tr>
			</s:iterator>
				<tr>
					<td>
						<s:hidden name="contentId" value="%{#request.content.contentId}" />
						<s:select name="sort" list="#{0:'First',1:'Last'}" />
					</td>
					<td><s:textfield name="rowIndex" /></td>
					<td><s:textfield name="rowFilter" /></td>
					<td><s:textfield name="rowReplace" /></td>
					<td><s:textfield name="cellIndex" /></td>
					<td><s:textfield name="cellFilter" /></td>
					<td><s:textfield name="cellReplace" /></td>
					<td><s:select name="active" list="#{0:'False',1:'True'}" /></td>
					<td>
						<s:submit value="SAVE" />
					</td>
				</tr>
		</table>
	</s:form>
</body>
</html>
