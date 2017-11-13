package com.gamebeans.fsl.web.controller;

import java.net.URI;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriTemplate;

import com.gamebeans.fsl.monitor.metric.FSLCustomActuatorMetricService;
import com.gamebeans.fsl.monitor.metric.FSLMetricService;

@Controller
@RequestMapping(value="auth")
public class FSLMetricController {
	 @Autowired
	    private FSLMetricService metricService;

	    @Autowired
	    private FSLCustomActuatorMetricService actMetricService;

	    public FSLMetricController() {
	        super();
	    }
	    // API
	    // discover
	    @GetMapping(value = "admin")
	    @ResponseStatus(value = HttpStatus.NO_CONTENT)
	    public void adminRoot(final HttpServletRequest request, final HttpServletResponse response) {
	        final String rootUri = request.getRequestURL().toString();

	        final URI fooUri = new UriTemplate("{rootUri}/{resource}").expand(rootUri, "foo");
	       // final String linkToFoo = LinkUtil.createLinkHeader(fooUri.toASCIIString(), "collection");
	       // response.addHeader("Link", linkToFoo);
	    }

	    @GetMapping(value = "/metric")
	    @ResponseBody
	    public Map getMetric() {
	        return metricService.getFullMetric();
	    }

	    @GetMapping(value = "/status-metric")
	    @ResponseBody
	    public Map getStatusMetric() {
	        return metricService.getStatusMetric();
	    }

	    @GetMapping(value = "/metric-graph")
	    @ResponseBody
	    public Object[][] drawMetric() {
	        final Object[][] result = metricService.getGraphData();
	        for (int i = 1; i < result[0].length; i++) {
	            result[0][i] = result[0][i].toString();
	        }
	        return result;
	    }


}
