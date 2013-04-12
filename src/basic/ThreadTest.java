package basic;

public class ThreadTest
{
    /**
     * @param args
     */
    public static void main(String[] args)
    {
        // 请等待足够久的时间(可能是1-2分钟)，程序会自动停止。
        Thread t1 = new Thread()
        {
            public void run()
            {
                int i = 0;
                while (true)// 死循环
                {
                    i++;
                    System.out.println("T1: " + i);
                    Thread.yield();//如果想让t2有机会更快完成，需要调用yield让出CPU时间。
                }
            }
        };
        // t1.setDaemon(true);// 注释掉这句就可以看出区别了。

        Thread t2 = new Thread()
        {
            public void run()
            {
                int i = 50000;
                while (i > 0)
                {
                    i--;
                    System.out.println("T2: " + i);
                }
                System.out.println("T2 terminated.");
            }
        };

        t1.start();
        t2.start();
        //Runtime.getRuntime().exit(0);
    }
}
