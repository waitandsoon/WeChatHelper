package com.zhaofliu.wechathelper.utils;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import java.net.URISyntaxException;

/**
 * Created by zhaofliu on 1/26/17.
 *
 * @author zhaofliu
 * @since 1/26/17
 */

public class IntentUtils {

    public static boolean startUrl(Context context, String url) {
        if(TextUtils.isEmpty(url)) {
           return false;
        }
        try {
            Intent i = Intent.parseUri(url, 0);
            context.startActivity(i);
            return true;
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void shareText(Context context, String dlgTitle, String text) {
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, text);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(Intent.createChooser(intent, dlgTitle));
    }

}
