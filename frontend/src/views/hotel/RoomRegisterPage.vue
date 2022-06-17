<template>
  <div>
    <room-register-form @submit="onSubmit"/>
  </div>
</template>

<script>
import RoomRegisterForm from '@/components/hotel/RoomRegisterForm.vue'
import axios from 'axios'
export default {
    name: 'RoomRegisterPage',
    components: {
        RoomRegisterForm,
    },
    methods: {
        onSubmit (payload) {
            const { roomName, roomType, perssonel, roomInfo, files } = payload
            let formData = new FormData()
            let hotel = {
                   roomName, 
                   roomType, 
                   perssonel,
                   roomInfo, 
                   files
            }
      
            formData.append('hotel',new Blob([JSON.stringify(hotel)],{type: "application/json"}))
            
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
                    name: 'HotelListPage'
                })
            })
            .catch(() => {
                alert('오류가 발생하였습니다.')
            })
        }
    }
}
</script>

<style>
</style>