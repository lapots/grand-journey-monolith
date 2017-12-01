import React, { Component } from 'react';
import Table from "./table";

export default class TableCard extends Component {
    constructor(props) {
        super(props);
        this.state = {
            dataUrl: this.props.dataUrl,
            limit: this.props.limit,
            title: this.props.title
        };
    };

    render() {
        return (
            <div className={'card'}>
                <div className={'card-header'}>
                    {this.state.title}
                </div>
                <div className={'card-body'}>
                    <Table dataUrl={this.state.dataUrl} limit={this.state.limit}/>
                </div>
            </div>
        );
    }
}