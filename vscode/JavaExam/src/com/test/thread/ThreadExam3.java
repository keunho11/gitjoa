package com.test.thread;

public class ThreadExam3 {
    public static void main(String[] args) {
        
        new Thread(new Runnable(){

            @Override
            public void run(){
                try {
                    for(int i = 0; i <30; i++){
                        Thread.sleep(1000);
                        System.out.println("Thread1이 실행");
    
                    }
                } catch (Exception e) {
                    //TODO: handle exception
                    e.printStackTrace();
                }
              

            };
        }).start();

        for(int i=0; i<30; i++){
            try {
                Thread.sleep(1000);
                System.out.println("Thread2가 실행");
            } catch (Exception e) {
                //TODO: handle exception
                e.printStackTrace();
            }
            
        }
    }
}
