# web开发

黑马程序员的JavaWeb课程（Spring+MyBatis+SpringMVC+SpringBoot等（HTML+JavaScript+CSS+Maven+JDBC+MySQL+阿里云OSS））

参照企业开发模式，需求分析-表结构设计-接口文档-功能接口实现-测试-联调

BV1m84y1w7Tb 2023-03-21

LTAI5tKKNwuJYe8ji7D6RM6Y
NCPsBqqXxr9tW6aaJbdvnffKBY9oVv

[TOC]

## Web

web网站的工作流程

![image-20240121184448086](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240121184448086.png)



## web前端开发

三个组成部分：HTML(网页的结构) CSS（表现） JavaSript（行为） （前端开发三剑客）

以及：Ajax element vue3 ...

![image-20240126182132806](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240126182132806.png)

### HTML：

定义：超文本（文字+视频 图片...） 标记(由标签构成)  语言

性质：标签不区分大小写 

​	单引号双引号不区分 

​	语法不严格 空格无论输入多少，都只会显示一个

#### 结构标签

```html
<!-- 声明文档类型为html -->
<!DOCTYPE html>
<html lang="en">
<head>
	<!-- 声明编码格式为utf-8 -->
	<meta charset="UTF-8">
	<!-- 设置浏览器的兼容性 -->
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- 设置浏览器标签的标题 -->
	<title>Document</title>
</head>

<!-- 正文内容 -->
<body>
    <h1>主题标签</h1>
    <h6>最小的</h6>
    <hr>水平线标签<span>行内元素标签 没有任何属性
    <img src="路径" width = "" height = "">图片目录 ./当前标签可省略 ../上一级标签不可省略
    <a herf = "...url" target = "在哪个窗口打开该超链接">超链接标签</a>
    <br>换行
    <p>
       段落
        <b><strong>加粗
    </p>
</body>

</html>
```

#### 表格标签

```html
<table>:定义表格
<tr>: 定义表格中的行，一个 <tr> 表示一行<th>: 表示表头单元格，具有加粗居中效果
<td>: 表示普通单元格
```



### CSS：

定义：层叠样式表（表现） 控制界面的样式

引入方式：行内 内嵌 外联 

```css
<h1 style="...">
<style>...
xxx.css <link herf="...">
```

#### 选择器

元素 类 ID(最优先)

```css
span{
    color:...;
    text-decoration: none设置文本装饰 文本装饰为标准
    text-indent:首行缩进
    text-height:行高
    text-align:对齐方式  
}元素名

.cls{
   
}类名

#time{
    
}ID名
```

#### 盒子模型

组成：content、padding、border、margin



### JavaScript：

定义：跨平台 面向对象 脚本（代码不需要编译）语言

​	控制网页行为 可以使网页交互

​	区分大小写 末尾分号可有可无

​	弱类型语言 变量可以存储不同类型的值

#### 引入方式

内部脚本 外部脚本

#### 基础语法

##### 输出语法

```javascript
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Document</title>
</head>
<body>
</body>
<script>
	//弹出警告框	
	window.alert("...");

	//写入html页面
	document.write("...");

	//向控制台输出
	console.log("...");
</script>
</html>
```

##### 变量

###### var关键字

```javascript
<script>
	var a = 10;
	a = "123";
</script>
```

特点：为全局变量 作用域较大

​	    可以重复定义 为最后一次定义的值

###### let关键字

```javascript
let x = 1;
```

特点：局部变量 不可以重复定义

###### const关键字

```javascript
let x = 1;
```

特点：常量 不可以改变

##### 数据类型

###### 原始类型

number、string、boolean、null、undefined

(object)

###### 引用类型

##### 运算符

==：进行类型转换

===：不进行类型转换

#### 函数

定义函数时 不需要定义变量类型（弱类型语言）

```javascript
<script>
	//定义函数1
	function add(a,b){
		return a+b;
	}
	//定义函数2
	var add = function(a,b){
		return a+b;
	}
	//函数调用
	var result = add(1,2);
</script>
```

#### 对象

##### 基础对象

###### 数组Array

类似java集合：长度可变 类型可变

属性：length:数组中元素数量

方法：forEach():遍历

​	   splice():从数组中删除元素

 	  push():添加新元素到数组的末尾 返回新的长度

###### 字符串str

