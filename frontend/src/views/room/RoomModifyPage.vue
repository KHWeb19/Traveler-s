<template>
  <div>
    <room-modify-form v-if="bmRoom" :bmRoom="bmRoom" @submit="onSubmit"/>
    <p v-else>안뜨고있는거임 하.....</p>
  </div>
</template>

<script>

import axios from 'axios'
import { mapActions, mapState } from 'vuex'
import RoomModifyForm from '@/components/room/RoomModifyForm.vue'

export default {
    components: {
        RoomModifyForm,

    },
    props: {
        roomNo: {
            type: String,
            required: true
        }
    },
    computed: {
        ...mapState(['bmRoom'])
    },
    methods: {
        ...mapActions(['fetchBmRoom']),
        onSubmit (payload) {
            const { price, roomType, personnel,roomInfo, files } = payload

            let formData = new FormData()
            let room = {
                   price, 
                   roomType, 
                   personnel,
                   roomInfo, 
                   files,
            }

            formData.append('roomRequest',new Blob([JSON.stringify(room)],{type: "application/json"}))
            
            for (let i = 0; i <  files.length; i++) {
                formData.append('files',files[i].file)
            }

            console.log(files)

            axios.put(`http://localhost:7777/room/bm/${this.roomNo}`,
                formData,{headers: {
                    'Content-Type' : 'multipart/form-data'
                }})
                    .then(res => {
                        alert('수정되었습니다.')
                        console.log(res.data.roomNo)
                        this.$router.push({
                            name: 'BRoomReadPage',
                            params: { roomNo: res.data.toString() }
                        })
                    })
                    .catch(() => {
                        alert('수정 실패하였습니다.')
                    })
        }
    },
    created () {
        this.fetchBmRoom(this.roomNo)
                .catch(() => {
                    alert('DB 조회 실패')
                    this.$router.back()
                })
    }
}
</script>

<style>

</style>