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
    <%@include file="common.jsp"%>
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

    <div id="example-4">
        <input v-model="parentMsg">
        <br>
        <child v-bind:message="parentMsg"></child>
    </div>

    <div id="counter-event-example">
        <p>{{ total }}</p>
        <button-counter v-on:increment="incrementTotal"></button-counter>
        <button-counter v-on:increment="incrementTotal"></button-counter>
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


        Vue.component('child',{
            //声明 props
            props:['message'],
            template:'<span> {{ message }} </span>'
        });

        new Vue({
            el:'#example-4',
            data:{
                parentMsg:''
            }
        });



        Vue.component('example',{
            props:{
                propA:Number,
                propB:[String,Number],
                propC:{
                    type:String,
                    required:true
                },
                propD:{
                    type:Number,
                    default:100
                },
                propE:{
                    type:Object,
                    default:function(){
                        return {message:'Hello'};
                    }
                },
                propF:{
                    validator:function(value){
                        return value > 10;
                    }
                }
            }
        });


        Vue.component('button-counter',{
            template:'<button v-on:click="increment">{{ counter }}</button>',
            data:function(){
                return {
                    counter:0
                }
            },
            methods:{
                increment:function(){
                    this.counter += 1;
                    this.$emit('increment');
                }
            }
        });


        new Vue({
            el:'#counter-event-example',
            data:{
                total:0
            },
            methods:{
                incrementTotal:function(){
                    this.total += 1
                }
            }
        });


















    </script>



</body>
</html>