属性：length

方法：charAt(位置)：字符

​	    indexOf(字符)：位置

​	    trim():去除字符串两边的空格

​	    subString(头，尾):

##### 自定义对象

###### 定义

var 对象名={

​	属性名：属性值

​	函数名：function(){}

​	函数名（）{}

}

###### 调用

对象名.属性名;

对象名.函数名();

##### JSON对象

定义：通过javaScript对象标记法书写的 文本（字符串）

多用于作数据载体 在网络中传递数据

###### 定义

var 变量名='{"key":value, ... }'

```javascript
<script>
	//定义JSON对象
	var userJson = '{"age":10 , "name" = "jarry" , "addr" = ["北京","上海","广州"]}';
	//JSON字符串 转化为JS对象
	var userJs = JSON.parse(userJson);
	//JS对象 转化为 JSON字符串
	var userStr = JSON.stringify(userJs);
</script>
```

##### 浏览器对象BOM

定义：浏览器对象模型 将浏览器的各个部分封装为对象

###### Window：浏览器窗口对象

获取:window.(可省略)

属性:history: 对 History 对象的只读引用      

​	location: 用于窗口或框架的 Location 对象

​	navigator:对Navigator 对象的只读引用

方法:alert(): 显示带有一段消息和一个确认按钮的警告框。

​	confirm():显示带有一段消息以及确认按钮和取消按钮的对话框

​	setlnterval(): 按照指定的周期(以毫秒计)来调用函数或计算表达式

​	setTimeout():在指定的毫秒数后调用函数或计算表达式

```javascript
//confirm
	var flag = confirm("确认删除吗？");//flag为布尔类型 确认true 取消false

	//setInterval
	var i = 0;
	setInterval(function(){
		i++;
		alert("定时器执行"+i+"次");
	},2000)//每个2000毫秒 执行一次函数

	//setTimeout
	setTimeout(function(){
		alert("JS");
	},3000)//延迟3000毫秒执行该函数
```



Navigator：浏览器对象

Screen：屏幕对象

History：历史记录对象



###### Location：地址栏对象

获取：window.location

属性：herf : 保存或设置url

##### 文档对象DOM

定义：文档对象类型

​	将标记语言（HTML）的各个组成部分封装为对应的对象：Document（整个文档对象）、Element（元素对象）、Attribute（属性对象）、Text（文本对象）、Comment（注释对象）

###### 对元素对象的获取：

```javascript
//通过ID名称获取
	var h1 = document.getElementById('h1');//获取单个元素 返回对象
	
	//通过标签名称获取
	var div = document.getElementsByTagName('div');//返回数组

	//通过class属性获取
	var cls = document.getElementsByClassName('cls');//返回数组

	//通过name属性获取
	var name = document.getElementsByName('name');//返回数组
```

#### 事件监听

事件：HTML元素上的事情（被点击，鼠标移动-->用户的操作）

##### 事件绑定

###### 绑定方式 

```javascript
<body>
    <input type="button" id="btn1" value="事件绑定1" onclick="on()">
    <input type="button" id="btn2" value="事件绑定2">
</body>

<script>
    function on(){
        alert("按钮1被点击");
    }//第一种绑定方式

    document.getElementById('byn2').onclick = function(){
        alert("按钮2被点击");
    }
</script>
```

###### 常见事件

![image-20240129141621654](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240129141621654.png)

### Vue框架

定义：前端 框架-->（半成品软件 是一个可重用、通用的、软件基础代码模型）

​	免除原生JS的DOM操作 -->简化开发 提高效率

​	基于MVVM（Model-View-ViewModel（Vue框架负责））思想

*双向数据绑定

```html
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Document</title>
	<!-- 引入Vue.js文件 -->
	<script>js/vue.js</Script>
</head>
<body>
	<!-- 定义视图 -->
	<div id = "app">
		<!-- 定义一个输入框 使用v-model绑定数据模型message -->
		<input type = "text" v-model = "message">
	</div>

</body>
<script>
	//创建VUE对象
	new Vue({//定义对应属性
		el :"#app",//定义vue接管的对象范围
		data :{//定义数据模型
			message : "hello Vue"
		}
	})
</script>
```

#### 指令

定义：HTML标签上带有v- 前缀的特殊属性 

##### 常用指令

