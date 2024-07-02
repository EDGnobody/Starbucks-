<template>
<div class="showarea">

<!-- 首页侧边栏 -->
<div v-if="page=='home'" class="home">
      <div class="title">心情惬意，来杯咖啡吧 ☕</div>
      <div >
        <router-link :style="{'visibility': (userStore.user.username==null ? 'visible' : 'hidden')}"
        @click.native="page = 'login'" class="login" to="/login">
          <img src="https://www.starbucks.com.cn/assets/icons/icon-account.svg"  />
          <span>登录</span>
        </router-link>
        <router-link :style="{'visibility': (userStore.user.username==null ? 'visible' : 'hidden')}"
         @click.native="page = 'register'" class="reg" to="/register">注册</router-link>
      </div>
    </div>
     <!-- 我的账户页面侧边栏 -->
    <div v-else-if=" page =='login'|| page =='register'||page =='account'" class="account">
      <div class="title">登录或创建一个新帐户 🌟</div>
      <ul class="list" :style="{'visibility': (userStore.user.username==null ? 'visible' : 'hidden')}">
        <li >
          <router-link
            @click.native="page = 'login'"
            to="/login"
            :class="page == 'login'?'active':''"
          >登录</router-link>
        </li>
        <li>
          <router-link
            @click.native="page = 'register'"
            to="/register"
            :class="page == 'register'?'active':''"
          >注册</router-link>
        </li>
      </ul>
    </div>
<!-- 菜单侧边栏 -->
<div v-else-if="page=='store'" class="home">
      <div class="title">心情惬意，来杯咖啡吧 ☕</div>
    
    </div>
    <div v-else-if="page=='address'" class="home">
      <div class="title">心情惬意，来杯咖啡吧 ☕</div>
    
    </div>
</div>
</template>

<script lang="ts" setup name="bottombar">
const props=defineProps(['page'])
const {page}=toRefs(props)
import { ref, toRefs } from 'vue';
import { useUserStore } from '@/store/user';
const userStore=useUserStore();

</script>

<style scoped>

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
top:350px;
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