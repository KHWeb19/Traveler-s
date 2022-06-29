<template>
  <v-app-bar app color="#ffffff" height="90px">
    <v-col id="BarBtn" v-if="!isLoggedIn" />
    <v-col id="BarBtn" v-else>
      <v-app-bar-nav-icon @click="drawer = !drawer" />
    </v-col>
    <v-col>
      <v-sheet justify="center" id="HomeButton" @click="home">
        <img src="@/assets/TeamLogo.jpg" />
      </v-sheet>
    </v-col>
    <LoginForm />
    <v-navigation-drawer disable-resize-watcher 
                         temporary 
                         app 
                         hide-overlay
                         v-model="drawer">
      <NavDrawer :userInfo="user"/>
    </v-navigation-drawer>
  </v-app-bar>
</template>

<script>
import { mapState, mapActions } from 'vuex'
import router from '@/router'

import LoginForm from './LoginForm.vue'
import NavDrawer from './NavDrawer.vue';

export default {
  name: "MainHeader",
  
  components: {
    LoginForm,
    NavDrawer,
  },
  data() {
    return {
      drawer: false,
      items: [],
      group: null,
      loginCheck: true,
    };
  },
  computed: {
    ...mapState(["isLoggedIn"]),
    ...mapState(["user"])
  },
  methods: {
    onClickLogout() {
      this.$store.dispatch("attemptLogout");
    },
    home() {
      (window.location.pathname !== "/") ? router.push("/") : router.go(0);
    },
    checkLogin() {
      this.loginCheck = true
      const login = this.login
      console.log(login)
      this.$emit('checkLogin', login)
    },
    ...mapActions(["setUser"])
  },
  mounted() {
    if (this.isLoggedIn){
      this.setUser();    
    }
  }
}

</script>

<style scoped>
.container {
  margin: 0;
  padding: 0;
}

.v-app-bar {
  margin: 0;
  padding: 0;
  color: rgb(255, 255, 255);
  margin-bottom: 0%;
}

.v-card {

  margin-bottom: 10px;
}

#NavDrawer {
  height: 600px;
}

#HomeButton {
  z-index: 1;
  widows: 200px;
  height: 90px;
  padding: 0;
  margin: 0;
  padding-right: 2%;
}

#BarBtn {
    padding: 0;
    width: 50px;
}
</style>