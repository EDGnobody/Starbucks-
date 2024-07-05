import axios from "axios";
import { ElMessage } from 'element-plus'
enum MSGS{
  "操作成功"=101,
  "用户名或密码输入不规范"=401,
  "用户名或密码输入错误"=303,
  "用户名未被注册"=302,
  "该用户名已被注册"=301,
  "邮箱不存在"=402
}

declare module 'axios'{
interface AxiosInstance{
  (config:AxiosRequestConfig):Promise<any>
}
}
const $http = axios.create({
  baseURL: "/api",
  timeout: 1000,
  headers:{
    "Content-Type":"application/json;charset=utf-8"
  }
});


/**
 * 请求拦截
 */

$http.interceptors.request.use(config=> {
  config.headers=config.headers||{}
  if(localStorage.getItem('token'))
   {
     config.headers.Authorization=localStorage.getItem('token')||''
   }
    return config;
  }
);
/**
 * 响应拦截
 */
$http.interceptors.response.use((res) => {
const code:number=res.data.data.code
if(code!=101){
  MSGS[code]
  ElMessage.error(MSGS[code])
  return Promise.reject(res.data.data)
}
    return res.data.data;
  },
  (err) => {
    console.log(err);
  }
);

export default $http
