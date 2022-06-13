<template>
    <v-container class="content">
        <v-row justify="center">
            <v-col>
                <ul>
                    <li class="content_body--input">
                        <input class="content_body--input--field" type="text" v-model="email" placeholder="아이디">
                    </li>
                    <li class="content_body--input">
                        <input class="content_body--input--field" type="password" v-model="password" placeholder="비밀번호">
                    </li>
                    <li class="content_body--input">
                        <v-btn @click="clickBtnEmail" class="primary" width="400px">로그인</v-btn>
                    </li>
                </ul>
            </v-col>
        </v-row>
        <v-row justify="center">
            <v-col>
            </v-col>  
        </v-row>
        <v-row>
            <v-col>
                <img src="../../assets/img/login_or.png">
            </v-col>  
        </v-row>
        <v-row justify="center">
            <v-col>
                <ul>
                    <li class="content_body--buttons">
                        <button @click="clickBtnGoogle"><img src="../../assets/img/login_google.png" width="100px" height="100px"></button>
                    </li>
                    <li class="content_body--buttons">
                        <button @click="clickBtnNaver"><img src="../../assets/img/login_naver.png" width="100px" height="100px"></button>
                    </li>
                </ul>
            </v-col>
        </v-row>
            
    </v-container> 
</template>

<script>
import { GOOGLE_URL, NAVER_URL  } from "@/const/urls"
import axios from "axios"
import router from "@/router"

import Vue from 'vue'
import cookies from "vue-cookies"

Vue.use(cookies)

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
            axios.post("http://localhost:7777/login", payload, {withCredentials: true})
            .then((res) => {
            localStorage.setItem("access_token", res.data.accessToken)

            router.push("/")
            })
            .catch(() => alert("Invalid Username or Password"))
        },

        clickBtnGoogle(){
            alert(GOOGLE_URL)
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
        list-style-type: none
    }
    .content {
        margin: 50px 4px 4px 4px;
        padding: 4px;
        text-align: center;
    }
    .content_body--input {
        margin: 10px;
        padding: 8px;
    }
    .content_body--input--field{
        line-height: 40px;
        width: 400px;
    }

    .content_body--button-kakao {
        border-radius: 50%;
    }
    .content_body--buttons{
        display: inline-block;
        margin: 4px;
        padding: 4px;
    }
</style>