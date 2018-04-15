<%@page import="it.dbb.common.language.loader.db.model.Language"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>

<%@ include file="init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

Language language = (Language)row.getObject();
%>

<c:set var="language" value="<%= language %>" />

<liferay-ui:icon-menu direction="left-side" icon="" markupView="lexicon" message="" showWhenSingleIcon="true">

	<%-- TODO: permissions --%>

	<portlet:renderURL var="editLanguageURL">
		<portlet:param name="mvcRenderCommandName" value="/edit" />
		<portlet:param name="redirect" value="${redirect}" />
		<portlet:param name="languageId" value="${language.languageId}" />
		<portlet:param name="languageCode" value="${languageCode}" />
	</portlet:renderURL>

	<liferay-ui:icon
		message="edit"
		url="<%= editLanguageURL %>"
	/>
	
	<portlet:actionURL var="deleteLanguageURL" name="deleteLanguage">
		<portlet:param name="redirect" value="${redirect}" />
		<portlet:param name="languageId" value="${language.languageId}" />
	</portlet:actionURL>
	
	<liferay-ui:icon-delete url="<%= deleteLanguageURL %>" message="delete" />

</liferay-ui:icon-menu>