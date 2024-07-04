import { defineStore } from "pinia";
export const useListStore =defineStore('store',{
    state(){
        return{           
            store:localStorage.getItem('store')||[{ 
               
            }]
         }
     },
     actions:{
        setStoreInfo(store:any){
            localStorage.setItem("store",store);
            this.store=store
        }
     }
  
})