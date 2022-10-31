### 今日课程目录

* 2022-03-27 ---学习到08(掌握img元素相对路径和图片格式)
* 2022-03-28---学习到34--13(理解)iframes的使用和禁止.
* 已经学完.

#### 1.HTML结构分析

- [ ] 文档声明

- [x] html元素

  * html是根元素,表示的是所有元素(顶级元素)

  * 所有元素为此元素后代
  * w3c标准建议html有一个lang属性
  * lang ="en" 表示英文语言,lang="zh-CN"表示中文语言
  * 可以理解为整个页面的配置<meta>
  * 

  

  - [x] head元素

    * 有maeta,还有title元素 <meta  charset="utf-8">

  - [x] body元素

    * 页面看到的都是一些body元素展现出来的

    * ![body90207.jpg](https://s2.loli.net/2022/03/27/etnAHXwcs7rdYiz.jpg)

    *  常用元素  p元素,段落 ,h元素,标题,a,元素,img元素,照片,iframe元素

    * div元素,span元素

      案例元素

    * ![dd207.jpg](https://s2.loli.net/2022/03/27/DNE3ybngjSTkvst.jpg)

    * 

#### 2.h1-h6 p元素

* H元素是h1到h6的统称h1--到h6区别都是因为不同的CSS样式导致的,基本上P元素是没什么区别的
* p元素,段落分段的意思

#### 3.img,,a, iframe元素

* 我们应该如何告诉浏览器显示一张图片使用img

* ```
  <img    地址 ="具体地址">  <img src=""  alt="" >
  ```

* img是一个可替换元素 ,alt显示对应的文本,屏幕阅读器会将这些描述读给需要使用阅读器的使用者

* ```
   图片
  1.存放在服务器 <img  src="http://xxxx.xxx.jpg">
  2.存放在本地地址(绝对路径,相对路径)<img  src="C:/xxxx/xxxx/ss.img">
  <img  src="../image/eeee/xxxx/ss.img">
  
  a元素的额target 
-blank在当前页面打开
   _parent:在父窗口终打开url
   _top在顶层中打开url
   
   ```
   
* 

* iframe元素

   ```
   iframe元素,可以在当前网页内嵌其他网页
   
   <iframe src="目标地址"  frmaeborder="0----s"></iframe>
   frmaeborder="0----显示边框
   frmaeborder="0----不显示边框
   
   ```

* 在nginx终配置,既可以完成完成禁止iframe使用

#### 4.div ,span,a元素

* a元素,在网页终经常要跳转到另一外一个链接,这个时候我们使用a元素<a> 称之为超链接用来打开url

* ![a元素](https://wx1.xoimg.com/i/2022/03/28/10gioj5.jpg)

* 锚点元素

* ![ssss](https://wx1.xoimg.com/i/2022/03/28/10h14z4.jpg)

* a元素和img联合使用

  ##### div和span元素

* div元素: divsion,意味分开\分配的意思

* span元素,:跨 域,涵盖的意思

* div元素,和span元素的来源,,,,由于之前的网页样式不好看,产生了div和span元素

* div多个div元素包裹在不同的行显示

* span多个span元 素包裹内容在同一行显示

#### 5.不常用元素

*  Strong元素
* i元素
* br元素



#### 6.HTML全局属性 

* 查看MDN文档(https://developer.mozilla.org/zh-CN/docs/Learn/CSS/First_steps)
* 需要掌握的全局属性
* id:定义唯一标识符,标识在整个文档中是唯一的
* class:一个以空格分隔的元素类名,它允许CSS和javaScript通过类选择器或者DOM方法来访问特定的元素
* style:给元素内嵌样式
* title:包含语气所属元素相关信息的文本,这些信息都可以作为提示呈现给用户,但不是必须的
* 

##### 加餐,常见的字符实体

![常见字符实体](https://s3.xoimg.com/i/2022/03/30/xknix0.jpg)



url协议:









