<template>
    <v-container class="board-list">

        <template> <!-- 서치 시간없으면 빼도 OK -->
            <div align="right" style="width: 100%">
            <v-col>
                <v-row>
                    <v-spacer></v-spacer>
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
                            <v-icon>
                                mdi-magnify
                            </v-icon>
                        </v-btn>
                    </v-col>
                </v-row>
            </v-col>
            </div>
        </template>
    <br>

    <template>
        <div>
            <table style="width: 100%;">
                <colgroup>
                    <col class="id">
                    <col class="checkIn">
                    <col class="checkOut">
                    <col class="roomName">
                    <col class="userName">
                    <col class="personnel">
                </colgroup>
                <thead>
                <tr>
                    <th align="center" width="160">예약번호</th>
                    <th align="center" width="160">체크인</th>
                    <th align="center" width="160">체크아웃</th>
                    <th align="center" width="300">객실명</th>
                    <th align="center" width="150">고객명</th>
                    <th align="center" width="150">숙박인원</th>
                    <th align="center" width="100">  </th>
                </tr>
                </thead>

              <!--  <tr v-if="!reservs || (Array.isArray(reservs) && reservs.length === 0)">
                    <td colspan="5">
                        현재 예약 고객이 없습니다!
                    </td>
                </tr> 백 연결하실 때 주석 살리고
                 아래 v-else v-for="reserv in reservs" :key="reserv.reservNo" 넣어주시면 됩니다.-->

                <tbody>
                <tr >
                    <td align="center"> <!-- 예약번호(id) -->
                        <span>1</span>
                    </td>    
                    <td align="center"> <!-- 체크인 날짜 -->
                        <span>2022-06-07</span>
                    </td>                
                    <td align="center"> <!-- 체크아웃 날짜 -->
                        <span>2022-06-08</span>
                    </td> 

                    <td align="left"> <!-- 객실명 -->
                    <v-col>                            
                            <span>객실이름여기에</span>
                    </v-col>
                    </td>
                    <td align="center"> <!-- 고객명 -->
                        <span>김땡땡</span>
                    </td>
                    <td align="center"> <!-- 숙박인원 -->
                        <span>4명</span>
                    </td>
                    <td align="center">
                        <reserv-detail/>
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
import ReservDetail from '@/components/business/ReservDetail.vue'
//import axios from 'axios'

export default {
    name: 'manageReservList',
    components: {
        ReservDetail        
    },
    data() {
        return {
        
        };
    },
    props: {
        reservs: {
            type: Array
        },
    },
    methods: {
        readReserv(){

        },
       /* search() {
            const { keyWord } = this;
                axios.post("http://localhost:7777/reserv/search", { keyWord })
                    .then((res) => {
                    console.log(res.data);
                    alert("검색 완료");
                    this.$router.push({ name: 'reservSearchList', params: { searchList: res.data, keyWord: this.keyWord },
                        })
                        .catch(() => {});
                    })
                    .catch(() => {
                    alert("검색 실패");
                }); 
        },*/
    },
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

#search{
    width:50%;
}
</style>