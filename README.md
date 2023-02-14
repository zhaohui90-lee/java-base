# java-base
一个学习和总结JAVA-SE的项目

### JAVA-IO
#### fileInputStream
#### fileOutputStream
#### pipes
#### system.in system.out system.err
#### ByteArrayInputStream
#### ByteArrayOutputStream
#### BufferedInputStream
#### ReusableBufferedInputStream

### JAVA-NIO
#### NIOChannel
#### MIOFiles

### Serializable java序列化
#### Person 序列化示例
#### MyExternalizable 自定义序列化

### MultiThreadsServer 多线程服务
#### MultiThreadsServer 多线程服务
#### SingleThreadsServer 单线程服务
#### WorkerRunnable 线程启动
#### ThreadPoolServer 线程池服务

### pojo
#### hashcode和equals



### 并发和并行

#### 并发

并发意味着应用程序在多个任务上取得进展——同时或至少看起来是在同一时间(并发)。

如果计算机只有一个CPU，应用程序可能不会在同一时间对多个任务进行处理，但应用程序中同时有多个任务在处理。为了并发地处理多个任务，CPU会在执行期间在不同的任务之间切换。如下图所示:

![https://jenkov.com/images/java-concurrency/concurrency-vs-parallelism-1.png](https://jenkov.com/images/java-concurrency/concurrency-vs-parallelism-1.png)

#### 并行

并行执行是指一台计算机有多个CPU或CPU核，并同时处理多个任务。然而，并行执行并不是指并行化。我稍后再回到并行。并行执行如下所示:

![https://jenkov.com/images/java-concurrency/concurrency-vs-parallelism-2.png](https://jenkov.com/images/java-concurrency/concurrency-vs-parallelism-2.png)

#### 并行并发执行（Parallel Concurrent Execution）

可以并行并发执行，其中线程分布在多个cpu中。因此，在同一个CPU上执行的线程是并发执行的，而在不同CPU上执行的线程是并行执行的。下面的图表说明了并行并发执行。

![https://jenkov.com/images/java-concurrency/concurrency-vs-parallelism-3.png](https://jenkov.com/images/java-concurrency/concurrency-vs-parallelism-3.png)

#### 平行

并行性这个术语意味着应用程序将其任务分割成可以并行处理的更小的子任务，例如完全同时在多个cpu上处理。因此，并行并不等同于并行并发执行——即使它们在表面上看起来很相似。

要实现真正的并行，您的应用程序必须有多个线程运行-每个线程必须运行在单独的CPU / CPU核心/显卡GPU核心或类似的CPU。

下图展示了一个更大的任务，它被分为4个子任务。这4个子任务由4个不同的线程执行，这些线程在2个不同的cpu上运行。这意味着，这些子任务的一部分是并发执行的(在同一个CPU上执行的)，而另一部分是并行执行的(在不同的CPU上执行的)。

![https://jenkov.com/images/java-concurrency/concurrency-vs-parallelism-4.png](https://jenkov.com/images/java-concurrency/concurrency-vs-parallelism-4.png)

如果相反，4个子任务由在各自的CPU上运行的4个线程执行(总共4个CPU)，那么任务执行将是完全并行的。但要将一个进程精确地划分为与可用cpu数目相同的子进程，并不总是那么容易。通常，更容易的做法是将一个任务分解为若干子任务，这些子任务自然地与当前的任务相适应，然后让线程调度器负责在可用的cpu之间分配线程。


### 线程安全
#### 竞态条件和临界区
```java
public class Counter implements Runnable {

    protected Count c;

    private int addVal;

    public Counter(Count count, int addVal) {
        this.c = count;
        this.addVal = addVal;
    }

  // 两个线程竞争同一资源的情况，访问资源的顺序很重要，这种情况称为竞争条件(race condition)。
  // 导致竞争条件的代码段称为临界区(critical section)。
    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                c.add(this.addVal);
                System.out.println("add value " + this.addVal + " to register");
                System.out.println("now count is " + c.count);
            }

        }

    }
}
```
### 反射
Java的反射是一个强大的功能，它允许程序在**运行时**动态地获取对象的类型信息并对其进行操作。它使用java.lang.reflect包中的类和接口，如Class、Method、
Field、Constructor等，可以访问类的元数据，如类名、方法、字段、注释等，并在运行时调用类中的方法和字段。
反射机制允许动态地创建实例，调用方法，读写字段，等等。这使得开发人员可以在运行时对类进行更灵活的操作，并可以创建更加动态和可扩展的应用程序。
总之，Java反射是一种运行时类型信息和类型安全的动态处理机制，它允许程序在不知道对象的类型信息的情况下访问和操作对象。

