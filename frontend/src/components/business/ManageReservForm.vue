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
            <table style="width: 80%; ">
                <tr>
                    <th align="center" width="160">체크인 날짜</th>
                    <th align="center" width="300"  colspan="2">객실명</th>
                    <th align="center" width="150">고객명</th>
                    <th align="center" width="150">숙박인원</th>
                    <th align="center" width="130">  </th>
                </tr>

                <tr>
                    <td id="tdPad" align="center"> <!-- 날짜 -->
                        <p>2022.06.09</p>
                    </td>                

                    <td id="tdPad" align="center">
                        <v-img id="roomImg" :src="require(`@/assets/hotelImage/hotel1.jpg`)"/>
                    </td>

                    <td id="tdPad" align="center"> <!-- 객실명 -->
                    <v-col>                            
                            <p>패밀리 독채</p>
                    </v-col>
                    </td>
                    <td id="tdPad" align="center"> <!-- 고객명 -->
                        <p>김땡땡</p>
                    </td>
                    <td id="tdPad" align="center"> <!-- 숙박인원 -->
                        <p>4~6인</p>
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


export default {
    name: 'ManageReservForm',
    components: {
        ReservDetail
        
    }    
}
</script>


<style scoped>
table{
    border: 1px solid #444444;
}
th{
    border-bottom: 1px solid #444444;
    padding: 10px;
}
#tdPad{
    padding-top: 15px;
}
#search{
    width:80%;
}
#roomImg{
    width: 100px;
    height: 100px;
}
</style>