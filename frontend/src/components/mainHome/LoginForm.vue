<template>
     <v-col id="Login">
        <v-sheet class="UserSpace1" v-if="!isLoggedIn">
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
        </v-sheet>
        <v-sheet class="UserSpace2" v-else>
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
        </v-sheet>
      </v-col>
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
.UserSpace1{
  position: absolute;
    width: 200px;
    padding: 0;
    margin-top: 3px;
    justify-content: space-between;
    align-items: center;
}
.UserSpace2 {
    position: absolute;
    width: 200px;
    margin-top: 9px;
    padding: 0;
    justify-content: space-between;
    align-items: center;
}
.UserSpace1 ul {
    display: flex;
    justify-content: right;
    align-items: right;
    margin-right: 1%;
}
.UserSpace2 ul {
    display: flex;
    justify-content: right;
    align-items: right;
    margin-right: 1%;
}

.UserSpace1 ul li {
    list-style: none;
    padding-top: 0;
}
.UserSpace2 ul li {
    list-style: none;
    padding-top: 0;
}
.UserSpace1 ul li a {
    text-decoration: none;
    color: rgb(0, 0, 0);
    position: relative;
    font-size: 30px;
}
.UserSpace2 ul li a {
    text-decoration: none;
    color: rgb(0, 0, 0);
    position: relative;
    font-size: 30px;
}

.UserSpace1-top {
    position: absolute;
    top: 1em;
    list-style: none;
    right: 2em;
}
.UserSpace2-top {
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
#Login{
    height: 90px;
    padding: 0;
    padding-top: 18px;
    margin: 0;
    padding-right: 10%;
    min-width: 205px;
    max-width: 300px;
  }

</style>>