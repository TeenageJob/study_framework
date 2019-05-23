package org.plugin.cache;

import org.smart.framework.plugin.Plugin;

public class CachePlugin implements Plugin {

    @Override
    public void init() {
        new CacheThread().start();
    }

    @Override
    public void destroy() {
    }
}
