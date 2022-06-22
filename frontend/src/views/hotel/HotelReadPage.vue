<template>
<div>
    <bm-side-bar/>
    <hotel-read v-if="hotel" :hotel="hotel"/>
    <p v-else>로딩중 입니다.</p>
    
    <div>
        <router-link :to="{ name: 'HotelModifyPage', params: { hotelNo } }">
            <v-btn class="btn1">수정하기</v-btn>
        </router-link>
        <v-btn @click="onDelete" class="btn1">삭제</v-btn>
        <router-link :to="{ name: 'HotelListPage' }" ><v-btn class="btn2">목록</v-btn></router-link>
    </div>

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

<style scoped>
.myButton {
	background:linear-gradient(to bottom, #44c767 5%, #5cbf2a 100%);
	background-color:#44c767;
	border-radius:42px;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-family:Arial;
	font-size:17px;
	padding:15px 25px;
	text-decoration:none;
	text-shadow:0px 0px 26px #2f6627;
}
.myButton:hover {
	background:linear-gradient(to bottom, #5cbf2a 5%, #44c767 100%);
	background-color:#5cbf2a;
}
.myButton:active {
	position:relative;
	top:1px;
}
.btn1 {
    margin-left: 40%;
    margin-bottom: 30px;
    text-align: center;
    word-spacing: 15px;
    border: none;
    border-radius: 10px;
    padding: 10px 35px;
    text-decoration: none;
    display: inline-block;
    font-size: 15px;
    cursor: pointer;
}
.btn2 {
    margin-left: 10px;
    margin-bottom: 30px;
    text-align: center;
    word-spacing: 15px;
    border: none;
    border-radius: 10px;
    padding: 10px 35px;
    text-decoration: none;
    display: inline-block;
    font-size: 15px;
    cursor: pointer;
}
.vbtn {
    position: relative;
    left: 86%;
    bottom: 5px;
}
</style>