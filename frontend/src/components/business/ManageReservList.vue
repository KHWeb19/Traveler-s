<template>
  <v-container>
    <template>
      <!-- 서치 시간없으면 빼도 OK -->
      <div align="center" style="width: 80%">
        <v-col>
          <v-row>
            <v-text-field
              class="search"
              v-model="keyWord"
              label="Search"
              placeholder="키워드를 입력해주세요."
              single-line
              hide-details
            ></v-text-field>
            <v-col cols="2" md="1">
              <v-btn id="searchBtn" dark small>
                <v-icon> mdi-magnify </v-icon>
              </v-btn>
            </v-col>
          </v-row>
        </v-col>
      </div>
    </template>
    <br />

    <template>
      <div>
        <table style="width: 80%">
          <tr>
            <th align="center" width="160">체크인</th>
            <th align="center" width="160">체크아웃</th>
            <th align="center" width="300">객실명</th>
            <th align="center" width="150">고객명</th>
            <th align="center" width="150">숙박인원</th>
            <th align="center" width="100"></th>
          </tr>
          <tbody>
            <tr
              v-if="
                !ceoBookingLists ||
                (Array.isArray(ceoBookingLists) && ceoBookingLists.length === 0)
              "
            >
              <td colspan="5">현재 예약 고객이 없습니다!</td>
            </tr>

            <tr
              v-else
              v-for="(ceoBookingList, idx) in ceoBookingLists"
              :key="idx"
            >
              <td align="center">
                <!-- 체크인 날짜 -->
                <span>{{ ceoBookingList.startDate }}</span>
              </td>
              <td align="center">
                <!-- 체크아웃 날짜 -->
                <span>{{ ceoBookingList.endDate }}</span>
              </td>

              <td align="center">
                <!-- 객실명 -->
                <v-col>
                  <span>{{ ceoBookingList.roomType }}</span>
                </v-col>
              </td>
              <td align="center">
                <!-- 고객명 -->
                <span>{{ ceoBookingList.username }}</span>
              </td>
              <td align="center">
                <!-- 숙박인원 -->
                <span>{{ ceoBookingList.personnel }} 명</span>
              </td>
              <td align="center">
                <reserv-detail :bookingData="ceoBookingList" />
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </template>

    <!--테이블 페이지네이션-->
  </v-container>
</template>

<script>
import ReservDetail from "@/components/business/ReservDetail.vue";

//import axios from 'axios'

export default {
  name: "manageReservList",
  components: {
    ReservDetail,
  },

  props: {
    ceoBookingLists: {
      type: Array,
      required: true,
    },
  },
  data() {
    return {};
  },
};
</script>

<style scoped>
th {
  border-bottom: 2px solid #444444;
}
td {
  vertical-align: middle;
}
#search {
  width: 80%;
}
#roomImg {
  width: 100px;
  height: 100px;
}
</style>
