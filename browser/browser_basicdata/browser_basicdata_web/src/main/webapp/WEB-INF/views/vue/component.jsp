<%--
  Created by IntelliJ IDEA.
  User: yifan
  Date: 2017/5/18
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>组件</title>
    <script type="text/javascript" src="../scripts/common/vue/vue_2_3_3.js"></script>
</head>
<body>
    <div id="example">
        <my-component></my-component>
    </div>


    <div id="example-2">
        <simple-counter></simple-counter>
        <simple-counter></simple-counter>
        <simple-counter></simple-counter>
    </div>

    <script type="text/javascript">
        Vue.component('my-component',{
            template:'<div>自定义组件！</div>'
        });

        new Vue({
            el:'#example'
        });


        Vue.component('simple-counter',{
            template:'<button v-on:click="counter += 1"> {{ counter }} </button>',
            data:function(){
                return {
                    counter:0
                }
            }
        });

        new Vue({
            el:'#example-2'
        });


        //使用 v-on 绑定自定义事件
















    </script>



</body>
</html>
