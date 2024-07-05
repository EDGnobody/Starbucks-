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
    <!-- <img 
      src="../images/bar.png"
    /> -->
  </el-card>
  <!--  -->
  <el-card class="card" style="margin-top: 10px;height: 360px;">
    <img src="../assets/gift.png" class="equilt" style="width: 90%"></img>
    <hr style="border: 0; border-top: 4px solid rgb(8, 85, 25);">
    <el-carousel :interval="6000" arrow="always">
      <el-carousel-item v-for="(item, index) in items" :key="index">
        <div>
          <img class="image" :src="item.imgSrc" :alt="item.altText">
          <h2>{{ item.title }}</h2>
          <p>{{ item.description }}</p>
        </div>
      </el-carousel-item>
    </el-carousel>

   
  </el-card>

<!--     
    <img src="../images/account-01.png" class="equilt" style="width: 90%"></img>
    <img src="../images/account-02.png" class="equilt" style="width: 90%"></img> -->
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
  <el-card v-show="userStore.user.root==1" class="card" style="margin-top: 10px;">
    <div  style="margin-top:30px">
  <h2>管理员模式专属</h2>
  <hr>
  <!-- <div class="form">
        用户名输入框
        <div :class="(userInputing || form.username ?'active ':'')+'user'">
              <div class="text">用户名(长度5-13位)</div>
              <input
                type="text"
                v-model="form.username"
                @focus="userInputing =true"
                @blur="userInputing =false"
              />
            </div>
            密码输入框
        <div :class="(passwordInputing || form.password?'active ':'')+'password'">
              <div class="text">密码(长度5-13位)</div>
              <input
                type="password"
                v-model="form.password"
                @focus="passwordInputing =true"
                @blur="passwordInputing =false"
              />
        </div>
        确认密码输入框
        <div :class="(newpasswordInputing || password?'active ':'')+'password'">
              <div class="text">确认密码</div>
              <input
                type="password"
                v-model="password"
                @focus="newpasswordInputing =true"
                @blur="newpasswordInputing =false"
              />
        </div>
            注册按钮
            
     </div> -->
     <el-form :model="form" label-width="auto" style="max-width: 500px">
    <el-form-item label="用户名">
      <el-input v-model="form.username" 
              type="text"
              @focus="userInputing =true"
              @blur="userInputing =false"
               placeholder="(长度5-13位)"
      />
    </el-form-item>
    <el-form-item label="密码" >
      <el-input v-model="form.password" type="password"
                @focus="passwordInputing =true"
                @blur="passwordInputing =false"
                placeholder="(长度5-13位)"/>
             
          </el-form-item>
          <el-form-item label="确认密码" >
      <el-input v-model="password" type="password"
                @focus="newpasswordInputing =true"
                @blur="newpasswordInputing =false"
                placeholder="(长度5-13位)"/>     
          </el-form-item>
 
  </el-form>
  <el-button type="primary"   @click="handleRegister" >确认创建新管理员</el-button>
 
 </div>
  </el-card>
 </div>

</template>

<script lang="ts" setup >
import { onMounted, reactive, ref } from 'vue';
import { useRouter } from 'vue-router';
const router=useRouter();
import { useUserStore } from '@/store/user';
import { addAdmin, getOrderList } from '@/utils/api';
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

const form=reactive({
            username: "",
            password: ""
          })
    const userInputing=ref(false);
    const password=ref("")
    const passwordInputing=ref(false)
    const newpasswordInputing=ref(false)
function handleRegister(){
  if(form.username.length!=0&&form.password.length!=0){
  if(password.value==form.password){
  addAdmin(form).then(res=>{  
  if(res.code==101){
    ElMessage({
    message: '管理员账号注册成功',
    type: 'success',
  })
     }
    
})
    }else{
      ElMessage.error('两次输入密码不一致')
    } }
  }
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
   
      const items = ref([
  {
    imgSrc: './images/account-1.png',
    altText: 'image',
    title: '星享日常所爱',
    description: '一份指定中杯手工调制饮品/星巴克\\浓/系列饮品/烘焙食品/酸奶/水果沙拉/三明治'
  },
  {
    imgSrc: './images/account-2.png',
    altText: 'image',
    title: '星享奇妙无穷',
    description: '一份指定臻选™手工调制饮品（臻选浓缩/臻选冲煮探秘/臻选冷萃）/臻选咖啡融合冰淇淋产品/星享小点整盒/星轻食系列产品'
  },
  {
    imgSrc: './images/account-3.png',
    altText: 'image',
    title: '定制挚爱风味',
    description: '一次升杯、一次添加浓缩咖啡、糖浆等客制化权益'
  },
  {
    imgSrc: './images/account-4.png',
    altText: 'image',
    title: '星享确幸好礼',
    description: '一张指定中杯手工调制饮品7折优惠券或一张专星送免运费券'
  },
  {
    imgSrc: './images/account-5.png',
    altText: 'image',
    title: '星享心意礼遇',
    description: '一张指定中杯手工调制饮品6折优惠券'
  },
  {
    imgSrc: './images/account-6.png',
    altText: 'image',
    title: '满星欢喜',
    description: '一份星巴克臻选上海烘焙工坊指定产品78元抵用券/一份星巴克门店指定单品75元抵用券'
  },
  {
    imgSrc: './images/account-7.png',
    altText: 'image',
    title: '星享升级体验',
    description: '一份指定中杯季节性手工调制饮品/冷萃咖啡/慕斯浓缩/冰震浓缩(大杯+1星)/意榄朵™(大杯+1星)/星巴克冰淇淋系列产品/蛋糕甜点/三明治/卷类产品/指定单品45元抵用券。'
  },
]);

</script>

<style scoped>

.main{
    width:100%;
    height:auto;
}
.card{
    margin-top: 0;
    width: 70%;
    margin-left: 15%;
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
p {
  color: rgb(118, 118, 118);
}
.el-carousel__item h3 {
    color: #475669;
    margin: 0;
  }
</style>