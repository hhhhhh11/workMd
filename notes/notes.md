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

# git

> git秘钥生成 https://www.cnblogs.com/xiuxingzhe/p/9303278.html

> git使用多个GitHub账号https://jingyan.baidu.com/article/948f592414ad67d80ef5f966.html
>
> Github使用公钥和私钥https://blog.csdn.net/memory_nothing/article/details/94908152

