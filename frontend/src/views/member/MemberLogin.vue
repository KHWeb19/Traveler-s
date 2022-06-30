<template>
<div>
    <div class="content">
        <v-row>
            <v-col>
                <p class="pageTit pageTitC">편안한 여행, <br>Traveler's로 시작하세요</p>

                <ul>
                    <li class="content_body--li">
                        <input class="content_body--li--field" type="text" v-model="email" placeholder="아이디를 입력해주세요.">
                    </li>
                    <li class="content_body--li">
                        <input class="content_body--li--field" type="password" v-model="password" placeholder="비밀번호를 입력해주세요.">
                    </li>
                    <li class="content_body--li">
                        <v-btn @click="clickBtnEmail" class="primary" width="300px">로그인</v-btn>
                    </li>
                </ul>
            </v-col>
        </v-row>

        <v-row>
            <v-col>
                <ul>
                    <li class="content_body--li--link">
                        <p>아이디 찾기</p>
                    </li>
                    <li class="content_body--li--link">
                        <p>비밀번호 찾기</p>
                    </li>
                    <li class="content_body--li--link">
                        <router-link :to="{path: '/signup'}" style="text-decoration: none; color: black;">회원가입</router-link>
                    </li>
                </ul>
            </v-col>  
        </v-row>

        <v-row>
            <v-col>
                <img src="../../assets/img/login_or.png" class="orimg">
            </v-col>  
        </v-row>
        <v-row>
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
    </div> 
        <main-footer-top/>
</div>
</template>

<script>
import { GOOGLE_URL, NAVER_URL  } from "@/const/urls"
import MainFooterTop from '@/components/mainHome/MainFooterTop.vue'

export default{
    components: {
        MainFooterTop
    },
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

@font-face {
    font-family: 'NanumSquareRound';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_two@1.0/NanumSquareRound.woff') format('woff');
}
    .pageTit {
        display: block;
        margin: 0 0 48px 0;
        color: #202020;
        font-weight: 900;
        font-family: 'NanumSquareRound';
        font-size: 2.0rem;
        line-height: 1.25;
        letter-spacing: -.01em;
    }

    .pageTit:after {
        content: '';
        display: inline-block;
        width: 4px;
        height: 4px;
        margin-bottom: 24px;
        border-radius: 50%;
        background-color: #e63668;
}

    ul {
        list-style-type: none;
    }

    .content {
        text-align: center;
        margin: 100px;
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

    .orimg {
        margin-left: 15px;
    }

    .primary {
        color: #1d68dc;;
        height: 48px;
    }

    .content_body--buttons{
        display: inline-block;
        margin: 10px;
        padding: 10px;

    }

    input[type=text],  input[type=password] {
        min-width: 100px;
        height: 48px;
        padding: 0 15px;
        color: #606060;
        font-size: inherit;
        line-height: 48px;
        border-radius: 8px;
        border: 1px solid #EAEAEA;
        background: #fff;
    }

    input:focus {
        outline: none !important;
        border:1px solid #1d68dc;
}

</style>