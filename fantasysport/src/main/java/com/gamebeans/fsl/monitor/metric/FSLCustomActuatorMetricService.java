package com.gamebeans.fsl.monitor.metric;

public interface FSLCustomActuatorMetricService 
{
	void increaseCount(final int status);

    Object[][] getGraphData();
}
