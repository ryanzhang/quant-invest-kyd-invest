package com.cgc.horizon0.account.restapi;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.cgc.horizon0.account.domain.W10BackTest;

import io.quarkus.qute.Template;

import org.jboss.logging.Logger;
import io.quarkus.runtime.util.ExceptionUtil;

@Path("/")
public class BackTestPage {

    @Inject
    Logger log;

    @Inject
    Template backtestTemplate;

    // public List<W10BackTest> listWhereLike(String like) {

    //     String searchInput = "%" + like + "%";
    
    //     return list("name like ?1", searchInput );
    //   }

    @Path("dys/s8s")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String render_s8s(@QueryParam("job_id") String job_id, @QueryParam("params")String params) {
        log.info("job_id:" + job_id);
        log.info("params:" + params);
        List<W10BackTest> s8s = null;
        if (job_id == null){
            s8s = W10BackTest.listAll();
        }else{
            String searchInput = "%" + job_id + "%";
            s8s = W10BackTest.list("job_id like ?1", searchInput);
        }
        if (params != null){
            String searchInput = "%" + params + "%";
            log.info("searchInput:" + searchInput);
            s8s = W10BackTest.list("params like ?1", searchInput);
        }

        String html = "<h1>数据渲染有问题，请访问/api/dys/s8s/ 获取json格式结果</h1>";

        try {
            html =backtestTemplate.data("all", s8s).render(); 
            
        } catch (Exception e) {
            log.error("渲染html页面时候粗错!" + ExceptionUtil.generateStackTrace(e));
        }
        return html;
    }

    @Path("dys/w10s")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String render_w10s(@QueryParam("job_id") String job_id, @QueryParam("params")String params) {
        log.info("job_id:" + job_id);
        log.info("params:" + params);
        List<W10BackTest> w10s = null;
        if (job_id == null){
            w10s = W10BackTest.listAll();
        }else{
            String searchInput = "%" + job_id + "%";
            w10s = W10BackTest.list("job_id like ?1", searchInput);
        }
        if (params != null){
            String searchInput = "%" + params + "%";
            log.info("searchInput:" + searchInput);
            w10s = W10BackTest.list("params like ?1", searchInput);
        }

        String html = "<h1>数据渲染有问题，请访问/api/dys/w10s/ 获取json格式结果</h1>";

        try {
            html =backtestTemplate.data("all", w10s).render(); 
            
        } catch (Exception e) {
            log.error("渲染html页面时候粗错!" + ExceptionUtil.generateStackTrace(e));
        }
        return html;
    }
}
