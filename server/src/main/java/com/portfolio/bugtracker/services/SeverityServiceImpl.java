package com.portfolio.bugtracker.services;

import com.portfolio.bugtracker.models.Severity;
import com.portfolio.bugtracker.models.Ticket;
import com.portfolio.bugtracker.models.TicketSeverities;
import com.portfolio.bugtracker.repositories.SeverityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "severityservice")
public class SeverityServiceImpl implements SeverityService
{
    @Autowired
    private SeverityRepository severityRepository;

    @Autowired
    private TicketService ticketService;

    @Override
    public Severity findBySeverityId(long severityid)
    {
        Severity severity = severityRepository.findById(severityid)
                .orElseThrow(() ->  new EntityNotFoundException("Severity with id " + severityid + " not found!"));

        return severity;
    }

    @Override
    public Severity save(Severity sev1) throws Exception
    {
        Severity severity = new Severity();
        if (sev1.getSeverityid() != 0)
        {
            severityRepository.findById(sev1.getSeverityid())
                    .orElseThrow(() -> new EntityNotFoundException("Severity with id " + sev1.getSeverityid() + " not found!"));
            severity.setSeverityid(sev1.getSeverityid());
        }

        severity.setSeveritylevel(sev1.getSeveritylevel());

        if (sev1.getTickets().size() > 0)
        {
            for (TicketSeverities ts : sev1.getTickets())
            {
                Ticket ticket = ticketService.findTicketById(ts.getTicket().getTicketid());

                severity.getTickets().add(new TicketSeverities(ticket, severity));
            }
        }

        return severityRepository.save(severity);
    }

    @Override
    public List<Severity> findAllSeverties()
    {
        List<Severity> severityList = new ArrayList<>();
        severityRepository.findAll().iterator().forEachRemaining(severityList::add);

        return severityList;
    }

    @Override
    public void deleteSeverityById(long severityid)
    {
        severityRepository.deleteById(severityid);
    }

    @Override
    public Severity edit(Severity partiallyEditedSeverity) throws Exception
    {
        if (partiallyEditedSeverity.getSeverityid() == 0)
        {
            throw new Exception("You cannot patch a non existent Severity!");
        }

        Severity updatedSeverity = severityRepository.findById(partiallyEditedSeverity.getSeverityid())
                .orElseThrow(() -> new EntityNotFoundException("Severity with id " + partiallyEditedSeverity.getSeverityid() + " not found!"));

        if (partiallyEditedSeverity.getSeveritylevel() > -1)
        {
            updatedSeverity.setSeveritylevel(partiallyEditedSeverity.getSeveritylevel());
        }

        if (partiallyEditedSeverity.getTickets().size() > 0)
        {
            throw new Exception("You cannot edit or create Tickets through Severity.");
        }

        return severityRepository.save(updatedSeverity);
    }
}
