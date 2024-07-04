<template>
<div class="showarea">

<!-- 首页侧边栏 -->
<div v-if="router.name=='home'" class="home">
      <div class="title" :style="{'visibility': (userStore.user.username=='' ? 'hidden' : 'visible')}">欢迎回来，{{ userStore.user.username }}🌟</div>
      <div class="title">心情惬意，来杯咖啡吧 ☕</div>
      <hr>
      
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
    <div v-else-if=" router.name =='login'|| router.name =='register'||router.name =='account'||router.name=='store'" class="account">
      <div class="title" :style="{'visibility': (userStore.user.username=='' ? 'hidden' : 'visible')}">欢迎回来，{{ userStore.user.username }}🌟</div>
  
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
<div v-else-if="router.name=='address'" >
  
  <div v-show="userStore.user.root==1" style="margin-top:30px">
  <h2>管理员模式专属</h2>
  <hr>
  
 </div>
  <!-- 地址列表 -->
  <div class="demo-collapse">
    <el-collapse  accordion>
      <el-collapse-item v-for="item in storeList" :key="item.id"  :name="item.name">
        <template #title>
          <el-icon class="header-icon" @click="changeAddress">
            <Location />
          </el-icon>
        {{item.name}}
        </template>
        <el-descriptions >
    <el-descriptions-item label="店名" >{{item.name}}</el-descriptions-item>
  </el-descriptions>
  <el-descriptions >
    <el-descriptions-item label="电话号码">{{ item.phone }}</el-descriptions-item>
  </el-descriptions>
  <el-descriptions >
    <el-descriptions-item label="地址">{{ item.location }}</el-descriptions-item>
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

<script lang="ts" setup name="bottombar">

const props=defineProps(['page'])
import { onBeforeMount, onMounted, ref, toRefs } from 'vue';
import { useUserStore } from '@/store/user';
import { getCoffeeList, getStoreList } from '@/utils/api';

import { Location } from '@element-plus/icons-vue'
import { useRoute } from 'vue-router';
import { useListStore } from '@/store/store';

const userStore=useUserStore();
const listStore=useListStore()
const router=useRoute();
// 改变地图坐标位置
function changeAddress(){
console.log(8888)
}
var storeList:any=[]
onMounted(()=>{
        getStoreList().then(res=>{
          storeList=res.data
        });
      
      })
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
  font-size: 26px;
  font-weight: 550;
  padding-bottom: 12px;
}

.showarea{
    width: 100%;
    margin-top: 100px;
    position: relative;
}
/* h2{
    margin-top: 370px;
    margin-left: 80px;
}
h4{
    margin-left: 80px;
} */
 
</style>