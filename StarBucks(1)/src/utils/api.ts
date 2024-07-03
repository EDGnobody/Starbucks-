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
// 获取咖啡列表
export const getCoffeeList =()=>
    $http(
        {
            url:"/coffee/get_coffee_list",
            method:"get",
            headers:{
                "Authorization":localStorage.getItem('token')
            }
        })
// 创建新的咖啡商品
export const createCoffee =(params:any)=>
            $http(
                {
                    url:"/coffee/create",
                    method:"post",
                    headers:{
                        "Authorization":localStorage.getItem('token')
                    },
                    params: {
                        name: params.name,
                        price:params.price,
                        category: params.category
                      }
                })
        

// 店铺类
// 获取店面信息列表
export const getStoreList =()=>
    $http(
        {
            url:"/store/get_store_list",
            method:"get",
            headers:{
                "Authorization":localStorage.getItem('token')
            }
        })
// 添加店面信息
export const createStore =(params:any)=>
    $http(
        {
            url:"/store/add",
            method:"post",
            headers:{
                "Authorization":localStorage.getItem('token')
            },
            params: {
                    name: params.name,
                    location:params.location,
                    phone: params.phone,
                    latitude:params.latitude,
                    longitude:params.longitude
              }
        })
// 订单信息
// 获取历史订单
export const getOrderList =()=>
    $http(
        {
            url:"/order/get_by_user_id",
            method:"get",
            headers:{
                "Authorization":localStorage.getItem('token')
            }
        })