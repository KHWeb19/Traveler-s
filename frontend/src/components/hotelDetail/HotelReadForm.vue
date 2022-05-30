<template>
<div align="center">
    <v-container>
            <form @submit.prevent="onSubmit">

            <table style="width: 100%">

                <tr>
                <td>

                </td>
                </tr>

                <tr>
                <td>
                    <!-- 숙소 이름 -->
                    <!-- 숙소 한줄 소개 -->
                    <h1>숙소 이름</h1>
                    <p>숙소 한줄 소개</p>
                </td>
                </tr>

                <tr>
                <td>
                    <!-- 객실 란 -->
                    <template>
                        <v-card :elevation="hover ? 16:2" class="{ 'on-hover': hover }" 
                            @click="registerRoom(room.boardNo, room.id)"
                            align = "center"
                            style="margin: 10px; width: 100%; height: 200px;">
                            <v-row justify>
                                <table id="inCard" style="width: 30%">
                                    <tr>
                                        <td>
                                            <p>객실 이미지</p>
                                        </td>
                                    </tr>
                                </table>

                                <table id="inCard" style="width: 40%">
                                    <tr>
                                        <td>
                                            <p>평수</p>
                                        </td>
                                        <td>
                                            <p>기준 n명, 최대 n명</p>
                                        </td>
                                        <td>
                                            <v-row >
                                                <v-btn id="button">버튼</v-btn>
                                                <v-btn id="button">버튼</v-btn>
                                                <v-btn id="button">버튼</v-btn>
                                                <v-btn id="button">버튼</v-btn>
                                                <v-btn id="button">버튼</v-btn>
                                            </v-row>
                                        </td>
                                    </tr>
                                </table>

                                <table id="inCard" style="width: 30%">
                                    <tr>
                                        <td>
                                            <v-btn id="button">예약하기</v-btn>
                                        </td>
                                    </tr>
                                </table>
                            </v-row>
                        </v-card>
                    </template>
                </td>
                </tr>


                <hr align="center" style="width: 100%;">
                <!-- 이 숙소의 매력 포인트 태그 -->

                <tr>
                <td>
                    <p>숙소 태그 채워보기</p>
                </td>
                </tr>

                <hr>
                <!-- 숙소 위치 -->

                <tr>
                <td>
                    <p>숙소 주소</p>
                </td>
                </tr>

                <hr>
                <!-- 사업자명 확인 가능 & 카톡으로 문의하기 -->

            </table>


            </form>
    </v-container>

</div>
</template>

<script>
export default {
    
}
</script>


<style scoped>
#inCard{
    border: 1px;
    color: black;
}
#button{
    margin: 10px;
}
</style>