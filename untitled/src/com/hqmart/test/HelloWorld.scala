package com.hqmart.test

import scala.io.Source

/**
  * Created by dingwei on 2016/12/27.
  */
object HelloWorld {
  def main(args: Array[String]): Unit = {
    println("aaaaa")

    //声明常量
    val a = 12131
    println(a)

    //声明变量
    var b = 8989
    b=88888
    println(b)

    //if-else boolen
    if(a>b){
      println("a:"+a)
    }else{
      println("b:"+b)
    }

    //循环
    var c = 4
    while (c>0){
      println(c)
      c=c-1
    }

    var d = 5
    do {
      println(d)
      d=d-1
    } while( d>0 )

    for( x <- 1 to 10 ){
      println("aaa")
    }

    //调用方法
    println(add(111,122))

    //匿名函数
    val multiplier = (i:Int) => i * 10
    println("multiplier:"+multiplier(1))

    //闭包
    val factor = 10
    val multiplier1 = (i:Int) => i * factor
    println("multiplier1:"+multiplier1(1))

    //字符串(在 Scala 中，String 是一个不可变的对象，所以该对象不可被修改。
    // 这就意味着你如果修改字符串就会产生一个新的字符串对象。)
    val str = "hello world"
    println(str)
    println(str.length)

    //字符串连接
    val str1 = "java"
    val str2 = str.concat(str1)
    println(str2)

    //定义数组
    val z1 = Array("Runoob", "Baidu", "Google")

    //声明数组
    val arr = new Array[String](3)
    //数组赋值
    arr(0) = "aaaaa"
    arr(1) = "bbbbb"
    arr(4/2) = "cccc"

    //遍历数组
    for (x <- z1){
      println("遍历数组："+x)
    }

    for (x <- arr){
      println("遍历数组："+x)
    }

    //定义List
    val list =List(1,2,3)
    for(x <- list){
      println("list:"+x)
    }

    //定义set
    val set = Set(4,5,6)
    for (x <- set){
      println("Set:"+x)
    }

    //定义不同类型的元组
    val xl = (10,"yy",2.3)
    println(xl._1)
    println(xl._2)
    println(xl._3)


    //定义Map
    val map = Map("one"->1,"two"->2,"three"->3)

    println(map.keys)
    println(map.values)
    println(map.get("one"))

    //迭代器
    val it = Iterator("Baidu", "Google", "Runoob", "Taobao");
    while (it.hasNext){
      println("遍历迭代器："+it.next())
    }

    //迭代器中找出最大和最小元素
    val ita = Iterator(20,40,2,50,69, 90)
    val itb = Iterator(20,40,2,50,69, 90)
    println("最大元素是：" + ita.max )
    println("最小元素是：" + itb.min )
    //获取迭代器的长度
    println("ita.size 的值: " + ita.size )
    println("itb.length 的值: " + itb.length )

    //调用类
    val point = new Point(10,10)
    point.move(10,20)

    //继承
    val loc = new Location(10, 20, 15)
    loc.move(10, 10, 5)

    //模式匹配
    println(matchTest(1))
    println(matchTest(2))
    println(matchTest(3))

    println("#########################################")
    //不同类型模式匹配
    println(matchTest1("two"))
    println(matchTest1("test"))
    println(matchTest1(1))
    println(matchTest1(6))
    println(matchTest1("dfdsfd"))

    println("#########################################")

    //使用样例类
    val alice = new Person("Alice", 25)
    val bob = new Person("Bob", 32)
    val charlie = new Person("Charlie", 32)
    val lili = new Person("lili", 20)

    for (person <- List(alice, bob, charlie,lili)) {
      person match {
        case Person("Alice", 25) => println("Hi Alice!")
        case Person("Bob", 32) => println("Hi Bob!")
          //如果找不到匹配的数据打印一下语句
       // case Person(name, age) => println("Age: " + age + " year, name: " + name + "?")
        case Person(name, age) => println("NOT MATCH!!!!!!")
      }
    }
    println("#########################################")
    //正则表达式

    val pattern = "Scala".r
    val pattern1 = "Scalable".r()
    val strq = "Scala is Scalable and cool Scala"

    val it2 = pattern findAllIn strq
    while (it2.hasNext){
      println("遍历迭代器："+it2.next())
    }
    println(pattern findFirstIn strq)
    println(pattern1 findFirstIn strq)


    //Scala 文件 I/O
    /*val writer = new PrintWriter("test.txt")
    writer.write("菜鸟教程")
    writer.write("我是一只小小鸟")
    writer.close()*/

    //从屏幕上读取用户输入
    //print("请输入你的名字：")
    //val line = Console.readLine()
   // println("您输入的名字是："+line)

    //从文件上读取内容
    println("文件内容为：")
    Source.fromFile("test.txt" ).foreach{
      print
    }

    println()
    println("#########################################")

    //Scala 提取器(Extractor)
    println ("Apply 方法 : " + apply("Zara", "gmail.com"));
    println ("Unapply 方法 : " + unapply("Zara@gmail.com"));
    println ("Unapply 方法 : " + unapply("Zara Ali"));

    //提取器使用模式匹配

    //占位符使用
    val f=(_:Int) +( _:Int)
    println("占位符使用"+f(1,9))
    println(adder(1,2))
    println(5&4)
    val fnaldata = Array(1,3,6,8,9,10,13,12,16)
    println(Fibonacci(fnaldata))
  }
  def Fibonacci(y : Array[Int]): Int={
    var a = 0
    for(x <- 1 to y.length){
      //a => a
    }
    return a
  }
  def adder(m:Int,n:Int)=m&n+3
  def min(m:Int,n:Int):Int={
    var a=m+1
    if(m>n)a=n+1
    return a
  }



  // 注入方法 (可选)
  def apply(user: String, domain: String) = {
    user +"@"+ domain
  }

  // 提取方法（必选）
  def unapply(str: String): Option[(String, String)] = {
    val parts = str split "@"
    if (parts.length == 2){
      Some(parts(0), parts(1))
    }else{
      None
    }
  }

  // 样例类
  case class Person(name: String, age: Int)

  def matchTest1(x: Any): Any = x match {
    case 1 => "one"
    case "two" => 2
    case y: Int => "scala.Int"
    case _ => "many"
  }

  def matchTest(x: Int): String = x match {
    case 1 => "one"
    case 2 => "two"
    case _ => "many"
  }

  def add(x:Int,y:Int): Int ={
    var sum:Int = 0
    sum = x + y

    return sum
  }


}
