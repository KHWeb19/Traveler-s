<template>
  <v-app>
    <AllHeader/>
    <HomeView />
    <Allfooter/>
  </v-app>
</template>

<script>
  import AllHeader from './components/mainHome/AllHeader.vue';
  import Allfooter from './components/mainHome/AllFooter.vue';
  import HomeView from './views/HomeView.vue';

  export default {
    name: 'App',

    components: {
      AllHeader,
      Allfooter,
      HomeView
      // HelloWorld,
    },

    data: () => ({
      //
    }),
  };
</script>
