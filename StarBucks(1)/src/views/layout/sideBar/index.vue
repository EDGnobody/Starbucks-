<template>
  <div  class="sidebar">
    <div class="menu">
  <img class="logo" @click="tohome"  style="width: 40px" src="/src/images/logo.png" alt="logo"/>
      <div class="navigateArea">
        <RouterLink  to="/address" class="navigate">门店</RouterLink>
        <RouterLink  :to="(userStore.user.username==''? '/login':'/account' )" class="navigate">我的账户</RouterLink>
        <RouterLink  to="/store" class="navigate">菜单</RouterLink>
    </div>
  
    <a  class="nav-menu" >
        <img
          src="https://www-static.chinacdn.starbucks.com.cn/prod/assets/icons/icon-hamburger.svg"
        />
      </a>
</div>
  <bottombar />
</div>
</template>

<script lang="ts" setup>
import bottombar from './bottombar.vue'
import { onMounted, ref } from 'vue';
import { useRouter } from 'vue-router';
import { useUserStore } from '@/store/user';

const userStore=useUserStore();
const router=useRouter();
function tohome(){
  router.push('/')
}

onMounted(()=>{

      })
</script>
<style scoped>
.sidebar{
  width:30vw;
  height: 100vh;
 background-color: #fff;
  position: fixed;
  box-shadow: 0 4px 8px rgba(0,0,0,0.2);
  top:0;
  left:0;
}
.flex-grow {
  flex-grow: 1;
}
.menu{
    width:100%;
    height: 100px;
    position: absolute;
 background-color: #fff;
}
.logo{
    position: relative;
    margin-top: 25px;
    margin-left: 20px;
}
.navigateArea{
    position: absolute;
    width: 400px;
    height: 50px;
    top: 0px;
    left: 100px;
    list-style: none;
}
.navigate{
    margin-left: 20px;
    position: relative;
    font-weight: bold;
    font-size: large;
    display: inline;
    color: black;
    text-decoration: none;
}
a{
    position: absolute;
    top:30px;
    right:30px
}
</style>