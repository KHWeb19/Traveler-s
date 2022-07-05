<template>
  <v-container style="padding: 0px; margin-top: 20px">
    <v-card class="right">
      <div style="display: flex; justify-content: center; padding-top: 120px">
        <table class="table">
          <thead style="background: #1890ff; height: 60px">
            <tr>
              <th scope="col" align="center" width="150">이름</th>
              <th scope="col" align="center" width="640">주소</th>
              <th scope="col" align="center" width="150">삭제</th>
            </tr>
          </thead>
          <tbody>
            <tr
              v-if="
                !wishLists ||
                (Array.isArray(wishLists) && wishLists.length === 0)
              "
            >
              <td colspan="4">현재 위시가 없습니다!</td>
            </tr>
            <tr v-else v-for="wishList in wishLists" :key="wishList.hotelNo">
              <td align="center">
                <router-link
                  :to="{
                    name: 'MHotelReadPage',
                    params: { hotelNo: wishList.hotelNo.toString() },
                  }"
                >
                  {{ wishList.hotelName }}
                </router-link>
              </td>
              <td align="center">
                {{ wishList.totalAddress }}
              </td>
              <th scope="col">
                <v-btn @click="deletewish(wishList.hotelNo)">취소</v-btn>
              </th>
            </tr>
          </tbody>
        </table>
      </div>
    </v-card>
  </v-container>
</template>

<script>
import axios from "axios";
export default {
  name: "MyPageWish",
  props: {
    wishLists: {
      type: Array,
      required: true,
    },
  },
  data() {
    return {};
  },
  methods: {
    deletewish(payload) {
      const hotelNo = payload;
      axios
        .delete(`http://localhost:7777/wish/${hotelNo}`)
        .then(() => {
          alert("삭제되었습니다.");
          this.$router.go();
          console.log(this.hotelNo);
        })
        .catch(() => {
          alert("삭제요청실패");
        });
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
