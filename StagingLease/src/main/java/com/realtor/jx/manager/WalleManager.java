package com.realtor.jx.manager;

import android.content.Context;

import com.meituan.android.walle.ChannelInfo;
import com.meituan.android.walle.WalleChannelReader;
import com.realtor.jx.BuildConfig;
import com.realtor.jx.hotfix.StagingLeaseApplicationLike;

import java.util.Map;
/**
 * description:
 * autour: Tait
 * created at 2017/10/17 16:47
 */
public class WalleManager {
    private String channel;
    private Context mApplicationContext;
    private WalleManager() {
        mApplicationContext = StagingLeaseApplicationLike.getContext();
        channel = WalleChannelReader.getChannel(mApplicationContext);
    }

    private static class SingletonHolder {
        private static final WalleManager INSTANCE = new WalleManager();

    }

    public static WalleManager getInstance() {
        return WalleManager.SingletonHolder.INSTANCE;
    }

    /**
     * 得到渠道名
     */
    public String getChannel() {
        if (channel != null && !channel.isEmpty()) {
            return channel;
        }
        channel = WalleChannelReader.getChannel(mApplicationContext);

        if (BuildConfig.DEBUG || channel==null||channel.isEmpty()) {
            if (BuildConfig.V_TAG.isEmpty()) {
                return "DEBUG";
            } else return BuildConfig.V_TAG;

        } else {
            return channel;
        }
    }

    /**
     * 得到渠道信息----Map
     */
    public Map<String, String> getChannelMsg() {
        Map<String, String> extraInfo = null;
        ChannelInfo channelInfo = WalleChannelReader.getChannelInfo(mApplicationContext);
        if (channelInfo != null) {
            String channel = channelInfo.getChannel();
            extraInfo = channelInfo.getExtraInfo();
        }
        return null;
    }

    /**
     * 得到渠道信息----String
     */
    public String getChannelMsg(String key) {
        return WalleChannelReader.get(mApplicationContext, key);
    }
}
