# C语言

## 整数类型

下表列出了关于标准整数类型的存储大小和值范围的细节：

| 类型           | 存储大小    | 值范围                                               |
| :------------- | :---------- | :--------------------------------------------------- |
| char           | 1 字节      | -128 到 127 或 0 到 255                              |
| unsigned char  | 1 字节      | 0 到 255                                             |
| signed char    | 1 字节      | -128 到 127                                          |
| int            | 2 或 4 字节 | -32,768 到 32,767 或 -2,147,483,648 到 2,147,483,647 |
| unsigned int   | 2 或 4 字节 | 0 到 65,535 或 0 到 4,294,967,295                    |
| short          | 2 字节      | -32,768 到 32,767                                    |
| unsigned short | 2 字节      | 0 到 65,535                                          |
| long           | 4 字节      | -2,147,483,648 到 2,147,483,647                      |
| unsigned long  | 4 字节      | 0 到 4,294,967,295                                   |

##  i++ 和 ++i

> 1、首先，单独拿出来说++i和i++，意思都是一样的，就是i=i+1。
>
> 2、如果当做运算符来说，就是a=i++或者a=++i这样的形式。情况就不一样了。
>
> 先说a=i++，这个运算的意思是先把i的值赋予a，然后在执行i=i+1；
>
> 而a=++i，这个的意思是先执行i=i+1，然后在把i的值赋予a；
>
> 举个例子来说，如果一开始i=4。
>
> 那么执行a=i++这条语句之后，a=4，i=5；
>
> 那么执行a=++i这条语句之后，i=5，a=5；
>
> 同理，i--和--i的用法也是一样的。

## #ifdef，#else，#endif

```
#ifdef _XXXX 
　　…程序段1… 
#else 
　　…程序段2… 
#endif 
如果标识符_XXXX已被#define命令定义过则对程序段1进行编译；否则对程序段2进行编译。
```

```
#ifndef _XXXX 
　　…程序段1… 
#else 
　　…程序段2… 
#endif 
#ifndef表示的是if not def。当然是和#ifdef相反的状况（如果没有定义了标识符_XXXX，那么执行程序段1，否则执行程序段2）
```

```
#if 常量 
　　…程序段1… 
#else 
　　…程序段2… 
#endif 
如果常量为真（非0，随便什么数字，只要不是0），就执行程序段1，否则执行程序段2
```

## memcpy()

> ```
> void *memcpy(void *str1, const void *str2, size_t n)
> str1 -- 指向用于存储复制内容的目标数组，类型强制转换为 void* 指针。
> str2 -- 指向要复制的源数组，类型强制转换为 void* 指针。
> n -- 要被复制的字节数。
>  char src[] = "***";
>  char dest[] = "abcdefg";
>  printf("使用 memcpy 前: %s\n", dest);
>  memcpy(dest, src, strlen(src));
>  printf("使用 memcpy 后: %s\n", dest);
> ```

##  strcpy

> ```
> char *strcpy(char *dest, const char *src)
> ```
>
> ## 参数
>
> - **dest** -- 指向用于存储复制内容的目标数组。
> - **src** -- 要复制的字符串。

## memcmp

> ```
> int memcmp(const void *str1, const void *str2, size_t n)
> ```
>
> ## 参数
>
> - **str1** -- 指向内存块的指针。
> - **str2** -- 指向内存块的指针。
> - **n** -- 要被比较的字节数。
>
> ## 返回值
>
> - 如果返回值 < 0，则表示 str1 小于 str2。
> - 如果返回值 > 0，则表示 str1 大于 str2。
> - 如果返回值 = 0，则表示 str1 等于 str2。

## calloc

> ```
> void *calloc(size_t nitems, size_t size)
> ```
>
> ## 参数
>
> - **nitems** -- 要被分配的元素个数。
> - **size** -- 元素的大小。
>
> ## 返回值
>
> 该函数返回一个指针，指向已分配的内存。如果请求失败，则返回 NULL。

## 值传递、指针传递、引用传递（C++）

https://blog.csdn.net/u013550000/article/details/80954151

https://www.cnblogs.com/sum-41/p/10799555.html

| 传递方式 | 函数定义    | 函数调用 | 函数内对a修改的影响 |
| :------- | :---------- | :------- | :------------------ |
| 值传递   | fun(int a)  | fun(x)   | 外部x不变           |
| 指针传递 | fun(int *a) | fun(&x)  | 外部x同步更改       |
| 引用传递 | fun(int &a) | fun(x)   | 外部x同步更改       |

