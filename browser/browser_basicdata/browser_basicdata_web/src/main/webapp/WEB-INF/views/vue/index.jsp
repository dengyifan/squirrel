<%--
  Created by IntelliJ IDEA.
  User: yifan
  Date: 2017/5/15
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello Vue2</title>

    <script type="text/javascript" src="../scripts/common/vue/vue_2_3_3.js"></script>


</head>
<body>
    <div id="app">
        {{ message }}
    </div>


    <div id="app-2">
        <span v-bind:title="message">Hello</span>
    </div>

    <div id="app-3">
        <p v-if="seen">现在可以查看了</p>
    </div>

    <div id="app-4">
        <ol>
            <li v-for="todo in todos">
                {{ todo.text }}
            </li>
        </ol>
    </div>

    <div id="app-5">
        <p>{{ message }}</p>
        <button v-on:click="reverseMessage">逆转消息</button>
    </div>

    <div id="app-6">
        <p>{{ message }}</p>
        <input v-model="message"/>
    </div>

    <div id="app-7">
        <ol>
            <todo-item v-for="item in groceryList" v-bind:todo="item"></todo-item>
        </ol>
    </div>


    <script type="text/javascript">
        var app = new Vue({
            el:'#app',
            data:{
                message:'Hello Vue!'
            }
        });

        var app2 = new Vue({
            el:'#app-2',
            data:{
                message:'页面加载于　' + new Date()
            }
        });

        var app3 = new Vue({
            el:'#app-3',
            data:{
                seen:true
            }
        });

        var app4 = new Vue({
            el:'#app-4',
            data:{
                todos:[
                    {text:'JavaScript'},
                    {text:'Vue'},
                    {text:'Go'}
                ]
            }
        });


        var app5 = new Vue({
            el:'#app-5',
            data:{
                message:'Hello Vue.js'
            },
            methods:{
                reverseMessage:function(){
                    this.message = this.message.split('').reverse().join('');
                }
            }
        });

        var app6 = new Vue({
            el:'#app-6',
            data:{
                message:'Hello Vue!'
            }
        });

        //定义名为 todo-item 的新组件
        Vue.component('todo-item',{
            props:['todo'],
            template:'<li>{{ todo.text }}</li>'
        });

        var app7 = new Vue({
            el:'#app-7',
            data:{
                groceryList: [
                    { text: '蔬菜' },
                    { text: '奶酪' },
                    { text: '随便其他什么人吃的东西' }
                ]
            }
        });
    </script>

</body>
</html>
