package io.behindthemath.xvoiceplus.receivers;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import io.behindthemath.xvoiceplus.R;
import io.behindthemath.xvoiceplus.XVoicePlusService;

public class BootCompletedReceiver extends XVoicePlusReceiver {
    public static final String BOOT_COMPLETED = "android.intent.action.BOOT_COMPLETED";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (isEnabled(context) && BOOT_COMPLETED.equals(intent.getAction())) {
            Toast.makeText(context, context.getResources().getString(R.string.xvoiceplus_started), Toast.LENGTH_LONG).show();
            UserPollReceiver.startAlarmManager(context);
            intent.setClass(context, XVoicePlusService.class);
            startWakefulService(context, intent);
        }
    }
}
