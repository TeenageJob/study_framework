package org.plugin.job;

import org.smart.framework.plugin.Plugin;

public class JobPlugin implements Plugin {

    @Override
    public void init() {
        JobHelper.startJobAll();
    }

    @Override
    public void destroy() {
        JobHelper.stopJobAll();
    }
}
