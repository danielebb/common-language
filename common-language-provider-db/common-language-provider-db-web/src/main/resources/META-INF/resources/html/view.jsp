<%@include file="init.jsp" %>

<%
    String mainRequire = (String)renderRequest.getAttribute("common-language-provider-db-web/mainRequire");
%>

<clay:management-toolbar
    filterDropdownItems="${displayContext.localesDropdownItems}"
    showSearch="${displayContext.showSearch}"
    searchActionURL="${displayContext.searchURL}"
    searchInputName="${displayContext.searchParameter}"
    searchValue="${displayContext.searchKeywords}"
/>

<div class="closed container-fluid-1280">

    <liferay-frontend:fieldset label="add-translation" />

    <aui:form action="${displayContext.addTranslationURL}" method="post" name="addTranslationFm">

        <aui:input name="languageId" type="hidden" value="${displayContext.languageId}" />
        <aui:input name="redirect" type="hidden" value="${displayContext.redirectURL}" />

        <aui:model-context bean="${displayContext.emptyTranslation}" model="${displayContext.emptyTranslation.modelClass}" />

        <aui:row>
            <aui:col span="4">
                <aui:input name="key" />
            </aui:col>
            <aui:col span="4">
                <aui:input name="value" />
            </aui:col>
            <aui:col span="2">
                <aui:button type="submit" value="add" />
            </aui:col>
        </aui:row>

    </aui:form>

    <liferay-frontend:fieldset label="edit-existing-translation" />

    <liferay-ui:search-container compactEmptyResultsMessage="true" searchContainer="${displayContext.searchContainer}">

        <liferay-ui:search-container-row className="it.dbb.common.language.provider.db.model.Translation"
                                         keyProperty="translationId" modelVar="translation"
                                         rowVar="row" >

            <liferay-ui:search-container-column-text name="key" property="key" />

            <liferay-ui:search-container-column-text name="value" >

                <div id="${renderResponse.namespace}valueCol-${row.pos}"></div>

                <aui:script require='<%= mainRequire %>' position="bottom">

                    var componentConfig = {

                        name: 'value',
                        id: 'value-${row.pos}',
                        portletNamespace: '${renderResponse.namespace}',
                        curValue: '${translation.value}',
                        actionURL: '${displayContext.getEditTranslationURL(translation)}'
                    }

                    new Main.default('${renderResponse.namespace}valueCol-${row.pos}',
                            componentConfig);

                </aui:script>

            </liferay-ui:search-container-column-text>

            <liferay-ui:search-container-column-text>

                <liferay-ui:icon-delete url="${displayContext.getDeleteTranslationURL(translation)}" showIcon="true" />

            </liferay-ui:search-container-column-text>

        </liferay-ui:search-container-row>

        <liferay-ui:search-iterator markupView="lexicon" />

    </liferay-ui:search-container>

</div>