## C语言中Hex转ASCII函数

https://blog.csdn.net/u010761559/article/details/83508834

## fopen

> ```c
> FILE *fopen(const char *filename, const char *mode)
> ```
>
> - **filename** -- 这是 C 字符串，包含了要打开的文件名称。
> - **mode** -- 这是 C 字符串，包含了文件访问模式，模式如下：
>
> | 模式 | 描述                                                         |
> | :--- | :----------------------------------------------------------- |
> | "r"  | 打开一个用于读取的文件。该文件必须存在。                     |
> | "w"  | 创建一个用于写入的空文件。如果文件名称与已存在的文件相同，则会删除已有文件的内容，文件被视为一个新的空文件。 |
> | "a"  | 追加到一个文件。写操作向文件末尾追加数据。如果文件不存在，则创建文件。 |
> | "r+" | 打开一个用于更新的文件，可读取也可写入。该文件必须存在。     |
> | "w+" | 创建一个用于读写的空文件。                                   |
> | "a+" | 打开一个用于读取和追加的文件。                               |

## fread 

> ```c
> size_t fread(void *ptr, size_t size, size_t nmemb, FILE *stream)
> ```
>
> ## 参数
>
> - **ptr** -- 这是指向带有最小尺寸 *size\*nmemb* 字节的内存块的指针。
> - **size** -- 这是要读取的每个元素的大小，以字节为单位。
> - **nmemb** -- 这是元素的个数，每个元素的大小为 size 字节。
> - **stream** -- 这是指向 FILE 对象的指针，该 FILE 对象指定了一个输入流。

## stat

