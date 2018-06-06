// IDemandListener.aidl
package com.hcxy.aidlserver;

import com.hcxy.aidlserver.MessageBean;

interface IDemandListener {
    void onDemandReceiver(in MessageBean msg); // 客户端->服务端
}
