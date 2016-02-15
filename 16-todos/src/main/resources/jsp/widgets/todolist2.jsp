<%@ taglib uri="/struts-tags" prefix="s"%>
<h1>lista todo</h1>
<s:iterator value="list">
	<li>
		<s:property value="task"/>
		<s:form action="deletetodo" >
			<s:hidden name="id"/>
			<s:submit value="elimina"/>
		</s:form>
		<s:form action="edittodo" >
				<s:hidden name="id"/>
				<s:submit value="modifica"/>
		</s:form>

	</li>
</s:iterator>