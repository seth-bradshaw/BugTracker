import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useDispatch, useSelector } from 'react-redux';
import { Header, Modal, Statistic, Icon } from 'semantic-ui-react';
import { actions as statusActions } from '../../store/ducks/statusDuck';
import { actions as ticketActions } from '../../store/ducks/ticketDuck';

export default function TestTicketBoard() {
  //I'm thinking we pass tickets through props so that this component can be used for every trello board
  const [completed, setCompleted] = useState([]);
  const [notStarted, setNotStarted] = useState([]);
  const [inProgress, setInProgress] = useState([]);
  const [showTicketModal, setShowTicketModal] = useState(false);
  const [company, setCompany] = useState({});
  const dispatch = useDispatch();
  const status = useSelector(state => state.statuses.ticketStatus);
  const statuses = useSelector(state => state.statuses.statuses);
  const tickets = useSelector(state => state.tickets.tickets);

  useEffect(() => {
    dispatch(ticketActions.fetchAllTicketsThunk());
    dispatch(statusActions.fetchSingleStatusThunk(12));
    dispatch(statusActions.fetchStatusesThunk());
    axios
      .get('http://localhost:2019/companies/company/4')
      .then(res => {
        setCompany(res.data);
      })
      .catch(err => {
        console.log(err);
      });
  }, []);

  const onDragStart = (e, id) => {
    console.log('DRAG START===> ', id);
    e.dataTransfer.setData('id', id);
  };

  const onDragOver = e => {
    console.log('DRAGGED OVER');
    e.preventDefault();
  };

  const onDrop = (e, status) => {
    let id = e.dataTransfer.getData('id');
    console.log('ON DROP==> ', id);

    let tasks = tickets.filter(tkt => {
      if (tkt.ticketid == id) {
        tkt.status.statustype = status.statustype;
      }
      return tkt;
    });

    if (status.statustype === 'Not Started') {
      setNotStarted({ ...notStarted, tasks });
    }
    if (status.statustype === 'In Progress') {
      setInProgress({ ...inProgress, tasks });
    }
    if (status.statustype === 'Completed') {
      setCompleted({ ...completed, tasks });
    }
    console.log(
      'Not started: ',
      notStarted,
      '\n In progress: ',
      inProgress,
      '\n completed: ',
      completed
    );
  };

  const notStartedTickets = () =>
    tickets.filter(tkt => tkt.status.statustype === 'Not Started');
  const inProgressTickets = () =>
    tickets.filter(tkt => tkt.status.statustype === 'In Progress');
  const completedTickets = () =>
    tickets.filter(tkt => tkt.status.statustype === 'Completed');

  const items = [
    {
      key: 'notstarted',
      label: 'Not Started',
      value: notStartedTickets().length.toString(),
    },
    {
      key: 'inprogress',
      label: 'In Progress',
      value: inProgressTickets().length.toString(),
    },
    {
      key: 'completed',
      label: 'Completed',
      value: completedTickets().length.toString(),
    },
  ];

  // const useCreateStatusState = (status) => {
  //     const [statusState, setStatusState] = useState([])

  //     status["statusState"] = statusState
  //     status["setStatusState"] = setStatusState
  //     return status
  // }
  console.log('HERE IS STATUS FROM DUCK===> ', status);
  return (
    <div style={{ width: '80%', margin: 'auto' }}>
      <div
        className="ticket-board-header"
        style={{
          width: '100%',
          height: '75px',
          backgroundColor: 'rgb(43,44,46)',
          display: 'flex',
          justifyContent: 'space-between',
        }}
      >
        <p style={{ color: 'white', margin: '1.75% 0% 1% 2.5%' }}>
          {company.companyname}
        </p>
        <Statistic.Group items={items} />
        <Icon
          link
          to="/"
          name="setting"
          style={{ color: 'white', margin: '1.75% 2.5% 1%' }}
        />
      </div>
      <div style={{ display: 'flex', justifyContent: 'space-evenly' }}>
        {statuses.map(status => {
          return (
            <div
              onDragOver={e => onDragOver(e)}
              onDrop={e => onDrop(e, status)}
              style={{ backgroundColor: '#f1f1f1', width: '25%' }}
            >
              <h3>{status.statustype}</h3>
              {tickets.map(tkt => {
                if (tkt.status.statustype === status.statustype) {
                  return (
                    <Modal
                      onClose={() => setShowTicketModal(false)}
                      onOpen={() => setShowTicketModal(true)}
                      trigger={
                        <div
                          draggable
                          onDragStart={e => onDragStart(e, tkt.ticketid)}
                        >
                          <h4>{tkt.title}</h4>
                        </div>
                      }
                    >
                      <Modal.Header>{tkt.title}</Modal.Header>
                      <Modal.Content>
                        <Modal.Description>
                          <h4>Category:</h4>
                          <p>{tkt.category.categorytype}</p>
                          <h4>Error Code:</h4>
                          <p>{tkt.errorcode}</p>
                          <h4>Severity:</h4>
                          <p>{tkt.severity}</p>
                          <h4>Description:</h4>
                          <p>{tkt.description}</p>
                        </Modal.Description>
                      </Modal.Content>
                    </Modal>
                  );
                }
              })}
            </div>
          );
        })}
      </div>
    </div>
  );
}
