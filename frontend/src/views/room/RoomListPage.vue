<template>
  <div align="center">
    <v-container>
      <table style="width: 800px">
        <tr>
          <td align="left" colspan="2">
            <h2 class="pageTit">객실 관리</h2>
          </td>
        </tr>

        <tr>
          <td align="left">
            <span class="page-count">전체</span>
          </td>
          <td align="right">
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
          </td>
        </tr>

        <tr>
          <td colspan="2">
            <br />
            <router-link
              v-if="hotelNo"
              :to="{
                name: 'RoomRegisterPage',
                params: { hotelNo: this.hotelNo.toString() },
              }"
              class="btn"
            >
              <v-btn>객실등록</v-btn>
            </router-link>
          </td>
        </tr>

        <tr>
          <td align="left" colspan="2">
            <room-list
              v-if="bmRoomList"
              :bmRoomList="bmRoomList"
              @deleteRooms="deleteRooms"
            />
          </td>
        </tr>
      </table>
    </v-container>
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
    };
  },
  computed: {
    ...mapState(["hotelType"]),
    ...mapState(["bmRoomList"]),
  },
  mounted() {
    this.getHotelType();
    console.log(this.bmRoomList);
  },
  methods: {
    ...mapActions(["getHotelType"]),
    ...mapActions(["fetchBmRoomList"]),
    getRoomList(event) {
      this.hotelNo = event.target.value;
      this.fetchBmRoomList(this.hotelNo);
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
  created() {
    this.fetchBmRoomList(this.hotelNo);
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
  padding: 50px 0px 30px 0px;
}
.pageTit {
  padding: 50px 0px 30px 0px;
  font-family: "NanumSquareRound";
  font-size: 2rem;
  line-height: 1.25;
  letter-spacing: -0.01em;
  color: #202020;
  font-weight: 900;
}
.pageTit:after {
  content: "";
  display: inline-block;
  width: 4px;
  height: 4px;
  margin-bottom: 24px;
  border-radius: 50%;
  background-color: #e63668;
}
.page-count {
  margin-left: 15px;
  border: 1px;
  border-bottom: 5px solid #e63668;
  border-radius: 5px;
  padding: 5px 10px;
  outline: none;
  color: #18225c;
  -webkit-text-stroke: 0.7px #18225c;
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
/*table, th, td{
    border-collapse:collapse;
    border: 1px solid black;
}*/
</style>
