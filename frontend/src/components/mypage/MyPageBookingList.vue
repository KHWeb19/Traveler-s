<template>
  <v-container style="padding: 0px; margin-top: 20px">
    <v-card class="right">
      <div style="display: flex; justify-content: center; padding-top: 120px">
        <div>
          <v-select
            v-model="findList"
            :items="selectState"
            label="예약 상태"
            style="width: 150px"
            @change="findDesign"
          ></v-select>
          <v-data-table
            :headers="headerTitle1"
            :items="bookingLists"
            style="width: 600px"
            v-if="this.chooseState != 'part'"
          >
          </v-data-table>
          <v-data-table
            :headers="headerTitle2"
            :items="chooseProcessArr"
            style="width: 600px"
            v-if="this.chooseState == 'part'"
          >
          </v-data-table>
        </div>
      </div>
    </v-card>
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
        { text: "예약 상태", value: "reservationStatus", width: "90" },
        { text: "체크 인", value: "startDate", width: "80px" },
        { text: "체크 아웃", value: "endDate", width: "80px" },
      ],
      headerTitle2: [
        { text: "룸 타입", value: "roomType", width: "40px" },
        { text: "가격", value: "price", width: "10px" },
        { text: "예약 상태", value: "reservationStatus", width: "90px" },
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
          if (this.bookingLists[i].reservationStatus == this.findList) {
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
.left_menu {
  width: 200px;
  height: 848px;
  border-right-width: 3px;
  border-right-color: rgba(64, 64, 64);
  border-right-style: dotted;
  padding: 3%;
  background: rgba(64, 64, 64);
  color: white;
}
.proimg {
  width: 150px;
}

.col1 {
  background: rgb(224, 224, 224);
}
.btn2 {
  background: rgb(224, 224, 224);
}

.right {
  width: 600px;
  height: 848px;
  background: rgb(250, 250, 250);
}
.tb1 {
  background: #ffe082;
}

ul a {
  color: inherit;
}

ul {
  list-style: none;
  margin: 20% 0 0 0;
}

a {
  text-decoration: none;
}
td,
th {
  border: 1px solid #dbdbdb;
}
</style>
