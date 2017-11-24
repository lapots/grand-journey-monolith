'use strict';

const React = require('react');
const ReactDOM = require('react-dom');

class App extends React.Component {
    render() {
        return <Pagination />
    }
}

class Pagination extends React.Component {
    render() {
        return <nav aria-label="Page navigation">
                <ul className="pagination" id="pages"></ul>
            </nav>
    }
}

ReactDOM.render(
    <App />,
    document.getElementById('react'),
    function() {
        $('#pages').twbsPagination({
            totalPages: 10,
            visiblePages: 4,
            onPageClick: function(event, page) {
                console.info(page);
            }
        });
    }
);
