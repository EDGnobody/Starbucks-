import $http from './request';



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