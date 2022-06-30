<template>
  <div align="center">
    <m-hotel-read-form :mHotel="mHotel" />
    <!-- HotelReadPage로 옮긴다면 kakaoMapAPI위치는 여기에   -->
    <m-search-calender-form/>
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
import MSearchCalenderForm from"@/components/hotelDetail/SearchCalenderForm.vue"

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
    MSearchCalenderForm
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
          console.log(res);
          this.roomList = res.data;
        });
  },
  methods: {
    ...mapActions(["fetchMHotel"]),
  },
};
</script>

<style scoped></style>
