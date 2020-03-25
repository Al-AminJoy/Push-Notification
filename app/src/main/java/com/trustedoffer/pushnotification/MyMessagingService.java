package com.trustedoffer.pushnotification;

import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyMessagingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        //Receive Nitification From Firebase
        String title=remoteMessage.getNotification().getTitle();
        String message=remoteMessage.getNotification().getBody();

        shownotification(title,message);
    }

    private void shownotification(String title, String message) {
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,"MyNotification")
                .setContentTitle(title)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setAutoCancel(true)
                .setContentText(message);
        NotificationManagerCompat compat=NotificationManagerCompat.from(this);
        compat.notify(01,builder.build());
    }
}
