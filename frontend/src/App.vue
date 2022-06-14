<template>
	<v-app>
		<v-main style="width: 100%">
			<!-- <MainHeader/>-->
      <MainHeader/>
			<router-view class="page"/>
      <MainFooter/>
			<!-- <MainFooter/>-->
		</v-main>
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