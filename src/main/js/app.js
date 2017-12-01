import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import Table from './components/table';

window.React = React;

export class App extends Component {
    render() {
        return (
            <div className={ 'panel' }>
                <div className={ 'panel-heading' }>Players</div>
                <div className={ 'panel-body' }>
                    <Table dataUrl={'http://localhost:8080/grand-journey/players/all'} limit={10}/>
                </div>
            </div>
        );
    }
}

ReactDOM.render(
    <App />,
    document.getElementById('react-paginate')
);
