<template>
<div>
    <h2>숙소 읽기</h2>
    <room-read v-if="bmRoom" :bmRoom="bmRoom"/>
    <p v-else>로딩중 입니다.</p>
    <router-link :to="{ name: 'BRoomModifyPage', params: { roomNo } }">
            수정
        </router-link>
     <button @click="onDelete">삭제</button>
     <router-link :to="{ name: 'BRoomListPage' }">
            목록
        </router-link>
</div>
</template>

<script>
import RoomRead from '@/components/room/RoomRead.vue'
import axios from 'axios'
import { mapActions, mapState } from 'vuex'
export default {
    name: 'RoomReadPage',
    props: {
        roomNo: {
            type: String,
            required: true
        }
    },
    components: {
        RoomRead
    },
    computed: {
        ...mapState(['bmRoom'])
    },
    created () {
        this.fetchBmRoom(this.roomNo)
                .catch(() => {
                    alert('불러오지 못했습니다.')
                    this.$router.push()
                })
    },
    methods: {
        ...mapActions(['fetchBmRoom']),
        onDelete () {
            axios.delete(`http://localhost:7777/room/bm/${this.roomNo}`)
                    .then(() => {
                        alert('삭제 되었습니다.')
                        this.$router.push({ name: 'BRoomListPage' })
                    })
                    .catch(() => {
                        alert('실패했습니다.')
                    })
        }
    }
}
</script>

<style>

</style>