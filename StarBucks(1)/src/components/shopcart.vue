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
<!-- 购物车图钉 -->
<el-affix :offset="300" style="margin-left: 95%;">
    <el-button type="primary" @click="visible=!visible">购物车</el-button>
  </el-affix>
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
    <el-card v-for="i in coffeeNumber" :key="i" class="box-card" style="width: 350px">
      <template #header>
        <div class="card-header">
          <!-- <span >{{ coffeeList[i-1].name }}</span>
          <span style="width">{{ coffeeList[i-1].price }}</span> -->
       <el-descriptions  >
    <el-descriptions-item width="200">{{coffeeList[i-1].name }}</el-descriptions-item>  
    <el-descriptions-item label="单价" width="200">{{coffeeList[i-1].price}}¥</el-descriptions-item>   
  </el-descriptions>
        </div>
      </template>
     <img :src="'http://139.155.128.8:5650/file/download/'+coffeeList[i-1].picture" alt="咖啡图片">  
     <el-input-number v-model="coffeenumber[i-1]" :min="0" :max="10" style="margin-top: 10px;margin-left: 20%;"
      @click="addOrder(coffeeList[i-1].name,coffeenumber[i-1])" />
    </el-card>
  </el-space>
</div>
<div style="margin-top:30px">
  <h2>果茶</h2>
  <hr>
<el-space wrap>
    <el-card v-for="i in fruitNumber" :key="i" class="box-card" style="width: 350px">
      <template #header>
        <div class="card-header">
          <el-descriptions  >
    <el-descriptions-item width="200">{{fruitList[i-1].name }}</el-descriptions-item>  
    <el-descriptions-item label="单价" width="200">{{fruitList[i-1].price}}¥</el-descriptions-item>   
  </el-descriptions>
        </div>
      </template>
      <img :src="'http://139.155.128.8:5650/file/download/'+fruitList[i-1].picture" alt="果茶图片">  
      <el-input-number v-model="fruitnumber[i-1]" :min="0" :max="10" style="margin-top: 10px;margin-left: 20%;"
      @click="addOrder(fruitList[i-1].name,fruitnumber[i-1])" />
    </el-card>
  </el-space>
</div>
<div style="margin-top:30px">
  <h2>奶茶</h2>
  <hr>
<el-space wrap>
    <el-card v-for="i in milkNumber" :key="i" class="box-card" style="width: 350px">
      <template #header>
        <div class="card-header">
          <el-descriptions  >
    <el-descriptions-item width="200">{{milkList[i-1].name }}</el-descriptions-item>  
    <el-descriptions-item label="单价" width="200">{{milkList[i-1].price}}¥</el-descriptions-item>   
  </el-descriptions>
        </div>
      </template>
      <img :src="'http://139.155.128.8:5650/file/download/'+milkList[i-1].picture" alt="奶茶图片">  
      <el-input-number v-model="milknumber[i-1]" :min="0" :max="10" style="margin-top: 10px;margin-left: 20%;" 
      @click="addOrder(milkList[i-1].name,milknumber[i-1])"/>
    </el-card>
  </el-space>
</div>
<hr>
<!-- 购物车 -->
<el-affix v-show="visible" position="bottom" :offset="0">
  <!-- 购物车图标 -->
  <!-- <el-icon class="icon"><ShoppingCart /></el-icon> -->
  <!-- <el-avatar v-show="visible" class="icon" src="../images/image.png" @click="showCart">
  </el-avatar> -->
   <!-- <img class="icon" src="../images/shopcart.png" alt=""> -->
