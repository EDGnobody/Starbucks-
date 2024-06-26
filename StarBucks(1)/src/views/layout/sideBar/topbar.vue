<template>
<div class="menu">
    <img
    class="logo"
        style="width: 40px"
        src="/src/images/logo.png"
        alt="logo"
      />
      <ul>
         <li>门店</li>
        <li>我的账户</li>
        <li>菜单</li>
    </ul>
  
    <a href="#" class="nav-menu" >
        <img
          src="https://www-static.chinacdn.starbucks.com.cn/prod/assets/icons/icon-hamburger.svg"
         
        />
      </a>
</div>
</template>

<script lang="ts" setup >
import { ref } from 'vue'
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
ul{
    position: absolute;
    top:15px;
    left:30px;
    list-style: none;
}
li{
    display: inline;
    margin-left: 20px;
    font-weight: bold;
}
a{
    position: absolute;
    top:30px;
    right:30px
}
</style>