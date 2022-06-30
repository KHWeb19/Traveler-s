<template>
    <v-container class="content" justify="space ground">
        <v-sheet justify="space ground">
            <v-row justify="center">
                <v-col>
                    <ul>
                        <li class="content_body--li">
                            <input class="content_body--li--field" type="text" v-model="email" placeholder="아이디">
                        </li>
                        <li class="content_body--li">
                            <input class="content_body--li--field" type="password" v-model="password"
                                placeholder="비밀번호">
                        </li>
                        <li class="content_body--li">
                            <v-btn @click="clickBtnEmail" class="primary" width="300px">로그인</v-btn>
                        </li>
                    </ul>
                </v-col>
            </v-row>
            <v-row justify="center">
                <v-col>
                    <ul>
                        <li class="content_body--li--link">
                            <p>아이디 찾기</p>
                        </li>
                        <li class="content_body--li--link">
                            <p>비밀번호 찾기</p>
                        </li>
                        <li class="content_body--li--link">
                            <router-link :to="{ path: '/signup' }" style="text-decoration: none; color: black;">회원가입
                            </router-link>
                        </li>
                    </ul>
                </v-col>
            </v-row>
            <v-row>
                <v-col id="lineImg">
                    <img src="../../assets/img/login_or.png">
                </v-col>
            </v-row>
            <v-row justify="center">
                <v-col>
                    <ul>
                        <li class="content_body--buttons">
                            <button @click="clickBtnGoogle"><img src="../../assets/img/login_google.png" width="100px"
                                    height="100px"></button>
                        </li>
                        <li class="content_body--buttons">
                            <button @click="clickBtnNaver"><img src="../../assets/img/login_naver.png" width="100px"
                                    height="100px"></button>
                        </li>
                    </ul>
                </v-col>
            </v-row>
        </v-sheet>
    </v-container>
</template>

<script>
import { GOOGLE_URL, NAVER_URL  } from "@/const/urls"

export default{

    data(){
      return {
          email: "",
          password: ""
      } 
    },
    methods:{
        clickBtnEmail(){
            const {email, password} = this
            const payload = {email, password}
            this.$store.dispatch("attemptLogin", payload)
        },

        clickBtnGoogle(){
            window.location.href = GOOGLE_URL
        },
        clickBtnNaver(){
            window.location.href = NAVER_URL
        }
    }
}

</script>

<style scoped>

    ul {
        list-style-type: none;
    }
    .content {
        margin-top: 10%;
        padding: 0%;
        border: 0%;
        margin-bottom: 2%;
        text-align: center;
    }
    .content_body--li {
        margin: 10px;
        padding: 8px;
    }
    .content_body--li--field{
        line-height: 40px;
        width: 300px;
    }
    .content_body--li--link{
        display: inline-block;
        margin: 4px;
        padding: 4px;
    }

    .content_body--buttons{
        display: inline-block;
        margin: 4px;
        padding: 4px;
    }
    #lineImg {
        padding-top: 0%;
        padding-bottom: 2px;
        padding-left: 41px;
    }
    .v-card {
        width: 500px;
    }
</style>