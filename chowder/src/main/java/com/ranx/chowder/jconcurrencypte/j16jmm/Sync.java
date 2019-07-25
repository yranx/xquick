//package com.ranx.chowder.study.jconcurrencypte.j16jmm;
//
//import java.util.concurrent.CancellationException;
//import java.util.concurrent.ExecutionException;
//import java.util.concurrent.locks.AbstractQueuedSynchronizer;
//
///**
// * FutureTask的内部类，如何借助同步的FutureTask
// * @author ranx
// * @create 2019-06-14 19:11
// **/
//public final class Sync extends AbstractQueuedSynchronizer{
//    private static final int RUNNING = 1, RAN = 2, CANCELLED = 4;
//    private V result;
//    private Exception exception;
//
//    void innerSet(V v) {
//        while (true) {
//            int s = getState();
////            if (runOrCancelled(s)) {
////                return;
////            }
//            if (compareAndSetState(s, RAN)) {
//                break;
//            }
//        }
//        result = v;
//        releaseShared(0);
////        done();
//    }
//
//    V innerGet() throws InterruptedException,ExecutionException {
//        acquireSharedInterruptibly(0);
//        if (getState() == CANCELLED) {
//            throw new CancellationException();
//        }
//        if (exception != null) {
//            throw new ExecutionException(exception);
//        }
//        return result;
//    }
//}
