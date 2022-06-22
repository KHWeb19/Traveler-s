<template>
  <div>
    <room-register-form @submit="onSubmit"
                        :hotelType="hotelType"/>
  </div>
</template>

<script>
import RoomRegisterForm from '@/components/hotel/RoomRegisterForm.vue'
import axios from 'axios'
import { mapActions, mapState } from 'vuex'
export default {
    name: 'RoomRegisterPage',
    components: {
        RoomRegisterForm,
    },
    computed: {
        ...mapState(["hotelType"])
    },
    methods: {
        ...mapActions(["getHotelType"]),
        onSubmit (payload) {
            const { roomName, roomType, personnel, roomInfo, files ,hotelNo } = payload
            let formData = new FormData()
            let room = {
                   roomName, 
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
                    name: 'hotelListPage'
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