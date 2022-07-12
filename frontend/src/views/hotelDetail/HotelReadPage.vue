<template>
  <div align="center">
    <m-hotel-read-form :mHotel="mHotel"
                        :payload="keyWord"
                        :hotelNo="hotelNo" /> 
    <!-- <m-search-calender-form/>
     SearchCalenderForm.vue 해당 컴포넌트 내역을 우선
     RoomReadForm 내로 이동시켰습니다.
     검색 작업상 내역을 분리하는 편이 좋다면 주석만 풀어주시면 됩니다.
    -->
    <!-- 주석 -->
    <!-- <m-review-read-form :mReview="mReview"/>
        <p v-else> 로딩중......</p> -->
        
  </div>
</template>

<script>

import MHotelReadForm from "@/components/hotelDetail/HotelReadForm.vue";

import { mapActions, mapState } from 'vuex';
//import MSearchCalenderForm from"@/components/hotelDetail/SearchCalenderForm.vue"

export default {
  name: "MHotelReadPage",
  props: {
    hotelNo: {
      type: String,
      required: true,
    },
  },
  data() {
    return {
      roomList:[],
      dates: [],
      personnel: '',
      keyWord: null
    }
  },
  components: {
    MHotelReadForm,
    //MSearchCalenderForm 
  },
  computed: {
      ...mapState(['mHotel'])
    },
  methods: {
     ...mapActions(['fetchMHotel']),
  },
  created() {
    const payload = JSON.parse(localStorage.getItem('vuex'))
    this.keyWord =  payload.keyWord.hotelReadKeyword
    console.log('keyword')
    console.log(this.keyWord)
    this.fetchMHotel(this.hotelNo)
  }
};
</script>

<style scoped></style>
