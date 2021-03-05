import React, { useState, useEffect } from "react";
import axios from "axios";
import { useDispatch, useSelector } from "react-redux";
import { Header, Modal, Statistic, Icon } from "semantic-ui-react";
import { actions as statusActions } from "../../store/ducks/statusDuck";
import { actions as ticketActions } from "../../store/ducks/ticketDuck";

export default function TestTicketBoard() {
  //I'm thinking we pass tickets through props so that this component can be used for every trello board
  const [showTicketModal, setShowTicketModal] = useState(false);
  const [company, setCompany] = useState({});
  const statuses = useSelector((state) => state.statuses.statuses);
  const ticket = useSelector((state) => state.tickets.ticket);
  const ticketStatus = useSelector((state) => state.statuses.status);
  const tickets = useSelector((state) => state.tickets.tickets);
  const [save, setSave] = useState(false);
  const dispatch = useDispatch();

  useEffect(() => {
    dispatch(ticketActions.fetchAllTicketsThunk());
    dispatch(statusActions.fetchStatusesThunk());

    axios
      .get("http://localhost:2019/companies/company/4")
      .then((res) => {
        setCompany(res.data);
      })
      .catch((err) => {
        console.log(err);
      });
  }, []);

  const onDragStart = (e, id) => {
    e.dataTransfer.setData("id", id);
  };

  const onDragOver = (e) => {
    console.log("DRAGGED OVER");
    e.preventDefault();
  };

  const onDrop = (e, status) => {
    let id = e.dataTransfer.getData("id");

    let tasks = tickets.filter((tkt) => {
      if (tkt.ticketid == id) {
        tkt.status.statustype = status.statustype;
      }
      return tkt;
    });

    // dispatch(
    //   ticketActions.editTicketThunk(ticket.ticketid, {
    //     title: ticket.title,
    //     description: ticket.description,
    //     errorcode: ticket.errorcode,
    //     notes: ticket.notes,
    //     severity: ticket.severity,
    //     users: ticket.users,
    //     category: ticket.category,
    //     status: status,
    //   })
    // );

    dispatch(statusActions.putStatusThunk(s));
    setSave(!save);
  };

  const notStartedTickets = () =>
    tickets.filter((tkt) => tkt.status.statustype === "Not Started");
  const inProgressTickets = () =>
    tickets.filter((tkt) => tkt.status.statustype === "In Progress");
  const completedTickets = () =>
    tickets.filter((tkt) => tkt.status.statustype === "Completed");

  const items = [
    {
      key: "notstarted",
      label: "Not Started",
      value: notStartedTickets().length.toString(),
    },
    {
      key: "inprogress",
      label: "In Progress",
      value: inProgressTickets().length.toString(),
    },
    {
      key: "completed",
      label: "Completed",
      value: completedTickets().length.toString(),
    },
  ];

  return (
    <div style={{ width: "80%", margin: "auto" }}>
      <div
        className="ticket-board-header"
        style={{
          width: "100%",
          height: "75px",
          backgroundColor: "rgb(43,44,46)",
          display: "flex",
          justifyContent: "space-between",
        }}
      >
        <p style={{ color: "white", margin: "1.75% 0% 1% 2.5%" }}>
          {company.companyname}
        </p>
        <Statistic.Group items={items} />
        <Icon
          link
          to="/"
          name="setting"
          style={{ color: "white", margin: "1.75% 2.5% 1%" }}
        />
      </div>
      <div style={{ display: "flex", justifyContent: "space-evenly" }}>
        {statuses.map((status) => {
          return (
            <div
              onDragOver={(e) => onDragOver(e)}
              onDrop={(e) => onDrop(e, status)}
              style={{ backgroundColor: "#f1f1f1", width: "25%" }}
              onClick={() =>
                dispatch(statusActions.fetchSingleStatusThunk(status.statusid))
              }
            >
              <h3>{status.statustype}</h3>
              {tickets.map((tkt) => {
                if (tkt.status.statustype === status.statustype) {
                  return (
                    <Modal
                      onClose={() => setShowTicketModal(false)}
                      onOpen={() => setShowTicketModal(true)}
                      trigger={
                        <div
                          draggable
                          onDragStart={(e) => {
                            onDragStart(e, tkt.ticketid);
                            dispatch(
                              ticketActions.fetchSingleTicketbyId(tkt.ticketid)
                            );
                          }}
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
