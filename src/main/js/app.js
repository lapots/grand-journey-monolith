import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import ReactPaginate from 'react-paginate';
import $ from 'jquery';
import util from 'util';

window.React = React;

export class CommentList extends Component {
    render() {
        let commentNotes = this.props.data.map(function(comment, index) {
            return (
                <div key={index}>{comment.comment}</div>
            );
        });
        return (
            <div id="project-comments" className="commentList">
                <ul>
                    {commentNotes}
                </ul>
            </div>
        )
    };
}

export class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            data: [],
            offset: 0
        }
    };

    loadComments() {
        $.ajax({
            url         : 'http://localhost:8080/grand-journey/players/all',
            dataType    : 'json',
            type        : 'GET',
            success: data => {
                this.setState({data: data.comments.slice(offset, offset + 10), pageCount: 20})
            }
        }};
    }

    componentDidMount() {
        this.loadComments();
    }

    handlePageClick = (data) => {
        let selected = data.selected;
        let offset = Math.ceil(selected * this.props.perPage);
        this.setState({offset: offset}, () => {
            this.loadComments();
        });
    };

    generateData = () => {
        var comments = [];
        for (var i = 0; i < 200; i++) {
            comments.push({
                    username : util.format('user-%s', i),
                    comment  : util.format('This is the comment #%d', i)
            });
        }
    };

    render() {
        return (
            <div>
                <CommentList data={this.state.data}/>
                <ReactPaginate  previousLabel={"prev"}
                                nextLabel={"next"}
                                breakLabel={<a href="">...</a>}
                                breakClassName={"break-me"}
                                pageCount={this.state.pageCount}
                                marginPagesDisplayed={2}
                                pageRangeDisplayed={5}
                                onPageChange={this.handlePageClick}
                                containerClassName={"pagination"}
                                activeClassName={"active"}/>
            </div>
        );
    }
}



ReactDOM.render(
    <App perPage={5}/>,
    document.getElementById('react-paginate')
);
