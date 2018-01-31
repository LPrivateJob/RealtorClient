package com.realtor.jx.manager;

import android.support.annotation.DrawableRes;
import android.support.v4.util.ArrayMap;
import android.util.SparseArray;

import com.realtor.jx.R;
import com.realtor.jx.utils.StringUtil;

/**
 * description: 合同列表页图标管理类
 * autour: Tait
 * created at: 2018/1/7 16:27
 */
public class IconManager {
    private IconManager() {
    }

    private static class SingletonHolder {
        private static IconManager INSTANCE = new IconManager();
    }

    public static IconManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static SparseArray<String> nameMap = new SparseArray<>();
    private static ArrayMap<String, Integer> drawableMap = new ArrayMap<>();
    private static ArrayMap<String, String> colorMap = new ArrayMap<>();

    static {
        nameMap.put(0, "申请中");
        nameMap.put(1, "待修改");
        nameMap.put(2, "待扫码");
        nameMap.put(3, "待审核");
        nameMap.put(4, "审核中");
        nameMap.put(5, "还款中");
        nameMap.put(6, "已还清");
        nameMap.put(7, "已违约");
        nameMap.put(8, "审核拒绝");

        drawableMap.put("申请中", R.drawable.icon_applying);
        drawableMap.put("待修改", R.drawable.icon_alter);
        drawableMap.put("待扫码", R.drawable.icon_scan);
        drawableMap.put("待审核", R.drawable.icon_await);
        drawableMap.put("审核中", R.drawable.icon_proceed);
        drawableMap.put("还款中", R.drawable.icon_refund);
        drawableMap.put("已还清", R.drawable.icon_payoff);
        drawableMap.put("已违约", R.drawable.icon_overdue);
        drawableMap.put("审核拒绝", R.drawable.icon_reject);

        colorMap.put("申请中", "#e9d237");
        colorMap.put("待修改", "#248ef1");
        colorMap.put("待扫码", "#d0719f");
        colorMap.put("待审核", "#1f9f88");
        colorMap.put("审核中", "#e4b925");
        colorMap.put("还款中", "#f19924");
        colorMap.put("已还清", "009b00");
        colorMap.put("已违约", "#d71414");
        colorMap.put("审核拒绝", "#b02de3");
    }

    public String getName(int type) {
        return nameMap.get(type);
    }

    @DrawableRes
    public int getIcon(int type) {
        String name = nameMap.get(type);
        if (StringUtil.isEmpty(name)) {
            name = "后台返空";
            return drawableMap.get("申请中");
        }
        return drawableMap.get(nameMap.get(type));
    }

    public String getColor(int type) {
        return colorMap.get(nameMap.get(type));
    }
}
