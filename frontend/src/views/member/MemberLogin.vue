<template>
    <v-container class="content">
        <div class="content_body">
            <div class="content_body--input">
                <div>
                    <input type="text" v-model="email" placeholder="아이디">
                </div>
                <div>
                    <input type="password" v-model="password" placeholder="비밀번호">
                </div>
                <v-btn @click="clickBtnEmail" class="primary content_body--input--button">로그인</v-btn>
            </div>
            <div>
                <button @click="clickBtnGoogle"><img src="../../assets/img/login_google.png" width="400" height="100"></button>
            </div>
            <div>
                <button @click="clickBtnNaver"><img src="../../assets/img/login_naver.png" width="400" height="100"></button>
            </div>

        </div>
        
    </v-container> 
</template>

<script>
import { GOOGLE_URL, NAVER_URL  } from "@/const/urls"
import axios from "axios"
import router from "@/router"

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
    .content {
        margin: auto;
        text-align: center;
    }
    .content_body {
        display:inline-block;
        width: 400px;
        height: 400px;
    }
    
    .content_body--input {

    }
    .content_body--input--button {
        width: 100%;
        border-radius: 12px;
    }
</style>