<template>
    <div>
        <v-btn @click="listall">
            리스트
        </v-btn>

    </div>
</template>

<script>
import axios from 'axios'

export default {
    
    name:'listAll',
        methods:{
            listall(){
                axios.get('http://localhost:7777/listall')
                    .then(res => {
                            if(res.data != "가입되었습니다"){
                                console.log('중복')
                                alert(res.data)
                            }else{
                           alert('회원가입이 완료 되었습니다.')
                           }
                        })
                    
                        .catch(() => {
                        alert('오류발생')
                            })
        }
        }
}
</script>