<template>
  <div align="center">
    <h1>호텔 상세보기 페이지</h1>
    <m-hotel-read-form v-if="mHotel" :mHotel="mHotel" :userInfo="user" />
    <p v-else>로딩중......</p>
  </div>
</template>

<script>
import { mapActions, mapState } from "vuex";
import MHotelReadForm from "@/components/hotelDetail/HotelReadForm.vue";

export default {
  name: "MHotelReadPage",
  props: {
    hotelNo: {
      type: String,
      required: true,
    },
  },
  components: {
    MHotelReadForm,
  },
  computed: {
    ...mapState(["mHotel", "user"]),
  },
  created() {
    this.fetchMHotel(this.hotelNo).catch(() => {
      alert("숙소 상세보기 요청 실패!");
      this.$router.push();
    });
  },
  methods: {
    ...mapActions(["fetchMHotel", "setUser"]),
  },
};
</script>

<style scoped></style>
