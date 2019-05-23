package org.mvc.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.plugin.job.BaseJob;
import org.smart.framework.ioc.annotation.Bean;


public class SmartHelloJob extends BaseJob {

    private static final SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

    @Override
    public void execute() {
        System.out.println(format.format(new Date()) + " - Hello Smart!");
    }
}
