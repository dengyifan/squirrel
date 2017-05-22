<%--
  Created by IntelliJ IDEA.
  User: yifan
  Date: 2017/5/16
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
    <%@include file="common.jsp"%>

</head>
<body>
    <div>
        <ul id="example-1">
            <li v-for="item in items">
                {{ item.message }}
            </li>
        </ul>

        <br/>

        <ul id="example-2">
            <li v-for="(item, index) in items">
                {{ parentMessage }} - {{ index }} - {{ item.message }}
            </li>
        </ul>

        <br/>



        <div id="repeat-object" >

            <ul class="demo">
                <li v-for="(value,key,index) in object">
                    {{ index }} : {{ key }} : {{ value }}
                </li>
            </ul>

            <span v-for="n in 10">{{ n }}</span>
        </div>

    </div>


    <div id="todo-list-example">
        <input v-model="newTodoText"
               v-on:keyup.enter="addNewTodo"
               placeholder="Add a todo"/>

        <ul>
            <li is="todo-item"
                v-for="(todo, index) in todos"
                v-bind:title="todo"
                v-on:remove="todos.splice(index,1)">

            </li>
        </ul>
    </div>


    <script type="text/javascript">
        var example1 = new Vue({
            el:'#example-1',
            data:{
                items:[
                    {message:'Foo'},
                    {message:'Bar'}
                ]
            }
        });

        var example2 = new Vue({
            el:'#example-2',
            data:{
                parentMessage:'Parent',
                items:[
                    {message:'Foo'},
                    {message:'Bar'}
                ]
            }
        });


        new Vue({
            el:'#repeat-object',
            data:{
                object:{
                    FirstName: 'John',
                    LastName: 'Doe',
                    Age: 30
                }
            }
        });



        Vue.component('todo-item',{
            template: '\
                <li>\
                  {{ title }}\
                  <button v-on:click="$emit(\'remove\')">X</button>\
                </li>\
              ',
            props: ['title']
        });

        new Vue({
            el:'#todo-list-example',
            data:{
                newTodoText:'',
                todos:[
                    'Do the dishes',
                    'Take out the trash',
                    'Mow the lawn'
                ],
            },
            methods:{
                addNewTodo: function () {
                    this.todos.push(this.newTodoText)
                    this.newTodoText = ''
                }
            }
        });

        //数组更新检测



    </script>
</body>
</html>
