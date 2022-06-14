<template>
    <v-container>

        <template>
            <div align="center" style="width: 80%">
            <v-col>
                <v-row>
                    <v-text-field
                    class="search"
                    v-model="keyWord"
                    label="Search"
                    placeholder="키워드를 입력해주세요."
                    single-line
                    hide-details
                    ></v-text-field>
                    <v-col cols="2" md="1">
                        <v-btn id="searchBtn" @click="search" dark small>
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
            <table style="width: 80%;">
                <tr>
                    <th align="center" width="160">체크인 날짜</th>
                    <th align="center" width="300"  colspan="2">객실명</th>
                    <th align="center" width="150">고객명</th>
                    <th align="center" width="150">숙박인원</th>
                    <th align="center" width="130">  </th>
                </tr>

                <tr v-if="!reservs || (Array.isArray(reservs) && reservs.length === 0)">
                    <td colspan="5">
                        현재 예약 고객이 없습니다!
                    </td>
                </tr>

                <tr v-else v-for="reserv in reservs" :key="reserv.reservNo">
                    <td align="center"> <!-- 체크인 날짜 -->
                        <span>{{new Date(reserv.check_in).toLocalString("ko-KR", {timeZone: "Asia/Seoul"}).toString().substr(0, 11)}}</span>
                    </td>                

                    <td align="center" style="width: 150px">
                        <v-img v-if="item.roomImg == null" id="roomImg" :src="require(`@/assets/${item.hotelImg}`)"/>
                        <v-img v-else id="roomImg" :src="require(`@/assets/hotelImage/hotel1.jpg`)"/>
                    </td>

                    <td align="left"> <!-- 객실명 -->
                    <v-col>                            
                            <span>{{reserv.room_name}}</span>
                    </v-col>
                    </td>
                    <td align="center"> <!-- 고객명 -->
                        <span>{{reserv.name}}</span>
                    </td>
                    <td align="center"> <!-- 숙박인원 -->
                        <span>{{reserv.personnel}}</span>
                    </td>
                    <td align="center">
                        <reserv-detail/>
                    </td>
                </tr>                
            </table>
        </div>
    </template>

    <!--테이블 페이지네이션-->

    </v-container>
</template>

<script>
import ReservDetail from '@/components/business/ReservDetail.vue'
import axios from 'axios'

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
        search() {
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
        },
    },
}
</script>


<style scoped>
th{
    border-bottom: 2px solid #444444;
}
td{
    vertical-align: middle;
}
#search{
    width:80%;
}
#roomImg{
    width: 100px;
    height: 100px;
}
</style>