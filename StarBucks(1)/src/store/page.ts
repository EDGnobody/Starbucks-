import { defineStore } from "pinia";
export const usePageStore =defineStore('page',{
    state(){
        return{           
         page:localStorage.getItem('page')||"home",
         }
     },
     actions:{
        setPage(page:any){
            localStorage.setItem("page",page);
            this.page=page
        }
     }
  
})