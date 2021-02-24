package com.portfolio.bugtracker.services;

import com.portfolio.bugtracker.models.Status;
import com.portfolio.bugtracker.models.Ticket;
import com.portfolio.bugtracker.models.TicketStatuses;
import com.portfolio.bugtracker.repositories.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "statusservice")
public class StatusServiceImpl implements StatusService
{
    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private TicketService ticketService;

    @Override
    public Status findByStatusId(long statusid)
    {
        Status status = statusRepository.findById(statusid).orElseThrow(() -> new EntityNotFoundException("Status with id " + statusid + " not found!"));

        return status;
    }

    @Override
    public Status save(Status s1) throws Exception
    {
        Status status = new Status();
        if (s1.getStatusid() != 0)
        {
            statusRepository.findById(s1.getStatusid())
                    .orElseThrow(() -> new EntityNotFoundException("Status with id " + s1.getStatusid() + " not found!"));
            status.setStatusid(s1.getStatusid());
        }

        status.setStatustype(s1.getStatustype());

        if (s1.getTickets().size() > 0)
        {
            for (TicketStatuses ts : s1.getTickets())
            {
                Ticket ticket = ticketService.findTicketById(ts.getTicket().getTicketid());

                status.getTickets().add(new TicketStatuses(ticket, ts.getStatus()));
            }
        }

        return statusRepository.save(status);
    }

    @Override
    public List<Status> findAllStatuses()
    {
        List<Status> statusList = new ArrayList<>();
        statusRepository.findAll().iterator().forEachRemaining(statusList::add);

        return statusList;
    }

    @Override
    public void deleteStatusById(long statusid)
    {
        statusRepository.deleteById(statusid);
    }
}
