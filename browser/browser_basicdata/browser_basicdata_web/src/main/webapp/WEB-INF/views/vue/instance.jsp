<%--
  Created by IntelliJ IDEA.
  User: yifan
  Date: 17-5-15
  Time: 下午9:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Vue实例</title>
    <%@include file="common.jsp"%>

</head>
<body>

    <div id="app-1">
        <span>Message: {{ msg }}</span>
        <br/>

        <span v-once> This will never change: {{ msg }}</span>

        <br/>

        <div v-html="rawHtml"></div>

        <div v-bind:id="dynamicId">
            <button v-bind:disabled="someDynamicCondition"
                    v-on:onclick="doSomething">Button</button>
        </div>

        <div v-bind:id="'list-' + id">
            <a v-bind:href="url">OnlyYou</a>
        </div>
    </div>

    <div id="example">
        <p>Original message: "{{ message }}"</p>
        <p>Computed reversed message: "{{ reversedMessage }}"</p>
    </div>

    <div id="demo">{{ fullName }}</div>


    <div id="conditionRender">
        <h3 v-if="ok">Yes</h3>
        <h3 v-else="">No</h3>

        <template v-if="ok">
            <div>
                <h3>Title</h3>
                <p>Paragraph 1</p>
                <p>Paragraph 2</p>
            </div>
        </template>

        <div v-if="Math.random() > 0.5">
            Now you see me
        </div>
        <div v-else>
            Now you don't
        </div>


        <div v-if="type === 'A' ">
            A
        </div>
        <div v-else-if="type === 'B' ">
            B
        </div>
        <div v-else-if="type === 'C' ">
           C
        </div>
        <div v-else>
            Not A/B/C
        </div>


        <template v-if="loginType === 'username' ">
            <label>Username</label>
            <input placeholder="Enter your username" key="username-input"/>
        </template>
        <template v-else>
            <label>Email</label>
            <input placeholder="Enter your address" key="email-input"/>
        </template>
    </div>

    <script type="text/javascript">
        var data = {a:1};
        var vm = new Vue({
            data:data,
            created:function(){
                // this 指向 vm 实例
                console.log('a is: ' + this.a);
            }
        });

        //true
        console.log(vm.a === data.a);

        //设置属性也会影响到原始数据
        vm.a = 2;
        console.log(data.a);//2

        data.a = 3;
        console.log(vm.a);  //3


        var app1 = new Vue({
            el:'#app-1',
            data:{
                msg:'Vue.js',
                rawHtml:'<h3>Hello Vue.js</h3>',
                dynamicId:'testBindAttr',
                someDynamicCondition:false,
                id:'onlyYou',
                url:'http://www.baidu.com'
            },
            methods:{
                doSomething:function(){
                    alert('Hello Vue.js');
                }
            }
        });

        var exampleApp = new Vue({
            el:'#example',
            data:{
                message:'Hello'
            },
            computed:{
                reversedMessage:function(){
                    return this.message.split('').reverse().join('');
                }
            }
        });

        /*
         * 使用 watch 函数来观察属性的变化
        var demoApp = new Vue({
            el:'#demo',
            data:{
                firstName:'Foo',
                lastName:'Bar',
                fullName:'Foo Bar'
            },
            watch:{
                firstName:function(val){
                    this.fullName = val + ' ' + this.lastName;
                },
                lastName:function(val){
                    this.fullName = this.firstName + ' ' + val;
                }
            }
        });
        */

        //使用计算属性来实现 watch 的功能
        var demoApp = new Vue({
            el:'#demo',
            data:{
                firstName:'Foo',
                lastName:'Bar',
                fullName:'Foo Bar'
            },
            computed:{
                fullName:{
                    get:function(){ //getter
                        return this.firstName + ' ' + this.lastName;
                    },
                    set:function(newValue){ //setter
                        var names = newValue.split(' ');
                        this.firstName = names[0];
                        this.lastName = names[names.length - 1]
                    }
                }
            }
        });

        var conditionRenderApp = new Vue({
            el:'#conditionRender',
            data:{
                ok:true,
                type:'D',
                loginType:'username'
            }
        });

        //TODO : Class 与 Style 绑定
    </script>
</body>
</html>
