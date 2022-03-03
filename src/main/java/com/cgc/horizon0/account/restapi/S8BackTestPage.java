package com.cgc.horizon0.account.restapi;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.cgc.horizon0.account.domain.Small8BackTest;

import io.quarkus.qute.Template;

import org.jboss.logging.Logger;
import io.quarkus.runtime.util.ExceptionUtil;

@Path("/")
public class S8BackTestPage {

    @Inject
    Logger log;

    @Inject
    Template s8sBackTest;

    // public List<Small8BackTest> listWhereLike(String like) {

    //     String searchInput = "%" + like + "%";
    
    //     return list("name like ?1", searchInput );
    //   }

    @Path("dys/s8s")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String render(@QueryParam("job_id") String job_id, @QueryParam("params")String params) {
        log.info("job_id:" + job_id);
        log.info("params:" + params);
        List<Small8BackTest> s8s = null;
        if (job_id == null){
            s8s = Small8BackTest.listAll();
        }else{
            String searchInput = "%" + job_id + "%";
            s8s = Small8BackTest.list("job_id like ?1", searchInput);
        }
        if (params != null){
            String searchInput = "%" + params + "%";
            log.info("searchInput:" + searchInput);
            s8s = Small8BackTest.list("params like ?1", searchInput);
        }

        String html = "<h1>数据渲染有问题，请访问/api/dys/s8s/ 获取json格式结果</h1>";

        try {
            html =s8sBackTest.data("all", s8s).render(); 
            
        } catch (Exception e) {
            log.error("渲染html页面时候粗错!" + ExceptionUtil.generateStackTrace(e));
        }
        return html;
    }
}