![image-20240129150021799](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240129150021799.png)

对应代码

```html
<!-- v-bind:为HTML标签绑定属性值 -->
		<a v-bind:href="url">。。。</a>
		<a :href="url">...</a>
```

#### 生命周期

状态

![image-20240129152917589](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240129152917589.png)

![image-20240129153008668](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240129153008668.png)

每触发一个声明周期事件，会自动执行一个 生命周期方法（钩子）

对应代码

```javascript
new Vue({//定义对应属性
		el :"#app",//定义vue接管的对象范围
		data :{//定义数据模型
			url : "baidu"
		},
		methods:{

		},
		mounted() {//在该生命周期时，此方法自动被调用
			
		},
	})
```

### Ajax异步交互技术

概念：异步的JavaScript和XML（存储数据的标记语言）

作用：数据交换 异步交互

​                            同步/异步：在服务器进行处理时，客户不可以/可以执行其他操作

#### Axios

介绍：对原生Ajax进行封装，简化书写，

快速开发

##### 使用

向服务器发送异步请求

![image-20240129184255532](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240129184255532.png)

### 前端工程化

定义：实际的前端开发：将前端开发所需的工具、技术、流程等   进行模块化（JS、CSS）、组件化、规范化、自动化

#### Vue项目

创建

##### 目录结构

![image-20240129224111408](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240129224111408.png)

![image-20240129224130795](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240129224130795.png)

##### Element库

介绍：基于Vue2.0的桌面端组件库

​	组件：组成网页的组件：找链接、按钮、图片、。。。

重要性：运用组件 创建更加美观的界面

##### Vue路由

定义：URL中的hash（#）与组件之间的关系

###### 定义路由

##### 打包部署

###### Nginx

## 前后端分离开发

### YAPI

介绍：api管理平台 管理接口文档

功能：API接口管理 Mock服务

​		添加项目->分类->接口

## Web后端开发

### Maven

#### 介绍

- apache旗下的一个开源项目

​    ↑：世界上最大的开源软件基金会

- 用于管理和构建java项目的工具
- 基于项目对象模型（POM）的概念，通过一小段信息来管理项目的构建

##### 作用

- 依赖管理：管理项目依赖的资源（jar包），避免版本冲突问题

- 统一项目结构：提供标准、统一的项目结构

###### 	项目结构

![image-20240130162853398](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240130162853398.png)

- 项目构建：提供标准跨平台（linux、windows、MacOS）的自动化项目构建方式

##### 模型及仓库

![image-20240130163841837](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240130163841837.png)

#### IDEA集成Maven

P52+53

#### 依赖管理

##### 依赖配置

在pom.xml文档中添加依赖

```html
<dependencies>
    <dependency>依赖
        <groupId>组织名</groupId>
        <artifactId>模块名</artifactId>
        <version>版本</version>
        <scope>控制范围</scope>
    </dependency>
</dependencies>
```

- 如果假如的依赖不存在本地仓库里，将会连接远程/中央仓库进行下载

- 如果不知道依赖的组表信息，那么可以进行搜索

##### 依赖传递

Maven的特性：依赖的导入具有传递性

​	间接/直接依赖

​	排除依赖：exclusions->exclusion断开与依赖资源的连接

![image-20240201220022401](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240201220022401.png)

##### 依赖范围

通过scope控制依赖的范围

![image-20240201220525001](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240201220525001.png)

##### 生命周期

介绍：为了对所有的Maven项目建构过程进行抽象和统一

三套项目独立的生命周期：

- clean：清理工作

- default：核心工作（编译、测试、打包、。。。）
- site:生成报告、发布站点、。。。

![image-20240201221432959](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240201221432959.png)

- clean：移除上一次构建生成的文件
- compile：编译项目源代码
- test：选择合适的单元测试框架进行测试
- package：将编译后的文件打包
- install：安装项目到本地仓库

### SpringBoot Web

#### Spring

介绍：提供了若干个子项目，每个项目用于完成特定的功能

​	Spring发展到今天已经形成了一种开发生态圈

![image-20240201223356499](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240201223356499.png)

Spring Framework提供Spring家族的基本框架-->Spring Boot简化Spring应用程序的构建、开发、提供效率

#### SpringBootWeb入门

##### 基本开发步骤

