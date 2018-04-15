<%@include file="init.jsp" %>

<liferay-portlet:renderURL varImpl="filterURL" />

<aui:form action="${filterURL.toString()}" method="get" name="filterFm">

	<liferay-portlet:renderURLParams varImpl="filterURL" />

	<aui:select label="language" name="language" changesContext="true">

		<c:forEach items="${languageIds}" var="languageId">
		
			<aui:option label="${languageId}" />
		
		</c:forEach>

	</aui:select>

</aui:form>
