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
        src="../images/coffee.png"
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
const userStore=useUserStore();
const visible = ref(false)
function cancel(){
  userStore.setLoginInfo(null,null)

    router.push("/login")
}
userStore.$subscribe((mutate,state)=>{
    localStorage.setItem('user',JSON.stringify(state.user))
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
</style>