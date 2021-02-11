import React from 'react';
import { useHistory } from 'react-router-dom';
import { Button, Header, Icon, Segment } from 'semantic-ui-react';

const NoTickets = () => {
  const { push } = useHistory();
  return (
    <Segment placeholder>
      <Header icon>
        <Icon name="file alternate outline" />
        No tickets are listed for this customer.
      </Header>
      <Button primary onClick={() => push('/postticket')}>
        Add Ticket
      </Button>
    </Segment>
  );
};

export default NoTickets;
