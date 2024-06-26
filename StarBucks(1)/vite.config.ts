import { fileURLToPath, URL } from 'node:url'
import AutoImport from 'unplugin-auto-import/vite' // 自动导入配置的模块
import Components from 'unplugin-vue-components/vite' // 自动导入组件的模块
import { ElementPlusResolver } from 'unplugin-vue-components/resolvers' // 自动导入 Element Plus 的 Api
import ElementPlus from 'unplugin-element-plus/vite' // 自动导入 Element Plus 的 style
import { defineConfig } from 'vite' // 使用 defineConfig 工具函数，这样不用 jsdoc 注解也可以获取类型提示
import vue from '@vitejs/plugin-vue'
import VueSetupExtend from 'vite-plugin-vue-setup-extend'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [
    vue(),
    VueSetupExtend(),
    AutoImport({
      resolvers: [ElementPlusResolver()],
      dts: 'types/auto-generate/auto-import.d.ts',
  }),
  Components({
      resolvers: [ElementPlusResolver()],
      dts: 'types/auto-generate/components.d.ts',
  }),
  ElementPlus({}),
  ],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    }
  }
})


