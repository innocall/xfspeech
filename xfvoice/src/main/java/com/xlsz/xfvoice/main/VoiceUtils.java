package com.xlsz.xfvoice.main;

import android.content.Context;
import android.speech.SpeechRecognizer;

import com.iflytek.cloud.Setting;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechUtility;

/**
 * Created by wuxiaotie on 2017/10/11.
 */
public class VoiceUtils {

    /**
     * 语音初始化，程序入口完成
     * @param context
     */
    public static void init(Context context) {
        // 将“12345678”替换成您申请的APPID，申请地址：http://www.xfyun.cn
        // 请勿在“=”与appid之间添加任何空字符或者转义符
        SpeechUtility.createUtility(context, SpeechConstant.APPID + "=59dc2915");
        Setting.setShowLog(true); //日志开关
    }


}
