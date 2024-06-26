<template>
<div class="showarea">
<h2>登录或创建一个新账户</h2>
<h4 @click="ifpicked">登录</h4>
<h4 >注册</h4>
<h4>关于星享俱乐部</h4>
</div>
</template>

<script lang="ts" setup name="bottombar">
import { ref } from 'vue';
const picked=ref(false);
function ifpicked()
{

}
</script>

<style scoped>
.showarea{
    width: 100%;
    margin-top: 100px;
}
h2{
    margin-top: 370px;
    margin-left: 80px;
}
h4{
    margin-left: 80px;
}
</style>