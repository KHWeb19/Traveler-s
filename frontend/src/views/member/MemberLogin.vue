<template>
    <v-container>
        <!--<router-link to="/loginEmail">이메일로 로그인</router-link>-->
        <div class="content_body">
            <div>
                <v-btn @click="clickBtnEmail" class="primary">로그인</v-btn>
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

export default{

    methods: {
        clickBtnEmail(){
            this.$router.push({name: "loginEmail"})
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
    .content_body {
            width: 400px;
            height: 400px;
            justify-content: center;
}
</style>