1. 创建SpringBoot工程，并勾选web开发相关依赖
2. 编写代码，添加对应的注解
3. 运行测试

```java
//启动类--启动SpringBoot工程
@SpringBootApplication
public class SpringbootQuickstartApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootQuickstartApplication.class, args);
    }
}
```

```java
//请求处理类-->需要添加标识来说明此类为一个请求处理类
@RestController
public class HelloController {
    //注明当前方法处理的是什么请求--》如果浏览器发出/hello地址的请求，那么此方法就会被调用
    public String hello(){
        System.out.println("hello~");
        return "helloWorld";//返回给浏览器的数据
    }
}
```

#### HTTP协议

##### 概述

定义：超文本传输协议，规定了浏览器和服务器之间 数据传输的 规则（请求和响应的格式）

特点：

基于TCP协议：面向连接，安全

- 基于 请求-响应 模型：一次请求对应一次响应

- HTTP协议是无状态的协议：对事物处理没有记忆能力。 每次请求-响应都是独立的：

  ​	缺点：多次请求之间不能共享数据

  ​	优点：速度快

##### 请求协议

定义：请求数据的格式

###### 请求行

定义：请求数据第一行

包括：请求方式（get、post、。。。） 资源路径 协议

###### 请求头

定义：从第二行开始 格式：key：value

内容：浏览器版本、请求的主机地址、。。。

常见的请求头

![image-20240204184537011](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240204184537011.png)

###### 请求体

定义：post请求特有的 用于存放请求参数

​	存于最后一行 与请求头之前用空行隔开

[^get请求与post请求的区别]: 

##### 响应协议

###### 响应行

定义：请求数据第一行

包括：协议 

状态码 

![image-20240204185430447](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240204185430447.png)

![image-20240204185649164](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240204185649164.png)

描述

###### 响应头

定义：描述相应信息

​	从第二行开始 格式：key：value

常见的响应头

![image-20240204190650391](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240204190650391.png)

###### 响应体

定义：存放响应数据

​	存于最后一行 与响应头之前用空行隔开

##### 协议解析

介绍：根据http请求格式，解析对应的请求数据和响应数据

使用web服务器（主流Tomcat↓）软件进行解析

#### Tomcat

##### 介绍

###### web服务器

是一个软件程序

对http协议进行封装，简化开发流程

部署web项目，提供网上信息浏览服务

###### 概念

apache软件基金会的一个核心项目、开源免费的轻量级web服务器

###### Java语言的分支

JavaSE：java标准版

JavaME：java小型版-->嵌入式

JavaEE：java企业版-->一些列java企业级开发技术的规范总和

##### 基本使用

###### 目录介绍

![image-20240221233054026](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240221233054026.png)

###### Tomcat启动和停止

![image-20240221233345747](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240221233345747.png)

#### 请求响应

DispatcherServlet（前端控制器）：实现servlet规范中的servlet接口 一个可以被Tomcat识别的servlet程序

![image-20240222160544745](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240222160544745.png)

##### 请求

###### postman工具

网页调试与发送网页HTTP请求的插件 常用于接口测试

###### 参数的接收以及封装

1.简单参数

```java
     //1. 简单参数
     //原始方式
    @RequestMapping("/simpleParam")
    public String simpleParam(HttpServletRequest request){
        //获取请求参数
        String name = request.getParameter("name");
        String ageStr = request.getParameter("age");

        int age = Integer.parseInt(ageStr);
        System.out.println(name+ ":" + age);
        return "OK";
    }

	    //springboot方式
    @RequestMapping("/simpleParam")
    public String simpleParam(String name, Integer age){
        System.out.println(name+ ":" + age);
        return "OK";
    }
	
	//@RequestParam注解
	//如果方法形参名称与请求参数不匹配，可以使用@RequestParam完成映射
	//默认值required属性为true
	@RequestMapping("/simpleParam")
    public String simpleParam(@RequestParam(name = "name", required = false) String username, Integer age){
        System.out.println(username+ ":" + age);
        return "OK";
    }
```

2.实体参数：请求参数名与形参对象属性名相同，定义POJO接收即可

