velocity模板引擎学习
Velocity是一个基于java的模板引擎（template engine）。它允许任何人仅仅简单的使用模板语言（template language）来引用由java代码定义的对象

"#"用来标识Velocity的关键字，包括#set、#if 、#else、#end、#foreach、#end、#include、#parse、#macro等；

"$"用来标识Velocity的变量；如：$i、$msg、$TagUtil.options(...)等。

"{}"用来明确标识Velocity变量；比如在页面中，页面中有一个$someonename，此时，Velocity将把someonename作为变量名，若我们程序是想在someone这个变量的后面紧接着显示name字符，则上面的标签应该改成${someone}name。

"!"用来强制把不存在的变量显示为空白。如：当找不到username的时候，$username返回字符串"$username"，而$!username返回空字符串""