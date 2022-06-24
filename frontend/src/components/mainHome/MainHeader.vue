<template>
  <v-container>
    <v-app-bar app color="#ffffff" height="90px">
      <v-col v-if="!isLoggedIn">
      <v-app-bar-nav-icon id="BarBtn" @click="drawer = false"></v-app-bar-nav-icon>
      </v-col>
      <v-col v-else>
      <v-app-bar-nav-icon id="BarBtn" @click="drawer = true"></v-app-bar-nav-icon>
      </v-col>
      <v-col id="HomeButton" @click="home">
        <img src="@/assets/TeamLogo.jpg" />
      </v-col>
      <v-col id="Login">
        <v-col class="UserSpace" v-if="!isLoggedIn">
          <div>
            <ul>
              <li id="LBotton"><a href="/login">
                  <v-btn>로그인</v-btn>
                </a></li>
              <li id="RBotton"><a href="/signup">
                  <v-btn>회원가입</v-btn>
                </a></li>
            </ul>
          </div>
        </v-col>
        <v-col class="UserSpace" v-else>
          <div>
            <ul>
              <li id="LBotton">
                <v-card class="mx-auto" max-width="300" tile>
                </v-card>
              </li>
              <li id="RBotton"><button @click="onClickLogout">
                  <v-btn>로그아웃</v-btn>
                </button></li>
            </ul>
          </div>
        </v-col>
      </v-col>
    </v-app-bar>
    <v-navigation-drawer v-model="drawer" absolute temporary>
      <v-list nav dense>

        <v-list-item-group v-model="group">
          <v-list-item href="/mypage">
            <v-list-item-title>마이페이지</v-list-item-title>
          </v-list-item>
          <v-list-item href="">
            <v-list-item-title>위시리스트</v-list-item-title>
          </v-list-item>
          <v-list-item href="">
            <v-list-item-title>예약 내역 확인</v-list-item-title>
          </v-list-item>
        </v-list-item-group>

        <v-list-item-group v-model="group">
        <v-list-item href="/mypage">
            <v-list-item-title>마이페이지</v-list-item-title>
          </v-list-item>
          <v-list-item href="">
            <v-list-item-title>위시리스트</v-list-item-title>
          </v-list-item>
          <v-list-item href="">
            <v-list-item-title>예약 내역 확인</v-list-item-title>
          </v-list-item>
          <v-list-item href="">
            <v-list-item-title>관리자 메뉴얼</v-list-item-title>
          </v-list-item>
          <v-list-item href="">
            <v-list-item-title>예약관리</v-list-item-title>
          </v-list-item>
          <v-list-item href="/roomRegister">
            <v-list-item-title>객실등록</v-list-item-title>
          </v-list-item>
          <v-list-item href="">
            <v-list-item-title>객실설정</v-list-item-title>
          </v-list-item>
          <v-list-item href="">
            <v-list-item-title>요금설정</v-list-item-title>
          </v-list-item>
          <v-list-item href="">
            <v-list-item-title>숙박관리</v-list-item-title>
          </v-list-item>
          <v-list-item href="/HotelListPage">
            <v-list-item-title>숙소관리</v-list-item-title>
          </v-list-item>
          <v-list-item href="">
            <v-list-item-title>객실관리</v-list-item-title>
          </v-list-item>
        </v-list-item-group>

      </v-list>
    </v-navigation-drawer>
  </v-container>
</template>

<script>
import { mapState } from 'vuex'
import router from '@/router'

export default {
  name: "MainHeader",

  props: ["userInfo"],

  data() {
    return {
      drawer: false,
      group: null,
      loginCheck: true,

    }
  },

  computed: {

    ...mapState(['isLoggedIn'])
  },

  methods: {
    onClickLogout() {
      this.$store.dispatch("attemptLogout")
    },
    home() {
      (window.location.pathname !== '/') ? router.push('/') : router.go(0)
    },
    checkLogin () {
      this.loginCheck = true
      const login = this.login
      console.log(login)
      this.$emit('checkLogin',login)
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
}

.v-card {
  margin-bottom: 10px;
}

.UserSpace {
  position: absolute;
  width: 200px;
  padding: 0;
  justify-content: space-between;
  align-items: center;
}

.UserSpace ul {
  display: flex;
  justify-content: right;
  align-items: right;
  margin-right: 1%;
}

.UserSpace ul li {
  list-style: none;
  padding-top: 0;
}

.UserSpace ul li a {
  text-decoration: none;
  color: rgb(0, 0, 0);
  position: relative;
  font-size: 30px;
}

.UserSpace-top {
  position: absolute;
  top: 1em;
  list-style: none;
  right: 2em;
}

#RBotton {
  margin-right: 2%;
    margin-left: 3%;
  }
  
  #LBotton {
    margin-right: 3%;
    margin-left: 2%;
  }
  #HomeButton{
    z-index: 1;
    widows: 200px;
    height: 90px;
    padding: 0;
    margin: 0;
    padding-right: 2%;
}
  .v-app-bar{
    color: rgb(255, 255, 255);
  }
  #Login{
    height: 90px;
    padding: 0;
    padding-top: 18px;
    margin: 0;
    padding-right: 10%;
    min-width: 205px;
    max-width: 300px;
  }
  #BarBtn {
    padding: 0;
    width: 50px;
  }
</style>