<template>
<v-main>
  <v-app style="width: 100%">
    <MainHeader />

      <router-view class="page" />

    <MainFooter />
  </v-app>
</v-main>
</template>

<script>
import MainHeader from './components/mainHome/MainHeader.vue';
import MainFooter from './components/mainHome/MainFooter.vue';
//import HomeView from './views/HomeView.vue';

export default {
  name: 'App',

  components: {
    MainHeader,
    MainFooter,
    //HomeView
    // HelloWorld,
  },

  data: () => ({
    //
  }),
};
</script>
