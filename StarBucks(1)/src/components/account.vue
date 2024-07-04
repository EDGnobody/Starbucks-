<template>
<!-- 这是用户账户信息展示页面 -->
 <div class="main">
    <el-card class="card" style="width: 700px">
    <template #header>
        <!-- 用户信息框 -->
        <el-popover  placement="top" trigger="click" :width="200">
    <div class="user-info">
      <el-button size="small" type="primary" @click="cancel">
        退出登录
      </el-button>
      <el-button size="small" type="primary" @click="change()">
        切换头像
      </el-button>
    </div>
    <template #reference>
      <el-avatar :size="60"  :src="avatars[item]">
    </el-avatar>
    </template>
  </el-popover>
    </template>
    <img 
        class="equilt"
      src="../images/equilt.png"
    />
  </el-card>
  <el-card class="card" style="width: 700px;margin-top: 10px;">
   <div class="h1">消费记录</div>
   <hr>



  </el-card>

 </div>

</template>

<script lang="ts" setup >


import { onMounted, ref } from 'vue';
import { useRouter } from 'vue-router';
const router=useRouter();
import { useUserStore } from '@/store/user';
import { getOrderList } from '@/utils/api';
const userStore=useUserStore();
var avatars = ref([

  "./images/avatar-01.jpg",
  "./images/avatar-02.jpg",
  "./images/avatar-03.jpg",
  "./images/avatar-04.jpg",
  "./images/avatar-05.jpg",
]);

// 退出登录功能
let item=ref(1);
function cancel(){
  userStore.setLoginInfo(null,null)
    router.push("/login")
}

function change(){
  item.value=(item.value+1) % 5;
}
// 获取历史订单信息

// 挂载
onMounted(()=>{
  getOrderList().then(res=>{
    // if(res.data.code==101){
    // // console.log(res.data)
    //  }  
   })
 })
</script>

<style scoped>

.main{
    width:100%;
    height:auto;
}
.card{
    margin-top: 0;
    margin-left: 20%;
}
.equilt{
    width: 700px;
    left:0;
    top:0;
    margin-left: 0;
}
.h1{
    font-size: larger
}
.user-info{
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 10px;
    /* style="text-align: right; margin: 0" */
}
</style>