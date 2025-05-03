/*
執行緒的作用在於同時執行多項任務藉此降低執行時間
就好比我要做一台車一台車有好幾個零件,像是車體,發動機,變速箱等等
如果我只有一條thread我就必須等車體做完再做發動機在做變速箱
但是如果我使用多執行緒的話我可以同時製造以上的物件
所以可以大大的縮短做一台車的時間
*重點是如果其中個thread出現錯誤,其他thread依舊會繼續執行,不會停止

thread的建立有三種方式
一種是extends thread
一種是implements Runnable

比較推薦用Runnable
因為它可以繼承其他class,但是用thread只能有thread不能再額外繼承

執行緒有幾種狀態
1.預備狀態(Ready)
2.執行狀態(Running)
3.凍結狀態(Blocked)
4.等待狀態(Waiting)
*如果想要多了解一些執行緒,去看作業系統的書
*/

public class Main{
    public static void main(String[] argv){
        Mythread thread1=new Mythread();
        
        MyRunnable runnable1=new MyRunnable();
        Thread thread2=new Thread(runnable1);
        
        /*
         * thread1.setDaemon(true);
         * thread2.setDaemon(true);
         * 這兩句語法表示只要遇錯誤就會停止
         */
        

        thread1.start();
        //thread1.join();   這個語法表示必須先讓thread1執行完才換別的執行緒執行但記得在argv後加上throws InteruptedException
        //join()括號中加設加入3000表示等thread1執行3秒鐘後,就會開始執行thread2
        thread2.start();
    }
}


