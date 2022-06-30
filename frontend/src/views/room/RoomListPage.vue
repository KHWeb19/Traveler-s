<template>
  <div>
    <h2>숙소 관리</h2>
    <span class="page-count">전체</span>
    <label class="hotelNameLabel">* 호텔이름</label>
    <select
      class="hotel-select"
      v-model="hotelNo"
      @change="getRoomList($event)"
    >
      <option :value="''">호텔을 선택하세요.</option>
      <option
        v-for="(hotel, idx) in hotelType"
        :key="idx"
        :value="hotel.hotelNo"
      >
        {{ hotel.hotelName }}
      </option>
    </select>

    <router-link
      v-if="hotelNo"
      :to="{
        name: 'RoomRegisterPage',
        params: { hotelNo: this.hotelNo.toString() },
      }"
      class="btn"
      ><v-btn>객실등록</v-btn></router-link
    >

    <br />
    <room-list :roomList="roomList" @deleteRooms="deleteRooms" />
  </div>
</template>

<script>
import RoomList from "@/components/room/RoomList.vue";
import { mapState, mapActions } from "vuex";
import axios from "axios";

export default {
  name: "RoomListPage",
  components: {
    RoomList,
  },
  data() {
    return {
      hotelNo: "",
      roomList: [],
    };
  },
  computed: {
    ...mapState(["hotelType"]),
  },
  mounted() {
    this.getHotelType();
  },
  methods: {
    ...mapActions(["getHotelType"]),
    getRoomList(event) {
      this.hotelNo = event.target.value;
      console.log(this.hotelNo);
      const hotelNo = event.target.value;
      console.log(hotelNo);
      axios
        .post("http://localhost:7777/room/bm/list", { hotelNo })
        .then((res) => {
          console.log(res);
          this.roomList = res.data;
        });
    },
    deleteRooms(payload) {
      const rooms = payload;

      axios
        .post("http://localhost:7777/room/bm/deleteRooms", rooms)
        .then(() => {
          alert("삭제 되었습니다.");
          this.$router.go();
        })
        .catch(() => {
          alert("실패했습니다.");
        });
    },
  },
};
</script>

<style scoped>
div {
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}
h2 {
  padding: 50px 0px 30px 50px;
}
.page-count {
  margin-left: 50px;
  border: none;
  border-bottom: 5px solid #1890ff;
  border-radius: 5px;
  padding: 5px 10px;
  outline: none;
  color: #1890ff;
}
.btn {
  position: sticky;
  left: 90%;
  text-decoration: none;
}
.hotel-select {
  margin-top: 10px;
  margin-left: 30px;
  width: 200px;
  height: 30px;
  border-radius: 2pt;
  box-shadow: 0 0 0 1pt grey;
  outline: none;
  transition: 0.1s;
}
.hotelNameLabel {
  font-size: 14px;
  margin-left: 50px;
}
</style>