```java
    @RequestMapping("/simplePojo")
    public String simplePojo(User user){
        System.out.println(user);
        return "OK";
    }

	public class User {
    private String name;
    private Integer age;
    }

	//复杂实体对象：求参数名与形参对象属性名相同，按照对象层次结构关系即可接收嵌套pojo属性参数
    @RequestMapping("/complexPojo")
    public String complexPojo(User user){
        System.out.println(user);
        return "OK";
    }
	
	public class User {
    private String name;
    private Integer age;
    private Address address;
    }
```

3.数组集合参数

​	使用场景：复选框组件

```java
    //3. 数组集合参数
	//使用数组进行封装--数组和请求参数名变量相同
    @RequestMapping("/arrayParam")
    public String arrayParam(String[] hobby){
        System.out.println(Arrays.toString(hobby));
        return "OK";
    }

	   //使用集合进行封装--请求参数名与形参中变量名集合相同，使用@RequestParam绑定参数关系
	@RequestMapping("/listParam")
    public String listParam(@RequestParam List<String> hobby){
        System.out.println(hobby);
        return "OK";
    }
```

4.日期参数

```java
//4. 日期时间参数--需要指定接收日期的格式
@RequestMapping("/dateParam")
    public String dateParam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime updateTime){
        System.out.println(updateTime);
        return "OK";
    }
```

5.Json参数

```java
//5. json参数
//需要通过@RequestBody将json封装到一个实体类当中
    @RequestMapping("/jsonParam")
    public String jsonParam(@RequestBody User user){
        System.out.println(user);
        return "OK";
    }

//对应的实体类
public class User {
    private String name;
    private Integer age;

    private Address address;
}
public class Address {
    private String province;
    private String city;
}
```

6.路径参数

​	概念：通过请求URL直接传递参数

```java
    //6. 路径参数
	//使用{......}标识路径参数,使用@PathVariable获取路径参数
    @RequestMapping("/path/{id}")
    public String pathParam(@PathVariable Integer id){
        System.out.println(id);
        return "OK";
    }

    @RequestMapping("/path/{id}/{name}")
    public String pathParam2(@PathVariable Integer id , @PathVariable String name){
        System.out.println(id);
        System.out.println(name);
        return "OK";
    }
```

##### 响应

###### @ResponseBody注解

将方法返回值直接响应，如果返回值是实体对象/集合，将会转换为Json格式响应

```java
@RequestMapping("/hello")
    public Result hello(){
        System.out.println("Hello World ~");
        //return new Result(1,"success","Hello World ~");
        return Result.success("Hello World ~");
    }

    @RequestMapping("/getAddr")
    public Result getAddr(){
        Address addr = new Address();
        addr.setProvince("广东");
        addr.setCity("深圳");
        return Result.success(addr);
    }

    @RequestMapping("/listAddr")
    public Result listAddr(){
        List<Address> list = new ArrayList<>();

        Address addr = new Address();
        addr.setProvince("广东");
        addr.setCity("深圳");

        Address addr2 = new Address();
        addr2.setProvince("陕西");
        addr2.setCity("西安");

        list.add(addr);
        list.add(addr2);
        return Result.success(list);
    }

	//为了统一响应结果 创建result类
	public class Result {
    private Integer code ;//1 成功 , 0 失败
    private String msg; //提示信息
    private Object data; //数据 data
    }
```

##### 分层解耦

###### 三层架构

​	单一职责原则：一个类/方法，只负责一个单一的功能-->提升程序的扩展性和可维护性

![image-20240222222446148](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240222222446148.png)

###### 分层解耦

解耦：接触耦合

内聚：软件中各个功能模块内部的功能关系

耦合：衡量软件中各个层/模块之间的依赖、关联的程度

软件设计原则：高内聚低耦合

###### IOC控制反转

介绍：Inversion Of Control。对象的控制权由程序自身转移到外部（容器）中。

![image-20240222224944080](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240222224944080.png)

Bean组件扫描

![image-20240222225540999](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240222225540999.png)

###### DI依赖注入

介绍：Dependency Injection。容器为应用程序提供 运行时所依赖的资源。

![image-20240222230019983](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240222230019983.png)

###### Bean对象

介绍：IOC容器中创建、管理的对象

### MySQL

#### 概述

- 数据库：DataBase（DB），是存储和管理数据的仓库。
- 数据库管理系统：DBMS，操纵和管理数据库的大型软件。
- SQL：Structured Query Language，操作关系型数据库的编程语言，定义了一套 操作关系型数据库的统一标准
- 关系型数据库：建立在关系模型的基础上，由多张二维表组成的数据库

