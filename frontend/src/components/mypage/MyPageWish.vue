<template>
  <v-container style="padding: 0px; margin-top: 20px">
    <v-card class="right">
      <div style="display: flex; justify-content: center; padding-top: 120px">
        <v-form ref="form" lazy-validation> </v-form>
        <table border="2">
          <tr class="tb1">
            <th align="center" width="150">호텔 이름</th>
            <th align="center" width="640">호텔 주소</th>
            <th align="center" width="150">취소</th>
          </tr>
          <tr
            v-if="
              !wishLists || (Array.isArray(wishLists) && wishLists.length === 0)
            "
          >
            <td colspan="4">현재 등록된 게시물이 없습니다!</td>
          </tr>
          <tr v-else v-for="wishList in wishLists" :key="wishList.hotelNo">
            <td align="center">
              {{ wishList.hotelName }}
            </td>
            <td align="left">
              <router-link
                :to="{
                  name: 'MHotelReadPage',
                  params: {},
                }"
              >
                {{ wishList.totalAddress }}
              </router-link>
            </td>
            <td>
              <v-btn @click="dewish">취소</v-btn>
            </td>
          </tr>
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
    },

    methods: {
      dewish() {
        axios.get("http://localhost:7777/wish/HotelList").then((res) => {
          if (res.data) console.log(res.data);
          alert("리스트");
        });
      },
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
</style>
