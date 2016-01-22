<%@ taglib uri="/struts-tags" prefix="s"%>
<s:form action="welcome">
	<s:textfield name="username" label="nome utente"/>
	<s:textfield name="password" label="password"/>
	<s:submit value="accedi"/>
</s:form>