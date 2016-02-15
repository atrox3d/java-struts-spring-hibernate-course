<%@ taglib uri="/struts-tags" prefix="s"%>
<h1>lista todo</h1>
<s:iterator value="list">
	<li>
		<s:form theme="simple">
			<s:property value="task" />
				<s:hidden name="id" />
				<s:submit value="elimina" action="deletetodo" />
				<s:submit value="modifica" action="edittodo" />
		</s:form>
	</li>
</s:iterator>
