<template>
<!-- 사이드 바 -->
<div class="board-list">
  <!-- <v-text-field v-model="searchkeyword" dense outlined class="searchkeyword"/> -->
<table>
  <colgroup>
    <col class="select">
    <col class="hotelNo">
    <col class="hotelName">
    <col class="Address">
    <col class="date">
  </colgroup>
  <thead>
    <tr>
      <th><input class="check all" type="checkbox" v-model="allDeleteRooms"></th>
      <th>객실명</th>
      <th>가격</th>
    </tr>
  </thead>
  <tbody>
        <tr v-for="(room ,idx) in paginatedData" :key="idx">
          <td><input class="check all" type="checkbox" v-model="deleteRooms" :value="room.roomNo" ></td>
            <td>
                 <router-link :to="{ name: 'BRoomReadPage',
                                    params: { roomNo: room.roomNo.toString() } }">
                {{ room.roomType }}
                 </router-link>
            </td>
            <td>
                {{ room.price }}
            </td>
        </tr>
  </tbody>
</table>
<v-btn @click="deleteRoom()">삭제</v-btn>

<div class="page-box">
        <div class="btn-cover">
            <button :disabled="pageNum === 0" @click="prevPage" class="page-btn">
                이전
            </button>
            <span class="page-count">{{ pageNum + 1 }} / {{ pageCount }}</span>
            <button :disabled="pageNum >= pageCount - 1" @click="nextPage" class="page-btn">
                다음
            </button>
        </div>
  </div>

</div>
</template>

<script>

export default {
  name: 'RoomList',
  props : {
    bmRoomList:{
        type: Array,
    },
    pageSize: {
      type: Number,
      required: false,
      default: 5
    }
  },
  data () {
    return {
        deleteRooms: [],
        pageNum: 0,
        roomNo: ''
    }
  },
  methods : {
    deleteRoom () {
        console.log(this.deleteRooms)
        const deleteRooms = this.deleteRooms
         this.$emit('deleteRooms', deleteRooms)
    },
    nextPage () {
            this.pageNum += 1;
            },
    prevPage () {
            this.pageNum -= 1;
            },

  },
  computed: {
    allDeleteRooms : {
       get: function () {
        return this.bmRoomList ? this.deleteRooms.length == this.bmRoomList.length : false
       },
       set : function (value) {
            let deleteRooms = [];

            if (value) {
                this.bmRoomList.forEach(function (bmRoomList){
                    deleteRooms.push(bmRoomList.roomNo)
                })
            }

            this.deleteRooms = deleteRooms
       }
    },
    pageCount () {
                let listLeng = this.bmRoomList.length,
                    listSize = this.pageSize,
                    page = Math.floor(listLeng / listSize);
                if (listLeng % listSize > 0) page += 1
                return page;
            },
    paginatedData () {
                const start = this.pageNum * this.pageSize,
                        end = start + this.pageSize;
                return this.bmRoomList.slice(start, end);
                
            }
  }
}
</script>

<style scoped>
.board-list {
  margin-top: 20px;
  margin-left: 50px;
}
/* 링크 색상 (중요하지 않음) */
a {
  text-decoration: none;
  color: #333;
}
a:hover {color: #1890ff;}

/* 테이블 색상 (중요하지 않음) */
table {
  width: 95%;
  border-collapse: collapse;
}
th {
  background: #1890ff;
  color: #fff;
}
td, th {
  border: 1px solid #dbdbdb;
  padding: 5px 20px;
  font-size:12px;
}
tr:nth-of-type(odd) { 
	background: #eee; 
}

/* 체크박스의 크기 */
.check {
  width:15px;
  height:15px;
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
  font-size: 10px;
  border: 1px solid #dbdbdb;
  color: #333;
}
.page-box a.btn.on {
  background-color: #dbdbdb;
}
</style>