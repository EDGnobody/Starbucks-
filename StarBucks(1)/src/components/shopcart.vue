<template>

<!-- <div>
    <el-carousel :interval="4000" type="card" height="200px">
    <el-carousel-item v-for="item in 6" :key="item">
      <h3 text="2xl" justify="center">{{ item }}</h3>
    </el-carousel-item>
  </el-carousel>
</div> -->
<!-- <div>
  <el-carousel :interval="4000" type="card" height="200px">
    <el-carousel-item v-for="item in 6" :key="item">
      <img :src="'../assets/shopcart-carousel-${item}.png'" style="width: 100%; height: 200px;">
    </el-carousel-item>
  </el-carousel>
</div> -->
<div>
  <el-carousel :interval="4000" type="card" height="300px">
    <el-carousel-item>
      <img src="../assets/shopcart-carousel-1.png" style="width: 100%; height: 300px;">
    </el-carousel-item>
    <el-carousel-item>
      <img src="../assets/shopcart-carousel-2.png" style="width: 100%; height: 300px;">
    </el-carousel-item>
    <el-carousel-item>
      <img src="../assets/shopcart-carousel-3.png" style="width: 100%; height: 300px;">
    </el-carousel-item>
    <el-carousel-item>
      <img src="../assets/shopcart-carousel-4.png" style="width: 100%; height: 300px;">
    </el-carousel-item>
    <el-carousel-item>
      <img src="../assets/shopcart-carousel-5.png" style="width: 100%; height: 300px;">
    </el-carousel-item>
    <el-carousel-item>
      <img src="../assets/shopcart-carousel-6.png" style="width: 100%; height: 300px;">
    </el-carousel-item>
  </el-carousel>
</div>
<!-- 菜单 -->
 <div style="margin-top:30px">
  <h2>咖啡</h2>
  <hr>
<el-space wrap>
    <el-card v-for="i in 5" :key="i" class="box-card" style="width: 15%">
      <template #header>
        <div class="card-header">
          <span>Card name</span>
          <el-button class="button" text>Operation button</el-button>
        </div>
      </template>
      <div v-for="o in 4" :key="o" class="text item">
        {{ 'List item ' + o }}
      </div>
    </el-card>
  </el-space>
</div>
<div style="margin-top:30px">
  <h2>果茶</h2>
  <hr>
<el-space wrap>
    <el-card v-for="i in 5" :key="i" class="box-card" style="width: 15%">
      <template #header>
        <div class="card-header">
          <span>Card name</span>
          <el-button class="button" text>Operation button</el-button>
        </div>
      </template>
      <div v-for="o in 4" :key="o" class="text item">
        {{ 'List item ' + o }}
      </div>
    </el-card>
  </el-space>
</div>
<div style="margin-top:30px">
  <h2>奶茶</h2>
  <hr>
<el-space wrap>
    <el-card v-for="i in 5" :key="i" class="box-card" style="width: 15%">
      <template #header>
        <div class="card-header">
          <span>Card name</span>
          <el-button class="button" text>Operation button</el-button>
        </div>
      </template>
      <div v-for="o in 4" :key="o" class="text item">
        {{ 'List item ' + o }}
      </div>
    </el-card>
  </el-space>
</div>

</template>

<script lang="ts" setup >

</script>

<style scoped>
img{
    width: 100%;
    height: auto;
}
.el-carousel__item h3 {
  color: #475669;
  opacity: 0.75;
  line-height: 200px;
  margin: 0;
  text-align: center;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}
.el-row {
    width: 100%;
  margin-bottom: 20px;
  margin-top: 20px;
}
.el-row:last-child {
  margin-bottom: 0;
}
.el-col {
  border-radius: 4px;
}

.grid-content {
  border-radius: 4px;
  min-height: 36px;
}
</style>