<template>
	<v-app>
		<v-main style="width: 100%">
			<!-- <MainHeader/>-->
			<router-view class="page"/>
			<!-- <MainFooter/>-->
		</v-main>
	</v-app>
</template>

<script>
  import MainHeader from './components/mainHome/MainHeader.vue';
  import MainFooter from './components/mainHome/MainFooter.vue';

  export default {
    name: 'App',

    components: {
      MainHeader,
      MainFooter,
      // HelloWorld,
    },

    data: () => ({
      //
    }),
  };
</script>