##### 企业开发项目的具体流程

![image-20240222235207042](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240222235207042.png)

#### SQL语句

##### 通用语法

- SQL语句可以 单行或多行 书写，以分号为结尾
- SQL语句可以使用空格/缩进来增强语句的可读性
- MySQL数据库的SQL语句不区分大小写
- --单行注释 /*多行注释*/

##### 分类

![image-20240222234543218](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240222234543218.png)

##### DDL数据定义语言

数据定义语言，用来定义数据库对象（数据库、表）

###### 数据库

```mysql
-- 查询
	-- 查询所有数据库 show databases;
	-- 查询当前数据库 select database();
-- 创建 [if not exists]为可选项
create database[if not exists] 数据库名;
-- 切换/使用数据库 use 数据库名;
-- 删除数据库 drop database [if exists] 数据库名；

--  databae可以替换为schema
```

###### 表创建

```mysql
-- 创建
create table 表名(
    字段1-n 字段类型 [约束] [comment 字段1-n注释],
)[comment 表注释]

```

约束：用来限制存储在表中的数据

![image-20240223180559748](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240223180559748.png)

###### 数据类型

数值 

![image-20240223211237614](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240223211237614.png)

字符串 

![image-20240223211300065](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240223211300065.png)

日期时间

![image-20240223211338009](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240223211338009.png)

###### 表查询

![image-20240223211434989](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240223211434989.png)

###### 表修改

![image-20240223211719629](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240223211719629.png)

###### 表删除

![image-20240223212200973](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240223212200973.png)

##### DML数据操作语言

对数据表中的数据记录进行增删改操作

###### 添加insert

![image-20240223212808160](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240223212808160.png)

###### 修改update

![image-20240223213510405](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240223213510405.png)

###### 删除delete

![image-20240223214225859](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240223214225859.png)

##### DQL数据查询语言

Data Query Language，用来查询数据库表中的记录

![image-20240223215334907](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240223215334907.png)

###### 基本查询

[^问题1]: 数据插入时报错 为编码问题 准备测试数据之前先执行`alter table db01.tb_emp convert to character set utf8;`语句

![image-20240223221334453](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240223221334453.png)

###### 条件查询

![image-20240224155410346](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240224155410346.png)

![image-20240224155427428](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240224155427428.png)

###### 聚合函数

介绍：将一列数据作为一个整体，进行纵向计算

![image-20240224160806252](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240224160806252.png)

![image-20240224160826749](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240224160826749.png)

###### 分组查询

group by

![image-20240224161424668](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240224161424668.png)

![image-20240224161803803](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240224161803803.png)

###### 排序查询

order by

![image-20240224161906583](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240224161906583.png)

![image-20240224162004010](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240224162004010.png)

###### 分页查询

limit

![image-20240224162343523](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240224162343523.png)

![image-20240224162636170](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240224162636170.png)

#### 多表

##### 多表设计

###### 一对多

父（主）表    子表 两表之间建立关联-->添加外键

![image-20240224171601838](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240224171601838.png)

![image-20240224171942706](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240224171942706.png)

将物理外键转化为逻辑外键

![image-20240224172021703](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240224172021703.png)

###### 一对一

###### 多对多

中间表

#### 多表查询

从多张表中查询数据

##### 笛卡尔积

![image-20240224190130911](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240224190130911.png)

##### 连接查询

###### 内连接

查询两表的交集

![image-20240224190504679](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240224190504679.png)

###### 外连接

![image-20240224212145718](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240224212145718.png)

###### 子查询

![image-20240224212649728](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240224212649728.png)

![image-20240224212717302](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240224212717302.png)

#### 事务

##### 介绍

概念：一组操作的集合，是一个不可分割的工作单位

###### 事务控制

- 开启事务：start transaction; / begin;
- 提交事务：commit;
- 回滚事务：rollback;

##### 四大特性ACID

- 原子性：事务是不可分割的最小单元，要么全部成功，要么全部失败
- 一致性：事务完成时，必须使所有的数据都保持一致状态
- 隔离性：数据库系统提供的隔离机制，保证事务子不受外部并发操作影响的独立环境下运行
- 持久性：事务一旦提交或回滚，它对数据库中的数据的改变就是永久的

