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
  <el-card class="card" style="margin-top: 10px;height: 200px;">
    <el-carousel :interval="6000" arrow="always">
      <el-carousel-item v-for="(item, index) in items" :key="index">
        <div>
          <img class="image" :src="item.imgSrc" :alt="item.altText">
          <h3>{{ item.title }}</h3>
          <p>{{ item.description }}</p>
        </div>
      </el-carousel-item>
    </el-carousel>

   
  </el-card>

<!--     
    <img src="../images/account-01.png" class="equilt" style="width: 90%"></img>
    <img src="../images/account-02.png" class="equilt" style="width: 90%"></img> -->
  <!-- 消费记录 -->
  <el-card class="card" style="margin-top: 10px;">
   <div class="h1">消费记录</div>
   <hr>

   <div class="demo-collapse">
    <el-collapse >
      <el-collapse-item  v-for="i in orderNumber" key="i" :title="orderList[i-1].order.orderDate" name="1">
        <div>
          Consistent with real life: in line with the process and logic of real
          life, and comply with languages and habits that the users are used to;
        </div>
        <div>
          Consistent within interface: all elements should be consistent, such
          as: design style, icons and texts, position of elements, etc.
        </div>
      </el-collapse-item>
    </el-collapse>
  </div>
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
  console.log(userStore.user.username=='')
    router.push("/login")
}

function change(){
  item.value=(item.value+1) % 5;
}
var orderList:any=[]
// 挂载
// 获取历史订单信息
onMounted(()=>{
  getOrderList().then(res=>{
  if(res.code==101){
    orderList=res.data
    orderNumber.value=res.data.length;
     console.log(res.data[0].order)
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