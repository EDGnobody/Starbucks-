import $http from './request';
// 用户类
// 用户登录
export const login =(params:any)=>
    $http(
        {
            url:"/user/login",
            method:"post",
            params: {
                username: params.username,
                password: params.password
              }
        })
// 用户注册
export const register =(params:any)=>
    $http(
        {
            url:"/user/register",
            method:"post",
            params: {
                username: params.username,
                password: params.password
              }
        })

        export const getUser =(params:any)=>
            $http(
                {
                    url:"/user/userinfo",
                    method:"post",
                  
                })


// 咖啡类
