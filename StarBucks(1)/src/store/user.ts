import { defineStore } from "pinia";


export const useUserStore =defineStore('user',{
    state(){
        return{           
            user:{ 
                username:'',
                token:""
            }
         }
        // user:"blank"
     },
     actions:{
        setLoginInfo(username:any,token:any){
    
             localStorage.setItem("token",token);
            localStorage.setItem("username",username)
            this.user.username=username
            this.user.token=token
        }

     }
  
})