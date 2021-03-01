import React, {useState, useEffect} from 'react'

export default function BoardTicket(props) {
    //temp fixes until redux is implemented site wide.
    const {ticket} = props;

    const onDragStart = (e, id) =>
    {
        console.log('dragstart: ', id)
        e.dataTransfer.setData("id", id)
    }

    return (
        <div style={{border:"2px solid green"}} draggable onDragStart={(e) => onDragStart(e, ticket.ticketid)}>
            <h3>{ticket.title}</h3>
        </div>
    )
}
