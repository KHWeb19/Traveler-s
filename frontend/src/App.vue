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
  import MainHeader from './components/mainHome/MainHeader.vue';
  import MainFooter from './components/mainHome/MainFooter.vue';
  import Vue from 'vue'
  import cookies from 'vue-cookies'

  Vue.use(cookies)

  export default {
    name: 'App',

    components: {
      MainHeader,
      MainFooter,
      // HelloWorld,
    },
    methods: {
      unLoadEvnet(event) {
        event.preventDefault();
        
      }
    },
    mounted() { 
      window.addEventListener('beforeunload' , this.unLoadEvnet)
    },
    beforeUnmount() {
      window.removeEventListener('beforeunload', this.unLoadEvnet)
    },

    data: () => ({
      //
    }),
  };
</script>
