<template>
<!-- 这是用户账户信息展示页面 -->
 <div>这是用户展示页面</div>
</template>

<script lang="ts" setup >
import { onMounted } from 'vue';
import { useRouter } from 'vue-router';
const router=useRouter();
// onMounted(()=>{
//     const gotoLoginPage = () => {
//       router.push("/login");
//     };
//     if(sessionStorage.getItem("token") == null){
//       gotoLoginPage()
//     }
// })
</script>

<style scoped>

</style>