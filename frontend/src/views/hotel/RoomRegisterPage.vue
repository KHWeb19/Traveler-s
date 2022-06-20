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
            const { roomName, roomType, personnel, roomInfo, files, writer } = payload
            let formData = new FormData()
            let room = {
                   roomName, 
                   roomType, 
                   personnel,
                   roomInfo, 
                   files,
                   writer
            }

            
      
            formData.append('roomRequest',new Blob([JSON.stringify(room)],{type: "application/json"}))
            
            for (let i = 0; i <  files.length; i++) {
                formData.append('files',files[i].file)
            }
           
            axios.post('http://localhost:7777/room/register', formData, {
                headers: {
                    'Content-Type' : 'multipart/form-data'
                }
            }, writer)
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
    }
}
</script>

<style>
</style>