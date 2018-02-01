package com.realtor.jx.manager;

/**
 * description:
 * autour: Tait
 * created at 2018/2/1 11:24.
 */
public class BuglyManager {
    private BuglyManager() {

    }

    private static class SingletonHolder {
        private static final BuglyManager INSTANCE = new BuglyManager();
    }

    public static BuglyManager getInstance() {
        return SingletonHolder.INSTANCE;
    }


}
