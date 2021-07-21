# Java Note

##  八种基本类型

> Java语言提供了八种基本类型。六种数字类型（四个整数型，两个浮点型），一种字符类型，还有一种布尔型。
>
> byte   8位
>
> short	16位
>
> int	32位
>
> long	64位
>
> float	32位
>
> double	64位
>
> char	16位
>
> boolean	1位
>
> # [Java中short、int、long、float、double的取值范围](https://www.cnblogs.com/pangpanghuan/p/6418441.html)
>
>
> 一、基本数据类型的特点，位数，最大值和最小值。
> 1、
> 基本类型：short 二进制位数：16 
> 包装类：java.lang.Short 
> 最小值：Short.MIN_VALUE=-32768 （-2的15此方）
> 最大值：Short.MAX_VALUE=32767 （2的15次方-1）
> 2、
> 基本类型：int 二进制位数：32
> 包装类：java.lang.Integer
> 最小值：Integer.MIN_VALUE= -2147483648 （-2的31次方）
> 最大值：Integer.MAX_VALUE= 2147483647 （2的31次方-1）
> 3、
> 基本类型：long 二进制位数：64
> 包装类：java.lang.Long
> 最小值：Long.MIN_VALUE=-9223372036854775808 （-2的63次方）
> 最大值：Long.MAX_VALUE=9223372036854775807 （2的63次方-1）
> 4、
> 基本类型：float 二进制位数：32
> 包装类：java.lang.Float
> 最小值：Float.MIN_VALUE=1.4E-45 （2的-149次方）
> 最大值：Float.MAX_VALUE=3.4028235E38 （2的128次方-1）
> 5、
> 基本类型：double 二进制位数：64
> 包装类：java.lang.Double
> 最小值：Double.MIN_VALUE=4.9E-324 （2的-1074次方）
> 最大值：Double.MAX_VALUE=1.7976931348623157E308 （2的1024次方-1）
>
> 
>
> | 基本类型 | 字节数 | 位数  | 最大值                 | 最小值     |
> | -------- | ------ | ----- | ---------------------- | ---------- |
> | byte     | 1byte  | 8bit  | 2^7 - 1                | -2^7       |
> | short    | 2byte  | 16bit | 2^15 - 1               | -2^15      |
> | int      | 4byte  | 32bit | 2^31 - 1               | -2^31      |
> | long     | 8byte  | 64bit | 2^63 - 1               | -2^63      |
> | float    | 4byte  | 32bit | 3.4028235E38           | 1.4E - 45  |
> | double   | 8byte  | 64bit | 1.7976931348623157E308 | 4.9E - 324 |
> | char     | 2byte  | 16bit | 2^16 - 1               | 0          |

## System.arraycopy

> https://segmentfault.com/a/1190000009922279

```
public static void arraycopy(
                             Object src,  //源数组
                             int srcPos,  //源数组的起始位置
                             Object dest, //目标数组
                             int destPos, //目标数组的起始位置
                             int length   //复制长度
                             )
```

## 重载(Overload)和重写(Override)

> https://www.runoob.com/java/java-override-overload.html
>
> 方法的重写(Overriding)和重载(Overloading)是java多态性的不同表现，重写是父类与子类之间多态性的一种表现，重载可以理解成多态的具体表现形式。
>
> - (1)方法重载是一个类中定义了多个方法名相同,而他们的参数的数量不同或数量相同而类型和次序不同,则称为方法的重载(Overloading)。
> - (2)方法重写是在子类存在方法与父类的方法的名字相同,而且参数的个数与类型一样,返回值也一样的方法,就称为重写(Overriding)。
> - (3)方法重载是一个类的多态性表现,而方法重写是子类与父类的一种多态性表现。

## String、StringBuffer与StringBuilder的区别

| String                                                       | StringBuffer                                                 | StringBuilder    |
| ------------------------------------------------------------ | ------------------------------------------------------------ | ---------------- |
| String的值是不可变的，这就导致每次对String的操作都会生成新的String对象，不仅效率低下，而且浪费大量优先的内存空间 | StringBuffer是可变类，和线程安全的字符串操作类，任何对它指向的字符串的操作都不会产生新的对象。每个StringBuffer对象都有一定的缓冲区容量，当字符串大小没有超过容量时，不会分配新的容量，当字符串大小超过容量时，会自动增加容量 | 可变类，速度更快 |
| 不可变                                                       | 可变                                                         | 可变             |
|                                                              | 线程安全                                                     | 线程不安全       |
|                                                              | 多线程操作字符串                                             | 单线程操作字符串 |

https://blog.csdn.net/itchuxuezhe_yang/article/details/89966303

##  字符数组、String、StringBuffer的相互转化

https://www.cnblogs.com/caiyishuai/p/9665732.html

##  关于java中for和foreach循环

