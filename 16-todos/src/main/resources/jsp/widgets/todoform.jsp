<%@ taglib uri="/struts-tags" prefix="s"%>


<!-- <div> -->
<%-- id = <s:property value="id"/> --%>
<!-- </div> -->


<s:if test="id==0">
	<s:form action="addtodo">
		<s:hidden name="id"/>
		<s:textfield name="task" label="nuovo task" autofocus="true"/>
		<s:submit value="inserisci"/>
	</s:form>
</s:if>
<s:else>
	<s:form action="updatetodo">
		<s:hidden name="id"/>
		<s:textfield name="task" label="nuovo task" autofocus="true"/>
		<s:submit value="modifica"/>
	</s:form>
</s:else>	

<%-- <s:form action="addtodo"> --%>
<%-- 	<s:hidden name="id"/> --%>
<%-- 	<s:textfield name="task" label="nuovo task" autofocus="true"/> --%>
<%-- 	<s:submit value="inserisci"/> --%>
<%-- </s:form> --%>
