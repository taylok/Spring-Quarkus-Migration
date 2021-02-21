package com.gck.demo.paymentgateway.accountbalance.rest;

// --- Commented out for Quarkus Migration
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.ResponseBody;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.core.env.Environment;
// import org.springframework.data.domain.Example;
// import org.springframework.data.repository.Repository;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
import com.gck.demo.paymentgateway.accountbalance.db.BalanceRepository;
import com.gck.demo.paymentgateway.accountbalance.models.Balance;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// --- added for Quaarkus migration changes

/**
 * Provides information about this service
 *
 * Created by ganck.
 */

// --- Commented out for Quarkus Migration
//@RequestMapping("/ws/pg")
// @RestController
@Path("/ws/pg")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AccountBalance{

    // --- Commented out for Quarkus Migration
    // @Autowired
    @Inject
    private BalanceRepository repository;

    // --- Commented out for Quarkus Migration
    // --- changed @PathVariable to @PathParam
    // @RequestMapping(method = RequestMethod.GET, value = "/balance/{accountid}")
    // @ResponseBody
    @Path("/balance/{accountid}")
    @GET
    public Balance get(@PathParam("accountid") String accountId) {
        Balance result = repository.findByAccountId(accountId);
        //Balance b = new Balance();
        //Balance result = b.findByAccountId(accountId);
        return result;
    }

    // --- Commented out for Quarkus Migration
    // @RequestMapping(method = RequestMethod.GET, value = "/balance/all")
    // @ResponseBody
    @Path("/balance/all")
    @GET
    public List<Balance> get() {
        List<Balance> result = repository.listAll();
        //System.out.println("result = " + result);
        return result;
    }

    // --- Commented out for Quarkus Migration
    // -- remove @RequestBody
    //@RequestMapping(method = RequestMethod.POST, value = "/balance")
    //@ResponseBody
    @Path("/balance")
    @POST
    //public Balance createBalance(@RequestBody Balance balance) {
    public Balance createBalance(Balance balance) {
        // --- Commented out for Quarkus Migration
        //repository.insert(balance);
        repository.persist(balance);
        return balance;
    }

    // --- Commented out for Quarkus Migration
    //@RequestMapping(method = RequestMethod.PUT, value = "/balance")
    //@ResponseBody
    @Path("/balance")
    @PUT
    //public Balance updateBalance(@RequestBody Balance balance) {
    public Balance updateBalance(Balance balance) {
        // --- Commented out for Quarkus Migration
        // repository.save(balance);
        repository.persistOrUpdate(balance);
        return balance;
    }

}
