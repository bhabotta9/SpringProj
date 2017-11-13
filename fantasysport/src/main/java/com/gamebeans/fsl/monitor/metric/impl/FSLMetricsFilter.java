package com.gamebeans.fsl.monitor.metric.impl;
//com.gamebeans.fsl.monitor.metric.impl.FSLMetricsFilter
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.gamebeans.fsl.monitor.metric.FSLCustomActuatorMetricService;
import com.gamebeans.fsl.monitor.metric.FSLMetricService;

@Component
public class FSLMetricsFilter implements Filter{

		@Autowired
	    private FSLMetricService metricService;

	    @Autowired
	    private FSLCustomActuatorMetricService actMetricService;

	    @Override
	    public void init(final FilterConfig config) throws ServletException {
	        if (metricService == null || actMetricService == null) {
	            metricService = (FSLMetricService) WebApplicationContextUtils.getRequiredWebApplicationContext(config.getServletContext()).getBean("metricService");
	            actMetricService = (FSLCustomActuatorMetricService) WebApplicationContextUtils.getRequiredWebApplicationContext(config.getServletContext()).getBean(FSLCustomActuatorMetricService.class);
	        }
	    }

	    @Override
	    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws java.io.IOException, ServletException {
	        final HttpServletRequest httpRequest = ((HttpServletRequest) request);
	        final String req = httpRequest.getMethod() + " " + httpRequest.getRequestURI();

	        chain.doFilter(request, response);

	        final int status = ((HttpServletResponse) response).getStatus();
	        metricService.increaseCount(req, status);
	        actMetricService.increaseCount(status);
	     }

	    @Override
	    public void destroy() {

	    }

}
