# A problem occurred configuring project ‘:app‘. ＞ java.lang.NullPointerException

解决方法：https://blog.csdn.net/qq_39587209/article/details/110877179

# duplicate symbol

![image-20210122092550152](https://github.com/hhhhhh11/image-folder/blob/main/image/image-20210122092550152.png)


```
ld: error: duplicate symbol: NDK_RfidVersion

>>> defined at NDK.h:2211 (E:\study\NLLearn\app\src\main\jni\include\NDK.h:2211)

>>>            CMakeFiles/NlApi.dir/src/main/jni/jni_usePosNdk.c.o:(NDK_RfidVersion)

>>> defined at posNdk.c:138 (E:\study\NLLearn\app\src\main\jni\posNdk.c:138)

>>>            CMakeFiles/NlApi.dir/src/main/jni/posNdk.c.o:(.bss.NDK_RfidVersion+0x0)
ld: error: duplicate symbol: dlError

>>> defined at jni_usePosNdk.c:45 (E:\study\NLLearn\app\src\main\jni\jni_usePosNdk.c:45)

>>>            CMakeFiles/NlApi.dir/src/main/jni/jni_usePosNdk.c.o:(dlError)

>>> defined at posNdk.c:11 (E:\study\NLLearn\app\src\main\jni\posNdk.c:11)

>>>            CMakeFiles/NlApi.dir/src/main/jni/posNdk.c.o:(.bss.dlError+0x0)



ld: error: duplicate symbol: functionLib

>>> defined at jni_usePosNdk.c:44 (E:\study\NLLearn\app\src\main\jni\jni_usePosNdk.c:44)

>>>            CMakeFiles/NlApi.dir/src/main/jni/jni_usePosNdk.c.o:(functionLib)

>>> defined at posNdk.c:10 (E:\study\NLLearn\app\src\main\jni\posNdk.c:10)

>>>            CMakeFiles/NlApi.dir/src/main/jni/posNdk.c.o:(.bss.functionLib+0x0)

clang: error: linker command failed with exit code 1 (use -v to see invocation)

ninja: build stopped: subcommand failed.
```

# 找不到符号

> E:\study\NLLearn\app\src\main\java\com\newland\nllearn\MainActivity.java:16: 错误: 找不到符号
> public class MainActivity extends AppCompatActivity implements View.OnClickListener {
>                                ^
> 符号: 类 AppCompatActivity
>
> E:\study\NLLearn\app\src\main\java\com\newland\nllearn\MainActivity.java:23: 错误: 方法不会覆盖或实现超类型的方法
>  @Override
>  ^
>
> E:\study\NLLearn\app\src\main\java\com\newland\nllearn\MainActivity.java:25: 错误: 找不到符号
>      super.onCreate(savedInstanceState);
>      ^
> 符号:   变量 super
> 位置: 类 MainActivity
> E:\study\NLLearn\app\src\main\java\com\newland\nllearn\MainActivity.java:26: 错误: 找不到符号
>      setContentView(R.layout.activity_main);
>      ^
> 符号:   方法 setContentView(int)
> 位置: 类 MainActivity
>
> E:\study\NLLearn\app\src\main\java\com\newland\nllearn\MainActivity.java:28: 错误: 找不到符号
>      bt1 = findViewById(R.id.bt1);
>            ^
> 符号:   方法 findViewById(int)
> 位置: 类 MainActivity
> E:\study\NLLearn\app\src\main\java\com\newland\nllearn\MainActivity.java:29: 错误: 找不到符号
>      bt2 = findViewById(R.id.bt2);
>            ^
> 符号:   方法 findViewById(int)
> 位置: 类 MainActivity
> E:\study\NLLearn\app\src\main\java\com\newland\nllearn\MainActivity.java:31: 错误: 找不到符号
>      tv1 = findViewById(R.id.tv1);
>            ^
> 符号:   方法 findViewById(int)
> 位置: 类 MainActivity
>
> ![image-20210122100451134](https://github.com/hhhhhh11/image-folder/blob/main/image/image-20210122100451134.png)

```
解决方法：import class
```

# error: use of undeclared identifier 'NDK_GetRfidType'

> E:\study\NLLearn\app\src\main\jni\posNdk.c:433:27: error: use of undeclared identifier 'NDK_GetRfidType'
>
> 注释掉

# Execution failed for task ':processDebugResources'.
> Could not resolve all files for configuration ':_internal_aapt2_binary'.
> Cannot resolve external dependency com.android.tools.build:aapt2:4.1.1-6503028 because no repositories are defined.
> Required by:
>  	project :
>
> 解决方法：添加
>
> ```
> allprojects {
>     repositories {
>         google()
>     }
> }
> ```
>
> ![image-20210122114730335](https://github.com/hhhhhh11/image-folder/blob/main/image/image-20210122114730335.png)

# Design editor is unavailable until after a successful project sync

> 安卓布文件显示异常
>
> 重启AS

# module not specified

> settings.gradle里添加      include ‘:module-name’

![image-20210208093102920](https://github.com/hhhhhh11/image-folder/blob/main/image/image-20210208093102920.png)

# 程序包android.support.v7.app不存在

> https://blog.csdn.net/qq_36005498/article/details/104099785

#  Plugin with id 'com.android.application' not found.

> https://blog.csdn.net/liangtianmeng/article/details/90379526

# 错误：No layout manager attached; skipping layout

> https://blog.csdn.net/wj5ryf78/article/details/94580361