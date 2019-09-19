import React from 'react';
import qs from 'qs';

class SaveOnEditComponent extends React.Component {

    constructor(props) {

        super(props);

        this.state = {

            edit: false,
            value: props.curValue,
            savedValue: props.curValue
        }
    }

    render() {

        if(this.state.edit) {

            const namespacedName = this.props.namespace + this.props.name
            const id = this.props.id ? (this.props.namespace + this.props.id) : namespacedName;

            return (
                <input onBlur={(event) => this.lostFocus(event)} onChange={(event) => this.handleChange(event)}
                    id={id} name={namespacedName}
                    type="text" value={this.state.value}
                    className="field form-control lfr-input-text"
                    autoFocus="true" />
            );
        }

        return (
            <div className="editable-component" onClick={() => this.gainFocus()} >{this.state.savedValue}</div>
        );
    }

    handleChange(event) {

        this.setState({value: event.target.value});
    }

    /*
    element gained focus, render as input
     */
    gainFocus() {

        this.setState({
            edit: true
        });
    }

    /*
    element lost focus, submit the value and return to read-only text
     */
    lostFocus() {

        if(this._isValueChanged()) {

            this.submitValue();
        }

        this.setState({edit: false});
    }

    submitValue() {

        const actionURL = this.props.actionURL;

        const requestBody = {};

        requestBody[this.props.namespace + 'value'] = this.state.value;

        fetch(actionURL, {

            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            body: qs.stringify(requestBody)

        }).then((response) => {

            console.log(actionURL + " responded with HTTP "+response.status);

            if(response.ok) {

                this.setState((state, props) => ({savedValue: state.value}));
            }
        });
    }

    _isValueChanged() {

        return this.state.value !== this.state.savedValue;
    }
}

export default SaveOnEditComponent;
