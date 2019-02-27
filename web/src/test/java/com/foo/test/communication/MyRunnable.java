package com.foo.test.communication;

class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println(System.currentTimeMillis()+",Thread started:::"+Thread.currentThread().getName());
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis()+",Thread ended:::"+Thread.currentThread().getName());
    }
    
}