<template>
  <div class="app">
    <!-- 导航区 -->
<div  class="navigate">
 <side-bar/>
</div>
<!-- 展示区 -->
<div class="main-content">
  <router-view></router-view>
</div>
</div>
</template>

<script lang="ts" setup >
import sideBar from './views/layout/sideBar/index.vue';
import { RouterView,RouterLink } from 'vue-router';
</script>

<style scoped>
.app{
  display: flex;
  height: 100%
}
.navigate{
  height: 100%;
 width: 30%;
 float:left;
 position: absolute;
 left:0;
 top:0;
}
.main-content{
  flex-grow:1;
  height: 100vh;
margin-left: 490px;
position: absolute;
top:0;
}
</style>