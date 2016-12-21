# XML解析（一）

## 1. 什么是解析XML
>系统最终会从xml中读取数据到内存,这个过程就是解析.

###1.1 下面是一个XML实例
``` xml
<?xml version="1.0" encoding="utf-8" ?>
<students>
	<student number="itcast_0001">
		<name>tom</name>
		<age>18</age>
		<sex>male</sex>
	</student>
	<student number="itcast_0002">
		<name>jerry</name>
		<age>16</age>
		<sex>female</sex>
	</student>
</students>
```


## 2. 思想

### 2.1 DOM
> DOM解析是将文档中的所有内容都一次性加载到内存,创建一棵dom树来记录对象之间的关系

#### 包含的对象类型
* document
* Element
* Attribute
* Test
* Commons
>  以上五个类都有共同的父类：Node
#### 特点
* 优点：方便进行操作(CRUD)
* 缺点：非常消耗内存

### 2.2 SAX
>SAX解析是基于事件驱动的方式读取XML.由具体的事件决定如何对读入内存的数据进行何种操作

#### 包含的事件类型
* 文档开始事件
* 元素开始事件
* 文本事件
* 元素结束事件
* 文档结束事件

#### 特点

* 优点：消耗内存小
* 缺点：不能保留整个XML的结构

### 2.3 DOM与SAX的出处
* DOM解析是由w3c推荐提出的
* SAX解析是由民间提出的

### 2.4 DOM4J

> http://dom4j.sourceforge.net/dom4j-1.6.1/


### 2.5 XPATH

> 关于XPATH的学习,参考阮一峰的文档:http://www.ruanyifeng.com/blog/2009/07/xpath_path_expressions.html