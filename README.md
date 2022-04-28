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

1. 用户路由

<details>

1. 登录

```http request
POST http://127.0.0.1:8080/api/auth/login
Content-Type: application/json

{
  "user": "administration",
  "password": "Test987456"
}
```

2. 注册

```http request
POST http://127.0.0.1:8080/api/auth/login
Content-Type: application/json

{
  "user":"administration",
  "password":"Test123321",
  "clazz":"2132Z12345",
  "username":"法外娇妻李四"
}
```

3. 更新用户信息

```http request
POST http://127.0.0.1:8080/api/update/user
Authorization: Bearer {{auth_token}}
Content-Type: application/json

{
  "user": "administration",
  "username": "李四200",
  "clazz": "2132Z000000",
  "password": "Test987456"
}
```

4. 注销用户

```http request
POST http://127.0.0.1:8080/api/auth/unregister
Authorization: Bearer {{auth_token}}
Content-Type: application/json

{
  "user": "administration",
  "password": "Test987456"
}
```

</details>

2. 相册路由

<details>

1. 新建相册

```http request
POST http://127.0.0.1:8080/api/photo/create
Authorization: Bearer {{auth_token}}
Content-Type: application/json

{
  "user": "administration",
  "photo": "Test2"
}
```

2. 删除相册

```http request
POST http://127.0.0.1:8080/api/photo/delete
Authorization: Bearer {{auth_token}}
Content-Type: application/json

{
  "user": "administration",
  "uid": "0b95b8914db047a586a6375c5dcccbc2"
}
```

3. 查询相册

```http request
POST http://127.0.0.1:8080/api/photo/query
Authorization: Bearer {{auth_token}}
Content-Type: application/json

{
  "user": "administration"
}
```

4. 更新相册

```http request
POST http://127.0.0.1:8080/api/photo/update
Authorization: Bearer {{auth_token}}
Content-Type: application/json

{
  "user": "administration",
  "uid": "c84602db-ff9f-464c-aeb9-b7bfa32679cc",
  "photo": "1dadadx"
}
```

5. 相册内照片查询

```http request
POST http://127.0.0.1:8080/api/photo/image/query
Authorization: Bearer {{auth_token}}
Content-Type: application/json

{
  "user":"administration",
  "photo":"c84602db-ff9f-464c-aeb9-b7bfa32679cc"
}

```

6. 相册内照片增加

```http request
POST http://127.0.0.1:8080/api/photo/image/insert
Authorization: Bearer {{auth_token}}
Content-Type: application/json

{
  "user":"administration",
  "photo":"c84602db-ff9f-464c-aeb9-b7bfa32679cc",
  "image": "test.png",
  "type" : 1
}
```

7. 相册内照片移除

```http request
POST http://127.0.0.1:8080/api/photo/image/delete
Authorization: Bearer {{auth_token}}
Content-Type: application/json

{
  "user":"administration",
  "photo":"c84602db-ff9f-464c-aeb9-b7bfa32679cc",
  "image": "test.png",
  "type" : 0
}
```

</details>

