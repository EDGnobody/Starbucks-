<template>
<!-- 这是用户登录页 -->
 <div>
    <img src="../images/club.png" alt="欢迎加入星享俱乐部">
 </div>
 <div class="form">
    <!-- 用户名输入框 -->
    <div :class="(userInputing || form.username ?'active ':'')+'user'">
          <div class="text">用户名或者电子邮箱</div>
          <input
            type="text"
            v-model="form.username"
            @focus="userInputing =true"
            @blur="userInputing =false"
          />
        </div>
        <!-- 密码输入框 -->
    <div :class="(passwordInputing || form.password?'active ':'')+'password'">
          <div class="text">密码</div>
          <input
            type="password"
            v-model="form.password"
            @focus="passwordInputing =true"
            @blur="passwordInputing =false"
          />
    </div>
    <!-- 注册按钮 -->
 <div>
  <br>
  <RouterLink to="/register" > 没有密码？去注册</RouterLink>
 </div>
        <!-- 登录按钮 -->
        <div class="footer clear">
          <div
            :class="(form.username&&form.password? 'active ':'')+'login-btn'"
            @click="handleLogin"
          >登录</div>
        </div>
 </div>
 <footer>
      <div class="wrapper">
        <h2 class="title">加入星享俱乐部</h2>
        <p class="text">只需几分钟，便可成功注册星享俱乐部帐户，成为“星”会员，立即开启集星之旅。</p>
        <router-link to="register" class="reg-btn">注册</router-link>
      </div>
    </footer>
</template>

<script lang="ts" setup >
import { onMounted, onUpdated, reactive, ref } from 'vue';
import { login } from '@/utils/api'
import { useRouter } from 'vue-router';
import { useUserStore } from '@/store/user';
const userStore=useUserStore();
const userInputing=ref(false);
const form=reactive({
        username: "",
        password: ""
      })
const passwordInputing=ref(false)
const promptVisiable=ref (false)
const router=useRouter();
// 登录函数
async function  handleLogin() {
   login(form).then(res=>{
  if(res.code==101){
promptVisiable.value=true;
userStore.user=form.username;
    router.push("/account")
  }  
   })
    }
</script>

<style scoped>
img{
    width: 100%;
    height: auto;
}
.form{
  max-width: 700px;
  margin: 0 auto;
  padding-top: 50px;
  margin-bottom: 30px;

  input {
    border: none;
    outline: none;
    border-bottom: 1px solid #dedede;
    width: 100%;
    height: 35px;
    font-size: 14px;
    background: transparent;
    position: relative;
  }
  input:hover {
    border-color: #00a862;
  }

  .text {
    font-size: 16px;
    font-weight: 200;
    color: #9c9c9c;
    transition: all 200ms;
    position: absolute;
    top: 2px;
  }

  .active {
    .text {
      top: -18px;
      font-size: 14px;
      color: #6f6f6f;
      font-weight: 500;
      letter-spacing: 0.5px;
    }

    input {
      border-color: #00a862;
      font-size: 16px;
      font-weight: 550;
    }
  }
  .password {
    margin-top: 20px;
  }
  .user,
  .password {
    position: relative;
  }

  .slider {
    margin-top: 50px;
    height: 216px;
    transition: 300ms all;
  }
  .slider.success {
    height: 70px;
  }
  .slide-verify {
    margin: 0 auto;
  }
  .slider-success {
    text-align: center;
    color: #00a862;
    height: 70px;
    img {
      vertical-align: middle;
    }
  }
  .footer {
    margin-top: 40px;
    height: 50px;
  }
  .login-btn {
    font-size: 16px;
    font-weight: 550;
    color: #9e9e9e;
    padding: 15px 25px;
    background-color: #f7f7f7;
    border-radius: 35px;
    box-shadow: 0px 2px 4px 0px #8c8c8c;
    float: right;
    cursor: not-allowed;
  }
  .login-btn.active {
    cursor: pointer;
    background-color: #00a862;
    color: #fff;
  }
  .login-btn.active:hover {
    background-color: #1ab172;
  }
}
footer {
    margin-top: 40px;
  background-color: #15777b;
  .wrapper {
    max-width: 725px;
    margin: 0 auto;
    padding: 40px 0;
  }
  h2.title {
    font-size: 22px;
    font-weight: 500;
    color: #fff;
  }
  p.text {
    font-size: 15px;
    color: #d8d8d8;
    margin-top: 30px;
  }
  .reg-btn {
    display: inline-block;
    padding: 8px 20px;
    font-size: 16px;
    color: #c2a661;
    border: 1px solid #c2a661;
    border-radius: 50px;
    margin: 27px 0px;
  }
}
.prompt {
  width: 400px;
  height: 50px;
  line-height: 50px;
  position: fixed;
  bottom: 0;
  left: 65%;
  margin-left: -200px;
  color: #ffffff;
  background-color: #3d3935;
  padding: 0px 25px;
  box-sizing: border-box;
  transition: 300ms all;

  .close {
    float: right;
    color: #04a25f;
    font-size: 13px;
  }
}
.prompt.fade {
  left: 200%;
  transition: none;
}
@media (min-width: 1024px) {
  .prompt {
    left: 65%;
  }
}
@media (max-width: 1024px) {
  .prompt {
    left: 50%;
  }
}
@media (max-width: 640px) {
  footer,.ad {
    display: none;
  }
  .prompt {
    width: 100%;
    bottom:55px;
    left: 0;
    margin: 0;
  }
}
</style>