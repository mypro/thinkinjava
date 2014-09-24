[TOC]

# thinkinjava笔记

## 第1章 对象入门
## 第2章 一切都是对象

### javadoc
2.8.4 @see：引用其他类
所有三种类型的注释文档都可包含@see标记，它允许我们引用其他类里的文档。对于这个标记，javadoc会生成相应的HTML，将其直接链接到其他文档。格式如下：

@see 类名
@see 完整类名
@see 完整类名#方法名

每一格式都会在生成的文档里自动加入一个超链接的“See Also”（参见）条目。注意javadoc不会检查我们指定的超链接，不会验证它们是否有效。

2.8.5 类文档标记
随同嵌入HTML和@see引用，类文档还可以包括用于版本信息以及作者姓名的标记。类文档亦可用于“接口”目的（本书后面会详细解释）。

1. @version
格式如下：
@version 版本信息
其中，“版本信息”代表任何适合作为版本说明的资料。若在javadoc命令行使用了“-version”标记，就会从生成的HTML文档里提取出版本信息。

2. @author
格式如下：
@author 作者信息
其中，“作者信息”包括您的姓名、电子函件地址或者其他任何适宜的资料。若在javadoc命令行使用了“-author”标记，就会专门从生成的HTML文档里提取出作者信息。
可为一系列作者使用多个这样的标记，但它们必须连续放置。全部作者信息会一起存入最终HTML代码的单独一个段落里。

2.8.6 变量文档标记
变量文档只能包括嵌入的HTML以及@see引用。

2.8.7 方法文档标记
除嵌入HTML和@see引用之外，方法还允许使用针对参数、返回值以及违例的文档标记。

1. @param
格式如下：
@param 参数名 说明
其中，“参数名”是指参数列表内的标识符，而“说明”代表一些可延续到后续行内的说明文字。一旦遇到一个新文档标记，就认为前一个说明结束。可使用任意数量的说明，每个参数一个。

2. @return
格式如下：
@return 说明
其中，“说明”是指返回值的含义。它可延续到后面的行内。

3. @exception
有关“违例”（Exception）的详细情况，我们会在第9章讲述。简言之，它们是一些特殊的对象，若某个方法失败，就可将它们“扔出”对象。调用一个方法时，尽管只有一个违例对象出现，但一些特殊的方法也许能产生任意数量的、不同类型的违例。所有这些违例都需要说明。所以，违例标记的格式如下：
@exception 完整类名 说明
其中，“完整类名”明确指定了一个违例类的名字，它是在其他某个地方定义好的。而“说明”（同样可以延续到下面的行）告诉我们为什么这种特殊类型的违例会在方法调用中出现。

4. @deprecated
这是Java 1.1的新特性。该标记用于指出一些旧功能已由改进过的新功能取代。该标记的作用是建议用户不必再使用一种特定的功能，因为未来改版时可能摒弃这一功能。若将一个方法标记为@deprecated，则使用该方法时会收到编译器的警告。

## 第3章 控制程序流程
## 第4章 初始化和清除
### 主类型的过载
 
	  void f1(char x) { prt("f1(char)"); }
	  void f1(byte x) { prt("f1(byte)"); }
	  void f1(short x) { prt("f1(short)"); }
	  void f1(int x) { prt("f1(int)"); }
	  void f1(long x) { prt("f1(long)"); }
	  void f1(float x) { prt("f1(float)"); }
	  void f1(double x) { prt("f1(double)"); }

### 对象的创建过程

在一个类里，初始化的顺序是由变量在类内的定义顺序决定的。即使变量定义大量遍布于方法定义的中间，那些变量仍会在调用任何方法之前得到初始化——甚至在构建器调用之前

请考虑一个名为Dog的类：

1. 类型为Dog的一个对象首次创建时，或者Dog类的static方法／static字段首次访问时，Java解释器必须找到Dog.class（在事先设好的类路径里搜索）。
2. 找到Dog.class后（它会创建一个Class对象，这将在后面学到），它的所有static初始化模块都会运行。因此，static初始化仅发生一次——在Class对象首次载入的时候。
3. 创建一个new Dog()时，Dog对象的构建进程首先会在内存堆（Heap）里为一个Dog对象分配足够多的存储空间。
4. 这种存储空间会清为零，将Dog中的所有基本类型设为它们的默认值（零用于数字，以及boolean和char的等价设定）。
5. 进行字段定义时发生的所有初始化都会执行。
6. 执行构建器。正如第6章将要讲到的那样，这实际可能要求进行相当多的操作，特别是在涉及继承的时候。

new一个对象的时候时候先初始化静态变量然后是成员变量， 都按变量的顺序初始化，然后构造函数返回对象。