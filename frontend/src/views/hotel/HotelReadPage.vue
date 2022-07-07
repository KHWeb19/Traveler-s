<template>
<div align="center">

    <table style="width: 900px;">
        <tr>
            <td>
                <h2 class="pageTit">{{bmHotel.hotelName}} 상세 정보</h2>  
            </td>
            <td align="center">
                <router-link :to="{ name: 'BHotelListPage' }">
                    <button id="button"> 목록 </button>
                </router-link>  
            </td>
        </tr>

        <tr>
            <td colspan="2">
                <hotel-read v-if="bmHotel" :bmHotel="bmHotel"/>
                <p v-else>로딩중 입니다.</p>
                <br>
                <br>
            </td>
        </tr>

        <tr>
            <td>
                <router-link :to="{ name: 'BHotelModifyPage', params: { hotelNo } }">
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

<style>
.pageTit {
  padding: 50px 0px 30px 0px;
  font-family: 'NanumSquareRound';
  font-size: 2.0rem;
  line-height: 1.25;
  letter-spacing: -.01em;
  color: #202020;
  font-weight: 900;
}
.pageTit:after {
    content: '';
    display: inline-block;
    width: 4px;
    height: 4px;
    margin-bottom: 24px;
    border-radius: 50%;
    background-color: #e63668;
}

#button {
    text-decoration: none;
    position: relative;
    padding: 0 15px;
    color: #404040;
    font-weight: 600;
    font-size: 15px;
    line-height: 29px;
}

#button:hover {
  color: #569aff;
}
</style>