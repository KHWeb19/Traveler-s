<template>
    <div>
        <span>이메일</span>
        <input type="text" v-model="email">
        <span>비밀번호</span>
        <input type="password" v-model="password">
        <button @click="clickBtnLogin">로그인</button>
    </div>

</template>
<script>
import axios from 'axios'
import router from '@/router'
export default{
    data(){
      return {
          email: "",
          password: ""
      } 
    },
    methods:{
        clickBtnLogin(){
            const {email, password} = this
            const payload = {email, password}
            axios.post("http://localhost:7777/login", payload, {withCredentials: true})
            .then((res) => {
            localStorage.setItem("access_token", res.data.accessToken)
            router.push("/")
            })
            .catch(() => alert("Invalid Username or Password"))
        }
    }
}
</script>
