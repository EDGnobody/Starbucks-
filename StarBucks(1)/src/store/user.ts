import { defineStore } from "pinia";


export const useUserStore =defineStore('user',{
    state(){
        return{          
            user:JSON.parse(localStorage.getItem('user')as string)||
            [{ 
           username:'',
           password:""
        }]
       
               }
        // user:"blank"
     }
  
})