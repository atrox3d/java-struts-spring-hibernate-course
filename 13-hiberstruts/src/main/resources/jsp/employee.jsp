<%@taglib uri="/struts-tags" prefix="s" %>
<P>
Welcome <s:property value="name"/>, your salary is <s:property value="salary"/>
</p>
<p>
here's a list of all registered employees:
</p>
<ul>
	<s:iterator value="employees">
		<li>
			<s:property value="name"/>
			<s:if test="isWanted">
				- catch him!
			<s:elseif test="isBroken">
				- broke
			</s:elseif>
			<s:else>
				- &euro; <s:property value="salary"/>
			</s:else>
			</s:if>
		</li>
	</s:iterator>
</ul>
