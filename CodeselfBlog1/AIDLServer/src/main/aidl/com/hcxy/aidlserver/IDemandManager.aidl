// IDemandManager.aidl
package com.hcxy.aidlserver;

import com.hcxy.aidlserver.MessageBean;
import com.hcxy.aidlserver.IDemandListener;

interface IDemandManager {
    MessageBean getDemand();
    void setDemandIn(in MessageBean msg); // 客户端->服务端
    // out和input都需要重写MesageBean的readFromParcel方法
    void setDemandOut(out MessageBean msg); // 服务端->客户端
    void setDemandInOut(inout MessageBean msg); // 客户端<->服务端

    void registerListener(IDemandListener listener);
    void unregisterListener(IDemandListener listener);
}
