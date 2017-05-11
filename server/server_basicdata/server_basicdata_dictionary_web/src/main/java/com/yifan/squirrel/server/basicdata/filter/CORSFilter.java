package com.yifan.squirrel.server.basicdata.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yifan on 2017/5/9.
 */

/**
 *
 Adding CORS support to your REST API
 While accessing the REST API, you might face issues concerning Same Origin Policy.

 Errors like :
 ” No ‘Access-Control-Allow-Origin’ header is present on the requested resource. Origin ‘http://127.0.0.1:8080′ is therefore not allowed access.” OR
 ” XMLHttpRequest cannot load http://abc.com/bla. Origin http://localhost:12345 is not allowed by Access-Control-Allow-Origin.” are common in such case.

 Solution is Cross-Origin Resource Sharing.
 Basically, on server side, we can return additional CORS access control headers with response,
 which will eventually allow further inter-domain communication.
 */
public class CORSFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        System.out.println("Filtering on...........................................................");
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        chain.doFilter(req, res);
    }

    public void destroy() {

    }
}
