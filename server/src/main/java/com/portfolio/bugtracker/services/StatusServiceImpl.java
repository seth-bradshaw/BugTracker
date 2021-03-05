package com.portfolio.bugtracker.services;

import com.portfolio.bugtracker.models.Status;
import com.portfolio.bugtracker.models.Ticket;
import com.portfolio.bugtracker.models.User;
import com.portfolio.bugtracker.repositories.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service(value = "statusservice")
public class StatusServiceImpl implements StatusService
{
    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private UserService userService;

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
            for (Ticket t : s1.getTickets())
            {
                System.out.println("HERES TOHNY==> " + t);
                ticketService.findTicketById(t.getTicketid());
                status.getTickets().add(t);
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

    @Override
    public Set<Status> findStatusByUser() throws Exception
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user;
        Set<Status> statusRtnList = new HashSet<>();

        if (authentication != null)
        {
            user = userService.findByUsername(authentication.getName());
        }
        else
        {
            throw new Exception("YOU ARE NOT LOGGED IN");
        }

        List<Ticket> ticketList = ticketService.findAllTicketsByUserId(user.getUserid());

        for (Ticket t : ticketList)
        {
            statusRtnList.add(t.getStatus());
        }

        return statusRtnList;
    }
}
