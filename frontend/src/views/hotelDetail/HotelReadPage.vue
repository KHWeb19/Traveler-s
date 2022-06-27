<template>
    <div align="center">
        <m-hotel-read-form :mHotel="mHotel"/>
        <!-- HotelReadPage로 옮긴다면 kakaoMapAPI위치는 여기에 -->
        <!--<m-search-bar-form/>
        <m-room-read-form :mRoom="mRoom"/>
        <m-review-read-form :mReview="mReview"/>
        <p v-else> 로딩중......</p> -->
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import MHotelReadForm from '@/components/hotelDetail/HotelReadForm.vue'
//import MRoomReadForm from '@/components/hotelDetail/RoomReadForm.vue'

export default {
    name: 'MHotelReadPage',
    props: {
        hotelNo: {
            type: String,
            required: true
        },
      //  roomNo: {
     //       type: String,
      //      required: true
      //  }
},
    components: {
        MHotelReadForm,
     //   MRoomReadForm,
    },
    computed: {
        ...mapState(['mHotel']),
        //...mapState(['mRoom'])
    },
    created () {
        this.fetchMHotel(this.hotelNo)
                .catch(() => {
                    alert('숙소 상세보기 요청 실패!')
                    this.$router.push()
                })
      //  this.fetchMRoom(this.roomNo)
              //  .catch(() => {
              //      alert('객실 상세보기 요청 실패!')
              //  })                
    },
    methods: {
        ...mapActions(['fetchMHotel']),            
     //   ...mapActions(['fetchRoom']),     
}
}
</script>


<style scoped>

</style>