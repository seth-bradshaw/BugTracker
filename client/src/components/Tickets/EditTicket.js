import React, { useState } from 'react';
import { Button } from 'semantic-ui-react';

import Ticket from './Ticket';
import PutTicket from './PutTicket';

export default function EditTicket({ ticketData }) {
  const [getIsEditing, setIsEditing] = useState(false);
  const { ticket } = ticketData;

  const handleClick = e => {
    setIsEditing(!getIsEditing);
  };

  return (
    <>
      {getIsEditing ? (
        <PutTicket ticket={ticket} />
      ) : (
        <Ticket ticket={ticket} />
      )}
      {getIsEditing ? (
        <Button onClick={handleClick}>Cancel</Button>
      ) : (
        <Button onClick={handleClick}>Edit</Button>
      )}
    </>
  );
}
