# Alumni System

> This is an Alumni System project.
>
> Write using the Ktor framework in Kotlin.

## FrontEnd

1. Vue 2.6.14
2. TDesign-vue 0.40.3

## RearEnd

1. Kotlin 1.6.20
2. Ktor 2.0.0
3. Mybatis-Plus 3.5.1

## Claim

1. 用户注册管理；用于新用户注册，用户身份注销，个人资料修改等。
2. 留言板管理；包括班级留言，个人留言等。
3. 通讯录管理；用于留下电话，QQ等联系方式。
4. 照片管理；包括上传照片，查看相册等。
5. 信息管理；包括查找同学，查看个人信息等。

## Route

1. 注册

```http request

POST https://localhost:8080/register
Content-Type: application/json

{
    "user": "test",
    "password": "test",
    "clazz": "12346Z12301"
}
```

2. 登录

```http request
POST https://localhost:8080/login
Content-Type: application/json

{
    "user": "test",
    "password": "test"
}
```

3. 个人信息

```http request
POST https://localhost:8080/user/{id}
Content-Type: application/json

{
    "token": "auth_token",
    "uuid": "",
    "user": "test",
}
```