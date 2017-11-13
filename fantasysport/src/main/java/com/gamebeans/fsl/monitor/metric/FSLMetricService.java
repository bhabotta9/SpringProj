package com.gamebeans.fsl.monitor.metric;

import java.util.Map;

public interface FSLMetricService {

    void increaseCount(final String request, final int status);

    Map getFullMetric();

    Map getStatusMetric();

    Object[][] getGraphData();
}