<template>
   <div class="home">
        <div id="header">
            <main-page/>
        </div>
    </div>
</template>

<script>
  import MainPage from '../components/mainHome/MainPage.vue'

  export default {
    name: 'HomeView',

    components: {
      MainPage
    },
  }
</script>
