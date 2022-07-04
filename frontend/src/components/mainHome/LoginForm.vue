<template>
<!-- header의 로그인, 회원가입 버튼 컴포넌트 -->
<div>
    <!-- (비로그인 상태)로그인, 회원가입 버튼 
    <v-col id="Login">-->
        <!-- <v-sheet class="UserSpace" v-if="!isLoggedIn">-->
          <div class="UserSpace" v-if="!isLoggedIn">
            <ul>
              <li id="LBotton"><a href="/login">
                  로그인
                </a></li>
              <li id="RBotton"><a href="/signup">
                  회원가입
                </a></li>
            </ul>
          </div>
        <!-- </v-sheet> -->

        <!-- (로그인 상태) 로그아웃 버튼 -->
        <v-sheet class="UserSpace2" v-else>
          <div>
            <ul>
              <li id="LBotton">
                <v-card class="mx-auto" max-width="300" tile>
                </v-card>
              </li>
              <li id="RBotton"><button @click="onClickLogout">
                  로그아웃
                </button></li>
            </ul>
          </div>
        </v-sheet>
    <!-- </v-col> -->
</div>
</template>

<script>
import { mapState } from 'vuex'

export default {
    name: 'LoginForm',
    computed: {
        ...mapState(["isLoggedIn"])
    },
    methods: {
        onClickLogout() {
            this.$store.dispatch("attemptLogout");
            alert('ㅂㅂ.')
        },
        checkLogin() {
            this.loginCheck = true;
            const login = this.login;
            console.log(login);
            this.$emit("checkLogin", login);
        }
    },
}

</script>

<style scoped>

.UserSpace {
    position: absolute;
}

.UserSpace ul {
    display: flex;
}

.UserSpace ul li {
    list-style: none;
}

.UserSpace ul li a {
    text-decoration: none;
    position: relative;
    padding: 0 15px;
    color: #404040;
    font-weight: 600;
    font-size: 15px;
    line-height: 29px;
}

.UserSpace ul li a:hover {
  color: #569aff;
}

.UserSpace2 {
    position: absolute;
}

.UserSpace2 ul {
    display: flex;
}

.UserSpace2 ul li {
    list-style: none;
}

.UserSpace2 ul li button {
    text-decoration: none;
    position: relative;
    padding: 0 15px;
    color: #404040;
    font-weight: 600;
    font-size: 15px;
    line-height: 29px;
}

.UserSpace2 ul li button:hover {
  color: #569aff;
}

</style>>