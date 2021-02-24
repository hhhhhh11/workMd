# C语言

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

# Java

## 八种基本类型

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

# git

> git秘钥生成 https://www.cnblogs.com/xiuxingzhe/p/9303278.html

> git使用多个GitHub账号https://jingyan.baidu.com/article/948f592414ad67d80ef5f966.html
>
> Github使用公钥和私钥https://blog.csdn.net/memory_nothing/article/details/94908152

# Android

##  dp,in,mm,pt,px,sp

> 如果设置表示长度、高度等属性时可以使用dp或sp。但如果设置字体，需要使用sp。
>
> https://blog.csdn.net/wlanye/article/details/81538394
>
> http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2012/1129/648.html

## RelativeLayout(相对布局)

> https://blog.csdn.net/qq_39216395/article/details/89217355?utm_medium=distribute.pc_relevant.none-task-blog-baidujs_title-14&spm=1001.2101.3001.4242

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

https://www.cnblogs.com/zxgl/archive/2012/12/03/2800061.html