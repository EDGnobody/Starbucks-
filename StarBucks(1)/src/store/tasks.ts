import { defineStore } from "pinia";


export const useTasksStore =defineStore('tasks',{
  
    state(){
        return{          
     tasks:JSON.parse(localStorage.getItem('tasks')as string)||
     [{ 
    id:'',
    content:"",
    reminder:false
 }]

        }
    }
})