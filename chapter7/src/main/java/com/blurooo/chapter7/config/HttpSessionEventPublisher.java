package com.blurooo.chapter7.config;

import org.springframework.context.ApplicationContext;
import org.springframework.security.web.context.support.SecurityWebApplicationContextUtils;
import org.springframework.security.web.session.HttpSessionCreatedEvent;
import org.springframework.security.web.session.HttpSessionDestroyedEvent;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 订阅session创建和销毁事件，清理session
 */
public class HttpSessionEventPublisher implements HttpSessionListener {
    public HttpSessionEventPublisher() {
    }
    ApplicationContext getContext(ServletContext servletContext){
        return SecurityWebApplicationContextUtils.findRequiredWebApplicationContext(servletContext);
    }
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSessionListener.super.sessionCreated(se);
        HttpSessionCreatedEvent e = new HttpSessionCreatedEvent(se.getSession());
        this.getContext(se.getSession().getServletContext()).publishEvent(e);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSessionListener.super.sessionDestroyed(se);
        HttpSessionDestroyedEvent e = new HttpSessionDestroyedEvent(se.getSession());
        this.getContext(se.getSession().getServletContext()).publishEvent(e);
    }
}
