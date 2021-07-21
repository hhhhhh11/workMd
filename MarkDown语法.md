# MarkDown语法

## 一些快捷键

> Ctrl+1  一阶标题    Ctrl+B  字体加粗
> Ctrl+2  二阶标题    Ctrl+I  字体倾斜
> Ctrl+3  三阶标题    Ctrl+U  下划线
> Ctrl+4  四阶标题    Ctrl+Home   返回Typora顶部
> Ctrl+5  五阶标题    Ctrl+End    返回Typora底部
> Ctrl+6  六阶标题    Ctrl+T  创建表格
> Ctrl+L  选中某句话   Ctrl+K  创建超链接
> Ctrl+D  选中某个单词  Ctrl+F  搜索
> Ctrl+E  选中相同格式的文字   Ctrl+H  搜索并替换
> Alt+Shift+5 删除线 Ctrl+Shift+I    插入图片
> Ctrl+Shift+M    公式块 Ctrl+Shift+Q    引用
>
> 注：一些实体符号需要在实体符号之前加”\”才能够显示

## 文字加粗、斜体、字体大小、换行

> **加粗**
>
> ```java
> **加粗内容**
> ```
>
> *斜体*
>
> ```java
> *斜体内容*
> ```
>
> <font size=5>自定义字体大小</font>
>
> ```java
> <font size=4>自定义字体大小</font>
> ```
>
> <small>字体变小</small>
> <big>字体变大</big>
>
> ```java
> <small>字体变小</small>
> <big>字体变大</big>
> ```
>
> ***换行***
>
> > 空格+空格+回车  
> >
> > **软换行：**需要说明的是，在 Markdown 语法中，换行（line break）与换段是不同的。且换行分为软换行和硬换行。在 Typora 中，你可以通过 Shift + Enter 完成一次软换行。软换行只在编辑界面可见，当文档被导出时换行会被省略。
> > **硬换行：**你可以通过 空格 + 空格 + Shift + Enter 完成一次硬换行，而这也是许多 Markdown 编辑器所原生支持的。硬换行在文档被导出时将被保留，且没有换段的段后距。
> > **换段：**你可以通过 Enter 完成一次换段。Typora 会自动帮你完成两次 Shift + Enter 的软换行，从而完成一次换段。这也意味着在 Markdown 语法下，换段是通过在段与段之间加入空行来实现的。

## 段落中的代码

> 用反引号把它包起来 
> `hello world`
>
> ```java
> `代码内容`
> ```

