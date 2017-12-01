import React, { Component } from 'react';
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
        return (
            <table className="table table-striped table-hover">
                {this.tableHeader()}
                {this.tableBody()}
            </table>
        );
    }

    tableHeader = () => {
        return (
            <thead className={"thead-dark"}>
                <tr>
                    <th>Player name</th>
                    <th>Player level</th>
                    <th>Player class</th>
                </tr>
            </thead>
        );
    };

    tableBody = () => {
        let rows = this.state.data.map(function(player, index) {
           return (
               <tr>
                   <td scope={"row"}>{player.name}</td>
                   <td>{player.level}</td>
                   <td>{player.clazz}</td>
               </tr>
           );
        });
        return (
          <tbody>
                {rows}
          </tbody>
        );
    };
}