> (https://www.cnblogs.com/adeng/p/5681713.html)
>
> - **for循环中的循环条件中的变量只求一次值！具体看最后的图片**
> - foreach语句是java5新增，在遍历数组、集合的时候，foreach拥有不错的性能。
> - foreach是for语句的简化，但是foreach并不能替代for循环。可以这么说，任何foreach都能改写为for循环，但是反之则行不通。
> - foreach不是java中的关键字。foreach的循环对象一般是一个集合，List、ArrayList、LinkedList、Vector、数组等。
> - foreach的格式：
>
> 　　　　for(元素类型T 每次循环元素的名称O : 循环对象){
>
> 　　　　　　　　//对O进行操作
>
> 　　　　}

## try catch finally

> https://blog.csdn.net/yuanmoxun0217/article/details/80939114

## Java substring()方法

> ```java
> public String substring(int beginIndex)
> 
> public String substring(int beginIndex, int endIndex)
> 
> ```
>
> - **beginIndex** -- 起始索引（包括）, 索引从 0 开始。
> - **endIndex** -- 结束索引（不包括）。

## Java POI的使用

> https://blog.csdn.net/qq_21137441/article/details/79226171
>
> https://blog.csdn.net/shangming150/article/details/78261095
>
> |        类名        |         说明         |
> | :----------------: | :------------------: |
> |    HSSFWorkbook    |   Excel的文档对象    |
> |     HSSFSheet      |     Excel的表单      |
> |      HSSFRow       |      Excel的行       |
> |      HSSFCell      |   Excel的格子单元    |
> |      HSSFFont      |      Excel字体       |
> |   HSSFDataFormat   |  格子单元的日期格式  |
> |     HSSFHeader     | Excel文档Sheet的页眉 |
> |     HSSFFooter     | Excel文档Sheet的页脚 |
> |   HSSFCellStyle    |     格子单元样式     |
> |    HSSFDateUtil    |         日期         |
> |   HSSFPrintSetup   |         打印         |
> | HSSFErrorConstants |      错误信息表      |

## 获取当前时间

> ```java
> long currentTime = System.currentTimeMillis();
> String timeNow = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(currentTime);
> 
> TimeUnit.DAYS          //天  
> TimeUnit.HOURS         //小时  
> TimeUnit.MINUTES       //分钟  
> TimeUnit.SECONDS       //秒  
> TimeUnit.MILLISECONDS  //毫秒 
> TimeUnit.NANOSECONDS   //毫微秒
> TimeUnit.MICROSECONDS  //微秒
> ```
>
> https://www.icode9.com/content-4-466089.html
>
> https://blog.csdn.net/qimuya/article/details/12760553?utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7Edefault-4.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7Edefault-4.control

## Runable接口创建线程

```java
    
	Thread threadRfidCard = new Thread(new RfidCardM0Runalbe());
	threadRfidCard.start();
	public class RfidCardM0Runalbe implements Runnable {
        @Override
        public void run() {
            while (numberOfCycles > 0){
                if (isEsc){
                    break;
                }
                RfidCardM0();
                numberOfCycles--;
            }
        }
    }
```

## ScheduledExecutorService

> 线程池之 newScheduledThreadPool中scheduleAtFixedRate（四个参数）_忍耐-CSDN博客_scheduleatfixedrate
> https://blog.csdn.net/weixin_35756522/article/details/81707276

> ```java
> schedule(Runnable command,
>          long delay,
>          TimeUnit unit);
> ```
>
> 
>
> 

> ```java
> schedule(Callable<V> callable,
>          long delay,
>          TimeUnit unit);
> ```
>
> 
>
> 

> ```java
> scheduleAtFixedRate(Runnable command,
>                     long initialDelay,
>                     long period,
>                     TimeUnit unit);
> ```
>
> command：执行线程
> initialDelay：初始化延时
> period：两次开始执行最小间隔时间
> unit：计时单位
>
> 间隔是连续两次任务开始执行的间隔
>
> > 1. 当前任务执行时间小于间隔时间，每次到点即执行；
> >
> > 2. 当前任务执行时间大于等于间隔时间，任务执行后立即执行下一次任务。相当于连续执行了。

> ```java
>  scheduleWithFixedDelay(Runnable command,
>                         long initialDelay,
>                         long delay,
>                         TimeUnit unit);
> ```
>
> command：执行线程
> initialDelay：初始化延时
> period：前一次执行结束到下一次执行开始的间隔时间（间隔执行延迟时间）
> unit：计时单位

> `ScheduledExecutorService#scheduleAtFixedRate()`指的是“以固定的频率”执行，period（周期）指的是两次成功执行之间的时间
>
> > 比如，`scheduleAtFixedRate(command, 5, 2, second)`，第一次开始执行是5s后，假如执行耗时1s，那么下次开始执行是7s后，再下次开始执行是9s后
>
> 而`ScheduledExecutorService#scheduleWithFixedDelay()` 指的是“以固定的延时”执行，delay（延时）指的是一次执行终止和下一次执行开始之间的延迟
>
> > `scheduleWithFixedDelay(command, 5, 2, second)`，第一次开始执行是5s后，假如执行耗时1s，执行完成时间是6s后，那么下次开始执行是8s后，再下次开始执行是11s后