> 头文件：#include<sys/stat.h>  #include<uninstd.h>
>
> 定义函数：int stat(const char * file_name, struct stat *buf);
>
> 函数说明：stat()用来将参数file_name 所指的文件状态, 复制到参数buf 所指的结构中。
>
> 下面是struct stat 内各参数的说明：
>
> [![复制代码](https://common.cnblogs.com/images/copycode.gif)](javascript:void(0);)
>
> ```c
>  1 struct stat {
>  2     dev_t st_dev; //device 文件的设备编号
>  3     ino_t st_ino; //inode 文件的i-node
>  4     mode_t st_mode; //protection 文件的类型和存取的权限
>  5     nlink_t st_nlink; //number of hard links 连到该文件的硬连接数目, 刚建立的文件值为1.
>  6     uid_t st_uid; //user ID of owner 文件所有者的用户识别码 
>  7     gid_t st_gid; //group ID of owner 文件所有者的组识别码 
>  8     dev_t st_rdev; //device type 若此文件为装置设备文件, 则为其设备编号 
>  9     off_t st_size; //total size, in bytes 文件大小, 以字节计算 
> 10     unsigned long st_blksize; //blocksize for filesystem I/O 文件系统的I/O 缓冲区大小. 
> 11     u nsigned long st_blocks; //number of blocks allocated 占用文件区块的个数, 每一区块大小为512 个字节. 
> 12     time_t st_atime; //time of lastaccess 文件最近一次被存取或被执行的时间, 一般只有在用mknod、 utime、read、write 与tructate 时改变.
> 13     time_t st_mtime; //time of last modification 文件最后一次被修改的时间, 一般只有在用mknod、 utime 和write 时才会改变
> 14     time_t st_ctime; //time of last change i-node 最近一次被更改的时间, 此参数会在文件所有者、组、 权限被更改时更新 
> 15 };
> ```

# Java

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
> ```
>
> https://www.icode9.com/content-4-466089.html
>
> https://blog.csdn.net/qimuya/article/details/12760553?utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7Edefault-4.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7Edefault-4.control

# Git

## Git使用注意

> 文件路径中使用  /
>
> $ cd C:/Users/Administrator/.ssh

> git秘钥生成 https://www.cnblogs.com/xiuxingzhe/p/9303278.html

> git使用多个GitHub账号https://jingyan.baidu.com/article/948f592414ad67d80ef5f966.html
>
> https://blog.csdn.net/a258831020/article/details/50373060
>
> Github使用公钥和私钥https://blog.csdn.net/memory_nothing/article/details/94908152
>
> 使用git config --global设置用户名和邮件https://blog.csdn.net/sjt19910311/article/details/83685616

## Git常用命令

![Git常用命令](https://github.com/hhhhhh11/image-folder/blob/main/image/git常用命令.png)

> # 配置git文件
>
> > git config  –(两个-)gloabal user.name “你的用户名”
> >
> > git config  –global user.email “你的邮箱”
>
> # 创建SSH Key 复制id_rsa.pub到github
>
> > ssh-keygen -t rsa -C “邮箱地址”
> >
> > 路径
>
> > 初始化本地仓库 git init
> >
> > 提交文件	git add .			所有文件
> >
> > ​					git commit	-m “first commit”	本次的提交说明
> >
> > ​					git remote add origin ~~https://github.com/LXiaoKang/web.git~~  删除线   ~~ xxx ~~（无空格）

## Git用法的全面解析，结合Android Studio来讲Git

> https://blog.csdn.net/sxh951026/article/details/77200003

## Git删除本地仓库

> https://www.cnblogs.com/beeone/p/12254848.html
>
> （1）方法1：自己手动删除掉“Git本地仓库”里面的根目录下面的隐藏文件夹“.git”（如上图所示）
>
> （2）方法2：在本地仓库的目录下调用命令行删除根目录下的.git文件夹，输入
>
> ```
> find . -name ".git" | xargs rm -Rf
> ```

## Git - 使用多个帐号

> https://blog.csdn.net/a258831020/article/details/50373060

## 更新代码

> 更新代码    git pull --rebase origin 分支名

# ADB

## adb查看包名

>  adb shell am monitor                                          quit结束监控
>
> adb shell dumpsys window | findstr mCurrentFocus

##  高通方案的Android设备几种开机模式的进入与退出

https://www.cnblogs.com/we-hjb/p/9784659.html

> | 开机模式                      | 屏幕显示     | 冷启动                                        | 热启动                                  | 按键退出                    | 命令退出                                          |
> | ----------------------------- | ------------ | --------------------------------------------- | --------------------------------------- | --------------------------- | ------------------------------------------------- |
> | Android/Normal                | Android界面  | 按Power键                                     | adb reboot                              | 手机短按，VR长按Power键     | adb shell reboot -p(关机)                         |
> | Recovery/OTA/卡刷             | Recovery界面 | 按住OK键(Vol+)，再按Power键                   | adb reboot recovery                     | 长按Power键重启             | adb reboot                                        |
> | Fastboot/线刷                 | Fastboot界面 | 按住BACK键(Vol-)，再按Power键                 | adb reboot bootloader                   | 长按Power键重启             | fastboot reboot  fastboot continue(resuming boot) |
> | FFBM/Fast Factory/厂测/半开机 | 显示测试列表 | misc分区头部为ffbm时，按Power键               | misc分区头部为ffbm时，adb reboot        | 长按Power键重启依然进入FFBM | 唯一退出方式擦除misc分区                          |
> | EDL/紧急下载/9008/砖头/裸板   | 无显示,黑屏  | 同时按住OK键(Vol+)和BACK键(Vol-)，再按Power键 | adb reboot edlfastboot reboot emergency | 长按Power键重启             | 无                                                |

# Android

## Android JNI(一)——NDK与JNI基础

> https://www.jianshu.com/p/87ce6f565d37   

## Android ndk+jni:android.mk和application.mk写法

> https://blog.csdn.net/u010326875/article/details/83031144

##  dp,in,mm,pt,px,sp

> 如果设置表示长度、高度等属性时可以使用dp或sp。但如果设置字体，需要使用sp。
>
> https://blog.csdn.net/wlanye/article/details/81538394
>
> http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2012/1129/648.html
>
> https://www.jianshu.com/p/b2c545c65355

## RelativeLayout(相对布局)

> https://blog.csdn.net/qq_39216395/article/details/89217355?utm_medium=distribute.pc_relevant.none-task-blog-baidujs_title-14&spm=1001.2101.3001.4242

## Activity

> | 回调        | 描述                                                         |
> | :---------- | :----------------------------------------------------------- |
> | onCreate()  | 这是第一个回调，在活动第一次创建时调用                       |
> | onStart()   | 这个回调在活动为用户可见时被调用                             |
> | onResume()  | 这个回调在应用程序与用户开始可交互的时候调用                 |
> | onPause()   | 被暂停的活动无法接受用户输入，不能执行任何代码。当前活动将要被暂停，上一个活动将要被恢复时调用 |
> | onStop()    | 当活动不在可见时调用                                         |
> | onDestroy() | 当活动被系统销毁之前调用                                     |
> | onRestart() | 当活动被停止以后重新打开时调用                               |

## AsyncTask和publishProgress学习

> https://blog.csdn.net/qq_37858386/article/details/79112816
>
> publishProgress在进度对话框上设置新消息
>
> AsyncTask提供了五个回调函数：
> 1、准备运行：onPreExecute(),该回调函数在任务被执行之后立即由UI线程调用。这个步骤通常用来建立任务，在用户接口（UI）上显示进度条。
> 2、正在后台运行：doInBackground(Params...),该回调函数由后台线程在onPreExecute()方法执行结束后立即调用。通常在这里执行耗时的后台计算。计算的结果必须由该函数返回，并被传递到onPostExecute()中。在该函数内也可以使用publishProgress(Progress...)来发布一个或多个进度单位(unitsof progress)。这些值将会在onProgressUpdate(Progress...)中被发布到UI线程。
>
> 3、进度更新：onProgressUpdate(Progress...),该函数由UI线程在publishProgress(Progress...)方法调用完后被调用。一般用于动态地显示一个进度条。
>
> 4、完成后台任务：onPostExecute(Result),当后台计算结束后调用。后台计算的结果会被作为参数传递给这一函数。
> 5、取消任务：onCancelled ()，在调用AsyncTask的cancel()方法时调用。
>
> AsyncTask的构造函数有三个模板参数
>
> 1、Params，传递给后台任务的参数类型
>
> 2、Progress，后台计算执行过程中，进步单位（progress units）的类型
>
> 3、Result，后台执行返回的结果类型

## RecyclerView的使用

https://blog.csdn.net/weixin_40625864/article/details/105207826

## visibility属性Visible、Invisible、Gone

> https://blog.csdn.net/weixin_37438128/article/details/90921739
>
> 当控件visibility属性为invisible时，界面保留了view控件所占有的空间；
>
> 而控件属性为gone时，界面则不保留view控件所占有的空间。

##  动画实现imageview的移动

```java
emvicon=(ImageView)findViewById(R.id.emvicon);

		btnUp.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
//				Toast.makeText(getApplication(),"上",Toast.LENGTH_SHORT).show();
				ObjectAnimator a1=ObjectAnimator.ofFloat(emvicon,"TranslationY",y,y-1);
				y--;
				AnimatorSet as=new AnimatorSet();
				as.play(a1);
				as.start();
			}
		});
