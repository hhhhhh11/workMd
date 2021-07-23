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