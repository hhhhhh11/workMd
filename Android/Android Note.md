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
>
> android 屏幕尺寸适配实现方案_易家四少的博客-CSDN博客
> https://blog.csdn.net/ygz111111/article/details/80309707
>
> > 1 inch = 2.54 cm
> >
> > **屏幕分辨率 : **单位px（pixel），纵向像素×横向像素，如1960×1080
> > **屏幕像素密度 ：**单位dpi（dot per inch）  
> >
> > 
> >
> > **dp转px ：** dp值×（当前dpi/160dpi)=>得出当前的像素数目
> >
> > 

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
>
> 两个activity
>
> > activity0  onPause
> > activity1  onCreate
> > activity1  onStart
> > activity1  onResume
> > activity0  onStop



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

## 显示字符串

> ```java
>     public void showMessage(TextView tv, String message) {
>         runOnUiThread(() -> {
>             tv.setText(message);
>         });
>     }
> ```
>
> 

## 监听开机广播



>  https://blog.csdn.net/watermusicyes/article/details/44963773
>
> 在Activity中使用startActivity()方法不会有任何限制，因为Activity重载了Context的startActivity()方法。但是如果是在其他地方（如Widget或Service、BroadcastReceiver中）使用startActivity()方法，就会报错：
>
> android.util.AndroidRuntimeException: Calling startActivity() from outside of an Activity  context requires the FLAG_ACTIVITY_NEW_TASK flag. Is this really what you want?
>
> 这时就需要为Intent设置一个FLAG_ACTIVITY_NEW_TASK的flag：
>
> Intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); 
>
> 这样就不会报错了，可以顺利的startActivity()。

>```java
>/**
> * 监听开机广播
> */
>public class BootReceiver extends BroadcastReceiver {
>
>    @Override
>    public void onReceive(Context context, Intent intent) {
>        // TODO: This method is called when the BroadcastReceiver is receiving
>        String action = intent.getAction();
>        LogUtils.e("start_action : " + action);
>        if (action.equals(Intent.ACTION_BOOT_COMPLETED)){
>            // 打印开机时间
>            long currentTime = System.currentTimeMillis();
>            String timeNow = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(currentTime);
>            LogUtils.d("开机时间 ："+timeNow);
>            // com.dianshijia.newlive.entry.SplashActivity
>            // com.dianshijia.newlive.home.LiveVideoActivity
>            Intent startTVIntent = new Intent();
>            startTVIntent.setClassName("com.dianshijia.newlive","com.dianshijia.newlive.entry.SplashActivity");
>            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
>            context.startActivity(startTVIntent);
>        }
>    }
>}
>```
>
>添加权限
>
>```xml
><uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED"/>
>
>注册广播
>        <receiver
>            android:name=".BootReceiver"
>            android:enabled="true"
>            android:exported="true">
>            <intent-filter android:priority="1000">
>                <action android:name="android.intent.action.BOOT_COMPLETED"></action>
>            </intent-filter>
>
>        </receiver>
>```
>

## 重启/重启BootLoader

> ```java
> private void reboot() {
>     PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
>     pm.reboot("");
> }
> 
> private void rebootBootloader() {
>     PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
>     pm.reboot("bootloader");
> }
> ```

## 修改文件权限

> Runtime.getRuntime().exec("chmod 777 " + destFile.getAbsolutePath());

## 启动其它应用

> ```java
>  Intent intent=new Intent();  
>  //包名 包名+类名（全路径）  
>  intent.setClassName("com.linxcool", "com.linxcool.PlaneActivity");  
>  startActivity(intent);  
> ```

## View坐标系

