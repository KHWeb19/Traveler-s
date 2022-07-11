<template>
  <v-container>
    <br />
      <div>
        <table style="width: 80%">
          <tr>
            <th align="center" width="160">체크인</th>
            <th align="center" width="160">체크아웃</th>
            <th align="center" width="180">예약상태</th>
            <th align="center" width="300">객실명</th>
            <th align="center" width="150">고객명</th>
            <th align="center" width="150">숙박인원</th>
            <th align="center" width="200"></th>
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
              v-for="(ceoBookingList, idx) in paginatedData"
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
                <!-- 예약상태 -->
                <span>{{ ceoBookingList.status }}</span>
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

<br>

      <div class="page-box">
              <div class="btn-cover">
                  <button :disabled="pageNum === 0" @click="prevPage" class="page-btn">
                      <v-icon> mdi-chevron-left </v-icon>
                  </button>
                  &ensp;

                  <span>{{ pageNum + 1 }} / {{ pageCount }}</span>
                  
                  &ensp;
                  <button :disabled="pageNum >= pageCount - 1" @click="nextPage" class="page-btn">
                      <v-icon> mdi-chevron-right </v-icon>  
                  </button>
              </div>
        </div>

<br>


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
    pageSize: {
      type: Number,
      required: false,
      default: 5
    }
  },
  data() {
    return {
      pageNum: 0,
    };
  },
  computed: {
    pageCount () {
                let listLeng = this.ceoBookingLists.length,
                    listSize = this.pageSize,
                    page = Math.floor(listLeng / listSize);
                if (listLeng % listSize > 0) page += 1
                return page;
            },
            paginatedData () {
                const start = this.pageNum * this.pageSize,
                        end = start + this.pageSize;
                return this.ceoBookingLists.slice(start, end);
                
            }
  },
  methods: {
    nextPage () {
    this.pageNum += 1;
    },
    prevPage () {
    this.pageNum -= 1;
    },
}
};
</script>

<style scoped>
.board-list {
  margin-top: 20px;
  /*margin-left: 50px;
  margin-right: 50px; */
}
/* 링크 색상 (중요하지 않음) */
a {
  text-decoration: none;
  color: #333;
}
/* 테이블 색상 (중요하지 않음) */
table {
  width: 95%;
  border-collapse: collapse;
}
th {
  background: #54658a;
  color: #fff;
  font-size: 15px;
  border: 1px solid #dbdbdb;
  height: 45px;
  padding: 5px 20px;
}
td {
  border: 1px solid #dbdbdb;
  color: rgb(34, 34, 34);
  height: 42px;
  padding: 5px 20px;
  font-size:13px;
}
tr:nth-of-type(odd) { 
	background: rgb(243, 243, 243); 
  vertical-align: middle;
}
#search {
  width: 80%;
  margin: 5px auto;
  height: 30px;
  text-align: center;
}
.page-box a.btn {
  display:inline-block;
  padding: 3px 5px;
  font-size: 15px;
  border: 1px solid #dbdbdb;
  color: #333;
}
.page-box a.btn.on {
  background-color: #dbdbdb;
}
.btn {
  position: sticky;
  text-decoration: none;
}
#search{
    width:50%;
}
#roomImg {
  width: 100px;
  height: 100px;
}
</style>
