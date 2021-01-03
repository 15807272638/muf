package com.jsu.parking.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "FilterCss",urlPatterns = "*.css")
public class FilterCss implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //        设置请求编码格式
        req.setCharacterEncoding("utf-8");  //post 改变(请求实体)
        //        设置响应编码格式
        resp.setContentType("text/css;charset=utf-8");//修改响应编码
        chain.doFilter(req, resp);

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
