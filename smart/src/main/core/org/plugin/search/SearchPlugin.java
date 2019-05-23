package org.plugin.search;

import org.smart.framework.plugin.Plugin;

public class SearchPlugin implements Plugin {

    @Override
    public void init() {
        new IndexThread().start();
    }

    @Override
    public void destroy() {
    }
}
