package com.portfolio.bugtracker.controllers;
import com.portfolio.bugtracker.models.Company;
import com.portfolio.bugtracker.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController
{
    @Autowired
    CompanyService companyService;

    @GetMapping(value = "/users/{companyid}", produces = "application/json")
    public ResponseEntity<?> fetchUserById(@PathVariable long companyid) throws Exception
    {
        Company rtnComp = companyService.findCompanyById(companyid);

        return new ResponseEntity<>(rtnComp, HttpStatus.OK);
    }
}
