<template>
  <section class="wrapper">
    <header>

      <img src="@/assets/TravelLogo.png" class="logoImg" @click="home" />

      <nav>
        <!-- 메뉴 리스트 -->
        <div class="navList">
          <h2>
            <a href="#">공지사항</a>
          </h2>
          <h2>
            <a href="#">항공</a>
          </h2>
          <h2>
            <a href="#">렌터카</a>
          </h2>
          <h2>
            <a href="#">숙박</a>
          </h2>
          <h2>
            <a href="#">맛집</a>
          </h2>
          <h2>
            <a href="#">에디패스</a>
          </h2>
        </div>

      </nav>

      <!-- 로그인, 회원가입 버튼-->
      <div class="login">
        <LoginForm />
      </div>

      <div class="navIcon">
        <v-col id="BarBtn" v-if="!isLoggedIn" />
        <v-col id="BarBtn" v-else>
          <v-app-bar-nav-icon @click="drawer = !drawer" />
        </v-col>
      </div>

      <!-- 로그인시 생기는 메뉴 -->
      <v-navigation-drawer disable-resize-watcher right app hide-overlay v-model="drawer">
        <NavDrawer :userInfo="user" />
      </v-navigation-drawer>
    </header>

  </section>
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
    ...mapActions(["setUser"]),
  },
  mounted() {
    if(this.$store.state.isLoggedIn == true){
      this.setUser()
    }
  }
}

</script>

<style scoped>

  @font-face {
    font-family: 'NanumSquareRound';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_two@1.0/NanumSquareRound.woff') format('woff');
}

   h2, button, div, header, nav, section {
    margin: 0;
    padding: 0;
    color: #606060;
    font-family: Pretendard,-apple-system,BlinkMacSystemFont,Open Sans,Helvetica Neue,sans-serif;
    line-height: 1.5;
    letter-spacing: -0.01em;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
    word-break: keep-all;
    word-wrap: break-word;
    white-space: normal;
}

  .wrapper header .logoImg {
    position: absolute;
    top: 40px;
    left: 70px;
    width: 150px;
    z-index: 10;
}

.wrapper header {
    position: relative;
    min-width: 1136px;
    height: 104px;
    padding: 0 72px;
    -webkit-transition: 0.3s;
    transition: 0.3s;
    background: #fff;
    text-align: center;
    z-index: 101;
}

.wrapper header nav {
    display: inline-block;
    margin: 0 auto;
    padding: 35px 0 0 0;
    text-align: center;
    font-size: 0;
}

.wrapper header nav .navList {
    position: relative;
    display: inline-block;
    font-size: 0;
    z-index: 10;
}

  .wrapper header nav .navList>h2 {
    display: inline-block;
}

.wrapper header nav .navList>h2>a {
    display: block;
    padding: 0 16px;
    color: #202020;
    font-size: 1.3rem;
    line-height: 46px;
    font-family: NanumSquareRound;
    font-weight: 900;
    text-decoration: none;
}

.wrapper header nav .navList>h2>a:hover {
  color: #569aff;
}

.wrapper header nav * {
  vertical-align: top;
}

.login {
  position: absolute;
  display: inline-block;
  top: 45px;
  right: 250px;

  font-family: NanumSquareRound;
}

.navIcon {
  position: absolute;
  display: inline-block;
  top: 41px;
  right: 110px;

}
@media screen and (min-width: 990px) and (max-width: 1070px) {
.wrapper header {
    position: relative;
    min-width: 500px; 
}
}
@media screen and (min-width: 780px) and (max-width: 990px) {
.wrapper header {
    position: relative;
    min-width: 500px;
    height: 200px
}
.wrapper header nav {
    position: absolute;
    top: 100px;
    right: 13%;
    padding: 35px 5%;
}

}
@media screen and (max-width: 780px) {
  .wrapper header {
    position: relative;
    min-width: 500px;
    height: 200px
}
  .wrapper header nav {
    position: absolute;
    top: 100px;
    right: 3%;
    padding: 35px 5%;
}
}
</style>