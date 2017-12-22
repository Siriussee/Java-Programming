package mail;

import java.rmi.Naming;

public class MessagePutClient {
    public static void main(String... args){
        final int time = 1000;

        Runnable get = new Runnable() {
            @Override
            public void run() {
                MessagePool obj = null;
                String msg="";
                while (true){
                    try{
                        obj = (MessagePool) Naming.lookup("//"+"/mess");
                        msg = obj.get();
                        System.out.println(msg);
                        Thread.sleep(2 * time);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        };

        Runnable put = new Runnable() {
            @Override
            public void run() {
                int count = 1;
                MessagePool obj = null;
                String msg="string";
                while (true){
                    try{
                        obj = (MessagePool) Naming.lookup("rmi://127.0.0.1:6600/MailServer");
                        obj.put(msg + count);
                        Thread.sleep(time);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    count++;
                }
            }
        };

        Thread thread = new Thread(get);
        thread.start();
        Thread th = new Thread(put);
        th.start();
    }
}
