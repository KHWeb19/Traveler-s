<template>
  <div align="center" style="display: inline-block">
    <v-container>
      <table style="width: 1000px">
        <tr>
          <td align="left" colspan="2">
            <h2 class="pageTit">나의 예약 내역</h2>
          </td>
        </tr>

        <tr>
          <td align="left">
            <span class="page-count">PENDING</span>
          </td>
          <td>
            <v-row>
              <v-spacer></v-spacer>
              <span>환불 및 위약금 규정</span>
              <payment-dialog/>
              &ensp;
            </v-row>
          </td>
        </tr>

        <tr>
          <td colspan="2">
            <v-row>
              <v-col>
                <my-booking-pending
                  :bookingLists="pendings"
                  @continueReservation="continueReservation"
                  @cancelReservation="cancelReservation"
                ></my-booking-pending>
              </v-col>
            </v-row>
          </td>
        </tr>
      </table>
    </v-container>
  </div>
</template>

<script>
//import MyPageLeftMenu from "@/components/mypage/MyPageLeftMenu.vue";
import axios from "axios"
import { mapActions, mapState } from "vuex";

import MyBookingPending from "@/components/mypage/MyBookingPending.vue";
import PaymentDialog from '@/components/mypage/PaymentDialog.vue';

export default {
  name: "MyPageBookingPending",
  components: {
    //MyPageLeftMenu,

    MyBookingPending,
    PaymentDialog
  },
  data() {
    return {
      status: "",
    };
  },
  computed: {
    ...mapState(["user", "pendings"]),
  },
  methods: {
    ...mapActions(["getStatusType", ""]),
    ...mapActions(["setUser", "getPedndings"]),

    getStatusList(event) {
      this.status = event.target.value;

      console.log(this.status);
    },
    continueReservation(idx){
      this.$router.push({path: `/mReservPage/${idx}`})
    },
    cancelReservation(id){
      axios.post(`http://localhost:7777/reserve/user/cancelReservation/${id}`)
      .then(res => {
        if (res){
          alert("예약 취소 완료")
          console.log(res)
          this.$router.push("/")
        } else {
          alert("예약 취소 완료")
          this.$router.push("/")
        }
        })
    }
  },
  mounted() {
    this.setUser();
    this.getPedndings();
  },
};
</script>

<style>
/*table, th, td{
    border-collapse:collapse;
    border: 1px solid black;
}*/

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
.reservation-select {
  margin-top: 10px;
  margin-left: 30px;
  width: 200px;
  height: 30px;
  border-radius: 2pt;
  box-shadow: 0 0 0 1pt grey;
  outline: none;
  transition: 0.1s;
}
.reservationNameLabel {
  font-size: 14px;
  margin-left: 50px;
}
</style>
