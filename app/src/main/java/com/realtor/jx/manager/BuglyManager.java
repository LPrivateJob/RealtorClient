package com.realtor.jx.manager;

import android.content.Context;
import android.os.Environment;

import com.realtor.jx.R;
import com.realtor.jx.activity.MainActivity;
import com.realtor.jx.base.RealtorClientApplication;
import com.tencent.bugly.Bugly;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.UpgradeInfo;

/**
 * description:
 * autour: Tait
 * created at 2018/2/1 11:24.
 */
public class BuglyManager {
    private static final String APP_ID = "db9ec35b4f";
    private boolean isDebug = true;
    private Context mApplicationContext;

    private BuglyManager() {
        mApplicationContext = RealtorClientApplication.getContext();
    }

    private static class SingletonHolder {
        private static final BuglyManager INSTANCE = new BuglyManager();
    }

    public static BuglyManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * app启动时自动初始化升级模块
     * 手动检查更新
     */
    public void init() {
        upGradeInit();
    }

    /**
     * 更新初始化
     */
    private void upGradeInit() {
        /**** Beta高级设置*****/
        /**
         * true表示app启动自动初始化升级模块；
         * false不好自动初始化
         * 开发者如果担心sdk初始化影响app启动速度，可以设置为false
         * 在后面某个时刻手动调用
         */
        Beta.autoInit = true;
        /**
         * true表示初始化时自动检查升级
         * false表示不会自动检查升级，需要手动调用Beta.checkUpgrade()方法
         */
        Beta.autoCheckUpgrade = false;
        /**
         * 设置通知栏大图标，largeIconId为项目中的图片资源；
         */
        Beta.largeIconId = R.mipmap.icon;
        /**
         * 设置状态栏小图标，smallIconId为项目中的图片资源id;
         */
        Beta.smallIconId = R.mipmap.icon;
        /**
         * 设置更新弹窗默认展示的banner，defaultBannerId为项目中的图片资源Id;
         * 当后台配置的banner拉取失败时显示此banner，默认不设置则展示“loading“;
         */
        Beta.defaultBannerId = R.mipmap.icon;
        /**
         * 设置sd卡的Download为更新资源保存目录;
         * 后续更新资源会保存在此目录，需要在manifest中添加WRITE_EXTERNAL_STORAGE权限;
         */
        Beta.storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        /**
         * 点击过确认的弹窗在APP下次启动自动检查更新时会再次显示;
         */
        Beta.showInterruptedStrategy = true;
        /**
         * 只允许在MainActivity上显示更新弹窗，其他activity上不显示弹窗;
         * 不设置会默认所有activity都可以显示弹窗;
         */
        Beta.canShowUpgradeActs.add(MainActivity.class);
        /**
         * 已经接入Bugly用户改用上面的初始化方法,不影响原有的crash上报功能;
         * init方法会自动检测更新，不需要再手动调用Beta.checkUpdate(),如需增加自动检查时机可以使用Beta.checkUpdate(false,false);
         * 参数1： applicationContext
         * 参数2：appId
         * 参数3：是否开启debug
         */
        /***** Bugly高级设置 *****/
        BuglyStrategy strategy = new BuglyStrategy();
        /**
         * 设置app渠道号
         */
        strategy.setAppChannel(getAppChannel());

        Bugly.init(mApplicationContext, APP_ID, isDebug, strategy);
    }

    private String getAppChannel() {
        return WalleManager.getInstance().getChannel();
    }

    /**
     * 检查更新
     *
     * @param isShowToast 是否Toast提示有无更新
     */
    public void checkUpgrade(boolean isShowToast) {
        Beta.checkUpgrade(isShowToast, false);
    }

    /**
     * 获取本地已有升级策略（非实时，可用于界面红点展示）
     */
    private UpgradeInfo getUpgradeInfo() {
        return Beta.getUpgradeInfo();
//        /***** 获取升级信息 *****/
//        UpgradeInfo upgradeInfo = Beta.getUpgradeInfo();
//        return upgradeInfo;
//        StringBuilder info = new StringBuilder();
//        info.append("id: ").append(upgradeInfo.id).append("\n");
//        info.append("标题: ").append(upgradeInfo.title).append("\n");
//        info.append("升级说明: ").append(upgradeInfo.newFeature).append("\n");
//        info.append("versionCode: ").append(upgradeInfo.versionCode).append("\n");
//        info.append("versionName: ").append(upgradeInfo.versionName).append("\n");
//        info.append("发布时间: ").append(upgradeInfo.publishTime).append("\n");
//        info.append("安装包Md5: ").append(upgradeInfo.apkMd5).append("\n");
//        info.append("安装包下载地址: ").append(upgradeInfo.apkUrl).append("\n");
//        info.append("安装包大小: ").append(upgradeInfo.fileSize).append("\n");
//        info.append("弹窗间隔（ms）: ").append(upgradeInfo.popInterval).append("\n");
//        info.append("弹窗次数: ").append(upgradeInfo.popTimes).append("\n");
//        info.append("发布类型（0:测试 1:正式）: ").append(upgradeInfo.publishType).append("\n");
//        info.append("弹窗类型（1:建议 2:强制 3:手工）: ").append(upgradeInfo.upgradeType);
    }
}