```

## Android 两个Activity 实现数据的来回传递

>  https://www.cnblogs.com/zxgl/archive/2012/12/03/2800061.html
>
> 数据保存到本地SharedPreferences 
>
> https://blog.csdn.net/bingocoder/article/details/80613993

## 动态添加碎片

> 1. 创建待添加的碎片实例
> 2. 获取FragmentManager，在活动中可以直接通过调用getSupportFragment()方法得到
> 3. 开启一个事务，通过调用beginTransaction()方法开启
> 4. 向容器内添加或替换碎片，一般使用replace()方法实心，需传入容器的id和待添加的碎片实例
> 5. 提交事务，调用commit()方法来完成

## android:padding和android:margin的区别

> padding为内边距；margin为外边距。
>
> https://blog.csdn.net/qq_32059827/article/details/51487997

## Android Studio打开Android Device Monitor

> https://blog.csdn.net/qq_42023080/article/details/105842271
>
> C:\Users\Administrator\AppData\Local\Android\Sdk\tools\lib\monitor-x86_64
>
> SDK文件夹里面

## Android Theme 常见主题风格详解

> https://www.jianshu.com/p/15f1c54ad5a0
>
> - 4.1 colorPrimary
>
> App Bar 的背景色，即 ActionBar，通常也是一个 App 的主题色调。不过 ActionBar 已经退出历史舞台，由 Toolbar 代替使用，但是 Toolbar 需要在 layout 文件中单独使用 background 属性设置背景色，如：
>
> ```xml
> <android.support.v7.widget.Toolbar
>   android:layout_width="match_parent"
>   android:layout_height="wrap_content"
>   android:background="?attr/colorPrimary" />
> ```
>
> - 4.2 colorPrimaryDark
>
> status bar（状态栏）背景色。仅作用于 Lollipop 及更高版本。
>
> - 4.3 colorAccent
>
> 许多控件在选中状态或获取焦点状态下使用这个颜色，常见有：
>
> - CheckBox：checked 状态
>
> - RadioButton：checked 状态
>
> - SwitchCompat：checked 状态
>
> - EditText：获取焦点时的 underline 和 cursor 颜色
>
> - TextInputLayout：悬浮 label 字体颜色
>
>   ```undefined
>   等等
>   ```
>
> - 4.4 android:navigationBarColor
>
> navigation bar 背景色。仅作用于 Lollipop 及更高版本。
>
> - 4.5 colorControlNormal
>
> 某些 Views “normal” 状态下的颜色，常见如：unselected CheckBox 和 RadioButton，失去焦点时的 EditText，Toolbar 溢出按钮颜色，等等。
>
> - 4.6 colorControlActivated
>
> 某种程度上，是 colorAccent 的替代者，比如对于 CheckBox 和 RadioButton 的 checked 状态，colorControlActivated 属性会覆盖 colorAccent 属性的对应颜色。
>
> - 4.7 colorControlHighlight
>
> 所有可点击 Views 触摸状态下的 Ripple（涟漪）效果。仅作用于 Lollipop 及更高版本。
>
> - 4.8 colorButtonNormal
>
> Button normal 状态下的背景色。注意，这种设置与 Button 的 android:background 属性改变背景色不同的是，前者在 Lollipop 及更高版本上会让 Button 依旧保持阴影和 Ripple 触摸效果。
>
> - 4.9 android:windowBackground
>
> 窗口背景色，诸如此类的还有：android:background，android:colorBackground 等。
>
> - 4.10 android:textColorPrimary
>
> EditText 的 text color，等等文本颜色。
>
> - 4.11 navigationIcon
>
> 返回按钮的图片
>
> 
>
> 作者：门心叼龙
> 链接：https://www.jianshu.com/p/15f1c54ad5a0
> 来源：简书
> 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

## SharedPreferences

> # 将数据保存到SharedPreferences中
>
> getSharedPreferences(“data”,MODE_PRIVATE).edit();
>
> data是SharedPreferences的文件名，MODE_PRIVATE是操作模式（目前只有这一种）
>
> 1.调用SharedPreferences对象的edit方法获取一个SharedPreferences.Editor对象
>
> 2.向SharedPreferences.Editor对象中添加数据，putBoolean(),putString()……
>
> ​			putString(“name”,”Tom”)	
>
> 3.调用apply()方法将添加的数据提交
>
> # 从SharedPreferences中读取数据
>
> SharedPreferences pref = getSharedPreferences(“data”,MODE_PRIVATE)；
>
> String name = pref.getString(“name”,””);	

## Intent的setClass和setClassName的区别

> **setClass**：跳转到与该工程下的（同一个Application中的）activity或者service
> **setClassName**：跳转到不同Applicaiton的activity或者service

## 关机重启等操作

> ```java
> public void systemReboot(Context context,String reason){
>     PowerManager pm = (PowerManager) context.getApplicationContext().getSystemService(Context.POWER_SERVICE);
>     pm.reboot(reason);
> }
> ```

# 计算机网络

## IP地址、子网掩码等

> https://blog.csdn.net/gatieme/article/details/50989257
>
> ![IP地址分类](https://img-blog.csdn.net/20160712182446560)
>
> ### 子网掩码
> 子网掩码(subnet mask)，用来指明一个IP地址的哪些位标识的是主机所在的子网，以及哪些位标识的是主机的位掩码。
>
> 子网掩码不能单独存在，它必须结合IP地址一起使用。子网掩码只有一个作用，就是将某个IP地址划分成网络地址和主机地址两部分。 
> 子网掩码是一个32位地址，用于屏蔽IP地址的一部分以区别网络标识和主机标识，并说明该IP地址是在局域网上，还是在远程网上。
>
> 子网掩码——屏蔽一个IP地址的网络部分的“全1”比特模式。对于A类地址来说，默认的子网掩码是255.0.0.0；对于B类地址来说默认的子网掩码是255.255.0.0；对于C类地址来说默认的子网掩码是255.255.255.0。
>
> 通过子网掩码，就可以判断两个IP在不在一个局域网内部。
>
> 子网掩码可以看出有多少位是网络号，有多少位是主机号
>
> ### 网络地址、广播地址
>
> - 将IP地址和子网掩码换算为二进制，子网掩码连续全1的是网络地址，后面的是主机地址，虚线前为网络地址，虚线后为主机地址
> - **IP地址和子网掩码进行与运算，结果是网络地址**（即主机号全0是网络地址）
> - 将运算结果中的网络地址不变，**主机地址变为1，结果就是广播地址**
> - 地址范围就是含在本网段内的所有主机

#   数据库

## 数据库事务

一个事务本质上有四个特点ACID：

1. Atomicity原子性
2. Consistency一致性
3. Isolation隔离性
4. Durability耐久性