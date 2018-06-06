/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /Users/cxy/android/demo/CodeselfBlog/CodeselfBlog1/AIDLClient/src/main/aidl/com/hcxy/aidlserver/IDemandListener.aidl
 */
package com.hcxy.aidlserver;
public interface IDemandListener extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.hcxy.aidlserver.IDemandListener
{
private static final java.lang.String DESCRIPTOR = "com.hcxy.aidlserver.IDemandListener";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.hcxy.aidlserver.IDemandListener interface,
 * generating a proxy if needed.
 */
public static com.hcxy.aidlserver.IDemandListener asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.hcxy.aidlserver.IDemandListener))) {
return ((com.hcxy.aidlserver.IDemandListener)iin);
}
return new com.hcxy.aidlserver.IDemandListener.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_onDemandReceiver:
{
data.enforceInterface(DESCRIPTOR);
com.hcxy.aidlserver.MessageBean _arg0;
if ((0!=data.readInt())) {
_arg0 = com.hcxy.aidlserver.MessageBean.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.onDemandReceiver(_arg0);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.hcxy.aidlserver.IDemandListener
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public void onDemandReceiver(com.hcxy.aidlserver.MessageBean msg) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((msg!=null)) {
_data.writeInt(1);
msg.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_onDemandReceiver, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_onDemandReceiver = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
public void onDemandReceiver(com.hcxy.aidlserver.MessageBean msg) throws android.os.RemoteException;
}
