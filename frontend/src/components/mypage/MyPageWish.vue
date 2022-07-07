<template>
  <v-container style="padding: 0px; margin-top: 20px">
    <table class="table">
      <colgroup>
        <col class="hotelName">
        <col class="Address">
        <col class="delete">
      </colgroup>

      <thead>
        <tr>
          <th scope="col" align="center" width="20%">이름</th>
          <th scope="col" align="center" width="60%">주소</th>
          <th scope="col" align="center" width="20%">삭제</th>
        </tr>
      </thead>
      <tbody>
        <tr v-if="
            !wishLists ||(Array.isArray(wishLists) && wishLists.length === 0)">
          <td align="center" colspan="3">현재 위시가 없습니다!</td>
        </tr>
        <tr v-else v-for="mHotel in paginatedData" :key="mHotel.hotelNo">
          <td align="center">
              {{ mHotel.hotelName }}
          </td>
          <td align="center">
            <router-link
              :to="{ name: 'MHotelReadPage',
                    params: { hotelNo: mHotel.hotelNo.toString(), mHotel },}">
             {{ mHotel.totalAddress }}
            </router-link>
          </td>
          <td align="center">
            <v-btn @click="deletewish(mHotel.hotelNo)">취소</v-btn>
          </td>
        </tr>
      </tbody>
    </table>

<br>
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
            let listLeng = this.wishLists.length,
                listSize = this.pageSize,
                page = Math.floor(listLeng / listSize);
            if (listLeng % listSize > 0) page += 1
            return page;
        },
        paginatedData () {
            const start = this.pageNum * this.pageSize,
                    end = start + this.pageSize;
            return this.wishLists.slice(start, end);
            
        }
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
    nextPage () {
    this.pageNum += 1;
    },
    prevPage () {
    this.pageNum -= 1;
    },
},
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
a:hover {
  color: #e63668;
}
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
}

/* 페이징 버튼 */
.page-box {
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
</style>