> ## View自身的坐标
>
> > getTop()：获取 View 自身顶边到其父布局顶边的距离。
> > getLeft()：获取 View 自身左边到其父布局左边的距离。
> > getRight()：获取 View 自身右边到其父布局左边的距离。
> > getBottom()：获取 View 自身底边到其父布局顶边的距离。
> >
> > getX()：获取点击事件距离控件左边的距离，即视图坐标。
> > getY()：获取点击事件距离控件顶边的距离，即视图坐标。
> >
> > getRawX()：获取点击事件距离整个屏幕左边的距离，即绝对坐标。
> > getRawY()：获取点击事件距离整个屏幕顶边的距离，即绝对坐标。
>
> ## View的滑动
>
> > 1. layout方法
> >
> >    ```java
> >    public boolean onTouchEvent(MotionEvent event) {
> >     		//获取手指触摸点的横坐标和纵坐标
> >     		int x = (int) event.getX()；
> >     		int y = (int) event.getY()；
> >     		switch (event.getAction()) {
> >     			case MotionEvent.ACTION_DOWN：
> >     				lastX = x；
> >     				lastY = y；
> >     				break；
> >    			...                
> >    			case MotionEvent.ACTION_MOVE：
> >     				//计算移动的距离
> >     				int offsetX = x - lastX；
> >     				int offsetY = y - lastY；
> >     				//调用 layout 方法来重新放置它的位置
> >     				layout(getLeft()+offsetX, getTop()+offsetY,
> >     					getRight()+offsetX , getBottom()+offsetY)；
> >     				break； 
> >                      
> >    ```
> >
> > 2. `offsetLeftAndRight()`与`offsetTopAndBottom`
> >
> >    替换ACTION_MOVE中的代码
> >
> >    ```java
> >     			case MotionEvent.ACTION_MOVE：
> >     				 //计算移动的距离
> >     				int offsetX = x - lastX；
> >     				int offsetY = y - lastY；
> >     				//对 left 和 right 进行偏移
> >     				offsetLeftAndRight(offsetX)；
> >     				//对 top 和 bottom 进行偏移
> >     				offsetTopAndBottom(offsetY)；
> >     				break； 
> >    ```
> >
> > 3. `LayoutParams`(改变布局参数)
> >
> >    ```java
> >    LinearLayout.LayoutParams layoutParams= (LinearLayout.LayoutParams)getLayoutParams()；
> >     	layoutParams.leftMargin = getLeft() + offsetX；
> >     	layoutParams.topMargin = getTop() + offsetY；
> >     	setLayoutParams(layoutParams)；
> >    ```
> >
> >    如果父控件是RelativeLayout，则要使用 RelativeLayout.LayoutParams。除了使用布局的 LayoutParams 外，我们还可以用 ViewGroup.MarginLayoutParams 来实现：
> >
> >    ```java 
> >    ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams)getLayoutParams();
> >     	layoutParams.leftMargin = getLeft() + offsetX;
> >     	layoutParams.topMargin = getTop() + offsetY;
> >     	setLayoutParams(layoutParams);
> >    ```
> >
> > 4. 动画
> >
> >    > **View 动画并不能改变 View 的位置参数**
> >    >
> >    > 如果对一个 Button 进行如上的平移动画操作，当 Button 平移 300 像素停留在当前位置时，我们点击这个 Button 并不会触发点击事件，但在我们点击这个 Button 的原始位置时却触发了点击事件。
> >
> >    可以采用 View 动画来移动，在 res 目录新建 anim 文件夹并创建 translate.xml：
> >
> >    ```xml
> >    ＜?xml version=＂1.0＂ encoding=＂utf-8＂?＞
> >    ＜set xmlns：android=＂http：//schemas.android.com/apk/res/android＂
> >    	android：fillAfter=＂true＂＞//加上fillAfter会停留在当前位置
> >     ＜translate
> >     android：duration=＂1000＂
> >     android：fromXDelta=＂0＂
> >     android：toXDelta=＂300＂ /＞
> >    ＜/set＞
> >    ```
> >
> >    接下来在 Java 代码中调用就好了，代码如下所示：
> >
> >    ```java 
> >    mCustomView.setAnimation(AnimationUtils.loadAnimation(this,R.anim.translate));
> >    ```
> >
> > 5. `scrollTo`与`scrollBy`
> >
> >    scrollTo(x,y)表示移动到一个具体的坐标点，而 scrollBy(dx,dy)则表示移动的增量为 dx、dy。其中，scollBy 最终也是要调用 scollTo 的。
> >
> >    scollTo、scollBy 移动的是 View 的内容，如果在 ViewGroup 中使用，则是移动其所有的子View。我们将 ACTION_MOVE 中的代码替换成如下代码：
> >
> >    ```jav
> >    ((View)getParent()).scrollBy(-offsetX,-offsetY);
> >    ```
> >
> >    若要实现 CustomView 随手指移动的效果，就需要将偏移量设置为负值。
> >
> > 6. `Scroller`
> >
> >    Scroller 本身是不能实现 View 的滑动的，它需要与 View 的 computeScroll()方法配合才能实现弹性滑动的效果。

## 属性动画

1. ObjectAnimator

```java
ObjectAnimator mObjectAnimator=ObjectAnimator.ofFloat(view,＂translationX＂,200);
mObjectAnimator.setDuration(300);
mObjectAnimator.start();
    ofFloat()代码
public static ObjectAnimator ofFloat(Object target, String propertyName,float... values) {
 	ObjectAnimator anim = new ObjectAnimator(target, propertyName);
 	anim.setFloatValues(values);
 	return anim;
}
```

