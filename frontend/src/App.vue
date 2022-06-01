<template>
  <v-app>
      <category v-if="($route.name !== 'Home')"/>
      <v-main>
        <router-view :key="$route.fullPath"/>
      </v-main>
    <petto-footer v-if="($route.name !== 'Home')"/>
  </v-app>
</template>

<script>
import Category from '@/views/Category.vue'
import MainFooter from '@/views/MainFooter.vue'
export default {
  name: 'App',
  components: {
    Category,
    MainFooter
  }
}
</script>

<style>

</style>