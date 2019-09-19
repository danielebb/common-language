
import React from 'react';
import ReactDOM from 'react-dom';

import SaveOnEditComponent from './SaveOnEditComponent.es';


/**
 * This is the main entry point of the portlet.
 *
 * See https://tinyurl.com/js-ext-portlet-entry-point for the most recent 
 * information on the signature of this function.
 *
 * @param  {Object} params a hash with values of interest to the portlet
 * @return {void}
 */
export default function(portletElementId, configs) {

    console.log("Element id: "+portletElementId);

    ReactDOM.render(
        <SaveOnEditComponent
            namespace={configs.portletNamespace}
            name={configs.name}
            curValue={configs.curValue}
            actionURL={configs.actionURL}
            id={configs.id}
        />,
        document.getElementById(portletElementId)
    );
    
}