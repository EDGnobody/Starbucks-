<template>
<!-- 活动展示轮播图 -->
<div>
  <el-carousel :interval="4000" type="card" width="100%" height="200px">
    <el-carousel-item>
      <img src="../assets/shopcart-carousel-1.png" style="width: 100%;">
    </el-carousel-item>
    <el-carousel-item>
      <img src="../assets/shopcart-carousel-2.png" style="width: 100%;">
    </el-carousel-item>
    <el-carousel-item>
      <img src="../assets/shopcart-carousel-3.png" style="width: 100%;">
    </el-carousel-item>
    <el-carousel-item>
      <img src="../assets/shopcart-carousel-4.png" style="width: 100%;">
    </el-carousel-item>
    <el-carousel-item>
      <img src="../assets/shopcart-carousel-5.png" style="width: 100%;">
    </el-carousel-item>
    <el-carousel-item>
      <img src="../assets/shopcart-carousel-6.png" style="width: 100%;">
    </el-carousel-item>
  </el-carousel>
</div>
<!-- 管理员模式 -->
 <div v-show="userStore.user.root==1" style="margin-top:30px">
  <h2>管理员模式专属</h2>
  <hr>
  <el-card class="box-card" style="width: 500px">
      <template #header>
        <div class="card-header">
          <span>  添加新品类饮品</span>
        </div>
      </template>
      <el-form :model="form" label-width="auto" style="max-width: 500px">
    <el-form-item label="饮品名字">
      <el-input v-model="form.name" />
    </el-form-item>
    <el-form-item label="价格" >
            <el-input v-model.number="form.price" type="number" autocomplete="off" placeholder="请输入要设定的价格">
              <template #append>
              <div>¥</div>
            </template></el-input>
          </el-form-item>
    <el-form-item label="饮品种类">
      <el-select v-model="form.category" placeholder="请选择饮品种类">
        <el-option label="果茶" value="果茶" />
        <el-option label="咖啡" value="咖啡" />
        <el-option label="奶茶" value="奶茶" />
      </el-select>
    </el-form-item>
  </el-form>
  <!-- 上传图片 -->
   
  <el-button type="primary" @click="addNewCoffee" >确认</el-button>
    </el-card>

 </div>
<!-- 菜单 -->
 <div style="margin-top:30px">
  <h2>咖啡</h2>
  <hr>
<el-space wrap>
    <el-card v-for="i in coffeeNumber" :key="i" class="box-card" style="width: 15%">
      <template #header>
        <div class="card-header">
          <span>{{ coffeeList[i-1].name }}</span>
          <el-button class="button" text>加入购物车</el-button>
        </div>
      </template>
     <img :src="'http://139.155.128.8:5650/file/download/'+coffeeList[i-1].picture" alt="咖啡图片">  
    </el-card>
  </el-space>
</div>
<div style="margin-top:30px">
  <h2>果茶</h2>
  <hr>
<el-space wrap>
    <el-card v-for="i in fruitNumber" :key="i" class="box-card" style="width: 15%">
      <template #header>
        <div class="card-header">
          <span>{{ fruitList[i-1].name }}</span>
          <el-button class="button" text>加入购物车</el-button>
        </div>
      </template>
      <img :src="'http://139.155.128.8:5650/file/download/'+fruitList[i-1].picture" alt="果茶图片">  
    </el-card>
  </el-space>
</div>
<div style="margin-top:30px">
  <h2>奶茶</h2>
  <hr>
<el-space wrap>
    <el-card v-for="i in milkNumber" :key="i" class="box-card" style="width: 15%">
      <template #header>
        <div class="card-header">
          <span>{{ milkList[i-1].name }}</span>
          <el-button class="button" text>加入购物车</el-button>
        </div>
      </template>
      <img :src="'http://139.155.128.8:5650/file/download/'+milkList[i-1].picture" alt="奶茶图片">  
    </el-card>
  </el-space>
</div>
<hr>
<!-- 购物车 -->
<el-affix position="bottom" :offset="100">
  <!-- 购物车图标 -->
  <!-- <el-icon class="icon"><ShoppingCart /></el-icon> -->
  <el-avatar  class="icon" src="../images/shopcart.png">
  </el-avatar>
   <!-- <img class="icon" src="../images/shopcart.png" alt=""> -->
<!-- 购物车卡片 -->
  <!-- <el-card  style="width: 100%;margin-top: 10px;">
  </el-card> -->
  </el-affix>
</template>

<script lang="ts" setup >
import { onBeforeMount, onMounted, reactive, ref } from 'vue';
import { createCoffee ,getCoffeeList} from '@/utils/api';
import { ElMessage } from 'element-plus';
import { useUserStore } from '@/store/user';
import { ShoppingCart } from '@element-plus/icons-vue'
const userStore=useUserStore();
 const form=reactive({
            name: "",
            price:"",
            category: ""
          });
const coffeeNumber=ref(0)
var coffeeList:any=[]
const milkNumber=ref(0)
var milkList:any=[]
const fruitNumber=ref(0)
var fruitList:any=[]
// 管理员添加饮料品种
  function addNewCoffee(){
    if(form.category.length!=0&&form.name.length!=0&&form.price.length!=0){
      createCoffee(form).then(res=>{  
 console.log(res.code);
 ElMessage({
    message: '添加成功',
    type: 'success',
  })

})
form.category="";
form.name="";
form.price="";
    }
  }

  // 获取咖啡列表
  onMounted(()=>{
    // 获取咖啡列表
        getCoffeeList("咖啡").then(res=>{
          coffeeList=res.data
       coffeeNumber.value=res.data.length;
        });
// 获取奶茶列表
getCoffeeList("奶茶").then(res=>{
          milkList=res.data
       milkNumber.value=res.data.length;
        });
//获取果茶列表
getCoffeeList("果茶").then(res=>{
          fruitList=res.data
       fruitNumber.value=res.data.length;
        });
      })
    
</script>

<style scoped>
.icon{
 width: 100px;
 height: 100px;
  margin-left: 80%;
}
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