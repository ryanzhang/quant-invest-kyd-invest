package com.cgc.horizon0.account.restapi;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.cgc.horizon0.account.domain.Small8BackTest;
import com.cgc.horizon0.account.domain.W10BackTest;
import com.cgc.horizon0.account.domain.W11BackTest;
import com.cgc.horizon0.account.domain.W12BackTest;

import io.quarkus.qute.Template;

import org.jboss.logging.Logger;
import io.quarkus.runtime.util.ExceptionUtil;

@Path("/")
public class BackTestPage {

    @Inject
    Logger log;

    @Inject
    Template s8sTemplate;
    @Inject
    Template w10sTemplate;
    @Inject
    Template w11sTemplate;
    @Inject
    Template w12sTemplate;

    // public List<W10BackTest> listWhereLike(String like) {

    //     String searchInput = "%" + like + "%";
    
    //     return list("name like ?1", searchInput );
    //   }

    @Path("dys/s8s")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String render_s8s(@QueryParam("job_id") String job_id, @QueryParam("params")String params, @QueryParam("by") String sort_column ) {
        if(sort_column == null){
            sort_column = "annuROI";
        }
        log.info("job_id:" + job_id);
        log.info("params:" + params);
        List<Small8BackTest> s8s = null;
        if (job_id == null & params == null){
            s8s = Small8BackTest.list("order by " + sort_column + " desc");
        }else if(job_id != null){
            String searchInput = "%" + job_id + "%";
            s8s = Small8BackTest.list("job_id like ?1 " + "order by " + sort_column + " desc", searchInput);
        }else if (params != null){
            String searchInput = "%" + params + "%";
            log.info("searchInput:" + searchInput);
            s8s = Small8BackTest.list("params like ?1 " + "order by " + sort_column + " desc", searchInput);
        }

        String html = "<h1>数据渲染有问题，请访问/api/dys/s8s/ 获取json格式结果</h1>";

        try {
            html =s8sTemplate.data("all", s8s).render(); 
            
        } catch (Exception e) {
            log.error("渲染html页面时候粗错!" + ExceptionUtil.generateStackTrace(e));
        }
        return html;
    }

    @Path("dys/w10s")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String render_w10s(@QueryParam("job_id") String job_id, @QueryParam("params")String params, @QueryParam("by") String sort_column ) {
        if(sort_column == null){
            sort_column = "annuROI";
        }

        log.info("排序字段：" + sort_column);
        log.info("job_id:" + job_id);
        log.info("params:" + params);
        List<W10BackTest> w10s = null;
        if (job_id == null & params == null){
            w10s = W10BackTest.list("order by " + sort_column + " desc");
        }else if(job_id != null){
            String searchInput = "%" + job_id + "%";
            w10s = W10BackTest.list("job_id like ?1 " + "order by " + sort_column + " desc", searchInput);
        }else if (params != null){
            String searchInput = "%" + params + "%";
            log.info("searchInput:" + searchInput);
            w10s = W10BackTest.list("params like ?1 " + "order by " + sort_column + " desc", searchInput);
        }

        String html = "<h1>数据渲染有问题，请访问/api/dys/w10s/ 获取json格式结果</h1>";

        try {
            html =w10sTemplate.data("all", w10s).render(); 
            
        } catch (Exception e) {
            log.error("渲染html页面时候粗错!" + ExceptionUtil.generateStackTrace(e));
        }
        return html;
    }

    @Path("dys/w11s")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String render_w11s(@QueryParam("job_id") String job_id, @QueryParam("params")String params, @QueryParam("by") String sort_column ) {
        if(sort_column == null){
            sort_column = "annuROI";
        }

        log.info("排序字段：" + sort_column);
        log.info("job_id:" + job_id);
        log.info("params:" + params);
        List<W11BackTest> w11s = null;
        if (job_id == null & params == null){
            w11s = W11BackTest.list("order by " + sort_column + " desc");
        }else if(job_id != null){
            String searchInput = "%" + job_id + "%";
            w11s = W11BackTest.list("job_id like ?1 " + "order by " + sort_column + " desc", searchInput);
        }else if (params != null){
            String searchInput = "%" + params + "%";
            log.info("searchInput:" + searchInput);
            w11s = W11BackTest.list("params like ?1 " + "order by " + sort_column + " desc", searchInput);
        }

        String html = "<h1>数据渲染有问题，请访问/api/dys/w11s/ 获取json格式结果</h1>";

        try {
            html =w11sTemplate.data("all", w11s).render(); 
            
        } catch (Exception e) {
            log.error("渲染html页面时候粗错!" + ExceptionUtil.generateStackTrace(e));
        }
        return html;
    }

    @Path("dys/w12s")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String render_w12s(@QueryParam("job_id") String job_id, @QueryParam("params")String params, @QueryParam("by") String sort_column ) {
        if(sort_column == null){
            sort_column = "annuROI";
        }

        log.info("排序字段：" + sort_column);
        log.info("job_id:" + job_id);
        log.info("params:" + params);
        List<W12BackTest> w12s = null;
        if (job_id == null & params == null){
            w12s = W12BackTest.list("order by " + sort_column + " desc");
        }else if(job_id != null){
            String searchInput = "%" + job_id + "%";
            w12s = W12BackTest.list("job_id like ?1 " + "order by " + sort_column + " desc", searchInput);
        }else if (params != null){
            String searchInput = "%" + params + "%";
            log.info("searchInput:" + searchInput);
            w12s = W12BackTest.list("params like ?1 " + "order by " + sort_column + " desc", searchInput);
        }

        String html = "<h1>数据渲染有问题，请访问/api/dys/w12s/ 获取json格式结果</h1>";

        try {
            html =w12sTemplate.data("all", w12s).render(); 
            
        } catch (Exception e) {
            log.error("渲染html页面时候粗错!" + ExceptionUtil.generateStackTrace(e));
        }
        return html;
    }
}
