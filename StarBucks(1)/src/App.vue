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
</script>

<style scoped>
.app{
  display: flex;
}
.navigate{
  height: 100vh;
 width: 500px;
 position: absolute;
 left:0;
 top:0;
}
.main-content{
  flex-grow:1;
  height: 100vh;
margin-left: 490px;
/* background-color: #df1515; */
position: absolute;
width: 58.5vw;

}
</style>