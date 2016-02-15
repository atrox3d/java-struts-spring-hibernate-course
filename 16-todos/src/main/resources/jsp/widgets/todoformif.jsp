<%@ taglib uri="/struts-tags" prefix="s"%>
<s:if test="id>0">
	<s:form action="addtodo">
		<s:hidden name="id"/>
		<s:textfield name="task" label="nuovo task" autofocus="true"/>
		<s:submit value="inserisci"/>
	</s:form>
<s:else>
	<s:form action="edittodo">
		<s:hidden name="id"/>
		<s:textfield name="task" label="nuovo task" autofocus="true"/>
		<s:submit value="edit"/>
	</s:form>
</s:else>
</s:if>
