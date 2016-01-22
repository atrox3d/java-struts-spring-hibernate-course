<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<title>index.jsp</title>
</head>
<body>
<s:form action="product">
	<s:textfield name="id" label="Product Id"></s:textfield>
	<s:textfield name="name" label="Product Name"></s:textfield>
	<s:textfield name="price" label="Product Price"></s:textfield>
	<s:submit value="save"></s:submit>
</s:form>
</body>
</html>