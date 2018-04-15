<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ include file="init.jsp" %>

<liferay-frontend:management-bar includeCheckBox="false" searchContainerId="languages">
	<liferay-frontend:management-bar-filters>
	
		<liferay-frontend:management-bar-filter value="${localeFilterItemLabel}" managementBarFilterItems="${localeFilterItems}" />
	
	</liferay-frontend:management-bar-filters>
</liferay-frontend:management-bar>

<c:set var="redirect" value="${searchContainer.getIteratorURL().toString()}" scope="request" />

<div class="container-fluid-1280">
	<liferay-ui:search-container id="languages" searchContainer="${searchContainer}">

		<liferay-ui:search-container-row className="it.dbb.common.language.loader.db.model.Language" 
				keyProperty="languageId" modelVar="language">
		
			<liferay-ui:search-container-column-text title="key" property="key" />
			
			<liferay-ui:search-container-column-text title="value" property="value" />
			
			<liferay-ui:search-container-column-jsp
				cssClass="entry-action-column"
				path="/action.jsp"
			/>
		
		</liferay-ui:search-container-row>
		
		<liferay-ui:search-iterator markupView="lexicon" />
		
	</liferay-ui:search-container>
</div>

<liferay-frontend:add-menu>

	<portlet:renderURL var="addLanguageURL">
		<portlet:param name="mvcRenderCommandName" value="/edit" />
		<portlet:param name="languageCode" value="${languageCode}" />
		<portlet:param name="redirect" value="${redirect}" />
	</portlet:renderURL>

	<liferay-frontend:add-menu-item title='<%= LanguageUtil.get(request, "translation") %>' url="<%= addLanguageURL %>" />
</liferay-frontend:add-menu>