# RocketMQ Action #

## 简介 ##
```RocketMQ 实战``` ，主要演示如何通过客户端调用队列并消费队列，实现分布式事务最终一致性操作。

## 数据库 ##
- 表
```sql
CREATE TABLE company(
  c_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  c_name VARCHAR(255) NOT NULL ,
  c_des VARCHAR(255) NOT NULL ,
  c_code VARCHAR(255) NOT NULL
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

CREATE TABLE user(
  uid VARCHAR(32) NOT NULL PRIMARY KEY,
  uName VARCHAR(255) NOT NULL ,
  uAmount int,
  uCode VARCHAR(32) NOT NULL
) ENGINE=INNODB CHARSET=utf8;

CREATE TABLE dept(
  dId VARCHAR(32) NOT NULL PRIMARY KEY,
  dDes VARCHAR(255) NOT NULL
) ENGINE=INNODB CHARSET=utf8;
```

- 数据库表介绍

|表|介绍|
|:--|:--|
|company（公司）|用于非事务消息的演示|
|user（用户）|用于事务消息演示|
|dept（部门）|用于事务消息演示|