#### 优化--索引

##### 介绍

概念：是帮助数据库高效获取数据的数据结构

![image-20240224222325753](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240224222325753.png)

##### 结构

默认为B+Tree结构组织的索引

###### B+Tree多路平衡搜索树

![image-20240224222908979](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240224222908979.png)

##### 语法

![image-20240224223042851](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240224223042851.png)

### SpringBoot MyBatis

![image-20240224223742259](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240224223742259.png)

MyBatis是一款优秀的 持久层（dao数据访问层） 框架，用于简化JDBC的开发

#### 入门

##### JDBC

使用Java语言操作关系型数据的一种API（使用文档）(规范)

##### 数据库连接池

是一个容器，负责分配、管理数据库

##### lombok工具

一个实用的Java类库，通过注解的形式自动生成构造器等方法。。。

![image-20240225212113979](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240225212113979.png)

#### 基础操作

##### 删除delete

[^问题2]: 运行testDelete()方法时idea报错org.springframework.boot不存在，此时通过设置 将IDE构建/运行操作委托给Maven

```java
//根据ID删除员工信息
    @Delete("delete from emp where id = #{id}")
    public void delete(Integer id);
```

###### 预编译SQL

![image-20240225223117665](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240225223117665.png)

###### SQL注入

通过操作输入的数据来修改事先定义好的SQL语句，以达到执行代码对服务器进行攻击的方法

###### 参数占位符

![image-20240225224131950](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240225224131950.png)

##### 新增Insert

```java
//新增员工信息
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time)" +
            "    values (#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime}")
    public void insert(Emp emp);
```

###### 主键返回

数据添加成功后，需要获取插入数据的主键

##### 更新（修改）update

```java
//修改员工信息
    @Update("update emp set username=#{username},name=#{name},gender=#{gender},image=#{image}," +
            " job=#{job},entrydate=#{entrydate},dept_id=#{updateId},update_time=#{updateTime} where id=#{id};")
    public void update(Emp emp);
```

##### 查询

```java
#开启mybatis的自动驼峰命名开关
mybatis.configuration.map-underscore-to-camel-case=true
    
//根据ID查找员工信息
    @Select("select * from emp where id=#{id};")
    public Emp getById(Integer id);
```

###### 条件查询

```java
//根据条件查询员工信息
    @Select("select * from emp where name like '%${name}%' and gender = #{gender} and entrydate between #{begin} and #{end} order by update_time desc;")
    public List<Emp> list(String name, Short gender, LocalDate begin,LocalDate end);
}
```

使用$符号存在一定问题，为此进行改进

```java
'%${name}%'
↓
concat('%',#{name},'%')
```

##### XML映射文件

![image-20240226165656996](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240226165656996.png)

```xml
<mapper namespace="com.itheima.mapper.EmpMapper">
    <select id="list" resultType="com.itheima.pojo.Emp">
        select * from emp where name like concat('%',#{name},'%') and gender = #{gender}
                            and entrydate between #{begin} and #{end} order
                                by update_time desc;
    </select>
</mapper>
```

#### 动态SQL

随着用户的输入或外部条件的变化而变化的SQL语句

##### if标签

判断条件是否成立 如果为True 则拼接SQL

```xml
<select id="list" resultType="com.itheima.pojo.Emp">
        select *
        from emp
        <where>
            <if test="name !=null">
                name like concat('%', #{name}, '%')
            </if>
            <if test="gender!=null">
                and gender = #{gender}
            </if>
            <if test="begin!=null and end!=null">
                and entrydate between #{begin} and #{end}
            </if>
        </where>
        order by update_time desc;
    </select>
```

##### set标签

去逗号

##### foreach标签

```xml
delete from emp where id in
            <foreach collection="ids" index="id" separator="," open="(" close=")">
                #{id}
            </foreach>
```

```java
//批量删除员工信息
    public void deleteByIds(List<Integer> id);
```

##### sql include标签

![image-20240226192456608](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240226192456608.png)

![image-20240226192548486](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240226192548486.png)

## 项目实践

### 概述

#### 环境搭建

- 数据库表
- 引入依赖
- 引入配置信息，准备对应的实体类
- 准备基础结构

![image-20240226193148709](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240226193148709.png)

![image-20240222222446148](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240222222446148.png)

