<%@include file="init.jsp" %>

<portlet:actionURL name="editLanguage" var="editLanguageURL" />

<aui:form action="<%= editLanguageURL %>" method="post" name="editLanguageFm" cssClass="container-fluid-1280" >

	<aui:input name="redirect" value="${redirect}" type="hidden" />
	<aui:input name="mvcRenderCommand" value="/edit" type="hidden" />
	<aui:input name="languageCode" value="${languageCode}" type="hidden" />
	<aui:input name="languageId" value="${languageId}" type="hidden" />

	<aui:model-context bean="${modelBean}" model="${modelClass}" />
	
	<aui:input name="key" />
	
	<aui:input name="value" />

	<aui:button-row>
		<aui:button type="submit" value="save" />
		<aui:button type="button" value="cancel" href="${backURL}" />
	</aui:button-row>

</aui:form>
