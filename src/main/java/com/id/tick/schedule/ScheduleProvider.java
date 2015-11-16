package com.id.tick.schedule;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

public class ScheduleProvider {
    private static Scheduler scheduler;

    public static Scheduler getScheduler() {
        if (scheduler == null) {
            try {
                scheduler = new StdSchedulerFactory().getScheduler();
                scheduler.start();
            } catch (SchedulerException e) {
                e.printStackTrace();
            }
        }
        return scheduler;
    }
}
