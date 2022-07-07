<template>
<!-- 사이드 바 -->
<v-container class="board-list">
  <!-- <v-text-field v-model="searchkeyword" dense outlined class="searchkeyword"/> -->
<table style="width: 100%">
  <colgroup>
    <col class="select">
    <col class="roomNo">
    <col class="price">
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

<br>
<button  id="button" @click="deleteRoom()">삭제</button>
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
.select {width: 10%;}
.roomName { /* 자동으로 맞춰집니다 */}
.price { width: 20%; }

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