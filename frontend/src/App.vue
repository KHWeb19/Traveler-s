<template>
		<v-main style="width: 100%">
      <MainHeader/>
			<router-view id="routermain" class="page"/>
      <MainFooter/>
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
      MainFooter
      //HomeView
      // HelloWorld,
    },
    data: () => ({
      //
    }),
  };
</script>