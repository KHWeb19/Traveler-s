<template>
    <div>
        <v-container class="container">
            <h2>회원가입</h2>
            <v-radio-group v-model="auth" row>
                    <v-radio v-for="kinds in kindsOfMember" :key="kinds" :label="`${kinds}`" :value="kinds"> 
                    </v-radio>
            </v-radio-group>
            
            <v-text-field  class="email" :rules="emailRules" v-model="email"
                label="아이디(이메일)" type="text" prepend-icon="mdi-email-multiple" >
            </v-text-field>
            <v-text-field  class="password" :rules="passwordRules" v-model="password"
                label="비밀번호" type="password" prepend-icon="mdi-lock">
            </v-text-field>
            <v-text-field  class="password-check" :rules="passwordCheckRules"  v-model="passwordChecking"
                label="비밀번호확인" type="password" prepend-icon="mdi-lock">
            </v-text-field>
            <v-text-field class="name" v-model="name"
                label="이름" type="text" prepend-icon="mdi-account">
            </v-text-field>
            <div class="phone-number">
                <table v-if="numberCheck == false">
                    <tr>
                        <td><v-icon>mdi-cellphone</v-icon></td>
                        <td>
                            <input class="cell-phone" type="text" v-model="mobile">
                            <v-btn  @click="checkPhoneNumber()">
                            번호인증
                            </v-btn>   
                        </td>
                    </tr>
                </table>
                 <table v-if="numberCheck == true">
                    <tr>
                        <td><v-icon>mdi-cellphone</v-icon></td>
                        <td>
                            <input class="cell-phone" type="text" v-model="mobile">
                            <v-btn  @click="checkPhoneNumber()">
                            재전송
                            </v-btn>   
                        </td>
                    </tr>
                </table>
            </div>
            <div>
                <table v-if="numberCheck == true && this.certification == false">
                    <tr>
                        <td><v-icon>mdi-cellphone</v-icon></td>
                        <td>
                            <input class="authentication" type="text" v-model="submitNum">
                            <v-btn @click="checkNumber()">
                            확인
                            </v-btn>   
                        </td>
                    </tr>
                </table>
                <table v-if="numberCheck == true && this.certification == true">
                    <tr>
                        <td><v-icon>mdi-cellphone</v-icon></td>
                        <td>
                            <input class="authentication" type="text" v-model="submitNum" readonly>
                            <v-btn @click="checkNumber()" disabled>
                            확인
                            </v-btn>   
                        </td>
                    </tr>
                </table>
            </div>
            
            <div class="button">
            <v-btn text @click="signUp()">
                    가입
            </v-btn>   
            <v-btn class="grey--text" text @click="cacelSignUp()">
                        취소
            </v-btn>
            </div>
        </v-container>
    </div>
</template>

<script>

import axios from 'axios'


export default {  
    name: 'MemberSignUp',
    props: {
        certification:{
            type: Boolean
        }
    },
    data () {
        return {
            signUpDialog: false,
            password: '',
            mobile: '',
            email: '', 
            auth: '',
            name:'',
            submitNum:'',
            numberCheck: false,
            kindsOfMember: [
                '개인',
                '사업자'
            ],
            radioGroup: '사용자',
            passwordChecking: '',
            passwordCheckRules: [v => this.password ===v || '비밀번호가 일치하지않습니다' ],
            userIdRules:[
                            v => !!v || '이름을 작성해주세요',
                            v =>  /^[a-zA-Z0-9]*$/.test(v) || '영문+숫자로만 입력해주세요',
                            v => !(v && v.length > 15) || 'ID는 15자를 넘길수없습니다.',
                            v => !/[~!@#$%^&*()_+{}]/.test(v) || '특수문자를 넣을수없습니다.',
                            v => !(v && v.length < 2) || '2자리이상으로해주세요'

            ],
            emailRules: [
                            v => !! v || '이메일을 작성해주세요.',
                            v => /.+@.+\..+/.test(v) || '이메일 형식으로 작성해주세요',
            ],
            mobileRules: [
                            v => !!v || '휴대폰 번호를 작성해주세요',
                            v => /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/.test(v)|| '휴대폰 번호를 작성해주세요'
                           

            ],
            passwordRules: [
                            v => !! v || '비밀번호를 작성해주세요.',
                            v =>  /^[a-zA-Z0-9]*$/.test(v) || '영문+숫자로만 입력해주세요',
                            v => !(v && v.length < 8) || '8자리이상으로해주세요' ,
                            v => !(v && v.length > 15) || '15자리를 넘길수없습니다.' 
            ]
        }
    },
    methods: {
        signUp () {
        const { userId, password, email, nickname } = this
        const auth = this.radioGroup
        const validate = this.$refs.form.validate();
            if (validate){
                axios.post('http://localhost:7777/member/register', { userId, password, email, nickname, auth })
                    .then(res => {
                        if(res.data.message == "가입 되었습니다"){
                        alert(res.data.message)
                        this.signUpDialog = false
                        this.$router.go()
                        }else{
                        alert(res.data.message)        
                        }
                        })
                    
                        .catch(() => {
                        alert('오류발생')
                            })
             
            }
        },
        checkPhoneNumber () {
            this.numberCheck = true
            const mobile = this.mobile
            console.log(mobile)
            this.$emit('checkPhoneNumber', mobile)

        },
        checkNumber () {
            const submitNum = this.submitNum
            console.log(submitNum)
            this.$emit('checkNumber', submitNum)
        },
        cacelSignUp(){
            this.$router.go(-1)
        }

    }
}
</script>

<style scoped>
.container {
    margin-top: 100px;
    width:500px;
}
.email,
.password,
.password-check,
.name{
    width:450px;
}
.cell-phone{
    width:330px;
    margin-left: 5px;
    margin-right: 15px;
    border-bottom: 1px solid;
    outline: none;
}
.button{
    margin-left: 150px; 
    margin-top: 30px;
}
.authentication{
    width:330px;
    margin-left: 5px;
    margin-right: 15px;
    border-bottom: 1px solid;
    outline: none;
}
.phone-number{
    margin-bottom: 30px;

}
</style>