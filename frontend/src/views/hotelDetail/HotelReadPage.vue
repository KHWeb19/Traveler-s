<template>
  <div align="center">
    <m-hotel-read-form :mHotel="mHotel" />
    <!-- <m-search-calender-form/>
     SearchCalenderForm.vue 해당 컴포넌트 내역을 우선
     RoomReadForm 내로 이동시켰습니다.
     검색 작업상 내역을 분리하는 편이 좋다면 주석만 풀어주시면 됩니다.
    -->
    <m-room-read-form :roomList="roomList" />
    <!-- 주석 -->
    <!-- <m-review-read-form :mReview="mReview"/>
        <p v-else> 로딩중......</p> -->
  </div>
</template>

<script>
import { mapActions, mapState } from "vuex";
import MHotelReadForm from "@/components/hotelDetail/HotelReadForm.vue";
import MRoomReadForm from "@/components/hotelDetail/RoomReadForm.vue";
//import MSearchCalenderForm from"@/components/hotelDetail/SearchCalenderForm.vue"

import axios from "axios";
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
      roomList: [],
    };
  },
  components: {
    MHotelReadForm,
    MRoomReadForm,
    //MSearchCalenderForm
},
  computed: {
    ...mapState(["mHotel"]),
  },
  created() {
    const hotelNo = this.hotelNo;
    this.fetchMHotel(this.hotelNo).catch(() => {
      alert("숙소 상세보기 요청 실패!");
      this.$router.push();
    }),
      axios
        .post("http://localhost:7777/room/mem/list", { hotelNo })
        .then((res) => {
          console.log(res.data);
          this.roomList = res.data;
        });
  },
  methods: {
    ...mapActions(["fetchMHotel"]),
  },
};
</script>

<style scoped></style>
