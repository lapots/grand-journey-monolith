import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import TableCard from "./components/table-card";

window.React = React;

export class App extends Component {
    render() {
        return <TableCard
            title={'Players'}
            dataUrl={'http://localhost:8080/grand-journey/players/all'}
            limit={10}
        />
    }
}

ReactDOM.render(
    <App />,
    document.getElementById('react-paginate')
);
