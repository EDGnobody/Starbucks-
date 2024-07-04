<template>
<!-- 这是用户账户信息展示页面 -->
 <div class="main">
    <el-card class="card">
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
  <!--  -->
  <el-card class="card" style="margin-top: 10px;">
    <div> 
      <h2>星享日常所爱</h2>
	      <div>	
		      <img class="image" src="../images/account-1.png" alt="image">
		      <p>
            一份指定中杯手工调制饮品/星巴克\浓/系列饮品/烘焙食品/酸奶/水果沙拉/三明治
          </p>
	      </div>
    </div>
<!--     
    <img src="../images/account-01.png" class="equilt" style="width: 90%"></img>
    <img src="../images/account-02.png" class="equilt" style="width: 90%"></img> -->
  </el-card>
  <!-- 消费记录 -->
  <el-card v-show="userStore.user.root==0" class="card" style="margin-top: 10px;min-height:200px">
   <div class="h1">消费记录</div>
   <hr>
<div v-show="orderNumber==0" ><h2>暂无消费记录</h2></div>
    <div class="demo-collapse">
    <el-collapse  accordion>
      <el-collapse-item v-for="i in orderNumber" key="i"  >
        <template #title>{{orderList[i-1].order.orderDate}}</template>
        <el-descriptions >
    <el-descriptions-item label="店名" >{{orderList[i-1].order.storeName}}</el-descriptions-item>
  </el-descriptions>
  <el-descriptions >
    <el-descriptions-item >购买清单如下：</el-descriptions-item>   
  </el-descriptions>
  <el-descriptions v-for="item in orderList[i-1].orderItems" >
    <el-descriptions-item width="200">{{item.coffeeName  }}</el-descriptions-item>  
    <el-descriptions-item label="单价" width="200">{{item.price }}</el-descriptions-item>  
    <el-descriptions-item label="数量" width="200">{{item.quantity  }}</el-descriptions-item>  
  </el-descriptions>
  <el-descriptions >
    <el-descriptions-item label="总价格">{{ orderList[i-1].order.totalPrice }}</el-descriptions-item>
  </el-descriptions>
      </el-collapse-item>
    </el-collapse>
  </div>
  
  </el-card>
  <!-- <el-card v-show="userStore.user.root==1" class="card" style="margin-top: 10px;">
    <div  style="margin-top:30px">
  <h2>管理员模式专属</h2>
  <hr>

  <el-button type="primary"  >确认</el-button>
 
 </div>
  </el-card> -->
 </div>

</template>

<script lang="ts" setup >
import { onMounted, reactive, ref } from 'vue';
import { useRouter } from 'vue-router';
const router=useRouter();
import { useUserStore } from '@/store/user';
import { getOrderList, register } from '@/utils/api';
import { ElMessage } from 'element-plus';
const userStore=useUserStore();
const orderNumber=ref(0);
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
  userStore.setLoginInfo('','',0)
    router.push("/login")
}

function change(){
  item.value=(item.value+1) % 5;
}
var orderList:any=[]
// 

// const form=reactive({
//             username: "",
//             password: ""
//           })
//     const password=ref("")
//     const passwordInputing=ref(false)
//     const newpasswordInputing=ref(false)
//     function handleRegister(){
//   if(form.username.length!=0&&form.password.length!=0){
//   if(password.value==form.password){
//   register(form).then(res=>{  
//   if(res.data==101){
//     ElMessage({
//     message: '管理员账号注册成功',
//     type: 'success',
//   })
//      }
    
// })
//     }else{
//       ElMessage.error('两次输入密码不一致')
//     } }
//   }
// 挂载
// 获取历史订单信息
onMounted(()=>{
  getOrderList().then(res=>{
  if(res.code==101){
    orderList=res.data
    orderNumber.value=res.data.length;
     }  
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
    width: 60%;
    margin-left: 20%;
}
.equilt{
    width: 100%;
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
.image{
    width: 200px;
    height: auto;
    float: right;
}
</style>