package com.cgc.horizon0.account.restapi;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.quarkus.qute.Template;
import com.cgc.horizon0.account.domain.Small8BackTest;

import org.jboss.logging.Logger;

@Path("/api/")
public class S8BackTestResource {

    @Inject
    Logger log;

    @Inject
    Template s8sBackTest;

    @Path("dys/s8s")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    // @Transactional
    public List<Small8BackTest> getS8SBackTestData() {
        List<Small8BackTest> all = Small8BackTest.listAll();

        return all;
    }

    // @Path("dys/s8s")
    // @GET
    // @Produces(MediaType.TEXT_HTML)
    // public String render() {
    //     return s8sBackTest.render();
    // }
}
