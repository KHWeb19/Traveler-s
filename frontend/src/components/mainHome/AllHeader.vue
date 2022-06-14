<template>
  <v-card flat width="100%" tile>

    <v-toolbar height="90">
      <div>
        <div @click="home"> <img src="@/assets/TeamLogo.jpg" /> </div>
      </div>

      <v-spacer></v-spacer>

      <div class="header" v-if="!isLoggedIn">
        <ul>
          <li><a href="/로그인페이지">로그인</a></li>
          <li><a href="/회원가입페이지">회원가입</a></li>
        </ul>
      </div>

      <div class="header" v-if="isLoggedIn">
        <ul v-if="this.auth == '개인'">
          <li><a>내정보</a>
            <ul>
              <li><a href="/내정보 수정">내정보 수정</a></li>
              <li><a href="/찜리스트">찜리스트</a></li>
              <li><a href="/내게시물">내 게시물</a></li>
              <li><a href="/문의">문의</a></li>
            </ul>
          </li>
          <li><a href="#" @click="logout()">로그아웃</a></li>
        </ul>

        <ul v-else-if="this.auth == '관리자'">
          <li><a>내정보</a>
            <ul>
              <li><a href="/회원관리">회원관리</a></li>
              <li><a href="/문의관리">문의관리</a></li>
              <li><a href="/추가사항">추가사항</a></li>
            </ul>
          </li>
          <li><a href="#">로그아웃</a></li>
        </ul>
      </div>
    </v-toolbar>
  </v-card>
</template>

<script>
import { mapState } from 'vuex';


export default {
  components: {
   
  },
  data() {
    return {
      isLogin: false,
    }
  },
  methods: {
    logout() {
      this.$cookies.remove("user");
      this.isLogin = false;
      this.$router.push({ name: 'HomeView' })
      alert('로그아웃 되었습니다.')
    }
  },
  mounted() {
    console.log('session : ' + this.session)
  },
  computed: {
      ...mapState([]),
      isLoggedIn() {
        if(this.session == null || this.session == '') {
          return false
        } else {
          return true
        }
      },
      auth() {
        return this.session.auth;
      }
  },
};
</script>

<style scoped>
.v-card{
  margin-bottom: 10px;
}
.header {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  padding: 15px 60px;
  justify-content: space-between;
  align-items: center;
}
.header ul {
  display: flex;
  justify-content: right;
  align-items: right;
  margin-right: 1%;
}
.header ul li {
  list-style: none;
}
.header ul li a {
  text-decoration: none;
  padding: 10px 10px;
  color: rgb(0, 0, 0);
  position: relative;
  font-size: 30px;
  margin-left: 10px;
  margin-right: 10px;
}

.header-top {
  position: absolute;
  top: 1em;
  list-style: none;
  right: 2em;
}

</style>