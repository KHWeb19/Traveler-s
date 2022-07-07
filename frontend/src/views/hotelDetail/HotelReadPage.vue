<template>
  <div align="center">
    <m-hotel-read-form :mHotel="hotel" />
    <!-- <m-search-calender-form/>
     SearchCalenderForm.vue 해당 컴포넌트 내역을 우선
     RoomReadForm 내로 이동시켰습니다.
     검색 작업상 내역을 분리하는 편이 좋다면 주석만 풀어주시면 됩니다.
    -->
    <m-room-read-form :roomList="roomList"
                      :checkDate="dates"
                      :people="personnel"
                      @searchRoom="searchRoom" />
    <!-- 주석 -->
    <!-- <m-review-read-form :mReview="mReview"/>
        <p v-else> 로딩중......</p> -->
  </div>
</template>

<script>

import MHotelReadForm from "@/components/hotelDetail/HotelReadForm.vue";
import MRoomReadForm from "@/components/hotelDetail/RoomReadForm.vue";
import axios from 'axios';
//import MSearchCalenderForm from"@/components/hotelDetail/SearchCalenderForm.vue"

export default {
  name: "MHotelReadPage",
  props: {
    hotelNo: {
      type: String,
      required: true,
    },
    payload: {
      type: Object
    },
    mHotel : {
      type :Object
    }
  },
  data() {
    return {
      roomList:[],
      hotel:null,
      dates: [],
      personnel: ''
    }
  },
  components: {
    MHotelReadForm,
    MRoomReadForm,
    //MSearchCalenderForm 
  },
  methods: {
      searchRoom(payload) {
        const {dates, personnel} = payload
        const hotelNo = this.hotelNo
        const keyWord = {dates, personnel, hotelNo}
        this.$store.state.roomKeyWord = keyWord
         axios
        .post("http://localhost:7777/room/mem/list", keyWord)
        .then((res) => {
          console.log(res.data);
          this.roomList = res.data;
        });

      }
  },
  created() {
    console.log('payload' + this.payload)
    if(this.payload){
    const {dates , personnel} = this.payload
    const hotelNo = this.hotelNo;
    const word = {dates, personnel, hotelNo}
    console.log(word)
    this.$store.state.roomKeyWord = word
    this.$store.state.hotel = this.mHotel
    console.log('hotel' + this.$store.state.hotel)
    }
    this.hotel = this.$store.state.hotel
    console.log('roomKeyWord' + this.$store.state.roomKeyWord)
    const keyWord = this.$store.state.roomKeyWord
      axios
        .post("http://localhost:7777/room/mem/list",  keyWord )
        .then((res) => {
          console.log(res.data);
          this.roomList = res.data;
        });
  },

};
</script>

<style scoped></style>
