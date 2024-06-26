<template>
  <div  class="sidebar">
  <topbar/>
  <bottombar/>
</div>
</template>

<script lang="ts" setup>
import topbar from './topbar.vue'
import bottombar from './bottombar.vue'
</script>
<style>
.sidebar{
  width:490px;
  height: 100vh;
 background-color: #fff;
  position: fixed;
  box-shadow: 0 4px 8px rgba(0,0,0,0.2);
  top:0;
  left:0;
}
</style>