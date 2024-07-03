<template>
<!-- 这是用户账户信息展示页面 -->
 <div class="main">
    <el-card class="card" style="width: 700px">
    <template #header>
        <!-- 用户信息框 -->
        <el-popover  placement="top" trigger="click" :width="160">
    <div style="text-align: right; margin: 0">
      <el-button size="small" type="primary" @click="cancel">
        退出登录
      </el-button>
    </div>
    <template #reference>
      <el-avatar :size="60"  >
      <img
        src="../images/avatar-01.jpg"
      />
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
// import { getOrderList } from '@/utils/api';
const userStore=useUserStore();
// 退出登录功能

function cancel(){
  userStore.setLoginInfo('','',0)
  console.log(userStore.user.username=='')
    router.push("/login")
}
function change(){

}

// 挂载
// 获取历史订单信息
// onMounted(()=>{
//   getOrderList().then(res=>{
//   if(res.code==101){
//      console.log(res.data)
//      }  
//    })
//       })
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
</style>