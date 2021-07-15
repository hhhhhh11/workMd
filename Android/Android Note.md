# Android Note

## Android命名规范

> https://www.jianshu.com/p/b7a644ea0d25

## Android JNI(一)——NDK与JNI基础

> https://www.jianshu.com/p/87ce6f565d37   

## Android ndk+jni:android.mk和application.mk写法

> https://blog.csdn.net/u010326875/article/details/83031144

## NDK调试

> NDK调试arm-linux-androideabi-addr2line工具的使用
>
> F:\Android\AndroidSDK\ndk-bundle\toolchains\arm-linux-androideabi-4.9\prebuilt\windows-x86_64\bin
>
> arm-linux-androideabi-addr2line -e F:\Android\eclipse\Workspace\PosAuthority\obj\local\armeabi-v7a\libPosAut hority.so 00005c6f
> F:/Android/eclipse/Workspace/PosAuthority/jni/libmfgutil.c:429 (discriminator 1)
>
> arm-linux-androideabi-addr2line -e
> F:\workspace\FFmpegDemo\app\build\intermediates\cmake\debug\obj\armeabi\libffmpeg-lib.so 00002c6f
>
> arm-linux-androideabi-addr2line -e 需要调试的so库路径 内存地址
>
> 64位
> F:\Android\AndroidSDK\ndk-bundle\toolchains\mips64el-linux-android-4.9\prebuilt\windows-x86_64\bin
> mips64el-linux-android-addr2line
>
> openssl pkcs7 -inform DER -in CERT.RSA  -noout -print_certs -text
> 看证书签名

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

> activity生命周期
>
> ![](https://img-blog.csdnimg.cn/20190221143601607.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl8zODE5NjQwNw==,size_16,color_FFFFFF,t_70)
>
> | 回调        | 描述                                                         |
> | :---------- | :----------------------------------------------------------- |
> | onCreate()  | 这是第一个回调，在活动第一次创建时调用                       |
> | onStart()   | 这个回调在活动为用户可见时被调用                             |
> | onResume()  | 这个回调在应用程序与用户开始可交互的时候调用                 |
> | onPause()   | 被暂停的活动无法接受用户输入，不能执行任何代码。当前活动将要被暂停，上一个活动将要被恢复时调用 |
> | onStop()    | 当活动不在可见时调用                                         |
> | onDestroy() | 当活动被系统销毁之前调用                                     |
> | onRestart() | 当活动被停止以后重新打开时调用                               |

## Fragment

> fragment生命周期
>
> |                        |                                                            |
> | ---------------------- | ---------------------------------------------------------- |
> | **onAttach()**         | 在Fragment和Activity建立关联时调用(Activity传递到此方法内) |
> | onCreate()             |                                                            |
> | **onCreateView()**     | 当Fragment创建视图时调用                                   |
> | **onActivityCreate()** | 在相关联的Activity的onCreate()方法已返回时调用             |
> | onStart()              |                                                            |
> | onResume()             |                                                            |
> | onPause()              |                                                            |
> | onStop()               |                                                            |
> | **onDestroyView()**    | 当Fragment中的视图被移除时调用                             |
> | onDestroy()            |                                                            |
> | **onDetach()**         | 当Fragment 和 Activity 取消关联时调用                      |
>
> 

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
>  数据保存到本地SharedPreferences 
>
>  https://blog.csdn.net/bingocoder/article/details/80613993

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
>  PowerManager pm = (PowerManager) context.getApplicationContext().getSystemService(Context.POWER_SERVICE);
>  pm.reboot(reason);
> }
> ```

## 设置EditText光标在最后

> ```java
> EditText edittext = (EditText)findViewById(R.id.edittext);
> edittext.setSelection(edittext.getText().length());
> ```