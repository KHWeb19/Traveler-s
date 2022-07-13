<template>
  <v-container class="board-list">
    <table style="width: 100%">
      <colgroup>
        <col class="id" />
        <col class="roomType" />
        <col class="price" />
        <col class="status" />
        <col class="checkIn" />
        <col class="checkOut" />
      </colgroup>
      <thead>
        <tr>
          <th>예약번호</th>
          <th>룸 타입</th>
          <th>가격</th>
          <th>예약 상태</th>
          <th>체크 인</th>
          <th>체크 아웃</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(bookingList, idx) in bookingLists" :key="idx">
          <td>
            {{ bookingList.id }}
          </td>
          <td>
            {{ bookingList.roomType }}
          </td>

          <td>
            {{ bookingList.price }}
          </td>
          <td>
            {{ bookingList.status }}
          </td>
          <td>
            {{ bookingList.startDate }}
          </td>
          <td>
            {{ bookingList.endDate }}
          </td>
        </tr>
      </tbody>
    </table>

  </v-container>
</template>

<script>
export default {
  props: {
    bookingLists: {
      type: Array,
      require: true,
    },
  },
  data() {
    return {
      headerTitle1: [
        { text: "룸 타입", value: "roomType", width: "40px" },
        { text: "가격", value: "price", width: "10px" },
        { text: "예약 상태", value: "status", width: "90" },
        { text: "체크 인", value: "startDate", width: "80px" },
        { text: "체크 아웃", value: "endDate", width: "80px" },
      ],
      headerTitle2: [
        { text: "룸 타입", value: "roomType", width: "40px" },
        { text: "가격", value: "price", width: "10px" },
        { text: "예약 상태", value: "status", width: "90px" },
        { text: "체크 인", value: "startDate", width: "80px" },
        { text: "체크 아웃", value: "endDate", width: "80px" },
      ],
      selectState: ["ALL", "RESERVED", "PENDING", "CANCELLED"],
      findList: "",
      chooseProcessArr: [],
      chooseState: ["all", "part"],
    };
  },
  methods: {
    findDesign() {
      this.chooseProcessArr = new Array();

      if (this.findList == "ALL") {
        return (this.chooseState = "all");
      } else {
        for (let i = 0; i < this.bookingLists.length; i++) {
          if (this.bookingLists[i].status == this.findList) {
            this.chooseProcessArr.push(this.bookingLists[i]);
          } else {
            continue;
          }
          this.chooseState = "part";
        }
      }
    },
  },
};
</script>

<style scoped>
table,
th,
td {
  border-collapse: collapse;
  border: 1px solid black;
}

.board-list {
  margin-top: 20px;
}
/* 링크 색상 (중요하지 않음) */
a {
  text-decoration: none;
  color: #333;
}
a:hover {
  color: #e63668;
}
/* 테이블 색상 (중요하지 않음) */
table {
  /* width: 95%;*/
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
  font-size: 13px;
}
tr:nth-of-type(odd) {
  background: rgb(243, 243, 243);
}

/* 컬럼의 너비 */
.id {
  width: 15%;
}
.roomType {
  width: 10%;
}
.price {
  width: 10%;
}
.status {
  width: 10%;
}
.checkIn {
  width: 20%;
}
.checkOut {
  width: 20%;
}

/* 컬럼의 정렬 */
tr td:nth-child(1) {
  text-align: center;
}
tr td:nth-child(2) {
  text-align: center;
}
tr td:nth-child(3) {
  text-align: center;
}
tr td:nth-child(4) {
  text-align: center;
}
tr td:nth-child(5) {
  text-align: center;
}
tr td:nth-child(6) {
  text-align: center;
}

/* 페이징 버튼 */
.page-box {
  width: 80%;
  margin: 5px auto;
  height: 30px;
  text-align: center;
}
.page-box a.btn {
  display: inline-block;
  padding: 3px 5px;
  font-size: 10px;
  border: 1px solid #dbdbdb;
  color: #333;
}
.page-box a.btn.on {
  background-color: #dbdbdb;
}

</style>
