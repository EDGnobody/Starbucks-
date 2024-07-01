<!-- 创建地图容器，js api会根据id将地图加载到容器中 -->
<!-- 注意：需要设置地图容器的大小 -->
<template>
    <div id="container"></div>
  </template>
  <component :is="'script'" type="text/javascript">
      window._AMapSecurityConfig = {securityJsCode: '准备环境阶段拿到的的安全密钥'}
  </component>
  
  <!-- 本文中使用script-setup，非setup需要自行替换写法 -->
  <script lang="ts" setup>
      // 引入jsApi 地图Loader
      import AMapLoader from '@amap/amap-jsapi-loader';
      import { onMounted, onUnmounted } from 'vue';
      
      let map: { destroy: () => void; } | null = null;
      onMounted(() => {
        AMapLoader.load({
          key: "", // 申请好的Web端开发者Key，首次调用 load 时必填
          version: "2.0", // 指定要加载的 JSAPI 的版本
          plugins: ["AMap.Scale", "AMap.ToolBar"], //(按需引用，pc端建议加入AMap.ToolBar，便于操作)需要使用的的插件列表，如比例尺'AMap.Scale'，支持添加多个如：['...','...']
          })
      .then((AMap) => {
        // 加载地图到id为container的容器中
        map = new AMap.Map("container", {
          viewMode: "2D", // 设置地图视图类型,2D / 3D
          zoom: 11, // 初始化地图级别
          center: [116.397428, 39.90923], // 初始化地图中心点位置
        });
      })
      .catch((e) => {
        console.log(e);
      });
  });
  
  onUnmounted(() => {
    map?.destroy();
  });
  </script>
  
  <style  scoped>
 
      #container{
          padding:0px;
          margin: 0px;
          width: 100%;
          height: 800px;
      }
  </style>
