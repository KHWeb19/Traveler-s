<template>
     <member-sign-up    @checkPhoneNumber="checkPhoneNumber"
                        @checkNumber="checkNumber"
                        :certification="certification"/>
</template>


<script>

import MemberSignUp from '@/components/member/MemberSignUpForm.vue'
import axios from 'axios'


export default {
        name: "SignUp",
        components: {
            MemberSignUp
        },
        data (){
            return{
                numStr:'',
                certification: false
            }
        },
        methods: {
            checkPhoneNumber(payload) {
                const mobile = payload
                console.log(mobile)
                axios.post('http://localhost:7777/check-number', {mobile})
                    .then(res => {
                           this.numStr = res.data
                           console.log(this.numStr)
                        })
                    
                        .catch(() => {
                        alert('오류발생')
                            })
            },
            checkNumber(payload) {
                const submitNum = payload
                if(this.numStr == submitNum){
                    alert("인증성공")
                    this.certification = true

                }else{
                    alert("다시 입력 하세요")
                }
            }
        }

}

</script>