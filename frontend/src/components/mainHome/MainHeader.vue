<template>
  <v-card flat width="100%" tile>
    <v-toolbar height="90">
        <div id="HomeButton" @click="home">
          <img src="@/assets/TeamLogo.jpg" />
        </div>  
      <v-spacer></v-spacer>
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
              <v-list-group>
                <template v-slot:activator>
                  <a href="/mypage">
                    <v-list-item-title>내정보</v-list-item-title>
                  </a>
                </template>
                <v-list-item-group :value="true" no-action sub-group>
                  <v-list-item>
                    <template>
                      <v-text>내정보수정</v-text>
                    </template>
                  </v-list-item>
                  <v-list-item>
                    <template>
                      <v-text>찜리스트</v-text>
                    </template>
                  </v-list-item>
                  <v-list-item>
                    <template>
                      <v-text>내 게시물</v-text>
                    </template>
                  </v-list-item>
                  <v-list-item>
                    <template>
                      <v-text>문의 내역</v-text>
                    </template>
                  </v-list-item>
                </v-list-item-group>
              </v-list-group>
            </v-card>
          </li>
          <li id="RBotton"><button @click="onClickLogout">
              <v-btn>로그아웃</v-btn>

            </button></li>
        </ul>
        </div>
      </v-col>
      <!--
		<ul v-if="this.auth == '개인'">
        <ul v-else-if="this.auth == '관리자'">
		-->
    </v-toolbar>
  </v-card>
</template>

<script>
import { mapState } from 'vuex'
import router from '@/router'

export default {
  name: "MainHeader",
  data() {
    return {
      // nickName: this.$store.state.userInfo.nickname,
    }
  },
  computed: {
    ...mapState(['isLoggedIn'])
  },

  methods: {
    onClickLogout() {
      this.$store.dispatch("attemptLogout")
    },
     home () {
      (window.location.pathname !== '/') ? router.push('/') : router.go(0)
     }
  }
}

</script>

<style scoped>

.v-card {
  margin-bottom: 10px;
}

.UserSpace {
  padding-right: 2%;
  position: absolute;
  width: 100%;
  padding: 15px 60px;
  justify-content: space-between;
  align-items: center;
  min-width: 300px;
}

.UserSpace ul {
  display: flex;
  justify-content: right;
  align-items: right;
  margin-right: 1%;
}

.UserSpace ul li {
  list-style: none;
  padding-top: 5px;
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
  }
</style>