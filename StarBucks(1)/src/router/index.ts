//1.1 引入创建路由的函数 以及采取的路由模式（hash还是history）
import { createRouter, createWebHashHistory} from 'vue-router'
//1.2 引入需要展示的组件
import accountView from '@/views/accountView.vue'
import addressView from '@/views/addressView.vue'
import storeView from '@/views/storeView.vue'
import homeView from '@/views/homeView.vue'
import loginView from '@/views/loginView.vue'
import  registerView  from '@/views/registerView.vue'
// 2 创建一个路由: 映射关系
const router = createRouter({
  // 2.1 指定采用的路由模式: hash
  history: createWebHashHistory(),
  // 2.2 配置路由映射关系
  routes: [
    {
      path: '/',
      name: 'home',
      component: homeView
    },
    {
        path: '/account',
        name: 'account',
        component: accountView
      },
      {
        path: '/login',
        name: 'login',
        component: loginView
      },
      {
        path: '/register',
        name: 'register',
        component: registerView
      },
    {
      path: '/address',
      name: 'address',
      component: addressView
    },
    {
        path: '/store',
        name: 'store',
        component: storeView
      }
  ]
})

export default router
