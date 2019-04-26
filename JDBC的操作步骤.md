# JDBC的操作步骤

## 0.找到对应的jar包，并将jar包复制到项目中

## 1.加载驱动

```java
Class.forName("com.mysql.jdbc.Driver");//双引号中的类名，成为全限定类名
```

## 2.创建一个Connection的连接对象

```java
Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost/demo?useSSL=true&characterEncoding=UTF8",
                    "root",//root是mysql数据库的账号
                    "root");//这个root本机mysql数据库的密码
//getConnection(url,username,password)
//url==>1.jdbc:mysql://localhost/demo?useSSL=true&characterEncoding=UTF8 是针对mysql5.5以上版本的
```

## 3.创建一个Statement的对象，用来执行各类的SQL语句

```java
Statement stmt=con.createStatement();
```

## 4.编写SQL语句（各种SQL语句)

```sql
String sql="CREATE TABLE users(uname VARCHAR(50) NOT NULL,upwd VARCHAR(30) NOT NULL)";//里面的sql语句，是不含结尾的分号。！！！
```

## 5.执行SQL语句

```java
stmt.execute(sql);
```

## 6.关闭数据库连接

```java
con.close();
```

注意事项:

Statement的执行效率比较低，不建议使用！！

推荐PreparedStatement，替换Statement



## 7.PreparedStatement的使用

#### 7.1.首先定义一个PreparedStatement对象

```java
String sql="INSERT INTO users VALUES (?,?)";
sPreparedStatement ps=con.prepareStatement(sql);
```

7.2.绑定数据

```java
ps.setString(1,"jack"); //第一个参数是问号的索引值，从1开始
ps.setString(2,"321"); //第二个参数是对应问号绑定的数据
```

7.3.执行

```java
ps.execute();
```