![image-20240226210707558](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240226210707558.png)





> Controller包：控制层代码 @RestController注解
>
> Service包：存放业务层的接口以及实现类 @Service
>
> ​	impl包：根据Service包中的接口 对接口函数进行实现
>
> mapper包：mapper接口 @Mapper mapper层直接与数据库打交道（执行SQL语句），接口提供给service层。也就是Dao层
>
> pojo包：实体类

> Dept
>
> Emp 所有包都需要分为这两部分 并且交给IOC容器管理

##### 开发规范

rest：表述性动态转换，是一种软件架构风格

### 部门管理

#### 查询

![image-20240226210209855](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240226210209855.png)

##### 实现的逻辑

1.Controller类接收请求

```java
/*查询部门信息的方法
    * */
    //注入部门管理的Service接口 以供Controller方法调用
    @Autowired
    private DeptService deptService;

    //添加注解 指定当前接口的访问路径
    @GetMapping("/depts")
    public Result list(){
        //记录日志
        log.info("查询全部部门数据");
        //调用Service的list方法 查询所有部门的信息
        List<Dept> deptList = deptService.list();
        //返回结果
        return Result.success(deptList);
    }
```

2.在Service接口中声明对应方法

```java
//声明对应的list方法 -- 查询全部部门数据
    List<Dept> list();
```

3.在实现类中实现list方法

```java
//Service类不可以对数据库进行直接的操作，因此引入Mapper的依赖
    @Autowired
    private DeptMapper deptMapper;

    public List<Dept> list() {
        //调用Mapper中的方法 查询全部部门信息
        return deptMapper.list();
    }
```

4.在mapper接口中实现对应方法

```java
//实现 查询所有部门的方法--->通过对数据库的直接操作
    @Select("select * from dept")
    List<Dept> list();
```

[^问题3]: send后发现500报错，检查之后发现数据库名字写错了！！！一定要注意拼写 善用复制粘贴
[^问题4]: 修改部门时出现的问题 postman请求一直报500 但是在NGIX页面运行时可以流畅运行 查看console发现出现Class SQLIntegrityConstraintViolationException报错 此类报错的原因是这表示违反了完整性约束（外键，主键或唯一键）。只要将post中的name属性改为表中不存在的name字段值 就可以请求 只是请求参数的问题！！
[^问题5]: POM文件引入依赖爆红-->直接刷新maven即可



#### 前后端联调

##### 开发流程

![image-20240226233730495](C:\Users\86188\AppData\Roaming\Typora\typora-user-images\image-20240226233730495.png)

#### 

员工管理

文件上传

修改员工

配置文件

登录

异常

事务管理

AOP

Bean的管理

SpringBoot原理

Maven高级

```java
package com.itheima;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.common.auth.*;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import java.io.FileInputStream;
import java.io.InputStream;

public class Demo {

    public static void main(String[] args) throws Exception {
        // Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
        String endpoint = "https:oss-cn-beijing.aliyuncs.com";
        // 从环境变量中获取访问凭证。运行本代码示例之前，请确保已设置环境变量OSS_ACCESS_KEY_ID和OSS_ACCESS_KEY_SECRET。
        EnvironmentVariableCredentialsProvider credentialsProvider = CredentialsProviderFactory.newEnvironmentVariableCredentialsProvider();
        // 填写Bucket名称，例如examplebucket。
        String bucketName = "web-tlias-xxl";
        String accessKeyId = "LTAI5tKKNwuJYe8ji7D6RM6Y";
        String accessKeySecret = "NCPsBqqXxr9tW6aaJbdvnffKBY9oVv";
        // 填写Object完整路径，完整路径中不能包含Bucket名称，例如exampledir/exampleobject.txt。
        String objectName = "1.jpg";
        // 填写本地文件的完整路径，例如D:\\localpath\\examplefile.txt。
        // 如果未指定本地路径，则默认从示例程序所属项目对应本地路径中上传文件流。
        String filePath= "C:\\develop\\develop\\1.jpg";

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId,accessKeySecret);

        try {
            InputStream inputStream = new FileInputStream(filePath);
            // 创建PutObjectRequest对象。
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, objectName, inputStream);
            // 创建PutObject请求。
            PutObjectResult result = ossClient.putObject(putObjectRequest);
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    }
} 
```
