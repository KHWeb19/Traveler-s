<template>
  <v-card flat width="100%" tile>
    <v-toolbar height="90">
      <div>
        <img src="@/assets/TeamLogo.jpg" />
      </div>
      <v-spacer></v-spacer>
      <div class="header" v-if="!isLoggedIn">
        <ul>
          <li><a href="/login">
              <v-btn>로그인</v-btn>
            </a></li>
          <li><a href="/signup">
              <v-btn>회원가입</v-btn>
            </a></li>
        </ul>
<<<<<<< HEAD
      </div>
      <div class="header" v-else>
        <ul>
          <li>
            <v-card class="mx-auto" max-width="300" tile>
              <v-list-group>
                <template v-slot:activator>
                  <a href="/mypage"><v-list-item-title>내정보</v-list-item-title></a>
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
=======
	</div>
    <div class="header" v-else>
		<ul>
          <li><a>내정보</a>
            <ul>
              <li><a href="/mypage">내정보 수정</a></li>
              <li><a href="/찜리스트">찜리스트</a></li>
              <li><a href="/내게시물">내 게시물</a></li>
              <li><a href="/문의">문의</a></li>
            </ul>
>>>>>>> 4b3156859929278494b7209b7347c9d6cf7165e2
          </li>
          <li><button @click="onClickLogout">
              <v-btn>로그아웃</v-btn>
            </button></li>
        </ul>
      </div>
    </v-toolbar>
  </v-card>
</template>

<script>
import { mapState } from 'vuex'

export default {
  name: "MainHeader",
  data() {
    return {
      nickName: this.$store.state.userInfo.nickname,
    }
  },
  computed: {
    ...mapState(['isLoggedIn'])
  },

  methods: {
    onClickLogout() {
      this.$store.dispatch("attemptLogout")
    }
  }
}

</script>

<style scoped>

.v-card {
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