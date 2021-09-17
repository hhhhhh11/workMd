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

## Git切换远程分支

git切换到指定远程分支_astonishqft的博客-CSDN博客_git 切换到远程分支
https://blog.csdn.net/astonishqft/article/details/83029490

> git checkout -b 本地分支名 origin/远程分支名

git提交

git push origin ssh://gujiawei@192.168.132.70:29418/Android/newland/packages/apps/NlAuthApp HEAD:refs/for/android-9.0

## Git版本回退

> git reset --hard 目标版本号
>
> Git命令之回退篇 git revert git reset - futureme - 博客园
> https://www.cnblogs.com/taylorluo/p/10792498.html

## Git切换分支，暂存本地修改的代码

> git branch   查看当前分支
>
> git stash  将本地改动暂存到“栈”里面
>
> git checkout master  切换到master分支
>
> git pull  拉取master分支最新的代码
>
> **当我们再想切换回当前的feature分支**
>
> git checkout feature  切换回到feature分支
>
> git stash pop  再将刚才暂存到“栈”里面的代码取出来，这样就可以继续接着刚才的业务逻辑继续开发了



比较两个历史版本之间的差异

  git diff SHA1 SHA2
