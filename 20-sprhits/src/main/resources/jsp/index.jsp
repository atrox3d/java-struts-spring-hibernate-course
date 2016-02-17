<%@taglib uri="/struts-tags" prefix="s" %>
<h1>register as user</h1>
<s:form action="user" >
	<s:textfield name="name" label="name"/>
	<s:submit value="register"/>
</s:form>
<h1>register as employee</h1>
<s:form action="employee">
	<s:textfield name="name" label="name" />
	<s:textfield name="salary" label="salary" type="number"/>
	<s:submit value="register"/>
</s:form>