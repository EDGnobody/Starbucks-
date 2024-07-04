<template>
<div class="showarea">

<!-- 首页侧边栏 -->
<div v-if="route.name=='home'" class="home">
      <div class="title" id="randomString">{{ strings[randomIndex] }}</div>
      <hr style="border: 0; border-top: 1px solid grey; width: 400px;">
      <img 
        src="./images/homepage-gift.png" 
        class="image"
        style="float: left;"
        >
      <img 
        src="./images/homepage-star.png"
        class="image"
        style="float: right;"
        >
      <div >
        <router-link :style="{'visibility': (userStore.user.username=='' ? 'visible' : 'hidden')}"
        class="login" to="/login">
          <img src="https://www.starbucks.com.cn/assets/icons/icon-account.svg"  />
          <span>登录</span>
        </router-link>
        <router-link :style="{'visibility': (userStore.user.username=='' ? 'visible' : 'hidden')}"
          class="reg" to="/register">注册</router-link>
         <br>
      </div>
    </div>
     <!-- 我的账户页面侧边栏 -->
    <div v-else-if=" route.name =='login'|| route.name =='register'||route.name =='account'||route.name=='store'" class="account">
      <div class="title" :style="{'visibility': (userStore.user.username=='' ? 'hidden' : 'visible')}">{{greeting[greetingIndex]}}，{{ userStore.user.username }}🌟</div>
  
      <div class="title">心情惬意，来杯咖啡吧 ☕</div>
      <hr>
      <div class="title" :style="{'visibility': (userStore.user.username=='' ? 'visible' : 'hidden')}">登录或创建一个新帐户 🌟</div>
      <div >
        <router-link :style="{'visibility': (userStore.user.username=='' ? 'visible' : 'hidden')}"
         class="login" to="/login">
          <img src="https://www.starbucks.com.cn/assets/icons/icon-account.svg"  />
          <span>登录</span>
        </router-link>
        <router-link :style="{'visibility': (userStore.user.username=='' ? 'visible' : 'hidden')}"
          class="reg" to="/register">注册</router-link>
      </div>
      
    </div>
<!-- 菜单侧边栏 -->
<div v-else-if="route.name=='address'" >
  
  <div v-show="userStore.user.root==1" style="margin-top:30px">
  <h2>管理员模式专属</h2>
  <hr>
  
 </div>
  <!-- 地址列表 -->
  <div class="demo-collapse">
    <el-collapse  accordion>
      <el-collapse-item v-for="i in number" key="i"  :name="storeList[i-1].name">
        <template #title>
          <el-icon class="header-icon" @click="changeAddress(storeList[i-1].latitude,storeList[i-1].longitude)">
            <Location />
          </el-icon>
        {{storeList[i-1].name}}
        </template>
        <el-descriptions >
    <el-descriptions-item label="店名" >{{storeList[i-1].name}}</el-descriptions-item>
  </el-descriptions>
  <el-descriptions >
    <el-descriptions-item label="电话号码">{{ storeList[i-1].phone }}</el-descriptions-item>
  </el-descriptions>
  <el-descriptions >
    <el-descriptions-item label="地址">{{ storeList[i-1].location }}</el-descriptions-item>
  </el-descriptions>
      </el-collapse-item>
    </el-collapse>
  </div>
    </div>
    <!-- <div v-else-if="page=='store'" class="home">
      <div class="title">心情惬意，来杯咖啡吧 ☕</div>
    
    </div> -->
</div>
</template>

<script lang="ts" setup >

const props=defineProps(['page'])
import { onBeforeMount, onMounted, ref, toRefs } from 'vue';
import { useUserStore } from '@/store/user';
import { getCoffeeList, getStoreList } from '@/utils/api';
import { Location } from '@element-plus/icons-vue'
import { useRouter } from 'vue-router';
import { useRoute } from 'vue-router';
import { useListStore } from '@/store/store';
const number=ref(0)
const userStore=useUserStore();
const listStore=useListStore()
const router=useRouter();
const route=useRoute()
// 改变地图坐标位置
function changeAddress(x:any,y:any){
  // router.push({ name: 'address', params: { latitude: x,longitude:y }})
}
var storeList:any=[]
onMounted(()=>{
        getStoreList().then(res=>{
          storeList=res.data;
          number.value=res.data.length
        });
      })
// 定义一个包含多个字符串的数组
const strings = ref([
  '想念的，会相见🍩', 
  '生活就像美式，总有回甘✨', 
  '保持期待与热爱🍫', 
  '生活向美而生🍭', 
  '细碎的美好🦄'
]);
const greeting = ref([
  '早上好', 
  '中午好', 
  '下午好', 
  '晚上好', 
  '深夜了',
]);
// 生成一个随机数作为索引
const randomIndex = Math.floor(Math.random() * strings.value.length);
const hours = new Date().getHours();
let greetingIndex = 0;
if (hours >= 6 && hours < 11) {
  greetingIndex = 0;
} else if (hours >= 11 && hours < 13) {
  greetingIndex = 1;
} else if (hours >= 13 && hours < 17) {
  greetingIndex = 2;
} else if (hours >= 17 && hours < 22) {
  greetingIndex = 3;
} else {
  greetingIndex = 4;
}
</script>

<style scoped>
.header-icon{
  width:  50px;
  height: 50px;
  size: 50cm;
}
.login {
  display: inline;
  color: #00a862;
  font-size: 16px;

text-decoration: none;

  img {
    vertical-align: middle;
    height: 29px;
  }
  span {
    line-height: 28px;
    margin-left: 4px;
  }
}
.reg {
  margin-left: 50px;
  display: inline;
  text-decoration: none;
  width: 40px;
  padding: 6px 12px;
  color: #00a862;
  border: 1px solid #00a862;
  border-radius: 16px;
  line-height: 33px;
  vertical-align: bottom;
}
.home{
position: absolute;
top:270px;
left: 80px;
}
.account{
position: absolute;
top:270px;
left: 80px;
}

.list {
  width: max-content;
}
.list li{
 list-style: none;
}
.list li a {
  color: #707070;
  display: inline-block;
  width: 40px;
  left:0;
  font-size: 16px;
  font-weight: 200;
  padding-bottom: 5px;
  border-bottom: 3px solid transparent;
  margin-top: 10px;
}
.list li :first-child{
    left:0;
}
/* .list li :last-child{
    left:50px;
} */
.list li a.active {
  color: #212121;
  font-weight: 550;
  border-color: #00a862;
}
.list li a:hover {
  color: #212121;
}
.title {
  font-size: 30px;
  font-weight: 550;
  padding-bottom: 12px;
}

.showarea{
    width: 100%;
    margin-top: 100px;
    position: relative;
}
.image{
    width: 30px;
    height: 30px;
}
/* h2{
    margin-top: 370px;
    margin-left: 80px;
}
h4{
    margin-left: 80px;
} */
 
</style>