> 常用的可以直接使用的属性动画的属性值。 
>
> • translationX 和 translationY：用来沿着 X 轴或者 Y 轴进行平移。
> • rotation、rotationX、rotationY：用来围绕 View 的支点进行旋转。
> • PrivotX 和 PrivotY：控制 View 对象的支点位置，围绕这个支点进行旋转和缩放变换处理。默认该支点位置就是 View 对象的中心点。
> • alpha：透明度，默认是 1（不透明），0 代表完全透明。
> • x 和 y：描述 View 对象在其容器中的最终位置。

在使用 ObjectAnimator 的时候，要操作的属性必须要有 get 和 set 方法，不然 ObjectAnimator 就无法生效。如果一个属性没有 get、set 方法，也可以通过自定义一个属性类或包装类来间接地给这个属性增加 get 和 set 方法。

2. ValueAnimator

   ValueAnimator 不提供任何动画效果，它更像一个数值发生器，用来产生有一定规律的数字，从而让调用者控制动画的实现过程。

3. 动画的监听

   完整的动画具有 start、Repeat、End、Cancel 这 4 个过程，代码如下所示：

   ```java
   ObjectAnimator animator=ObjectAnimator.ofFloat(view,＂alpha＂,1.5f);
    	animator.addListener(new Animator.AnimatorListener() {
    		@Override
    		public void onAnimationStart(Animator animation) {
    		}
    		@Override
    		public void onAnimationEnd(Animator animation) {
    		}
    		@Override
    		public void onAnimationCancel(Animator animation) {
    		}
    		@Override
    		public void onAnimationRepeat(Animator animation) {
    		}
    	});
    }
   
   ObjectAnimator animator=ObjectAnimator.ofFloat(view,＂alpha＂,1.5f);
    	animator.addListener(new AnimatorListenerAdapter() {
    		@Override
    		public void onAnimationEnd(Animator animation) {
    			super.onAnimationEnd(animation)；
    		}
    	});
   ```

4. 组合动画——AnimatorSet

   AnimatorSet.Builder 中包括以下 4 个方法。 

   • after(Animator anim)：将现有动画插入到传入的动画之后执行。
   • after(long delay)：将现有动画延迟指定毫秒后执行。
   • before(Animator anim)：将现有动画插入到传入的动画之前执行。
   • with(Animator anim) ：将现有动画和传入的动画同时执行。

5. 组合动画——PropertyValuesHolder

   使用 PropertyValuesHolder 类只能是多个动画一起执行。

   ~~~java
   PropertyValuesHolder valuesHolder1 = PropertyValuesHolder.ofFloat(＂scaleX＂, 1.0f, 1.5f);
   PropertyValuesHolder valuesHolder2 = PropertyValuesHolder.ofFloat(＂rotationX＂, 0.0f, 90.0f, 0.0F);
   PropertyValuesHolder valuesHolder3 = PropertyValuesHolder.ofFloat(＂alpha＂,1.0f, 0.3f, 1.0F);
   ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(mCustomView, valuesHolder1, valuesHolder2,valuesHolder3);
   objectAnimator.setDuration(2000).start();
   ~~~

6. 在XML中使用属性动画

   ~~~java
   Animator animator=AnimatorInflater.loadAnimator(this,R.animator.scale);
   animator.setTarget(view);
   animator.start();
   ~~~


## 自定义View

### 继承系统控件的自定义View

这种自定义 View 在系统控件的基础上进行拓展，一般是添加新的功能或者修改显示的效果，一般情况下在 onDraw()方法中进行处理。

## Activity启动模式

1. standard：标准模式，每次启动一个Activity都会重新创建一个新的实例
2. singleTop：栈顶复用模式，如果新的Activity已经位于任务栈的栈顶，那么此Activity不会被重新创建
3. singleTask：栈内复用模式，单实例模式。只要Activity在一个栈中存在，那么多次启动此Activity 都不会重新创建实例，和singleTop一样，系统也会回调其onNewIntent。singleTask默认具有clearTop的效果。
4. singleInstance：单实例模式，加强的singleTask，具有此模式的Activity只能单独地位于一个任务栈中

## Activity的Flags

> **FLAG_ACTIVITY_NEW_TASK**：为Activity指定“singleTask“启动模式，效果和在XML中指定该启动模式相同。 
>
> **FLAG_ACTIVITY_SINGLE_TOP**：为Activity指定“singleTop“启动模式，效果和在XML中指定该启动模式相同。
>
> **FLAG_ACTIVITY_CLEAR_TOP**：具有此标记位的Activity启动时，在同一个任务栈中所以位于它上面的Activity都要出栈
>
> ```java
>                 Intent intent = new Intent(PwdActivity.this, LoginActivity.class);
>                 intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
>                 startActivity(intent);
> ```



