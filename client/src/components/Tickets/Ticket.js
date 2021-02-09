import React from 'react';
import { Container, Header, Icon, Divider } from 'semantic-ui-react';

export default function Ticket({ ticket }) {
  return (
    <Container fluid textAlign="center">
      <Header as="h3" icon>
        <Icon name="file alternate outline" />
        {ticket.ticket.title}
      </Header>
      <Divider />
    </Container>
  );
}