<!-- 购物车卡片 -->
  <el-card  style="width: 100%;height: 300px;">
    <!-- 店家选择器 -->
    <div>    以下是你选购的商品：</div>
    <el-select
    v-model="orderList.storeName"
    clearable
    placeholder="请选择店铺："
    style="width: 20% ;margin-left: 80%;"
  >
    <el-option
      v-for="item in options"
      :key="item.value"
      :label="item.label"
      :value="item.value"
    />
  </el-select>
    <hr>
    <div v-show="items.length==0"><h3>您还未选购商品</h3></div>
    <!-- 选购商品清单 -->
    <el-descriptions v-for="item in items" >
    <el-descriptions-item width="200">{{item.coffeeName  }}</el-descriptions-item>  
    <el-descriptions-item label="数量" width="200">{{item.quantity  }}</el-descriptions-item>  
  </el-descriptions>
    <!-- 提交订单按钮 -->
    <el-button type="primary" style="margin-top: 10px" @click="submitOrder">提交订单</el-button>
  </el-card>
  </el-affix>
</template>

<script lang="ts" setup >
import { onBeforeMount, onMounted, reactive, ref } from 'vue';
import { createCoffee ,getCoffeeList, getStoreList} from '@/utils/api';
import { ElMessage } from 'element-plus';
import { useUserStore } from '@/store/user';
import { ShoppingCart } from '@element-plus/icons-vue'
import { createOrder } from '@/utils/api';
const userStore=useUserStore();
 const form=reactive({
            name: "",
            price:"",
            category: ""
          });
const coffeenumber:any=reactive([])
const fruitnumber:any=reactive([])
const milknumber:any=reactive([])
const coffeeNumber=ref(0)
var coffeeList:any=[]
const milkNumber=ref(0)
var milkList:any=[]
const fruitNumber=ref(0)
const visible=ref(false)
var fruitList:any=[];
var storeList:any=[];
const options: any[] =reactive ([
 ])
 const items:any=reactive([])
 var list: { coffeeName: any; quantity: any; }[]=[]
const orderList=reactive(
  {
    storeName:"",
    items:list
}
)
// 将商品添加到购物车
function addOrder(name:any,number:any){
  let a=0
  for(let i=0;i<items.length;i++){
    if(items[i].coffeeName==name){
  if(number==0){
  items.splice(i,1)
  list.splice(i,1)
  }else
{
  items[i].quantity=number;
  list[i].quantity=number;
  a=1
  }}
  }
  if(a==0&&number!=0){
items.push({coffeeName:name,quantity:number})
list.push({coffeeName:name,quantity:number})
}

    }

// 管理员添加饮料品种
  function addNewCoffee(){
    if(form.category.length!=0&&form.name.length!=0&&form.price.length!=0){
      createCoffee(form).then(res=>{  
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
// 提交订单
function submitOrder(){
  if(orderList.storeName==''){
    ElMessage.error('请先选择店铺')
  }
  if(orderList.items.length==0){
    ElMessage.error('请选择您的商品')
  }
var form=
  {
    storeName:orderList.storeName,
    items:list
}
console.log(form)
  if(orderList.storeName!=''&&orderList.items.length!=0){
  createOrder(form).then(res=>{ 
    console.log(res.data)
  if(res.code==101){
    ElMessage({
    message: '下单成功',
    type: 'success',
  })
     } 
})
  }
}
  // 获取咖啡列表
  onMounted(()=>{
    // 获取咖啡列表
        getCoffeeList("咖啡").then(res=>{
          coffeeList=res.data
          coffeeList.forEach((item: any) => {
    coffeenumber.push(0)
     });
       coffeeNumber.value=res.data.length;
        });
// 获取奶茶列表
getCoffeeList("奶茶").then(res=>{
          milkList=res.data
          milkList.forEach((item: any) => {
    milknumber.push(0)
     });
       milkNumber.value=res.data.length;
        });
//获取果茶列表
getCoffeeList("果茶").then(res=>{
          fruitList=res.data
          fruitList.forEach((item: any) => {
    fruitnumber.push(0)
     });
       fruitNumber.value=res.data.length;
        });
// 获取店家信息
getStoreList().then(res=>{
          storeList=res.data;
     storeList.forEach((item: any) => {
     options.push({value:item.name,
      label: item.name,
     })
     });
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