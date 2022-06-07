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
                <th>
                    <td>
                        <!--날짜-->
                    </td>
                    <td>
                        <!--객실명-->
                    </td>
                    <td>
                        <!--고객명-->
                    </td>
                    <td>
                        <!--숙박인원-->
                    </td>
                    <td>
                        <!--상세보기/체크아웃 버튼-->
                    </td>
                </th>
                <th>
                    <td>
                        <!-- -->
                    </td>
                </th>
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