<template>
  <!-- <div class="app">
    导航区
<div  class="navigate">
 <side-bar/>
</div>
展示区
<div class="main-content">
  <router-view></router-view>
</div>
</div> -->

<div class="common-layout">
    <el-container>
      <el-aside width="30%"> <side-bar/></el-aside>
      <el-main><router-view></router-view></el-main>
    </el-container>
  </div>
</template>

<script lang="ts" setup >
import sideBar from './views/layout/sideBar/index.vue';
import { RouterView,RouterLink } from 'vue-router';
</script>

<style scoped>
.app{
  height: 100%
}
.navigate{
  height: 100%;
 width: 30%;
 float:left;
 position: absolute;
}
.main-content{
  flex-grow:1;
  height: auto;
margin-left: 30%;
height: 100%;
position: absolute;
top:0;
}
</style>