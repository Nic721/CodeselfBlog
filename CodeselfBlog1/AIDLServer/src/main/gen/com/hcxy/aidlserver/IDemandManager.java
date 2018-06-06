/*___Generated_by_IDEA___*/

/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /Users/cxy/android/demo/CodeselfBlog/CodeselfBlog1/AIDLServer/src/main/aidl/com/hcxy/aidlserver/IDemandManager.aidl
 */
package com.hcxy.aidlserver;
public interface IDemandManager extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.hcxy.aidlserver.IDemandManager
{
private static final java.lang.String DESCRIPTOR = "com.hcxy.aidlserver.IDemandManager";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.hcxy.aidlserver.IDemandManager interface,
 * generating a proxy if needed.
 */
public static com.hcxy.aidlserver.IDemandManager asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.hcxy.aidlserver.IDemandManager))) {
return ((com.hcxy.aidlserver.IDemandManager)iin);
}
return new com.hcxy.aidlserver.IDemandManager.Stub.Proxy(obj);
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
case TRANSACTION_getDemand:
{
data.enforceInterface(DESCRIPTOR);
com.hcxy.aidlserver.MessageBean _result = this.getDemand();
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_setDemandIn:
{
data.enforceInterface(DESCRIPTOR);
com.hcxy.aidlserver.MessageBean _arg0;
if ((0!=data.readInt())) {
_arg0 = com.hcxy.aidlserver.MessageBean.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.setDemandIn(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_setDemandOut:
{
data.enforceInterface(DESCRIPTOR);
com.hcxy.aidlserver.MessageBean _arg0;
_arg0 = new com.hcxy.aidlserver.MessageBean();
this.setDemandOut(_arg0);
reply.writeNoException();
if ((_arg0!=null)) {
reply.writeInt(1);
_arg0.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_setDemandInOut:
{
data.enforceInterface(DESCRIPTOR);
com.hcxy.aidlserver.MessageBean _arg0;
if ((0!=data.readInt())) {
_arg0 = com.hcxy.aidlserver.MessageBean.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.setDemandInOut(_arg0);
reply.writeNoException();
if ((_arg0!=null)) {
reply.writeInt(1);
_arg0.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_registerListener:
{
data.enforceInterface(DESCRIPTOR);
com.hcxy.aidlserver.IDemandListener _arg0;
_arg0 = com.hcxy.aidlserver.IDemandListener.Stub.asInterface(data.readStrongBinder());
this.registerListener(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_unregisterListener:
{
data.enforceInterface(DESCRIPTOR);
com.hcxy.aidlserver.IDemandListener _arg0;
_arg0 = com.hcxy.aidlserver.IDemandListener.Stub.asInterface(data.readStrongBinder());
this.unregisterListener(_arg0);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.hcxy.aidlserver.IDemandManager
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
@Override public com.hcxy.aidlserver.MessageBean getDemand() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.hcxy.aidlserver.MessageBean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getDemand, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.hcxy.aidlserver.MessageBean.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void setDemandIn(com.hcxy.aidlserver.MessageBean msg) throws android.os.RemoteException
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
mRemote.transact(Stub.TRANSACTION_setDemandIn, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// 客户端->服务端
// out和input都需要重写MesageBean的readFromParcel方法

@Override public void setDemandOut(com.hcxy.aidlserver.MessageBean msg) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_setDemandOut, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
msg.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
}
// 服务端->客户端

@Override public void setDemandInOut(com.hcxy.aidlserver.MessageBean msg) throws android.os.RemoteException
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
mRemote.transact(Stub.TRANSACTION_setDemandInOut, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
msg.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
}
// 客户端<->服务端

@Override public void registerListener(com.hcxy.aidlserver.IDemandListener listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_registerListener, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void unregisterListener(com.hcxy.aidlserver.IDemandListener listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_unregisterListener, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_getDemand = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_setDemandIn = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_setDemandOut = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_setDemandInOut = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_registerListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_unregisterListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
}
public com.hcxy.aidlserver.MessageBean getDemand() throws android.os.RemoteException;
public void setDemandIn(com.hcxy.aidlserver.MessageBean msg) throws android.os.RemoteException;
// 客户端->服务端
// out和input都需要重写MesageBean的readFromParcel方法

public void setDemandOut(com.hcxy.aidlserver.MessageBean msg) throws android.os.RemoteException;
// 服务端->客户端

public void setDemandInOut(com.hcxy.aidlserver.MessageBean msg) throws android.os.RemoteException;
// 客户端<->服务端

public void registerListener(com.hcxy.aidlserver.IDemandListener listener) throws android.os.RemoteException;
public void unregisterListener(com.hcxy.aidlserver.IDemandListener listener) throws android.os.RemoteException;
}
