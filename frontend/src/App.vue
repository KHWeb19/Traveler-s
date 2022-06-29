<template>
  <v-app style="width: 100%">
    <MainHeader />
    <v-main>
      <router-view class="page" />
    </v-main>
    <MainFooter />
  </v-app>
</template>

<script>
import MainHeader from './components/mainHome/MainHeader.vue';
import MainFooter from './components/mainHome/MainFooter.vue';
//import HomeView from './views/HomeView.vue';

export default {
  name: 'App',

  components: {
    MainHeader,
    MainFooter
    //HomeView
    // HelloWorld,
  },

  data: () => ({
    //
  }),
};
</script>