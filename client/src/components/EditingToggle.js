import React from 'react';
import { Input, Message } from 'semantic-ui-react';

export default function EditingToggle({ toggleState, getter, setter }) {
  return (
    <>
      {toggleState ? (
        <Message color="red">
          <Input type="text" value={getter} onChange={setter} />
        </Message>
      ) : (
        <Message color="green">{getter}</Message>
      )}
    </>
  );
}
