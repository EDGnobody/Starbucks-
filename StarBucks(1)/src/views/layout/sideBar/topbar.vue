<template>
<div class="menu">
    <img
    class="logo"
        style="width: 40px"
        src="/src/images/logo.png"
        alt="logo"
      />
      <div class="navigateArea">
        <RouterLink to="/address" class="navigate">门店</RouterLink>
        <RouterLink to="/account" class="navigate">我的账户</RouterLink>
        <RouterLink to="/store" class="navigate">菜单</RouterLink>
    </div>
  
    <a href="#" class="nav-menu" >
        <img
          src="https://www-static.chinacdn.starbucks.com.cn/prod/assets/icons/icon-hamburger.svg"
        />
      </a>
</div>
</template>

<script lang="ts" setup >
import { ref } from 'vue'
import { RouterLink } from 'vue-router';
</script>

<style scoped>
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