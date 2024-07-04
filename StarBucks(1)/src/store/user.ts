import { defineStore } from "pinia";
export const useUserStore =defineStore('user',{
    state(){
        return{           
            user:{ 
                username:localStorage.getItem('username')||'',
                token:localStorage.getItem('token')||'',
                root:localStorage.getItem('root')||0,
            }
         }
        // user:"blank"
     },
     actions:{
        setLoginInfo(username:any,token:any,root:any){
            localStorage.setItem("root",root);
            localStorage.setItem("token",token);
            localStorage.setItem("username",username)
            this.user.username=username
            this.user.token=token
            this.user.root=root
        }
     }
  
})