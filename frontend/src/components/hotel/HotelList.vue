<template>
<v-container class="board-list">

<table style="width: 100%">
  <colgroup>
    <col class="select">
    <col class="hotelNo">
    <col class="hotelName">
    <col class="Address">
    <col class="date">
  </colgroup>
  <thead>
    <tr>
      <th><input class="check all" type="checkbox" v-model="allDeleteHotels"></th>
      <th>번호</th>
      <th>숙소명</th>
      <th>위치</th>
      <th>게시일</th>
    </tr>
  </thead>
  <tbody>
        <tr v-if="!bmHotels || (Array.isArray(bmHotels) && bmHotels.length === 0)">
            <td colspan="5">
                숙소를 등록해주세요.
            </td>
        </tr>
        <tr v-else v-for="bmHotel in paginatedData" :key="bmHotel.hotelNo">

          <td><input class="check all" type="checkbox" v-model="deleteHotels" :value="bmHotel.hotelNo" ></td>
            <td>
                {{ bmHotel.hotelNo }}
            </td>
            <td>
                <router-link :to="{ name: 'BHotelReadPage',
                                    params: { hotelNo: bmHotel.hotelNo.toString(), hotelName: bmHotel.hotelName } }">
                    {{ bmHotel.hotelName }}
                </router-link>
            </td>
            <td>
                <router-link :to="{ name: 'BHotelReadPage',
                                    params: { hotelNo: bmHotel.hotelNo.toString(), hotelName: bmHotel.hotelName } }">
                    {{ bmHotel.totalAddress }}
                </router-link>
            </td>
            <td>
                {{ new Date(bmHotel.regDate).toLocaleString("ko-KR", {timeZone: "Asia/Seoul"}).toString().substr(0, 11) }}
            </td>
        </tr>
  </tbody>
</table>

<br>

<button id="button" @click="deleteHotel()">삭제</button>

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
</v-container>
</template>
<script>

export default {
  name: 'HotelList',
  props: {
    bmHotels: {
      type: Array,
      required: true
    },
    pageSize: {
      type: Number,
      required: false,
      default: 5
    }
  },
  data () {
    return {
      deleteHotels: [],
      pageNum: 0,
      hotelNo: '',
    }
  },
  computed: {
    allDeleteHotels : {
       get: function () {
        return this.bmHotels ? this.deleteHotels.length == this.bmHotels.length : false
       },
       set : function (value) {
            let deleteHotels = [];

            if (value) {
                this.bmHotels.forEach(function (bmHotels){
                    deleteHotels.push(bmHotels.hotelNo)
                })
            }

            this.deleteHotels = deleteHotels
       }
    },
    pageCount () {
                let listLeng = this.bmHotels.length,
                    listSize = this.pageSize,
                    page = Math.floor(listLeng / listSize);
                if (listLeng % listSize > 0) page += 1
                return page;
            },
            paginatedData () {
                const start = this.pageNum * this.pageSize,
                        end = start + this.pageSize;
                return this.bmHotels.slice(start, end);
                
            }
  },
  methods: {
    deleteHotel () {
        console.log(this.deleteHotels)
        const deleteHotels = this.deleteHotels
         this.$emit('deleteHotels', deleteHotels)
    },
    nextPage () {
    this.pageNum += 1;
    },
    prevPage () {
    this.pageNum -= 1;
    },
}
}
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
}

/* 체크박스의 크기 */
.check {
  width:15px;
  height:15px;
  accent-color: #e63668;
}

/* 컬럼의 너비 */
.select {width: 3%;}
.hotelNo {width: 5%;}
.hotelName {width: 20%;}
.Address { /* 자동으로 맞춰집니다 */ }
.date {width: 15%;}

/* 컬럼의 정렬 */
tr td:nth-child(1){text-align:center;}
tr td:nth-child(2){text-align:center;}
tr td:nth-child(3){text-align:center;}
tr td:nth-child(4){text-align:center;}
tr td:nth-child(5){text-align:center;}

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