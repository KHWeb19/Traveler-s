<template>
  <div>
    <room-register-form @submit="onSubmit"/>
  </div>
</template>

<script>
import RoomRegisterForm from '@/components/room/RoomRegisterForm.vue'
import axios from 'axios'
import { mapActions, mapState } from 'vuex'
export default {
    name: 'RoomRegisterPage',
    components: {
        RoomRegisterForm,
    },
    props: {
        hotelNo:{
            type: String
        }
    },
    computed: {
        ...mapState(["hotelType"])
    },
    methods: {
        ...mapActions(["getHotelType"]),
        onSubmit (payload) {
            
            const hotelNo = this.hotelNo
            console.log("register" + hotelNo)
            const { price, roomType, personnel, roomInfo, files } = payload
            let formData = new FormData()
            let room = {
                   price, 
                   roomType, 
                   personnel,
                   roomInfo, 
                   files,
                   hotelNo
            }

            
      
            formData.append('roomRequest',new Blob([JSON.stringify(room)],{type: "application/json"}))
            
            for (let i = 0; i <  files.length; i++) {
                formData.append('files',files[i].file)
            }
           
            axios.post('http://localhost:7777/room/register', formData, {
                headers: {
                    'Content-Type' : 'multipart/form-data'
                }
            })
            .then(() => {
                alert('등록 되었습니다.')
                this.$router.push({
                    name: 'BRoomListPage'
                })
            })
            .catch(() => {
                alert('오류가 발생하였습니다.')
            })
        }
    },
    mounted() {
        this.getHotelType()
    
    },
}
</script>

<style>
</style>