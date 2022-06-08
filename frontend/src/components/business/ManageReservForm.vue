<template>
    <v-container>

        <template>
            <v-col>
                <v-row>
                    <v-text-field
                    class="search"
                    v-model="keyWord"
                    label="Search"
                    placeholder="작성자를 검색해주세요."
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
        </template>
    <br>

    <template>
        <div class="b_table">
            <table style="width: 80%">
                <tr>
                    <th align="center" width="100">날짜</th>
                    <th align="center" width="540">객실명</th>
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
                    <td align="center"> <!-- 날짜 -->
                        {{ reserv.regDate }}
                    </td>

                    <td align="left"> <!-- 객실명 -->
                        {{ reserv.room_name}}
                    </td>
                    <td align="right"> <!-- 고객명 -->
                        {{ reserv.name }}
                    </td>
                    <td  align="center"> <!-- 숙박인원 -->
                        {{ reserv.personnel }}
                    </td>
                    <td align="center">
                        <router-link :to="{ name: 'JpaBoardReadPage',
                                            params: { boardNo: reserv.reservNo.toString() } }">
                            <v-btn>상세보기</v-btn>
                        </router-link>
                    </td>
                </tr>                
            </table>
        </div>
    </template>

    <!--테이블 페이지네이션-->

    </v-container>
</template>

<script>


export default {
    name: 'ManageReservForm',
    components: {
        
    }    
}
</script>


<style scoped>
.table, th, td{
    border: 1px solid #444444;
}
#search{
    width:80%;
}
</style>