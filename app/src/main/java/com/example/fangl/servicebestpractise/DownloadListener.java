package com.example.fangl.servicebestpractise;

/**
 * Created by fangl on 2017/11/16.
 */

public interface DownloadListener {

    void onProgress(int progress);
    void onSuccess();
    void onFailed();
    void onPaused();
    void onCanceled();

}
