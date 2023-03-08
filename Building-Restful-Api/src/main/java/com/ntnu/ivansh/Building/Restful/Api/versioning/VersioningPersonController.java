package com.ntnu.ivansh.Building.Restful.Api.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
    @GetMapping(path = "/v1/person")
    public PersonV1 getFirstVersionOfPerson(){
        return new PersonV1("Bob Charlie");
    }
    @GetMapping(path = "/v2/person")
    public PersonV2 getSecondVersionOfPerson(){
        return new PersonV2("Bob","Charlie");
    }
    @GetMapping(path = "/person", params = "version=1")
    public PersonV1 getVersionOfPersonUsingRequestParameters(){
        return new PersonV1("Bob Charlie");
    }
    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 getSecondVersionOfPersonRequest(){
        return new PersonV2("Bob","Charlie");
    }
    @GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 getFirstVersionOfPersonUsingHeaders(){
        return new PersonV1("Bob Charlie");
    }
    @GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 getSecondVersionOfPersonUsingHeaders(){
        return new PersonV2("Bob","Charlie");
    }
    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json")
    public PersonV1 getFirstVersionOfPersonUsingAcceptHeader(){
        return new PersonV1("Bob Charlie");
    }
    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v2+json")
    public PersonV2 getSecondVersionOfPersonUsingAcceptHeader(){
        return new PersonV2("Bob","Charlie");
    }

}
