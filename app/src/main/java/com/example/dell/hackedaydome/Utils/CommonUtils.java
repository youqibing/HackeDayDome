package com.example.dell.hackedaydome.Utils;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by dell on 2016/10/29.
 */

public class CommonUtils {

    /**
     * 生成一个ID，让系统误以为是 R 中的id
     *
     * @return
     */
    public static int fakeGenId() {
        int realId = generateViewId();
        int fakeId = realId | 0x10000000;
        return fakeId;
    }

    /**
     * copy from {@link android.view.View#generateViewId()} <br>
     *
     * @return
     * @since API 17
     */
    public static int generateViewId() {
        for (; ; ) {
            final int result = sNextGeneratedId.get();
            // aapt-generated IDs have the high byte nonzero; clamp to the range
            // under that.
            int newValue = result + 1;
            if (newValue > 0x00FFFFFF) {
                newValue = 1; // Roll over to 1, not 0.
            }
            if (sNextGeneratedId.compareAndSet(result, newValue)) {
                return result;
            }
        }
    }

    private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);
}
