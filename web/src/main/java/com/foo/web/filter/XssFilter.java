package com.foo.web.filter;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.lang3.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * Xss过滤器
 * @author fooisart
 * @since 2017-12-26
 */
public class XssFilter implements Filter {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        logger.info("进入xss过滤器");
        chain.doFilter(new XssHttpServletRequestWrapper((HttpServletRequest) request), response);
    }

    @Override
    public void destroy() {
    }

    private class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {

        public XssHttpServletRequestWrapper(HttpServletRequest request) {
            super(request);
        }

        @Override
        public String getHeader(String name) {
            return escape(super.getHeader(name));
        }

        @Override
        public String getQueryString() {
            return escape(super.getQueryString());
        }

        @Override
        public String getParameter(String name) {
            return escape(super.getParameter(name));
        }

        @Override
        public String[] getParameterValues(String name) {
            String[] values = super.getParameterValues(name);
            if (values != null) {
                int length = values.length;
                String[] escapeValue = new String[length];
                for (int i = 0; i < length; i++) {
                    escapeValue[i] = escape(values[i]);
                }
                return escapeValue;
            }
            return values;
        }

        private String escape(String str) {
            return StringEscapeUtils.escapeHtml4(str);
        }
    }

}
