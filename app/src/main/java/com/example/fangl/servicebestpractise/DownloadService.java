package com.example.fangl.servicebestpractise;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class DownloadService extends Service {
    private DownloadTask downloadTask;
    private String downloadUrl;

    private DownloadListener listener = new DownloadListener() {
        @Override
        public void onProgress(int progress) {
//            getNotificationManager().notify(1,);
        }

        @Override
        public void onSuccess() {

        }

        @Override
        public void onFailed() {

        }

        @Override
        public void onPaused() {

        }

        @Override
        public void onCanceled() {

        }
    };

    public DownloadService() {
    }

    private DownloadBinder mBinder = new DownloadBinder();

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    class DownloadBinder extends Binder{

        public void startDownload(String url){
            if(downloadTask==null){
                downloadUrl = url;
                downloadTask = new DownloadTask(listener);
                downloadTask.execute(downloadUrl);
                startForeground(1,getNotification("downloading...",0));
                Toast.makeText(DownloadService.this,"downloading...",Toast.LENGTH_SHORT).show();
            }
        }

        public void pauseDownload(){
            downloadTask = null;
            Toast.makeText(DownloadService.this,"pause",Toast.LENGTH_SHORT).show();
        }

        public void cancelDownload(){
            downloadTask = null;
            Toast.makeText(DownloadService.this,"cancel",Toast.LENGTH_SHORT).show();
        }

    }

    private NotificationManager getNotificationManager(){
        return (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    private Notification getNotification(String title,int progress){
        Intent intent = new Intent(this,MainActivity.class);
        return null;
    }


}
