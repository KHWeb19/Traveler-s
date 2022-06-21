<template>
<div>
    <h2>숙소 읽기</h2>
    <bm-side-bar/>
    <hotel-read v-if="hotel" :hotel="hotel"/>
    <p v-else>로딩중 입니다.</p>
    <router-link :to="{ name: 'HotelModifyPage', params: { hotelNo } }">
            게시물 수정
        </router-link>
     <button @click="onDelete">삭제</button>
     <router-link :to="{ name: 'HotelListPage' }">
            게시물 목록
        </router-link>
</div>
</template>

<script>
import BmSideBar from '@/components/layout/BmSideBar.vue'
import HotelRead from '@/components/hotel/HotelRead.vue'
import axios from 'axios'
import { mapActions, mapState } from 'vuex'
export default {
    name: 'HotelReadPage',
    props: {
        hotelNo: {
            type: String,
            required: true
        }
    },
    components: {
        BmSideBar,
        HotelRead
    },
    computed: {
        ...mapState(['hotel'])
    },
    created () {
        this.fetchHotel(this.hotelNo)
                .catch(() => {
                    alert('불러오지 못했습니다.')
                    this.$router.push()
                })
    },
    methods: {
        ...mapActions(['fetchHotel']),
        onDelete () {
            const { hotelNo } = this.hotel
            axios.delete(`http://localhost:7777/hotel/${hotelNo}`)
                    .then(() => {
                        alert('삭제 되었습니다.')
                        this.$router.push({ name: 'HotelListPage' })
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