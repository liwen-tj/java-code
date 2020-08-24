import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

  public static void solve() {
    Test.solve();
  }

  public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
    //获取String所对应的Class对象
    Class<?> c = String.class;
    //获取String类带一个String参数的构造器
    Constructor constructor = c.getConstructor(String.class);
    //根据构造器创建实例
    Object obj = constructor.newInstance("23333");
    System.out.println(obj);
    String x = new String("233");


    // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/concurrent/ThreadPoolExecutor.html

    // 当任务请求到来时，
    // 如果 n < corePoolSize, 直接创建
    // 否则，也即 corePoolSize <= n < maxPoolSize，只有队列满才会继续创建

    // 当线程数超出corePoolSize，且超出keepAliveTime时间没有被使用，就会把超出corePoolSize的那一部分给关停

    // newFixedThreadPool和newSingleThreadExecutor存在风险，就是因为其使用了无界的队列

    //(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
    ExecutorService pool = Executors.newFixedThreadPool(16);

    // (0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>())
    ExecutorService infinite = Executors.newCachedThreadPool();

    // (1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>())
    ExecutorService one = Executors.newSingleThreadExecutor();

    Test.solve();
  }
}
