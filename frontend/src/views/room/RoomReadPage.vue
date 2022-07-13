<template>
<div align="center">

    <table style="width: 900px;">
        <tr>
            <td>
                <h2 class="pageTit">{{roomType}} 상세 정보</h2>  
            </td>
            <td align="center">
                <router-link :to="{ name: 'BRoomListPage' }">
                    <button id="button"> 목록 </button>
                </router-link>  
            </td>
        </tr>

        <tr>
            <td colspan="2">
                <room-read v-if="bmRoom" :bmRoom="bmRoom"/>
                <p v-else>로딩중 입니다.</p>
                <br>
                <br>
            </td>
        </tr>

        <tr>
            <td>
                <router-link :to="{ name: 'BRoomModifyPage', params: { roomNo } }">
                       <button id="button"> 수정 </button>
                    </router-link>
            </td>
            <td align="right">
                <button id="button" @click="onDelete">삭제</button>
            </td>
        </tr>
 
    </table>

    <br>

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
        },
        roomType: {
            type:String
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