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



# git

> git秘钥生成 https://www.cnblogs.com/xiuxingzhe/p/9303278.html

> git使用多个GitHub账号https://jingyan.baidu.com/article/948f592414ad67d80ef5f966.html
>
> Github使用公钥和私钥https://blog.csdn.net/memory_nothing/article/details/94908152

> 