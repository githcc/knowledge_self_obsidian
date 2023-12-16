---------------------------------------搜索引擎JSONP接口---------------------------------------------



提示：URL中的 #content# 为搜索的 关键字



1.谷歌（Google）



​            [ http://suggestqueries.google.com/complete/search?client=youtube&q=#content#&jsonp=window.google.ac.h](http://suggestqueries.google.com/complete/search?client=youtube&q=#content#&jsonp=window.google.ac.h)



callback：window.google.ac.h



```
window.google.ac.h(["关键字",[["关键字",0],["关键字 歌词",0],["关键字参数",0],["关键字 lyrics",0],["关键字过滤",0],["关键字排名",0],["关键字查询",0],["关键字提取算法",0],["关键字规划师可通过以下哪种方式帮助您制作新的搜索网络广告系列",0],["关键字优化",0]],{"k":1,"q":"uhaB8ZMjzJay-BACee_C0eVdUCA"}])
```





2.必应（Bing）



​            [ http://api.bing.com/qsonhs.aspx?type=cb&q=#content#&cb=window.bing.sug](http://api.bing.com/qsonhs.aspx?type=cb&q=#content#&cb=window.bing.sug)



 callback：window.bing.sug

**if(typeof window.bing.sug == 'function') window.bing.sug({"AS":{"Query":"关键字","FullResults":0}} /\* pageview_candidate \*/);**



 

3.百度（Baidu）



​             http://suggestion.baidu.com/su?wd=#content#&cb=window.baidu.sug



callback：window.baidu.sug

**window.baidu.sug({q:"关键字",p:false,s:["关键字搜索排名","关键字怎么优化","关键字查询工具","关键字推广","关键词优化","关键词排**

**名","关键字 英文","关键词挖掘","关键词查询","关键词搜索"]});**

 

4.好搜（So）



​           https://sug.so.360.cn/suggest?encodein=utf-8&encodeout=utf-8&format=json&word=#content#&callback=window.so.sug



callback：window.so.sug

**window.so.sug({"query":"关键字","result":[{"word":"关键字查询"},{"word":"关键字工具"},{"word":"关键字查询工具"},{"word":"关键字挖**

**掘"},{"word":"关键字搜索"},{"word":"关键字英文"},{"word":"关键字是什么"},{"word":"关键字广告"},{"word":"关键字分析"},{"word":"关键**

**字规划师"}],"version":"b","rec":""});**

 

5.搜狗（Sogou）



​               https://www.sogou.com/suggnew/ajajjson?type=web&key=#content#

 

callback：window.sogou.sug

**window.sogou.sug(["关键字",["关键字查询","关键字搜索","关键字优化","关键字规划师","关键字查询lol","关键字是什么意思","关键字**

**搜索工具","关键字广告图片","关键字排名查询","关键字生成器"],**

**["0;0;0;0","1;0;0;0","2;0;0;0","3;0;0;0","4;0;0;0","5;0;0;0","6;0;0;0","7;0;0;0","8;0;0;0","9;0;0;0"],["","","","","","","","","",""],**

**["0"],"","suglabId_1"],-1);**

 

 6.淘宝（Taobao）



​               [ https://suggest.taobao.com/sug?code=utf-8&q=#content#&callback=window.taobao.sug](https://suggest.taobao.com/sug?code=utf-8&q=#content#&callback=window.taobao.sug)



 callback：window.taobao.sug

**window.taobao.sug({"result":[["关键字推广","204"],["关键字seo","198"],["关键字 网站","182"],["关键字搜索","119"],["关键字软件","44"],**

**["关键字首页","50"],["关键字收录","35"],["关键字采集","16"],["关键字采集器","10"],["网站关键字","180"]]})**

 
---------------------------------------搜索建议使用方式---------------------------------------------



 以百度为例，API返回的是JSONP数据，JSONP是跨域访问的一种方式。由于服务器返回的JavaScript代码可以直接引用，通过回

调函数的方式就可以间接的获取服务器的数据。

 下面是一个回调搜索建议的例子，window.baidu.sug 返回的是一个json对象



```html
<body>



请输入：<input  id="content" type="text" />



 



</body>
<script type="text/javascript">



            window.onload = function() {



                



                //组装查询地址



                var sugurl = "http://suggestion.baidu.com/su?wd=#content#&cb=window.baidu.sug";



                var content = "新闻";



                sugurl = sugurl.replace("#content#", content);



 



                //定义回调函数



                window.baidu = {



                    sug: function(json) {



                        console.log(json)



                    }



                }



 



                //动态添加JS脚本



                var script = document.createElement("script");



                script.src = sugurl;



                document.getElementsByTagName("head")[0].appendChild(script);



 



            }



        </script>
```

控制台打印的结果：如果要将结果保存在一个字符串数组中，只需要 var arr = json.s 即可。

如图：

![img](README.assets/20170921220733450)


以上是转载内容，我们也可以用ajax来获取百度搜索框的数据，同样也使用jsonp的跨域方式
以百度为例：

首先，我们得先找到百度搜索框的接口，获取里面的数据，再传到我们自己的页面上，获取到的接口是

https://sp0.baidu.com/5a1Fazu8AA54nxGko9WTAnF6hhy/su



怎样获取百度的接口？打开百度首页，按下F12打开开发者工具，在百度搜索框中随便输入字段，在Network中抓取到接口；
抓取之后，就可以进行操作了，我用的是jQuery写的代码；  

```html
<body>  



请输入：<input list="languageList" id="value" type="text" />  



<datalist id="languageList" >  



</datalist>  



</body>
```



```javascript
<script>  



    /*设置监听事件，向输入框中输入内容，当键盘按键弹起的时候，将输入的内容作为参数传入到函数info中*/  



    $("#value").bind("keyup",function(event){  



        /*当键盘按下上下键的时候，不进行监听，否则会与keyup事件起冲突*/  



        if(event.keyCode == 38 || event.keyCode == 40){  



            return false;  



        }  



        var value = $("#value").val();  



            info(value);  



    })  



    /*将ajax封装到函数中*/  



    function info(value){  



        /*百度搜索框智能提示的接口*/  



        var url = "https://sp0.baidu.com/5a1Fazu8AA54nxGko9WTAnF6hhy/su";  



        /*需要传入的参数，cb是callback的缩写*/  



        var data = {  



            wd : value,  



            cb : "helloword"  



        }  



        /*因为涉及跨域，这里使用jsonp*/  



        $.ajax({  



            url : url,  



            data : data,  



            type : "GET",  



            dataType : "jsonp",  



            jsonpCallback : "helloword",  



            /*跨域成功的时候返回的数据*/  



            success : function (result){  



                /*返回成功之后可以在开发者工具里的Console打印看一下*/  



                console.log(result);  



                /*将获取的数据整理后返回到页面*/  



                var a = result.s;  



                var list = "";  



                for(var i in a ){  



                    var l = a[i];  



                    list += "<option>"+l+"</option>";  



                }  



                $("#languageList").html(list);  



            },  



            /*跨域失败的时候返回的数据*/  



            error : function(){  



                console.log("error");  



            }  



        })  



    }  



</script>
```

看一下效果图：

![img](README.assets/20170904105323742)