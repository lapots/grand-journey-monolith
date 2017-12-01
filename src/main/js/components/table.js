import React, { Component } from 'react';
import { BootstrapTable, TableHeaderColumn } from 'react-bootstrap-table';
import $ from 'jquery';

export default class Table extends Component {
    constructor(props) {
        super(props);
        this.state = {
            dataUrl: this.props.dataUrl,
            limit: this.props.limit, // default values
            offset: 0,
            pageCount: 0,
            data: []
        };
    };

    componentDidMount() {
        this.loadData();
    }

    loadData = () => {
        $.ajax({
            url         : this.state.dataUrl + '?limit=' + this.state.limit + "&offset=" + this.state.offset,
            dataType    : 'json',
            type        : 'GET',
            success: data => {
                this.setState({
                    data: data.content,
                    pageCount: data.pageCount,
                    limit: data.limit,
                    offset: data.offset
                });
            },
            error: (xhr, status, err) => {
                console.error('error during data retrieval', status, err.toString());
            }
        });
    };

    render() {
        const options = {
            onPageChange : this.onPageChange,
            onSizePerPageListChange : this.onSizePerPageListChange
        };
        return (
            <BootstrapTable data={this.state.data} striped={true} hover={true} options = {options} pagination={true}>
                <TableHeaderColumn dataField={'name'} isKey={true}>Player name</TableHeaderColumn>
                <TableHeaderColumn dataField={'level'}>Player level</TableHeaderColumn>
                <TableHeaderColumn dataField={'clazz'}>Player class</TableHeaderColumn>
            </BootstrapTable>
        );
    }
}
