<template>
<div>
    <h1>숙소 정보</h1>
    <hotel-read v-if="bmHotel" :bmHotel="bmHotel"/>
    <p v-else>로딩중 입니다.</p>
    
    <ul>
        <li><router-link :to="{ name: 'BHotelModifyPage', params: { hotelNo } }">
                수정
        </router-link></li>
        <li><button @click="onDelete">삭제</button></li>
        <li><router-link :to="{ name: 'BHotelListPage' }">
                목록
        </router-link></li>
    </ul>
</div>
</template>

<script>
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
        HotelRead
    },
    computed: {
        ...mapState(['bmHotel'])
    },
    created () {
        this.fetchBmHotel(this.hotelNo)
                .catch(() => {
                    alert('불러오지 못했습니다.')
                    this.$router.push()
                })
    },
    methods: {
        ...mapActions(['fetchBmHotel']),
        onDelete () {
            const { hotelNo } = this.bmHotel
            axios.delete(`http://localhost:7777/hotel/bm/${hotelNo}`)
                    .then(() => {
                        alert('삭제 되었습니다.')
                        this.$router.push({ name: 'BHotelListPage' })
                    })
                    .catch(() => {
                        alert('실패했습니다.')
                    })
        }
    }
}
</script>

<style scoped>

    h1 {
        text-align: center;
        margin-top: 10px;
    }

    ul {
        list-style: none;
        margin-left: 42%;
        margin-top: 100px;
        margin-bottom: 200px;
        color: #569aff;
    }

    li {
        float: left;
        padding: 0 20px;
    }

    a {
        text-decoration:none;
        color: #569aff;
    }
</style>