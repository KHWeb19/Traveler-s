<template>
  <v-card>
      <v-toolbar>
        <div>
          <v-btn  text plain route :to="{ name: 'Home' }">
            <h1>traveler-s 로고 자리</h1>
          </v-btn>
        </div>

        <v-spacer></v-spacer>

        <div class="header main-menu">
        <v-spacer></v-spacer>
          </div>

          <div class="header" v-if="!isLoggedIn">
            <ul>
              <li><a href="" style="">로그인</a></li>
              <li><a href="" style="">회원가입</a></li>
            </ul>
          </div>

          <div class="header" v-if="isLoggedIn">
            <ul v-if="this.auth == '일반'">
              <li><a href="" style="">1</a></li>
              <li><a href="" style="">2</a></li>
              <li><a href="" style="">3</a></li>
              <li><a href="" style="">4</a></li>
              <li><a href="" style="" @click="logout()">로그아웃</a></li>
            </ul>

            <ul v-else-if="this.auth == '사업자'">
              <li><a href="" style="">1</a></li>
              <li><a href="" style="">2</a></li>
              <li><a href="" style="">3</a></li>
              <li><a href="" style="" @click="logout()">로그아웃</a></li>
            </ul>
          </div>
      </v-toolbar>
  </v-card>     
</template>
